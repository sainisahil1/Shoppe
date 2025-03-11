package io.sahil.shoppe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.sahil.shoppe.R
import io.sahil.shoppe.ui.screens.common.ButtonMain
import io.sahil.shoppe.ui.theme.ShoppeTheme

@Composable
fun GetStarted() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconCircle(
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Title(
            modifier = Modifier.padding(bottom = 18.dp)
        )
        Subtitle(
            modifier = Modifier.padding(bottom = 100.dp)
        )
        ButtonMain("Let's get started")
        Spacer(modifier = Modifier.size(18.dp))
        Login(modifier = Modifier.padding(bottom = 24.dp))
    }
}



@Composable
fun IconCircle(modifier: Modifier) {
    Box (
        modifier = modifier
            .size(134.dp)
            .shadow(
                4.dp,
                CircleShape,
                clip = false,
                spotColor = Color.Black.copy(alpha = 0.25f)
            )
            .offset(y = (-5).dp)
            .clip(CircleShape)
            .background(Color.White)
    ){
        Image(
            painter = painterResource(R.drawable.shoppe_bag),
            contentDescription = "Shoppe Bag",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
fun Title(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.app_name),
        fontSize = 52.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun Subtitle(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Beautiful eCommerce UI Kit\nfor your online store",
        textAlign = TextAlign.Center,
        fontSize = 19.sp,
        fontWeight = FontWeight.Light,
        color = Color(0xFF202020)
    )
}

@Composable
fun Login(modifier: Modifier){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "I already have an account",
            color = Color(0xFF202020),
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(end = 16.dp)
        )
        Box (
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(Color(0xFF004CFF)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.right_arrow),
                contentDescription = "right arrow",
                modifier = Modifier.size(14.dp, 11.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ShoppeTheme {
        GetStarted()
    }
}
