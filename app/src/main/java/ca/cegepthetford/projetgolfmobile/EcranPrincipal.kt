package ca.cegepthetford.projetgolfmobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun EcranPrincipal(parcours: ParcoursGolfViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logogolf),
            contentDescription = "Image golf"
        )
        Text(
            text = "Pointage Golf",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            itemsIndexed(parcours.trous) { index, trouGolf ->
                ItemTrouGolf(
                    trou = trouGolf
                )
            }
        }
    }
}

@Composable
fun ItemTrouGolf(trou: TrouGolf) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        ListItem(
            colors = ListItemDefaults.colors(
                containerColor =
                if (trou.manqueScore())
                    Color.Green
                else
                    Color.LightGray
            ),
            headlineContent = { Text(text = "Trou #${trou.noTrou}", fontWeight = FontWeight.Bold) },
            supportingContent = {
                Text(text = "Par: ${trou.par}")
                if (!trou.manqueScore())
                    Text(text = "Score: ${trou.score}(${trou.determinerTermeScore()})")
            }
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun AppercuEcranPrincipal() {
    //EcranPrincipal()
}

@Preview(showBackground = true)
@Composable
fun AppercuItemTrouGolf() {
    val trou = TrouGolf(5, 5)
    trou.score = 7
    Column {
        ItemTrouGolf(trou = TrouGolf(5, 3))
        ItemTrouGolf(trou = trou)
    }
}

