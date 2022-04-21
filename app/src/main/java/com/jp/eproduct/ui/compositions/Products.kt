package com.jp.eproduct.ui.compositions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.jp.eproduct.viewmodel.ProductViewModel

@Composable
fun Products(
    viewModel: ProductViewModel
) {
    val isRefreshing by viewModel.isRefreshing.observeAsState(false)
    val products by viewModel.products.observeAsState(listOf())

    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { viewModel.refresh() }
    ) {
        LazyColumn(
            state = viewModel.lazyListState ?: rememberLazyListState(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            items(products) { item ->
                ProductCard(item = item)

            }
        }
    }
}