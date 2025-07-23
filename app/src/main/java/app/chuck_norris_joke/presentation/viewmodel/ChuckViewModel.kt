package app.chuck_norris_joke.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.chuck_norris_joke.domain.usecase.GetChuckNorrisJokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChuckViewModel @Inject constructor(
    private val useCase: GetChuckNorrisJokeUseCase
): ViewModel() {

    var joke by mutableStateOf<String?>(null)
        private set

    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    init {
        fetchJoke()
    }

    fun fetchJoke() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                joke = useCase().value
            } catch (e: Exception) {
                error = e.message
            }
            isLoading = false
        }
    }

}