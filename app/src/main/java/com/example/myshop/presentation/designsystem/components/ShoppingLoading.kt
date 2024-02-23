package com.example.myshop.presentation.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myshop.presentation.designsystem.theme.ShoppingAppTheme
import com.example.myshop.utils.ComponentPreview

@Composable
fun FullScreenCircularLoading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@ComponentPreview
@Composable
private fun FullScreenCircularLoadingPreview() {
    ShoppingAppTheme {
        Surface {
            FullScreenCircularLoading()
        }
    }
}