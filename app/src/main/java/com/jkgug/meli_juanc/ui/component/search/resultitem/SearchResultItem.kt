package com.jkgug.meli_juanc.ui.component.search.resultitem

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.domain.ProductInstallments
import com.jkgug.meli_juanc.domain.ProductPrice
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun SearchResultItem(
    product: Product,
    modifier: Modifier = Modifier
) {

    val spaceS = dimensionResource(R.dimen.space_s)

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = spaceS)
            .clickable { },
    ) {

        val (leftContent, rightContent) = createRefs()
        SearchResultItemImage(
            modifier = Modifier.constrainAs(leftContent) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )

        SearchResultItemData(
            product = product,
            modifier = Modifier
                .constrainAs(rightContent) {
                    start.linkTo(leftContent.end, spaceS)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
        )
    }
}


@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun SearchResultItemPreview() {
    MeLi_JuanCTheme {
        SearchResultItem(
            product = Product(
                id = "algo",
                title = "Algo de zidane",
                thumbnail = "",
                price = ProductPrice(price = 23000.0, originalPrice = 35000.0),
                installments = ProductInstallments(
                    quantity = 12,
                    rate = 0,
                    amount = 4500.0
                ),
                freeShipping = true

            )
        )
    }
}