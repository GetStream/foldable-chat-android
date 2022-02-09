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

package io.getstream.example.windowmanager.chat.util

import android.app.Activity
import android.util.Size
import androidx.window.layout.WindowMetricsCalculator

/**
 * Copyright 2022 Google LLC.
 * SPDX-License-Identifier: Apache-2.0
 *
 * Opinionated set of viewport breakpoints
 *     - Compact: Most phones in portrait mode
 *     - Medium: Most foldables and tablets in portrait mode
 *     - Expanded: Most tablets in landscape mode
 */
sealed class WindowSize(val size: Int) {
    class Compact(windowPixelSize: Int) : WindowSize(windowPixelSize)
    class Medium(windowPixelSize: Int) : WindowSize(windowPixelSize)
    class Expanded(windowPixelSize: Int) : WindowSize(windowPixelSize)
}

/**
 * Gets the [WindowSize] by computing window size.
 */
fun Activity.getWindowSize(): WindowSize {
    // Get the size (in pixels) of the window
    val windowSize = computeWindowSize()
    val windowPixelSize = windowSize.width
    return getWindowSizeClass(windowPixelSize)
}

/**
 * Computes the size of the Window by using [WindowMetricsCalculator].
 */
private fun Activity.computeWindowSize(): Size {
    val windowMetrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this)
    return windowMetrics.bounds.toSize()
}

/**
 * Partitions a width size into a enumerated [WindowSize] class.
 */
private fun getWindowSizeClass(windowPixelSize: Int): WindowSize = when {
    windowPixelSize < 0.dpToPx() -> throw IllegalArgumentException("Dp value cannot be negative")
    windowPixelSize < 600.dpToPx() -> WindowSize.Compact(windowPixelSize)
    windowPixelSize < 840.dpToPx() -> WindowSize.Medium(windowPixelSize)
    else -> WindowSize.Expanded(windowPixelSize)
}
