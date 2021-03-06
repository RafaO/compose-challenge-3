/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

// Set of Material typography styles to start with

const val CAPS = "smcp"

val kulimParkFont = FontFamily(
    Font(R.font.kulimpark_regular),
    Font(R.font.kulimpark_light, FontWeight.Light)
)

val latoFont = FontFamily(
    Font(R.font.lato_regular),
    Font(R.font.lato_bold, FontWeight.Bold)
)

val typography = Typography(
    h1 = TextStyle(
        fontFamily = kulimParkFont,
        fontSize = 28.sp,
        letterSpacing = 1.15.sp,
        fontWeight = FontWeight.Light,
    ),
    h2 = TextStyle(
        fontFamily = kulimParkFont,
        fontSize = 15.sp,
        letterSpacing = 1.15.sp,
        fontFeatureSettings = CAPS,
    ),
    h3 = TextStyle(
        fontFamily = latoFont,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Bold,
    ),
    body1 = TextStyle(
        fontFamily = latoFont,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
    ),
    button = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 1.15.sp,
        fontFeatureSettings = CAPS
    ),
    caption = TextStyle(
        fontFamily = kulimParkFont,
        fontSize = 12.sp,
        letterSpacing = 1.15.sp,
        fontFeatureSettings = CAPS
    )
)
