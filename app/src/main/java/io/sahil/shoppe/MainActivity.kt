package io.sahil.shoppe

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.sahil.shoppe.ui.screens.auth.GetStarted
import io.sahil.shoppe.ui.screens.auth.LogicScreen
import io.sahil.shoppe.ui.screens.auth.PasswordScreen
import io.sahil.shoppe.ui.screens.auth.RegisterScreen
import io.sahil.shoppe.ui.screens.common.Modules
import io.sahil.shoppe.ui.screens.common.Screens
import io.sahil.shoppe.ui.screens.shop.ShopActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            MainNavigation(moveToShop)
        }
    }

    private val moveToShop = {
        startActivity(Intent(applicationContext, ShopActivity::class.java))
    }
}

@Composable
fun MainNavigation(moveToShop: () -> Unit) {
    val navController = rememberNavController()

    val authNavHost: @Composable () -> Unit = {
        NavHost(
            navController = navController,
            startDestination = "${Modules.AUTH}/${Screens.GET_STARTED}"
        ) {
            composable("${Modules.AUTH}/${Screens.GET_STARTED}") {
                GetStarted(navController)
            }
            composable("${Modules.AUTH}/${Screens.REGISTER}") {
                RegisterScreen(navController)
            }
            composable("${Modules.AUTH}/${Screens.LOGIN}") {
                LogicScreen(navController)
            }
            composable("${Modules.AUTH}/${Screens.PASSWORD}") {
                PasswordScreen(navController)
            }
        }
    }

    authNavHost()
}


