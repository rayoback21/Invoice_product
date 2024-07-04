package com.example.proyectinvoice.service

import com.example.proyectinvoice.entity.Client
import com.example.proyectinvoice.repository.ClientRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class ClientServiceTest {
    @InjectMocks
    lateinit var clientService: ClientService

    @Mock
    lateinit var clientRepository: ClientRepository
    val jsonString = File("./src/test/resources/client/newClient.json").readText(Charsets.UTF_8)
    val clientMock = Gson().fromJson(jsonString, Client::class.java)

    @Test
    fun saveClientCorrect(){
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.save(clientMock)
        Assertions.assertEquals(response.id, clientMock.id)
    }



    @Test
    fun saveWhenNuiClientIsIncorrect() {
        clientMock.nui= "0704448547"
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.validateNui(clientMock.nui)
        Assertions.assertEquals(false,response)
    }

}