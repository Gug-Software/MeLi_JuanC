package com.jkgug.meli_juanc.ui.component.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ErrorAndRetryView(
    onRetryAction: () -> Unit,
    modifier: Modifier
) {

    val spaceS = dimensionResource(R.dimen.space_s)
    val spaceM = dimensionResource(R.dimen.space_m)
    val spaceXL = dimensionResource(R.dimen.space_xl)

    val sizeImage = dimensionResource(R.dimen.size_image)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(spaceXL),
            verticalArrangement = Arrangement.spacedBy(spaceS),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val cardElevation = dimensionResource(R.dimen.card_elevation)
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = cardElevation),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                ),
                border = BorderStroke(
                    width = dimensionResource(R.dimen.border_xs),
                    color = MaterialTheme.colorScheme.error
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spaceM),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.TwoTone.Warning,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(sizeImage)
                    )
                    Text(
                        text = stringResource(id = R.string.error_title),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(id = R.string.error_subtitle),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            Button(
                modifier = Modifier,
                onClick = onRetryAction
            ) {
                Text(text = stringResource(id = R.string.error_retry))
            }
        }
    }


}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ErrorAndRetryPreview() {
    MeLi_JuanCTheme {
        ErrorAndRetryView(
            modifier = Modifier, onRetryAction = {}
        )
    }
}
