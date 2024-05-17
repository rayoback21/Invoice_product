package com.example.proyectinvoice.repository



import com.example.proyectinvoice.entity.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository: JpaRepository<Invoice, Long> {
    fun findById (id: Long?): Invoice?
}