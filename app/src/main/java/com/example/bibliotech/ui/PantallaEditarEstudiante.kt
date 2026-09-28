package com.example.bibliotech.ui

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import com.example.bibliotech.model.Estudiante

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEditarEstudiante(
    estudiante: Estudiante,
    onGuardar: (Estudiante) -> Unit,
    onCancelar: () -> Unit
) {
    // 1. Estados inicializados con los datos actuales del estudiante
    var carnet by remember { mutableStateOf(estudiante.carnet) }
    var nombres by remember { mutableStateOf(estudiante.nombres) }
    var apellidos by remember { mutableStateOf(estudiante.apellidos) }

    val grados = listOf("1° Bachillerato", "2° Bachillerato", "3° Bachillerato")
    var grado by remember { mutableStateOf(if (estudiante.grado in grados) estudiante.grado else grados[0]) }
    var expandirGrado by remember { mutableStateOf(false) }

    val secciones = listOf("A", "B", "C")
    var seccion by remember { mutableStateOf(if (estudiante.seccion in secciones) estudiante.seccion else secciones[0]) }
    var expandirSeccion by remember { mutableStateOf(false) }

    var activo by remember { mutableStateOf(estudiante.activo) }

     Scaffold(containerColor = Color,Black ,
         topBar = {
             TopAppBar(
                 title = {Text("Editar Estudiante ", color = Color.White)
                 },
                 colors = TopAppBar
             )
         }) {}




    }