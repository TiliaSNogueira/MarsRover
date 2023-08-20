package br.com.marsrover.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.marsrover.R

@Composable
fun Error() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(id = R.string.error))
    }
}


@Preview
@Composable
fun ErrorPreview() {
    Error()
}