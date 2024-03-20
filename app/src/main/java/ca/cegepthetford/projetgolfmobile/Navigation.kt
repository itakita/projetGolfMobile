import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation() {
    val controleurNav = rememberNavController()
    NavHost(
        navController = controleurNav,
        startDestination = "EcranPrincipal"
    ) {
        composable(route = "EcranPrincipal") {

        }
        composable(
            route = "FicheTrou/{noTrou}",
            arguments = listOf(
                navArgument(name = "noTrou") {
                    type = NavType.IntType
                }
            )
        ) {entree ->

        }
    }
}
