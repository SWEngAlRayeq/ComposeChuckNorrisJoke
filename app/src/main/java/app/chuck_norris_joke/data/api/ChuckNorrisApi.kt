package app.chuck_norris_joke.data.api

import app.chuck_norris_joke.data.model.ChuckNorrisJoke
import retrofit2.http.GET

interface ChuckNorrisApi {

    @GET("jokes/random")
    suspend fun getRandomJoke(): ChuckNorrisJoke
    
}