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

package io.getstream.example.windowmanager.chat.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.getstream.sdk.chat.viewmodel.MessageInputViewModel
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.ui.channel.list.viewmodel.ChannelListViewModel
import io.getstream.chat.android.ui.channel.list.viewmodel.bindView
import io.getstream.chat.android.ui.channel.list.viewmodel.factory.ChannelListViewModelFactory
import io.getstream.chat.android.ui.message.MessageListActivity
import io.getstream.chat.android.ui.message.input.viewmodel.bindView
import io.getstream.chat.android.ui.message.list.header.viewmodel.MessageListHeaderViewModel
import io.getstream.chat.android.ui.message.list.header.viewmodel.bindView
import io.getstream.chat.android.ui.message.list.viewmodel.bindView
import io.getstream.chat.android.ui.message.list.viewmodel.factory.MessageListViewModelFactory
import io.getstream.example.windowmanager.chat.R
import io.getstream.example.windowmanager.chat.databinding.ActivityMainBinding
import io.getstream.example.windowmanager.chat.util.WindowSize
import io.getstream.example.windowmanager.chat.util.getWindowSize

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val factory by lazy { ChannelListViewModelFactory() }
    private val channelListViewModel: ChannelListViewModel by lazy {
        factory.create(ChannelListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a data binding and set content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            // Set WindowSize to the data binding
            windowSize = this@MainActivity.getWindowSize()

            // Set up channel list header view and list view
            ChatClient.instance().getCurrentUser()?.let { channelListHeaderView.setUser(it) }
            channelListViewModel.bindView(channelListView, this@MainActivity)

            // Set up on item click listener for channel list view
            channelListView.setChannelItemClickListener { channel ->
                cid = channel.cid

                // Configure difference layout depending on the WindowSize
                if (windowSize is WindowSize.Expanded) {
                    setupMessageList(channel.cid)
                } else {
                    startMessageListActivity(channel.cid)
                }
            }
        }
    }

    private fun setupMessageList(cid: String) {
        val factory = MessageListViewModelFactory(cid)
        val messageListHeaderViewModel = factory.create(MessageListHeaderViewModel::class.java)
        val messageListViewModel = factory.create(MessageListViewModel::class.java)
        val messageInputViewModel = factory.create(MessageInputViewModel::class.java)

        messageListHeaderViewModel.bindView(binding.messageListHeaderView, this)
        messageListViewModel.bindView(binding.messageListView, this)
        messageInputViewModel.bindView(binding.messageInputView, this)
    }

    private fun startMessageListActivity(cid: String) {
        val intent = MessageListActivity.createIntent(this@MainActivity, cid)
        startActivity(intent)
    }
}
