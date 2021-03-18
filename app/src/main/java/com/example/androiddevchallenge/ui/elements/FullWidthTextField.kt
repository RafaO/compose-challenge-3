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
package com.example.androiddevchallenge.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun FullWidthTextField(
    modifier: Modifier = Modifier,
    hint: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) = TextField(
    value = value,
    onValueChange = onValueChange,
    leadingIcon = leadingIcon,
    label = {
        Text(
            text = hint,
            style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
        )
    },
    modifier = modifier
        .height(56.dp)
        .fillMaxWidth()
)

@Preview
@Composable
fun Preview() = MyTheme {
    FullWidthTextField(hint = "Login", value = TextFieldValue(""), onValueChange = { /*TODO*/ })
}
