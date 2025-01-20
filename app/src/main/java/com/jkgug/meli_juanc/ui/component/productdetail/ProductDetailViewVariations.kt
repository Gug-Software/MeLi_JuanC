package com.jkgug.meli_juanc.ui.component.productdetail

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.ProductDetailsAttribute
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductDetailViewVariations(
    listProductDetailsVariation: List<ProductDetailsAttribute>,
    modifier: Modifier = Modifier
) {

    val spaceS = dimensionResource(R.dimen.space_s)

    if (listProductDetailsVariation.isNotEmpty()) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(spaceS)
        ) {
            itemsIndexed(
                items = listProductDetailsVariation,
                itemContent = { index, item ->
                    ProductDetailItemViewVariation(
                        productVariation = item,
                        modifier = Modifier
                    )
                })
        }
    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductDetailViewVariationsPreview() {
    MeLi_JuanCTheme {
        ProductDetailViewVariations(
            listProductDetailsVariation = listOf(
                ProductDetailsAttribute(
                    name = "Arline Sullivan", value = "erat"
                ),
                ProductDetailsAttribute(
                    name = "Arline Sullivan", value = "erat"
                )
            ),

            )
    }
}