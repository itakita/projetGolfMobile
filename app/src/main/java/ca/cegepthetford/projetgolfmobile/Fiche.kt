package ca.cegepthetford.projetgolfmobile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GolfCourse
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FicheTrouGolf(trou : TrouGolf) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.GolfCourse,
            contentDescription = "Golf",
            modifier = Modifier.size(150.dp)
        )
        Text(text="Trou ", fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Text(text="Par ", fontSize = 32.sp, fontWeight = FontWeight.Bold)

        Button(
            onClick = { },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = "",
                fontSize = 24.sp
            )
        }

    }
}
