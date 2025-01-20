package com.jkgug.meli_juanc.ui.component.productdetail

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun ProductDetailViewPictures(
    images: List<String>,
    modifier: Modifier = Modifier
) {

    val state = rememberPagerState { images.size }
    val sizeImage = dimensionResource(R.dimen.size_image_product_detail)

    HorizontalPager(
        state = state,
        modifier = modifier
            .fillMaxWidth()
            .height(sizeImage),
    ) { page ->
        val painter = rememberAsyncImagePainter(images[page])
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
    HorizontalPagerIndicators(images.size, state.currentPage, modifier = Modifier.fillMaxWidth())
}

@Composable
fun HorizontalPagerIndicators(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    inactiveColor: Color = MaterialTheme.colorScheme.onTertiary
) {

    val spaceS = dimensionResource(R.dimen.space_s)

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(spaceS)
                    .clip(CircleShape)
                    .background(
                        if (index == currentPage) activeColor else inactiveColor
                    )
                    .padding(spaceS)
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductDetailViewPicturesPreview() {
    MeLi_JuanCTheme {
        ProductDetailViewPictures(
            images = listOf()
        )
    }
}