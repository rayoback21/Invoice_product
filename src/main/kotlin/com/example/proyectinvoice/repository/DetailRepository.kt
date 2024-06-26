package com.example.proyectinvoice.repository

import com.example.proyectinvoice.model.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository: JpaRepository<Detail, Long> {
    fun findById (id: Long?): Detail?

}