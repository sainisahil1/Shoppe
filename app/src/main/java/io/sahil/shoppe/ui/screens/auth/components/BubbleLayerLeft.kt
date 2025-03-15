package io.sahil.shoppe.ui.screens.auth.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import io.sahil.shoppe.R

@Composable
fun BubbleLayerLeft() {
    Icon(
        painter = painterResource(R.drawable.bubble4),
        contentDescription = "bubble4",
        tint = Color(0xFFF2F5FE)
    )
    Icon(
        painter = painterResource(R.drawable.bubble3),
        contentDescription = "bubble3",
        tint = Color(0xFF004BFE)
    )
}

@Preview
@Composable
private fun BubbleLayerLeftPreview() {
    BubbleLayerLeft()
}