package com.jkgug.meli_juanc.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface MeliDestination {
    val route: String
}

object Search : MeliDestination {
    override val route = "search"
}

object ProductDetails : MeliDestination {
    override val route = "productDetails"
    const val PRODUCT_ID = "productIdArg"
    val routeWithArgs = "${route}/{${PRODUCT_ID}}"
    val arguments = listOf(
        navArgument(PRODUCT_ID) { type = NavType.StringType }
    )
}