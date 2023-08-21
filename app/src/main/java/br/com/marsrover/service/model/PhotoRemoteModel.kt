package br.com.marsrover.service.model

import com.google.gson.annotations.SerializedName

data class PhotoRemoteModel(
    val camera: CameraRemoteModel,
    @field:SerializedName("earth_date") val earthDate: String,
    val id: Int,
    @field:SerializedName("img_src") val imageSrc: String,
    val rover: RoverRemoteModel,
    val sol: Int
)
