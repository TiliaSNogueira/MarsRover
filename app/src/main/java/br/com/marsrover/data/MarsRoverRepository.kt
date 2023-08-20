package br.com.marsrover.data

import br.com.marsrover.domain.model.RoverManifestUiState
import br.com.marsrover.domain.model.toUiModel
import br.com.marsrover.service.MarsRoverService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverRepository @Inject constructor(private val service: MarsRoverService) {

    fun gerMarsRoverManifest(roverName: String): Flow<RoverManifestUiState> = flow {
        try {
            emit(
                toUiModel(
                    service.getMarsRoverManifest(roverName = roverName.lowercase())
                )
            )
        } catch (t: Throwable) {
            emit(RoverManifestUiState.Error)
        }
    }
}