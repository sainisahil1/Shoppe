package io.sahil.shoppe.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.sahil.shoppe.R
import io.sahil.shoppe.ui.screens.auth.components.BubbleLayerLeft
import io.sahil.shoppe.ui.screens.auth.components.ButtonMain
import io.sahil.shoppe.ui.screens.auth.components.Cancel
import io.sahil.shoppe.ui.screens.auth.components.FormTextField
import io.sahil.shoppe.ui.screens.common.Modules
import io.sahil.shoppe.ui.screens.common.Screens
import io.sahil.shoppe.ui.theme.TextBlack

@Composable
fun LogicScreen(navController: NavController?) {
    var email by remember { mutableStateOf("") }
    BubbleLayerLeft()
    Row (
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            painter = painterResource(R.drawable.bubble5),
            contentDescription = "bubble5",
            tint = Color(0xFF004BFE)
        )
    }
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Icon(
            painter = painterResource(R.drawable.bubble6),
            contentDescription = "bubble6",
            tint = Color(0xFFF2F5FE)
        )
    }
    Column (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
            text = "Login",
            color = TextBlack,
            fontSize = 52.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text(
                text = "Glad to have you back",
                color = TextBlack,
                fontSize = 19.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(end = 10.dp)
            )
            Icon(
                contentDescription = "heart",
                painter = painterResource(R.drawable.heart)
            )
        }
        FormTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = "Email"
        )
        ButtonMain(
            text = "Next",
            onClick = {
                navController?.navigate("${Modules.AUTH}/${Screens.PASSWORD}")
            },
            modifier = Modifier.padding(top = 35.dp, bottom = 15.dp)
        )
        Cancel(
            modifier = Modifier
                .padding(bottom = 50.dp),
            onclick = {
                navController?.navigate("${Modules.AUTH}/${Screens.GET_STARTED}")
            }
        )
    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
    LogicScreen(navController = null)
}