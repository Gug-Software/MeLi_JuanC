package com.jkgug.meli_juanc.ui.screen.search

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.ui.component.common.EmptyContent
import com.jkgug.meli_juanc.ui.component.common.Greeting
import com.jkgug.meli_juanc.ui.component.search.SearchView
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

@Composable
fun SearchScreen(
) {

    val mediumSpace = dimensionResource(R.dimen.space_m)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(mediumSpace)
    ) {

        val (topContent, search, bottomContent) = createRefs()
        Greeting(
            isLoading = false,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(topContent) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        SearchView(
            onSearchChanged = {},
            searchKeyValue = "hi",
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(search) {
                    top.linkTo(topContent.bottom, mediumSpace)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumSpace)
                .constrainAs(bottomContent) {
                    top.linkTo(search.bottom, mediumSpace)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            EmptyContent(modifier = Modifier.fillMaxWidth())
            //LoaderContent(modifier = Modifier.fillMaxWidth())
            //NotResultsContent(modifier = Modifier.fillMaxWidth())
            //ErrorAndRetry({}, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun SearchScreenPreview() {
    MeLi_JuanCTheme {
        SearchScreen()
    }
}