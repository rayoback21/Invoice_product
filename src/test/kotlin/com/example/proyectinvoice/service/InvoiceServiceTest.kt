package com.example.proyectinvoice.service

import com.example.proyectinvoice.entity.Invoice
import com.example.proyectinvoice.repository.ClientRepository
import com.example.proyectinvoice.repository.InvoiceRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class InvoiceServiceTest {
    @InjectMocks
    lateinit var invoiceService: InvoiceService

    @Mock
    lateinit var invoiceRepository: InvoiceRepository
    val jsonString= File ("./src/test/resources/invoice/newInvoice.json").readText(Charsets.UTF_8)
    val invoiceMock = Gson().fromJson(jsonString, Invoice::class.java)
    @Test
    fun saveWhenInvoiceCodeIsCorrect(){
        Mockito.`when`(invoiceRepository.save(Mockito.any(Invoice::class.java))).thenReturn(invoiceMock)
        val response = invoiceService.save(invoiceMock)
        Assertions.assertEquals(response.code, invoiceMock.code)
    }
    @Test
    fun saveWhenInvoiceCodeCorrect() {
        invoiceMock.code = "120-001-000000008"
        Mockito.`when`(invoiceRepository.save(Mockito.any(Invoice::class.java))).thenReturn(invoiceMock)
        val response = invoiceService.validateCode(invoiceMock.code)
        Assertions.assertEquals(true,response)
    }
}