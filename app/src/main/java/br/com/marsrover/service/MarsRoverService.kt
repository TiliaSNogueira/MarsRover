package br.com.marsrover.service

import br.com.marsrover.domain.model.RoverManifestRemoteModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface MarsRoverService {

    @GET("mars-photos/api/v1/manifests/{roverName}?api_key=DEMO_KEY")
    suspend fun getMarsRoverManifest(
        @Path("roverName") roverName: String
    ): RoverManifestRemoteModel

    companion object {
        private const val base_url = "https://api.nasa.gov/"

        fun create(): MarsRoverService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder().addInterceptor(logger).build()

            return Retrofit.Builder().baseUrl(base_url).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(MarsRoverService::class.java)
        }

    }


}