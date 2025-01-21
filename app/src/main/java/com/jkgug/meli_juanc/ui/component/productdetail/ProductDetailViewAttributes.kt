package com.jkgug.meli_juanc.ui.component.productdetail

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.ProductDetailsAttribute
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductDetailViewAttributes(
    attributeList: List<ProductDetailsAttribute>,
    modifier: Modifier = Modifier
) {

    val mediumSpace = dimensionResource(R.dimen.space_m)

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(top = mediumSpace)
    ) {
        val (topContent, bottomContent) = createRefs()

        Text(
            text = stringResource(R.string.product_details_text_attributes),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(topContent) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(bottomContent) {
                    top.linkTo(topContent.bottom, mediumSpace)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
        ) {
            if (attributeList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsIndexed(
                        items = attributeList,
                        itemContent = { index, item ->
                            ProductDetailItemViewAttribute(attribute = item, index)
                        })
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductDetailViewAttributesPreview() {
    MeLi_JuanCTheme {
        ProductDetailViewVariationsOrSaleTerms(
            listProductDetailsVariation = listOf(
                ProductDetailsAttribute(
                    name = "Arline Sullivan", value = "erat"
                ),
                ProductDetailsAttribute(
                    name = "Arline Sullivan", value = "erat"
                ),
                ProductDetailsAttribute(
                    name = "Arline Sullivan", value = "erat"
                ),
            )
        )
    }
}