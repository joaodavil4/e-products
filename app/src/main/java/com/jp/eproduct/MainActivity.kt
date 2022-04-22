package com.jp.eproduct

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.jp.eproduct.ui.compositions.Products
import com.jp.eproduct.ui.theme.EproductTheme
import com.jp.eproduct.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EproductTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.white)
                ) {
                    val viewModel by viewModels<ProductViewModel>()
                    viewModel.loadItems()
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = "e-Products",
                            fontSize = 50.sp,
                            fontWeight = FontWeight(700),
                            color = colorResource(id = R.color.purple_200)
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Products(viewModel = viewModel)
                    }

                }
            }
        }
    }
}