package com.example.proyectinvoice.controller

import com.example.proyectinvoice.config.JwtUtils
import com.example.proyectinvoice.dto.LoginDto
import com.example.proyectinvoice.dto.TokensDto
import com.example.proyectinvoice.entity.Client
import com.example.proyectinvoice.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auths")
class AuthsController {
    @Autowired
    private val authensticationManager: AuthenticationManager? = null
    @Autowired
    private val jwtUtils: JwtUtils? = null

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<*>? {
        val login = UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
        val authenstication: Authentication = authensticationManager!!.authenticate(login)
        val response = TokensDto().apply { jwt= jwtUtils!!.create(loginDto.username)}
        return ResponseEntity(response, HttpStatus.OK)
    }
}