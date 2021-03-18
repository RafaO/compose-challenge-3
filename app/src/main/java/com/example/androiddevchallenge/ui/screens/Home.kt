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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Collection
import com.example.androiddevchallenge.ui.elements.CircleItem
import com.example.androiddevchallenge.ui.elements.FavoriteCard
import com.example.androiddevchallenge.ui.elements.FullWidthTextField
import com.example.androiddevchallenge.ui.theme.MyTheme

private fun collections() =
    List(10) { Collection("Short mantras", "https://picsum.photos/id/1025/200/150") }

@Composable
fun Home() = Scaffold(
    floatingActionButtonPosition = FabPosition.Center,
    isFloatingActionButtonDocked = true,
    floatingActionButton = {
        FloatingActionButton(
            backgroundColor = MaterialTheme.colors.primary,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Filled.PlayArrow,
                "play",
                Modifier.size(24.dp)
            )
        }
    },
    bottomBar = { BottomBar() }
) {
    Column(
        Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(top = 56.dp, start = 16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
    ) {
        var search by remember { mutableStateOf(TextFieldValue("")) }

        FullWidthTextField(
            modifier = Modifier.padding(end = 16.dp),
            hint = "Search",
            value = search,
            onValueChange = { search = it },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    "search",
                    Modifier.size(18.dp)
                )
            }
        )
        SectionTitle("FAVORITE COLLECTIONS")
        LazyRow {
            collections().chunked(2).forEach {
                item {
                    Spacer(Modifier.width(8.dp))
                    Column {
                        it.forEach { FavoriteCard(it, Modifier.padding(bottom = 8.dp)) }
                    }
                }
            }
        }
        // FavoriteCard(Collection("Short mantras", "https://picsum.photos/id/1025/200/150"))
        SectionTitle("ALIGN YOUR BODY")
        CollectionRow(items = collections())
        SectionTitle("ALIGN YOUR MIND")
        CollectionRow(items = collections())
    }
}

@Composable
fun BottomBar() = BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
    BottomNavigationItem(
        selected = true, onClick = { /*TODO*/ },
        icon = {
            Icon(
                Icons.Filled.Spa,
                "play",
                Modifier.size(18.dp)
            )
        },
        label = { TabLabel("HOME") }
    )
    BottomNavigationItem(
        selected = false, onClick = { /*TODO*/ },
        icon = {
            Icon(
                Icons.Rounded.AccountCircle,
                "play",
                Modifier.size(18.dp)
            )
        },
        label = { TabLabel("PROFILE") }
    )
}

@Composable
fun TabLabel(label: String) = Text(label, style = MaterialTheme.typography.caption)

@Composable
fun SectionTitle(text: String) = Column {
    Text(
        modifier = Modifier.paddingFromBaseline(40.dp),
        text = text,
        style = MaterialTheme.typography.h2
    )
    Spacer(Modifier.height(8.dp))
}

@Composable
fun CollectionRow(items: List<Collection>) = LazyRow {
    items(items) {
        CircleItem(it)
        Spacer(Modifier.width(8.dp))
    }
}

@Preview
@Composable
fun HomePreview() = MyTheme {
    Home()
}
