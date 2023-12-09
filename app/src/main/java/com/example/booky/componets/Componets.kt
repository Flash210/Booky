package com.example.booky.componets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ReaderLogo(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(bottom = 15.dp),
        text = "Booky",
        style = MaterialTheme.typography.titleLarge,
        color = Color.Red
    )
}
