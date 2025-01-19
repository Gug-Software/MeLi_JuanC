package com.jkgug.meli_juanc.ui.component.product

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.domain.ProductInstallments
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductInstallmentsView(
    productInstallments: ProductInstallments,
    modifier: Modifier = Modifier
) {

    val spaceXS = dimensionResource(R.dimen.space_xs)

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(spaceXS)
    ) {

        Text(
            text = stringResource(R.string.product_installments_in),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary,
        )

        val textInstallments = stringResource(
            R.string.product_installments_text,
            productInstallments.quantity,
            productInstallments.amountString,
            productInstallments.rate
        )

        Text(
            text = textInstallments,
            style = MaterialTheme.typography.labelSmall,
            color = colorResource(R.color.green_text),
        )

    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductInstallmentsViewPreview() {
    MeLi_JuanCTheme {
        ProductInstallmentsView(
            productInstallments = ProductInstallments(
                quantity = 12,
                rate = 0,
                amount = 34000.0
            ), modifier = Modifier

        )
    }
}
