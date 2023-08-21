package br.com.marsrover.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.marsrover.domain.model.RoverPhotoUiState
import br.com.marsrover.ui.photolist.MarsRoverPhotoViewModel

@Composable
fun PhotoScreen(
    roverName: String?,
    sol: String?,
    viewModel: MarsRoverPhotoViewModel
) {
    val viewState by viewModel.roverPhotoUiState.collectAsStateWithLifecycle()

    if (roverName != null && sol != null) {
        LaunchedEffect(Unit) {
            viewModel.getMarsRoverPhoto(roverName, sol)
        }
        when (val roverPhotoUiState = viewState) {
            RoverPhotoUiState.Loading -> Loading()
            RoverPhotoUiState.Error -> Error()
            is RoverPhotoUiState.Success -> PhotoList(roverPhotoUiModelList = roverPhotoUiState.roverPhotoUiModelList)
        }


    }
}