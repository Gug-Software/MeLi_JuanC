package com.jkgug.meli_juanc.ui.screen.product

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jkgug.meli_juanc.R
import com.jkgug.meli_juanc.ui.component.common.ErrorAndRetryView
import com.jkgug.meli_juanc.ui.component.common.Greeting
import com.jkgug.meli_juanc.ui.component.common.LoaderContent
import com.jkgug.meli_juanc.ui.component.productdetail.ProductDetailView
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductDetailsScreen(
    snackBarHostState: SnackbarHostState,
    viewModel: ProductDetailsViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {

    val mediumSpace = dimensionResource(R.dimen.space_m)

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(mediumSpace)
    ) {
        val (topContent, bottomContent) = createRefs()

        Greeting(
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
            uiState.productDetails?.let {
                ProductDetailView(it)
            } ?: run {
                when {
                    uiState.loading -> LoaderContent(modifier = Modifier.fillMaxSize())
                    uiState.error -> ErrorAndRetryView(
                        onRetryAction = { viewModel.getProductDetails() },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

    }

    uiState.messageForUser?.let { userMessage ->
        LaunchedEffect(userMessage) {
            scope.launch {
                snackBarHostState.showSnackbar(userMessage)
                viewModel.snackBarMessageShown()
            }
        }
    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "DefaultPreviewDark")
@Preview(uiMode = UI_MODE_NIGHT_NO, name = "DefaultPreviewLight")
@Composable
fun ProductDetailsScreenPreview() {
    MeLi_JuanCTheme {
        ProductDetailsScreen(
            snackBarHostState = SnackbarHostState()
        )
    }
}