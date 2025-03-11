package io.sahil.shoppe.ui.screens.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.*

@Composable
fun BackgroundBubble(modifier: Modifier, color: Color) {
    Canvas(modifier = modifier){
        val height = size.height
        val width = size.width

        val path = Path().apply {
            //moveTo(width * 0.5f, 0f)

            close()
        }
        drawArc(
            color = color,
            startAngle = 270f,
            sweepAngle = 270f,
            size = size,
            topLeft = Offset(width/2, height/2),
            useCenter = true
        )
//        drawOval(
//            color = color,
//            size = Size(width/3, height/3),
//            topLeft = Offset(width/12, height/2)
//        )

        //drawPath(path, color = Color.Blue, style = Fill)
    }
}

@Preview
@Composable
private fun BackgroundBubblePreview() {
    BackgroundBubble(
        modifier = Modifier
            .size(100.dp),
        color = Color.Cyan
    )
}