package com.jp.eproduct.ui.compositions

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jp.eproduct.R
import com.jp.eproduct.model.Product

@Preview
@Composable
fun Preview(){
    val product = Product("teste", "Red", "12", "asd")
    ProductCard(item = product)
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductCard(
    item: Product
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.product), contentDescription = null,
        )

        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = item.name,
            fontSize = 16.sp,
            fontWeight = FontWeight(700)
        )
        Text(
            text = item.color,
            fontSize = 14.sp,
            fontWeight = FontWeight(400)
        )
        Text(
            text = item.size,
            fontSize = 14.sp,
            fontWeight = FontWeight(400)
        )
        val context = LocalContext.current
        Button(onClick = {
            Toast.makeText(context, "Added to the cart!", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Buy")
        }
    }
}