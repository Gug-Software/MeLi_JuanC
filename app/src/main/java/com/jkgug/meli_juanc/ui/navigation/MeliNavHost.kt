package com.jkgug.meli_juanc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jkgug.meli_juanc.ui.screen.product.ProductDetailsScreen
import com.jkgug.meli_juanc.ui.screen.search.SearchScreen

@Composable
fun MeliNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val startDestination = ProductDetails.route
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(
            route = Search.route,
        ) {
            SearchScreen()
        }

        composable(
            route = ProductDetails.route,
        ) {
            ProductDetailsScreen()
        }

    }
}