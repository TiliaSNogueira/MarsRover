package br.com.marsrover

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.marsrover.nav.Action
import br.com.marsrover.nav.Destinations.Home
import br.com.marsrover.nav.Destinations.Manifest
import br.com.marsrover.ui.theme.MarsRoverTheme
import br.com.marsrover.ui.view.ManifestScreen
import br.com.marsrover.ui.view.RoverList

@Composable
fun NavCompose() {

    val navController = rememberNavController()
    val actions = remember(navController) {
        Action(navController)
    }

    MarsRoverTheme {
        NavHost(navController = navController, startDestination = Home) {
            composable(Home) {
                RoverList() { roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Manifest) { backStackEntry ->
                ManifestScreen(
                    roverName = backStackEntry.arguments?.getString("roverName")
                )
            }
        }
    }

}