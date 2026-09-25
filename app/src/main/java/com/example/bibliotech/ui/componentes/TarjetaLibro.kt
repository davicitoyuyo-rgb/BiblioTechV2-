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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliotech.R
import com.example.bibliotech.model.Libro

@Composable
fun TarjetaLibro(Libro: Libro, onVerDetalles: () -> Unit) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.vegeta_biblioteca),
                    contentDescription = "Logo Vegeta Biblioteca",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(70.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))


                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = Libro.titulo,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Autor: ${Libro.autor}",
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // El botón se alinea siempre a la derecha
            Button(
                onClick = onVerDetalles,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Ver detalles")
            }
        }
    }
}