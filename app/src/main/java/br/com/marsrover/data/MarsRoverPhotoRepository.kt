package br.com.marsrover.data

import br.com.marsrover.domain.model.RoverPhotoUiModel
import br.com.marsrover.domain.model.RoverPhotoUiState
import br.com.marsrover.service.MarsRoverPhotoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverPhotoRepository @Inject constructor(private val api: MarsRoverPhotoService) {

    fun getMarsRoverPhoto(roverName: String, sol: String): Flow<RoverPhotoUiState> = flow {
        try {
            val networkResult = api.getMarsRoverPhotos(roverName, sol)
            emit(RoverPhotoUiState.Success(networkResult.photos.map { photo ->
                RoverPhotoUiModel(
                    id = photo.id,
                    roverName = photo.rover.name,
                    imgSrc = photo.imageSrc,
                    sol = photo.sol.toString(),
                    earthDate = photo.earthDate,
                    cameraFullName = photo.camera.fullName
                )
            }))
        } catch (t: Throwable) {
            emit(RoverPhotoUiState.Error)
        }
    }
}