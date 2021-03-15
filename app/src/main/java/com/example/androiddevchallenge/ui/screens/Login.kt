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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.elements.FullWidthButton
import com.example.androiddevchallenge.ui.elements.FullWidthTextField
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Login() = Surface(
    Modifier
        .background(color = MaterialTheme.colors.background)
        .fillMaxSize(),
) {
    val background = if (MaterialTheme.colors.isLight) R.drawable.light_login
    else R.drawable.dark_login

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

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
        Text(
            "LOG IN",
            style = MaterialTheme.typography.h1.copy(color = MaterialTheme.colors.onBackground)
        )
        Spacer(Modifier.height(32.dp))
        FullWidthTextField(
            value = email,
            onValueChange = {
                email = it
            }
        )
        Spacer(Modifier.height(8.dp))
        FullWidthTextField(
            value = password,
            onValueChange = {
                password = it
            }
        )
        Spacer(Modifier.height(8.dp))
        FullWidthButton {
            Text("Login")
        }
    }
}

@Preview
@Composable
fun LoginPreview() = MyTheme {
    Login()
}
