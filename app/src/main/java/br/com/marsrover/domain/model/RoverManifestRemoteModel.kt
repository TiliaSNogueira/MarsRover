package br.com.marsrover.domain.model

import br.com.marsrover.service.model.PhotoManifestRemoteModel
import com.google.gson.annotations.SerializedName

data class RoverManifestRemoteModel(
    @field:SerializedName("photo_manifest") val photoManifest: PhotoManifestRemoteModel
)
