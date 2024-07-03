package com.example.proyectinvoice.entity


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "detail")
class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var quantity: Long? = null
    var price: Double? = null
    @Column(name = "subtotal")
    var subTotal: Double? = null
    @Column(name = "invoice_id")
    var invoiceId: Long? = null
    @Column(name = "product_id")
    var productId: Long? = null
}

