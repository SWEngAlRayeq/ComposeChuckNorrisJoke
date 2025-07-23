package app.chuck_norris_joke.data.repo_impl

import app.chuck_norris_joke.data.api.ChuckNorrisApi
import app.chuck_norris_joke.data.model.ChuckNorrisJoke
import app.chuck_norris_joke.domain.repository.ChuckNorrisRepository
import javax.inject.Inject

class ChuckNorrisRepositoryImpl @Inject constructor(
    private val api: ChuckNorrisApi
) : ChuckNorrisRepository {
    override suspend fun getRandomJoke(): ChuckNorrisJoke {
        return api.getRandomJoke()
    }
}