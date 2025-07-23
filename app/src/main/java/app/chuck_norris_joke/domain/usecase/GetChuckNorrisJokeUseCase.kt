package app.chuck_norris_joke.domain.usecase

import app.chuck_norris_joke.data.model.ChuckNorrisJoke
import app.chuck_norris_joke.domain.repository.ChuckNorrisRepository
import javax.inject.Inject

class GetChuckNorrisJokeUseCase @Inject constructor(
    private val repository: ChuckNorrisRepository
) {
    suspend operator fun invoke(): ChuckNorrisJoke {
        return repository.getRandomJoke()
    }
}