package com.example.proyectinvoice.service

import com.example.proyectinvoice.entity.Client
import com.example.proyectinvoice.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list(): List<Client> {
        return clientRepository.findAll()
    }



    fun save(client: Client): Client {
        return clientRepository.save(client)
    }

    fun update(client: Client): Client {
        try {
            clientRepository.findById(client.id)?: throw Exception("Cliente no Encontrado")
            return clientRepository.save(client)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(client: Client): Client {
        try {

            var response = clientRepository.findById(client.id) ?: throw Exception("Ya existe este ID")
            response.apply {
                fullname=client.fullname

            }
            return clientRepository.save(response)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun  delete(id: Long) {
        try {

            var response = clientRepository.findById(id).orElseThrow{throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no Existe con el Id:  $id")}
            clientRepository.delete(response)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el cliente", ex)
        }
    }


}