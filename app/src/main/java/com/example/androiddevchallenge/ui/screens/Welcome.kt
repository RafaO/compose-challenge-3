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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.elements.FullWidthButton
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome(loginClicked: () -> Unit) = Surface(
    Modifier
        .background(color = MaterialTheme.colors.background)
        .fillMaxSize(),
) {
    val (background, logo) = if (MaterialTheme.colors.isLight) Pair(
        R.drawable.dark_welcome,
        R.drawable.dark_logo
    ) else Pair(R.drawable.light_welcome, R.drawable.light_logo)
    Image(
        contentScale = ContentScale.FillBounds,
        painter = painterResource(background),
        contentDescription = "background"
    )
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(logo), contentDescription = "logo")
        Spacer(Modifier.height(32.dp))
        FullWidthButton {
            Text("Sign up")
        }
        Spacer(Modifier.height(8.dp))
        FullWidthButton(
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            onClick = loginClicked
        ) {
            Text("Login")
        }
    }
}

@Preview
@Composable
fun LightPreview() {
    MyTheme {
        Welcome {}
    }
}
