package com.example.proyectinvoice.controller


import com.example.proyectinvoice.entity.Invoice
import com.example.proyectinvoice.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService
    @GetMapping
    fun list(): List<Invoice> {
        return invoiceService.list()
    }

    @PostMapping
    fun save(@RequestBody invoice: Invoice):ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody invoice: Invoice):ResponseEntity< Invoice> {
        return ResponseEntity( invoiceService.update(invoice), HttpStatus.OK)
    }

    @PatchMapping
    fun updateTotal(@RequestBody invoice: Invoice):ResponseEntity< Invoice> {
        return ResponseEntity(invoiceService.updateTotal(invoice), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity< String> {
        invoiceService.delete(id)
        return ResponseEntity( " Eliminado",HttpStatus.OK)
    }
}