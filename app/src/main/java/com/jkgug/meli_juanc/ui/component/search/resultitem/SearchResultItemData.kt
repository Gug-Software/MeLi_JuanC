package com.jkgug.meli_juanc.ui.component.search.resultitem

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.domain.ProductInstallments
import com.jkgug.meli_juanc.domain.ProductPrice
import com.jkgug.meli_juanc.ui.component.product.ProductFreeShippingView
import com.jkgug.meli_juanc.ui.component.product.ProductInstallmentsView
import com.jkgug.meli_juanc.ui.component.product.ProductPriceView
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun SearchResultItemData(
    product: Product,
    modifier: Modifier = Modifier
) {

    val spaceS = dimensionResource(R.dimen.space_s)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spaceS),
    ) {
        Text(
            text = product.title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.fillMaxWidth()
        )
        ProductPriceView(product.price)
        product.installments?.let { ProductInstallmentsView(it) }
        if (product.freeShipping) {
            ProductFreeShippingView()
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun SearchResultItemDataPreview() {
    MeLi_JuanCTheme {
        SearchResultItemData(
            product = Product(
                id = "algo",
                title = "Set  De 6  Cuadros  Futbolistas  Neymar-messi-ronaldo-zidane",
                thumbnail = "",
                price = ProductPrice(price = 23000.0, originalPrice = 28000.0),
                installments = ProductInstallments(
                    quantity = 12,
                    rate = 0,
                    amount = 5000.0
                ),
                freeShipping = true
            )
        )
    }
}