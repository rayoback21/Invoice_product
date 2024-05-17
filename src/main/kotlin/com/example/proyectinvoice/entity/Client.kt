package com.example.proyectinvoice.entity

import jakarta.persistence.*

@Entity
@Table(name = "client")
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var nui: String? = null
    var address: String? = null
    var fullname: String? = null
    var email: String? = null

}