package com.example.bibliotech.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliotech.R
import com.example.bibliotech.model.Libro

@Composable
fun TarjetaLibro(Libro: Libro, onVerDetalles: () -> Unit) {

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = R.drawable.vegeta_biblioteca),
                    contentDescription = "Logo Vegeta Biblioteca",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(70.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = Libro.titulo,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Autor: ${Libro.autor}")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onVerDetalles,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Ver detalles")
            }
        }
    }
}