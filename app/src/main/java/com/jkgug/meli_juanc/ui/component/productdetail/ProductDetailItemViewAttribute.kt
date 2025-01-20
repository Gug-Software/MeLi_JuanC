package com.jkgug.meli_juanc.ui.component.productdetail

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.ProductDetailsAttribute
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductDetailItemViewAttribute(
    attribute: ProductDetailsAttribute,
    index: Int,
    modifier: Modifier = Modifier
) {

    val spaceXS = dimensionResource(R.dimen.space_xs)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                if (index % 2 == 0) {
                    MaterialTheme.colorScheme.background
                } else {
                    MaterialTheme.colorScheme.primaryContainer
                }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = attribute.name,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .padding(vertical = spaceXS)
        )
        Text(
            text = attribute.value,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)
                .padding(vertical = spaceXS)
        )
    }

}


@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductDetailItemViewAttributePreview() {
    MeLi_JuanCTheme {
        ProductDetailItemViewAttribute(
            attribute = ProductDetailsAttribute(
                name = "Ursula Holder",
                value = "eu"
            ), 1
        )
    }
}