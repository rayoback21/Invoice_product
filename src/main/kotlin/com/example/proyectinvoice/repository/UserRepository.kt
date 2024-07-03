package com.example.proyectinvoice.repository

import com.example.proyectinvoice.entity.User

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<User, String> {
    fun findByUsername( username: String?): User?
}