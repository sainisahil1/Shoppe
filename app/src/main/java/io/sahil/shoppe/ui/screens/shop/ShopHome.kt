package io.sahil.shoppe.ui.screens.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.sahil.shoppe.R
import io.sahil.shoppe.ui.theme.TextBlack

@Composable
fun ShopHome(modifier: Modifier) {
    val storyItems = listOf(
        R.drawable.story1,
        R.drawable.story2,
        R.drawable.story3,
        R.drawable.story1,
        R.drawable.story2,
        R.drawable.story3,
        R.drawable.story1
    )
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Stories",
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            modifier = Modifier.padding(bottom = 10.dp),
            color = TextBlack
        )
        Stories(storyItems)
    }
}

@Composable
fun Stories(storyItems: List<Int>) {
    LazyRow {
        items(storyItems) {
            item: Int ->
            StoriesItem(item)
        }
    }
}

@Composable
fun StoriesItem(resourceId: Int) {
    Image(
        painter = painterResource(resourceId),
        contentDescription = "image",
        modifier = Modifier.size(104.dp, 175.dp),
    )
}


@Preview
@Composable
private fun ShopScreenPreview() {
    ShopHome(modifier = Modifier)
}