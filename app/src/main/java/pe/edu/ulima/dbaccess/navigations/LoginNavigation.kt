package pe.edu.ulima.dbaccess.navigations


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import pe.edu.ulima.dbaccess.ui.app.screens.SplashScreen
import pe.edu.ulima.dbaccess.ui.app.viewmodels.SplashScreenViewModel
import pe.edu.ulima.ui.login.uis.LoginScreen
import pe.edu.ulima.ui.login.viewmodels.LoginViewModel


@Composable
fun LoginNavigation(
    loginViewModel: LoginViewModel,
    splashScreenViewModel: SplashScreenViewModel,
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val parameter = navBackStackEntry?.arguments?.getString("parameter")
    val optionalParameter = navBackStackEntry?.arguments?.getString("optionalParameter")

    NavHost(
        navController = navController,
        startDestination = "/"
    ) {
        composable(
            route = "/",
            arguments = listOf()
        ) { entry ->
            SplashScreen(
                navController,
                splashScreenViewModel ,
                navController.navigate("/login") //Despues de 2 segundos vamos a /login/
            )

        }

        composable(
            route = "/login/",
            arguments = listOf()
        ) { entry ->
            LoginScreen(
                loginViewModel,
                goToResetPasswordScreen =
             {
                navController.navigate("/reset_password")
             })
        }
        }
    }

