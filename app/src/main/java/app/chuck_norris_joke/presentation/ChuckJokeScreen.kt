package app.chuck_norris_joke.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.chuck_norris_joke.presentation.viewmodel.ChuckViewModel

@Composable
fun ChuckJokeScreen(viewModel: ChuckViewModel = hiltViewModel()) {

    val joke = viewModel.joke
    val isLoading = viewModel.isLoading
    val error = viewModel.error

    Box(
        Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(Brush.verticalGradient(listOf(Color(0xFF0F2027), Color(0xFF2C5364))))
            .padding(24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                "🛡️ Chuck Norris Joke",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(32.dp))

            if (isLoading) {
                CircularProgressIndicator(color = Color.White)
            } else if (error != null) {
                Text("❌ $error", color = Color.Red)
            } else if (joke != null) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA))
                ) {
                    Text(
                        text = "\"$joke\"",
                        modifier = Modifier.padding(24.dp),
                        fontSize = 18.sp,
                        color = Color(0xFF006064),
                        fontStyle = FontStyle.Italic
                    )
                }
                Spacer(Modifier.height(24.dp))
            }

            Button(
                onClick = viewModel::fetchJoke,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF26C6DA)),
                shape = RoundedCornerShape(50)
            ) {
                Text("🔁 New Joke", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }

}