package app.chuck_norris_joke.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import app.chuck_norris_joke.presentation.ui.theme.ChuckNorrisJokeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChuckNorrisJokeTheme {
                ChuckJokeScreen()
            }
        }
    }
}

