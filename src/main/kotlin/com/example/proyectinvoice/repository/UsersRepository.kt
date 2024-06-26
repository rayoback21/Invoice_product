package com.example.proyectinvoice.repository

import com.example.proyectinvoice.entity.Users

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UsersRepository: JpaRepository<Users, String> {
    fun findByUsersname( Usersname: String?): Users?
}