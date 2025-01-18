package com.jkgug.meli_juanc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.jkgug.meli_juanc.ui.navigation.MeliNavHost
import com.jkgug.meli_juanc.ui.theme.MeLi_JuanCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeLiApp()
        }
    }
}

@Composable
private fun MeLiApp() {

    MeLi_JuanCTheme {
        val navController = rememberNavController()
        val snackBarHostState = remember { SnackbarHostState() }
        Surface(
            tonalElevation = dimensionResource(id = R.dimen.tonal_elevation),
        ) {
            Scaffold(
                snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            ) { innerPadding ->
                MeliNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeLi_JuanCTheme {
        MeLiApp()
    }
}