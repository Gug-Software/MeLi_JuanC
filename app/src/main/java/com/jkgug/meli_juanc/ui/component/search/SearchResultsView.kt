package com.jkgug.meli_juanc.ui.component.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.ui.component.search.resultitem.SearchResultItem

@Composable
fun SearchResultsView(
    products: List<Product> = emptyList(),
    onProductClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {

    val spaceS = dimensionResource(R.dimen.space_s)
    val lineXS = dimensionResource(R.dimen.line_xs)

    if (products.isNotEmpty()) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(spaceS)
        ) {
            itemsIndexed(
                items = products,
                itemContent = { index, item ->
                    SearchResultItem(
                        product = item,
                        modifier = Modifier.clickable { onProductClick(item.id) })
                    if (index != products.size - 1) {
                        HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = lineXS)
                    }
                })
        }
    }

}