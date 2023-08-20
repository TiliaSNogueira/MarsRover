package br.com.marsrover.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.marsrover.R
import br.com.marsrover.domain.model.roverUiModelList

@Composable
fun RoverList(
    onClick: (roverName: String) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(count = roverUiModelList.size, itemContent = { index ->
                RoverItem(
                    name = roverUiModelList[index].name,
                    image = roverUiModelList[index].image,
                    landingDate = roverUiModelList[index].landingDate,
                    distance = roverUiModelList[index].distance,
                    onClick = onClick
                )
            })
        }
    }
}

@Composable
fun RoverItem(
    name: String,
    image: Int,
    landingDate: String,
    distance: String,
    onClick: (roverName: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp).clickable { onClick(name) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Text(text = "Landing date: $landingDate", fontSize = 12.sp)
            Text(text = "Traveled distance $distance", fontSize = 12.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Credit: NASA/JPL",
                fontSize = 8.sp,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Preview
@Composable
fun RoverPreview() {
    RoverItem("Perseverance", R.drawable.curiosity, "18 Frebuary 2021", "12.56 km") { }
}