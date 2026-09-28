package com.example.bibliotech.ui

import android.app.Application
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.bibliotech.viewmodel.EstudianteViewModel
import com.example.bibliotech.viewmodel.LibroViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navegacion(
    navController: NavHostController
) {
    var mensaje by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current
    val app = context.applicationContext as Application

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") {
            PantallaPrincipal(
                onCatalogo = { navController.navigate("catalogo") },
                onPrestamo = { navController.navigate("prestamo") },
                onPrestados = { navController.navigate("prestados") },
                onEstudiante = { navController.navigate("estudiantes") }
            )
        }

        composable("catalogo") {
            PantallaCatalogo(
                onRegresar = { navController.popBackStack() },
                onVerDetalles = { idLibro -> navController.navigate("detalle/$idLibro") },
                onAgregarLibro = { navController.navigate("agregar") },
                mensaje = mensaje,
                onMensajeMostrado = { mensaje = null }
            )
        }

        composable("agregar") {
            PantallaAgregarLibro(
                onGuardar = {
                    mensaje = "Libro guardado con exito"
                    navController.popBackStack()
                },
                onCancelar = { navController.popBackStack() },
                viewModel = viewModel()
            )
        }

        composable("detalle/{idLibro}") { backStackEntry ->
            val idLibro = backStackEntry.arguments?.getString("idLibro")?.toIntOrNull()

            val viewModel: LibroViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory.getInstance(app)
            )

            val libro by viewModel.libroSeleccionado.collectAsState()

            LaunchedEffect(idLibro) {
                if (idLibro != null) {
                    viewModel.cargarLibroPorId(idLibro)
                }
            }

            libro?.let { libroActual ->
                PantallaDetalleLibro(
                    Libro = libroActual,
                    onRegresar = { navController.popBackStack() },
                    onEditar = { id -> navController.navigate("editar/$id") },
                    onEliminar = { libroEliminar ->
                        viewModel.eliminarLibro(libroEliminar)
                        mensaje = "Libro eliminado con exito"
                        navController.popBackStack()
                    },
                    navController = navController
                )
            }
        }

        composable("editar/{idLibro}") { backStackEntry ->
            val idLibro = backStackEntry.arguments?.getString("idLibro")?.toIntOrNull()

            val viewModel: LibroViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory.getInstance(app)
            )

            val libro by viewModel.libroSeleccionado.collectAsState()

            LaunchedEffect(idLibro) {
                if (idLibro != null) {
                    viewModel.cargarLibroPorId(idLibro)
                }
            }

            libro?.let { libroActual ->
                PantallaEditarLibro(
                    libro = libroActual,
                    onGuardar = { libroEditado ->
                        viewModel.actualizarLibro(libroEditado)
                        navController.previousBackStackEntry
                            ?.savedStateHandle
                            ?.set("mensaje", "Cambios guardados correctamente")
                        navController.popBackStack()
                    },
                    onCancelar = { navController.popBackStack() }
                )
            }
        }

        composable("prestamo") {
            PantallaPrestamo(
                onRegresar = { navController.popBackStack() }
            )
        }

        composable("estudiantes") {
            PantallaEstudiantes(
                onRegresar = { navController.popBackStack() },
                onVerDetalles = { idEstudiante ->
                    navController.navigate("detalleEstudiante/$idEstudiante")
                },
                onAgregarEstudiante = { navController.navigate("agregarEstudiante") },
                mensaje = mensaje,
                onMensajeMostrado = { mensaje = null }
            )
        }

        composable("prestados") {
            PantallaLibrosPrestados(
                onRegresar = { navController.popBackStack() }
            )
        }

        composable("agregarEstudiante") {
            val viewModel: EstudianteViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory.getInstance(app)
            )

            PantallaAgregarEstudiante(
                viewModel = viewModel,
                onGuardar = {
                    mensaje = "Estudiante guardado con exito"
                    navController.popBackStack()
                },
                onCancelar = {
                    navController.popBackStack()
                }
            )
        }

        composable("detalleEstudiante/{idEstudiante}") { backStackEntry ->
            val idEstudiante = backStackEntry.arguments
                ?.getString("idEstudiante")
                ?.toIntOrNull()

            val viewModel: EstudianteViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory.getInstance(app)
            )

            val estudiante by viewModel.estudianteSeleccionado.collectAsState()

            LaunchedEffect(idEstudiante) {
                if (idEstudiante != null) {
                    viewModel.cargarEstudiantePorId(idEstudiante)
                }
            }

            estudiante?.let { estudianteActual ->
                PantallaDetalleEstudiante(
                    estudiante = estudianteActual,
                    onRegresar = { navController.popBackStack() },
                    navController = navController,
                    onEditar = { idEst ->
                        navController.navigate("editarEstudiante/$idEst")
                    },
                    onEliminar = { estudianteEliminar ->
                        viewModel.eliminarEstudiante(estudianteEliminar)
                        mensaje = "Estudiante eliminado con éxito"
                        navController.popBackStack()
                    }
                )
            }
        }

        composable("editarEstudiante/{idEstudiante}") { backStackEntry ->
            val idEstudiante = backStackEntry.arguments
                ?.getString("idEstudiante")
                ?.toIntOrNull()

            val viewModel: EstudianteViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory.getInstance(app)
            )

            val estudiante by viewModel.estudianteSeleccionado.collectAsState()

            LaunchedEffect(idEstudiante) {
                if (idEstudiante != null) {
                    viewModel.cargarEstudiantePorId(idEstudiante)
                }
            }

            estudiante?.let { estudianteActual ->
                PantallaEditarEstudiante(
                    estudiante = estudianteActual,
                    onGuardar = { estudianteEditado ->
                        viewModel.actualizarEstudiante(estudianteEditado)
                        navController.previousBackStackEntry
                            ?.savedStateHandle
                            ?.set("mensaje", "Cambios guardados correctamente")
                        navController.popBackStack()
                    },
                    onCancelar = { navController.popBackStack() }
                )
            }
        }
    }
}