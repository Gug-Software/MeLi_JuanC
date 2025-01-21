package com.jkgug.meli_juanc.ui.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jkgug.meli_juanc.ui.screen.product.ProductDetailsScreen
import com.jkgug.meli_juanc.ui.screen.search.SearchScreen

@Composable
fun MeliNavHost(
    navController: NavHostController,
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {

    val startDestination = Search.route

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(
            route = Search.route
        ) {
            SearchScreen(
                snackBarHostState = snackBarHostState,
                onProductClick = { productId ->
                    navController.navigateToProductDetails(productId)
                }
            )
        }

        composable(
            route = ProductDetails.routeWithArgs, arguments = ProductDetails.arguments,
        ) {
            ProductDetailsScreen(snackBarHostState)
        }

    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

private fun NavHostController.navigateToProductDetails(productId: String) {
    this.navigateSingleTopTo("${ProductDetails.route}/$productId")
}