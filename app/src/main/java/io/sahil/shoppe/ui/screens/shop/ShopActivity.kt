package io.sahil.shoppe.ui.screens.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.sahil.shoppe.R

class ShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainFrame()
        }
    }
}

@Composable
fun MainFrame() {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        ShopHome(
            modifier = Modifier.weight(1f)
        )
        MainFooter()
    }
}

@Composable
fun MainFooter() {
    var selectedItem by remember { mutableStateOf("Shop") }
    val bottomNavItems = listOf(
        "Shop" to R.drawable.shop,
        "Wishlist" to R.drawable.wishlist,
        "Categories" to R.drawable.categories,
        "Cart" to R.drawable.cart,
        "Account" to R.drawable.account
    )
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind{
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 0.5.dp.toPx()
                )
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        bottomNavItems.forEach { (label, drawable) ->
            Icon(
                painter = painterResource(drawable),
                contentDescription = label,
                tint = if (selectedItem == label) Color(0xFF004CFF) else Color(0xFF000000),
                modifier = Modifier
                    .padding(vertical = 14.dp)
                    .clickable(
                        enabled = true,
                        onClick = {
                            selectedItem = label
                        }
                    )
            )
        }
    }
}

@Preview
@Composable
private fun MainFramePreview() {
    MainFrame()
}