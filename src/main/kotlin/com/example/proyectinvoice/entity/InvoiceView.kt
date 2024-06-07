package com.example.proyectinvoice.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "invoice_view")
class InvoiceView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var code: String? = null
    @Column(name="create_at")
    var createAt: Date? = null
    var total: Double? = null


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    var clientId: Client? = null

}