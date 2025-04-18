package io.sahil.shoppe.presentation.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.sahil.shoppe.R
import io.sahil.shoppe.presentation.ui.auth.components.BubbleLayerLeft
import io.sahil.shoppe.presentation.ui.auth.components.FormTextField
import io.sahil.shoppe.presentation.theme.TextBlack

@Composable
fun PasswordScreen(navController: NavController?, moveToShop: () -> Unit) {
    var passwordInput by remember { mutableStateOf("") }
    val focusRequester = remember {FocusRequester()}

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    BubbleLayerLeft()
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(105.dp)
                .clip(CircleShape)
                .background(Color.White)
                .shadow(elevation = 0.5.dp, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                contentDescription = "avatar",
                painter = painterResource(R.drawable.avatar),
                modifier = Modifier
                    .size(91.dp)
                    .clip(CircleShape)
            )
        }
        Text(
            text = "Hello, Romina!!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextBlack,
            modifier = Modifier.padding(vertical = 30.dp)
        )
        Text(
            text = "Type your password",
            fontSize = 19.sp,
            fontWeight = FontWeight.Light,
            color = TextBlack,
            modifier = Modifier.padding(vertical = 30.dp)
        )
        FormTextField(
            value = passwordInput,
            onValueChange = {passwordInput = it},
            placeholder = "",
            modifier = Modifier
                .padding(horizontal = 60.dp)
                .focusRequester(focusRequester = focusRequester),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    moveToShop()
                }
            )
        )
    }
}

@Preview
@Composable
private fun PasswordScreenPreview() {
    PasswordScreen(navController = null, {})
}