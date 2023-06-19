package pe.edu.ulima.dbaccess.ui.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import pe.edu.ulima.dbaccess.ui.theme.Gray200
import pe.edu.ulima.dbaccess.ui.theme.Orange200
import pe.edu.ulima.dbaccess.R
import pe.edu.ulima.dbaccess.ui.app.viewmodels.SplashScreenViewModel

@Composable
public fun SplashScreen(
    navController: NavHostController,
    splashScreenViewModel: SplashScreenViewModel,
    navigate: Unit,){
    val caslonFont = FontFamily(Font(R.font.caslon_classico_sc_regular))

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_otg),
                contentDescription = "Logo OTG",
                modifier = Modifier.size(120.dp).padding(bottom = 10.dp),
                colorFilter = ColorFilter.tint(
                    color = if(isSystemInDarkTheme()) Orange200 else Gray200
                )
            )
            Text(
                text = "ON THE GO\n DBZ \n WORLD",
                textAlign = TextAlign.Center,
                fontFamily = caslonFont
            )
        }
    }
}