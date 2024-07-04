package com.example.proyectinvoice.controller


import com.example.proyectinvoice.entity.Invoice
import com.example.proyectinvoice.entity.InvoiceView
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
    @GetMapping("/{value}/get-total")
    fun getTotal(@PathVariable value: Double): List<Invoice>{
        return invoiceService.getTotal(value)
    }

    @GetMapping
    fun list(): List<Invoice> {
        return invoiceService.list()
    }

    @GetMapping("/with-client")
    fun listView(): List<InvoiceView>{
        return invoiceService.listView()
    }

    @PostMapping
    fun save(@RequestBody invoice: Invoice): Invoice {
        return invoiceService.save(invoice)
    }

    @PutMapping
    fun update(@RequestBody invoice: Invoice): ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    @PatchMapping
    fun patch(@RequestBody invoice: Invoice): ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.updateName(invoice), HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity< String> {
        invoiceService.delete(id)
        return ResponseEntity( " Eliminado",HttpStatus.OK)
    }
}