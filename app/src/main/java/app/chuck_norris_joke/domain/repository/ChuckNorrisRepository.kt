package app.chuck_norris_joke.domain.repository

import app.chuck_norris_joke.data.model.ChuckNorrisJoke

interface ChuckNorrisRepository {
    suspend fun getRandomJoke(): ChuckNorrisJoke
}