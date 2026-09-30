package com.example.bibliotech.data


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bibliotech.model.Estudiante


@Dao
interface EstudianteDao {


    // Inserta un nuevo estudiante

    @Insert
    fun insertarEstudiante(estudiante: Estudiante): Long


    @Query("SELECT * FROM Estudiantes")
    fun obtenerEstudiantes(): List<Estudiante>


    @Query("SELECT * FROM Estudiantes WHERE id = :id")
    fun obtenerEstudiantePorId(id: Int): Estudiante?



    @Update
    fun actualizarEstudiante(estudiante: Estudiante)



    @Delete
    fun eliminarEstudiante(estudiante: Estudiante)
}
