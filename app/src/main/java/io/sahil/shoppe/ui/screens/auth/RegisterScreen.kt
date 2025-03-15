package io.sahil.shoppe.ui.screens.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.sahil.shoppe.R
import io.sahil.shoppe.ui.screens.auth.components.ButtonMain
import io.sahil.shoppe.ui.screens.auth.components.Cancel
import io.sahil.shoppe.ui.screens.auth.components.FormTextField
import io.sahil.shoppe.ui.screens.common.Modules
import io.sahil.shoppe.ui.screens.common.Screens

@Composable
fun RegisterScreen(navController: NavController?) {
    val circleSize = 90.dp
    val startPadding = 20.dp
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    Icon(
        painter = painterResource(R.drawable.bubble2),
        contentDescription = "bubble2",
        tint = Color(0xFFF2F5FE)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            painter = painterResource(R.drawable.bubble1),
            contentDescription = "bubble1",
            tint = Color(0xFF004BFE),
        )
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Create\nAccount",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = startPadding, bottom = 44.dp)
        )
        DashedCircle(
            modifier = Modifier
                .size(circleSize + startPadding)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        FormTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email"
        )
        Spacer(modifier = Modifier.size(10.dp))
        FormTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password"
        )
        Spacer(modifier = Modifier.size(10.dp))
        FormTextField(
            value = phone,
            onValueChange = { phone = it },
            placeholder = "Phone"
        )
        Spacer(modifier = Modifier.size(50.dp))
        ButtonMain(
            text = "Done",
            onClick = {},
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(24.dp))
        Cancel(
            onclick = {navController?.navigate("${Modules.AUTH}/${Screens.GET_STARTED}")}
        )
    }
}


@Composable
fun DashedCircle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(
            modifier = modifier
                .background(color = Color.Transparent)
                .align(alignment = Alignment.Center)
        ) {
            val radius = size.minDimension/2
            val width = 2.dp.toPx()
            drawCircle(
                color = Color(0xFF004CFF),
                radius = radius,
                style = Stroke(
                    width = width,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(50f, 36f), 0f)
                )
            )
        }
        Image(
            painter = painterResource(R.drawable.camera_icon),
            contentDescription = "Camera Icon",
            modifier = Modifier.size(25.dp),
            alignment = Alignment.Center
        )
    }

}

@Preview
@Composable
private fun CreateAccountPreview() {
    RegisterScreen(
        navController = null
    )
}