package com.jkgug.meli_juanc.ui.component.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun Greeting(
    modifier: Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.greeting_title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(R.string.greeting_subtitle),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun GreetingPreview() {
    MeLi_JuanCTheme {
        Greeting(modifier = Modifier)
    }
}