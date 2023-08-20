package br.com.marsrover.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.marsrover.domain.model.RoverManifestUiState
import br.com.marsrover.ui.manifestlist.MarsRoverManifestViewModel

@Composable
fun ManifestScreen(
    roverName: String?,
    viewModel: MarsRoverManifestViewModel
) {
    val viewState by viewModel.roverManifestUiState.collectAsStateWithLifecycle()

    if(roverName != null) {
        LaunchedEffect(Unit) {
            viewModel.getMarsRoverManifest(roverName)
        }
        when(val roverManifestUiState = viewState) {
            RoverManifestUiState.Loading -> Loading()
            RoverManifestUiState.Error -> Error()
            is RoverManifestUiState.Success -> ManifestList(roverManifestUiModelList = roverManifestUiState.roverManifestUiModelList )
        }
    }
}

