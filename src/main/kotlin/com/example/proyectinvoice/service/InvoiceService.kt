package com.example.proyectinvoice.service



import com.example.proyectinvoice.entity.Invoice
import com.example.proyectinvoice.entity.InvoiceView
import com.example.proyectinvoice.repository.InvoiceRepository
import com.example.proyectinvoice.repository.InvoiceViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceViewRepository: InvoiceViewRepository

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun list(): List<Invoice> {
        return invoiceRepository.findAll()
    }

    fun listView(): List<InvoiceView> {
        return invoiceViewRepository.findAll()
    }

    fun getById(id: Long): Invoice {
        return invoiceRepository.findById(id).orElseThrow { RuntimeException("Invoice not found") }
    }

    fun getTotal(value:Double): List<Invoice> {
        return invoiceRepository.findTotal(value)
    }

    fun save(invoice: Invoice): Invoice {
        return invoiceRepository.save(invoice)
    }

    fun update(invoice: Invoice): Invoice {
        try {
            invoiceRepository.findById(invoice.id)
                ?: throw Exception("Ya existe el id")
            return invoiceRepository.save(invoice)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(invoice: Invoice): Invoice? {
        try {
            var response = invoiceRepository.findById(invoice.id)
                ?: throw Exception("Ya existe el id")
            response.apply {
                code= invoice.code
            }
            return invoiceRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun  delete(id: Long) {
        try {

            var response = invoiceRepository.findById(id).orElseThrow{throw ResponseStatusException(HttpStatus.NOT_FOUND, "No Existe con el Id:  $id")}
            invoiceRepository.delete(response)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar", ex)
        }
    }

    fun validateCode (code: String?): Boolean? {
        if (code == null) {
            return false
        }

        val regex = Regex("\\d{3}-\\d{3}-\\d{9}")
        return regex.matches(code)
    }
}


