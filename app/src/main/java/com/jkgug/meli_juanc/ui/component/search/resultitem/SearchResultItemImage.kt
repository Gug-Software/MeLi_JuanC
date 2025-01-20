package com.jkgug.meli_juanc.ui.component.search.resultitem

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun SearchResultItemImage(
    thumbnail: String,
    modifier: Modifier = Modifier
) {

    val spaceXS = dimensionResource(R.dimen.space_xs)
    val sizeImage = dimensionResource(R.dimen.size_image_product)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(sizeImage)
            .padding(spaceXS),
    ) {
        val painter = rememberAsyncImagePainter(thumbnail)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun SearchResultItemImagePreview() {
    MeLi_JuanCTheme {
        SearchResultItemImage("")
    }
}