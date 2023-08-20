package br.com.marsrover.nav

import androidx.navigation.NavController
import br.com.marsrover.nav.Destinations.Home


object Destinations {
    const val Home = "home"
    const val Manifest = "manifest/{roverName}"
}

class Action(navController: NavController) {
    val home: () -> Unit = {
        navController.navigate(Home)
    }
    val manifest: (roverName: String) -> Unit = { roverName ->
        navController.navigate("manifest/$roverName")
    }
}