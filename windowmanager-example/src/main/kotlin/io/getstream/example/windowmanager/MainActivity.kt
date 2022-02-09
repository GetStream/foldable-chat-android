/*
 * Copyright 2022 Stream.IO, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.getstream.example.windowmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowMetricsCalculator
import io.getstream.example.windowmanager.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Computes current WindowMetrics
        val wmc = WindowMetricsCalculator.getOrCreate()
        val currentWM = wmc.computeCurrentWindowMetrics(this).bounds.flattenToString()
        val maximumWM = wmc.computeMaximumWindowMetrics(this).bounds.flattenToString()
        binding.metrics.text = "${currentWM}\n$maximumWM"

        // Create a new coroutine since repeatOnLifecycle is a suspend function.
        lifecycleScope.launch(Dispatchers.Main) {
            // The block passed to repeatOnLifecycle is executed when the lifecycle
            // is at least STARTED and is cancelled when the lifecycle is STOPPED.
            // It automatically restarts the block when the lifecycle is STARTED again.
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Safely collect from WindowInfoTracker when the lifecycle is STARTED
                // and stops collection when the lifecycle is STOPPED
                WindowInfoTracker.getOrCreate(this@MainActivity)
                    .windowLayoutInfo(this@MainActivity)
                    .collect { layoutInfo ->
                        // Updates display features
                        if (layoutInfo.displayFeatures.isNotEmpty()) {
                            binding.layoutChanges.text = "Spanned across displays"
                        } else {
                            binding.layoutChanges.text = "One logic/physical display - unspanned"
                        }

                        Log.e("Test", "layoutInfo.displayFeatures: ${layoutInfo.displayFeatures}")

                        // Updates folding features
                        val foldingFeature =
                            layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>()
                                .firstOrNull()

                        Log.e("Test", "foldingfeature: $foldingFeature")

                        foldingFeature ?: return@collect

                        when {
                            foldingFeature.isTableTopPosture() ->
                                binding.posture.text = "TableTop Posture"
                            foldingFeature.isBookPosture() ->
                                binding.posture.text = "Book Posture"
                            else -> binding.posture.text = "Normal Posture"
                        }
                    }
            }
        }
    }
}
