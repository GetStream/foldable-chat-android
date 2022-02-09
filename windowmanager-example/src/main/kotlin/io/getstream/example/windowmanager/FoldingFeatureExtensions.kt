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

import androidx.window.layout.FoldingFeature

/** Check is the [FoldingFeature] is the table-top mode. */
fun FoldingFeature.isTableTopPosture(): Boolean {
    return state == FoldingFeature.State.HALF_OPENED &&
        orientation == FoldingFeature.Orientation.HORIZONTAL
}

/** Check is the [FoldingFeature] is the book mode. */
fun FoldingFeature.isBookPosture(): Boolean {
    return state == FoldingFeature.State.HALF_OPENED &&
        orientation == FoldingFeature.Orientation.VERTICAL
}
