package com.example.proyectinvoice.repository



import com.example.proyectinvoice.entity.InvoiceView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceViewRepository: JpaRepository<InvoiceView, Long> {
    fun findById (id: Long?): InvoiceView?

}