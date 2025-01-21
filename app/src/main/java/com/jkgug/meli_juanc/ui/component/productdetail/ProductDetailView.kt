package com.jkgug.meli_juanc.ui.component.productdetail

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.domain.ProductPrice
import com.jkgug.meli_juanc.ui.component.product.ProductFreeShippingView
import com.jkgug.meli_juanc.ui.component.product.ProductPriceView
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductDetailView(
    productDetails: ProductDetails,
    modifier: Modifier = Modifier
) {

    val spaceS = dimensionResource(R.dimen.space_s)
    val lineXS = dimensionResource(R.dimen.line_xs)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spaceS)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = productDetails.title,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        ProductDetailViewPictures(
            productDetails.listPictures,
            modifier = Modifier.padding(top = spaceS)
        )
        ProductPriceView(productDetails.price)
        if (productDetails.freeShipping) {
            ProductFreeShippingView()
        }

        if (productDetails.listVariations.isNotEmpty()) {
            ProductDetailViewVariationsOrSaleTerms(productDetails.listVariations)
            HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = lineXS)
        }

        if (productDetails.listSaleTerms.isNotEmpty()) {
            ProductDetailViewVariationsOrSaleTerms(productDetails.listSaleTerms)
            HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = lineXS)
        }
        ProductDetailViewAttributes(productDetails.listAttributes)
    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductDetailViewPreview() {
    MeLi_JuanCTheme {
        ProductDetailView(
            productDetails = ProductDetails(
                id = "fames",
                title = "tota",
                thumbnail = "cum",
                price = ProductPrice(price = 2.3, originalPrice = null),
                freeShipping = false,
                listAttributes = listOf(),
                listVariations = listOf(),
                listSaleTerms = listOf(),
                listPictures = listOf()
            )
        )
    }
}