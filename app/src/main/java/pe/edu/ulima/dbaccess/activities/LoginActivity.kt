package pe.edu.ulima.dbaccess.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import pe.edu.ulima.dbaccess.navigations.LoginNavigation
import pe.edu.ulima.dbaccess.ui.app.viewmodels.SplashScreenViewModel
import pe.edu.ulima.dbaccess.ui.theme.AccesoDBTheme
import pe.edu.ulima.ui.login.viewmodels.LoginViewModel
import pe.edu.ulima.ui.login.viewmodels.ResetPasswordScreenViewModel

class LoginActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // login navigation
        var loginViewModel = LoginViewModel()
        var resetPasswordScreenViewModel = ResetPasswordScreenViewModel()
        val splashScreenViewModel = SplashScreenViewModel()
        // screen navigation
        setContent {
            AccesoDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //SplashScreen()
                    LoginNavigation(
                        loginViewModel = loginViewModel,
                        splashScreenViewModel = splashScreenViewModel,
                    )
                    //PokemonDetailScreen(viewModel = PokemonDetailViewModel())
                    //TouchScreen()
                    //Aqui abajo tambien pueden estas las navegaciones de las demas partes que tiene la aplicacion?¿
                    //Se ponen por separado ?¿
                }
            }
        }
    }
}