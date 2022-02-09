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

import android.content.res.Resources
import android.graphics.Rect
import android.util.Size
import android.util.TypedValue
import kotlin.math.roundToInt

/** Returns pixel size from the dp size. */
internal fun Int.dpToPx(): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).roundToInt()
}

/** Returns [Size] class from a [Rect] class. */
internal fun Rect.toSize(): Size {
    return Size(right - left, bottom - top)
}
