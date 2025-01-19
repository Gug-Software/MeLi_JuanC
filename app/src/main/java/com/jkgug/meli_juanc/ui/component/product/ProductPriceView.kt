package com.jkgug.meli_juanc.ui.component.product

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.ProductPrice
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductPriceView(
    productPrice: ProductPrice,
    modifier: Modifier = Modifier
) {

    val spaceS = dimensionResource(R.dimen.space_s)

    if (productPrice.originalPrice == null) {
        Text(
            text = productPrice.priceString,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
        )
    } else {

        ConstraintLayout(
            modifier = modifier.fillMaxWidth()
        ) {
            val (originalPrice, price, percent) = createRefs()

            Text(
                text = productPrice.originalPriceString,
                modifier = Modifier.constrainAs(originalPrice) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary,
                textDecoration = TextDecoration.LineThrough
            )
            Text(
                text = productPrice.priceString,
                modifier = Modifier.constrainAs(price) {
                    top.linkTo(originalPrice.bottom)
                    start.linkTo(parent.start)
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = productPrice.percentDiscount,
                modifier = Modifier.constrainAs(percent) {
                    start.linkTo(price.end, margin = spaceS)
                    baseline.linkTo(price.baseline) // Align baselines
                },
                style = MaterialTheme.typography.labelSmall,
                color = colorResource(R.color.green_text),
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductPriceViewPreview() {
    MeLi_JuanCTheme {
        ProductPriceView(
            productPrice = ProductPrice(
                price = 15000.0,
                originalPrice = null
            ), modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductPriceViewPreviewDiscount() {
    MeLi_JuanCTheme {
        ProductPriceView(
            productPrice = ProductPrice(
                price = 10000.0,
                originalPrice = 20000.0
            ), modifier = Modifier

        )
    }
}