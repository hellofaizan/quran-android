package `in`.hellofaizan.quranshareef.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun QuranActivity(
    innerPadding: PaddingValues,
) {
Column(
    modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    // QuranActivity
    Text(text = "Quran Activity", style = MaterialTheme.typography.titleMedium)
}
}