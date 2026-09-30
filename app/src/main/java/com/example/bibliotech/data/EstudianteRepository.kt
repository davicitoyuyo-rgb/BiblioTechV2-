package com.example.bibliotech.data


import com.example.bibliotech.model.Estudiante


class EstudianteRepository(


    private val estudianteDao: EstudianteDao


) {


    fun insertarEstudiante(estudiante: Estudiante): Long {
        return estudianteDao.insertarEstudiante(estudiante)
    }


    fun obtenerEstudiantes(): List<Estudiante> {
        return estudianteDao.obtenerEstudiantes()
    }

    fun obtenerEstudiantePorId(id: Int): Estudiante? {
        return estudianteDao.obtenerEstudiantePorId(id)
    }

    fun actualizarEstudiante(estudiante: Estudiante) {
        estudianteDao.actualizarEstudiante(estudiante)
    }

    fun eliminarEstudiante(estudiante: Estudiante) {
        estudianteDao.eliminarEstudiante(estudiante)
    }


}
