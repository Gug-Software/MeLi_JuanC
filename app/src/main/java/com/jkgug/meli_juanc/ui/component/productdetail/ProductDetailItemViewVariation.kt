package com.jkgug.meli_juanc.ui.component.productdetail

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.ProductDetailsAttribute
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductDetailItemViewVariation(
    productVariation: ProductDetailsAttribute,
    modifier: Modifier = Modifier
) {

    val spaceXS = dimensionResource(R.dimen.space_xs)

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = spaceXS)
    ) {

        val (leftContent, rightContent) = createRefs()
        Text(
            text = productVariation.name,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.constrainAs(leftContent) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )

        Text(
            text = productVariation.value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(rightContent) {
                    start.linkTo(leftContent.end, spaceXS)
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
        ProductDetailItemViewVariation(
            productVariation = ProductDetailsAttribute(
                name = "Leanna McCray",
                value = "habeo"
            )
        )
    }
}