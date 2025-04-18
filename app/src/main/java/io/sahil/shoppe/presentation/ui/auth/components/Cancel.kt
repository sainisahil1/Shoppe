package io.sahil.shoppe.presentation.ui.auth.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import io.sahil.shoppe.presentation.theme.TextBlack

@Composable
fun Cancel(modifier: Modifier = Modifier, onclick: () -> Unit) {
    Text(
        text = "Cancel",
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = onclick
            ),
        textAlign = TextAlign.Center,
        fontSize = 15.sp,
        color = TextBlack
    )
}