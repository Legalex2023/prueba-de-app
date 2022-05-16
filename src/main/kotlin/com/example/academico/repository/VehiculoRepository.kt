package com.example.academico.repository
import Vehiculo



import org.springframework.data.jpa.repository.JpaRepository

interface VehiculoRepository: JpaRepository<Vehiculo, Long>{
    fun findById(id:Long?):Vehiculo?
}