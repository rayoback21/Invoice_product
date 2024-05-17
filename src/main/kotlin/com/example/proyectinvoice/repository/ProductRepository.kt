package com.example.proyectinvoice.repository


import com.example.proyectinvoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
    fun findById (id: Long?): Product?
}