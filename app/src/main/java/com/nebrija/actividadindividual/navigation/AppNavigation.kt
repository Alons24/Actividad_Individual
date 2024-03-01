import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nebrija.actividadindividual.Screens.Acceso
import com.nebrija.actividadindividual.Screens.ExpertoMENU
import com.nebrija.actividadindividual.Screens.MenuPrimero
import com.nebrija.actividadindividual.Screens.NivelMedioMENU
import com.nebrija.actividadindividual.Screens.PrincipianteMENU
import com.nebrija.actividadindividual.navigation.AppScreens


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    //Declaramos en startDestination la pantalla en la que va a empezar.
    NavHost(navController = navigationController, startDestination = AppScreens.Acceso.ruta)
    {
        composable(AppScreens.Acceso.ruta){Acceso(navigationController)}
        composable(AppScreens.MenuPrimero.ruta){MenuPrimero (navigationController) }
        composable(AppScreens.PrincipianteMENU.ruta){PrincipianteMENU (navigationController) }
        composable(AppScreens.NivelMedioMENU.ruta){NivelMedioMENU (navigationController) }
        composable(AppScreens.ExpertoMENU.ruta){ExpertoMENU (navigationController) }

        }

}


