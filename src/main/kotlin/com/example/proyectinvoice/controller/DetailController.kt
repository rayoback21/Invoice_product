package com.example.proyectinvoice.controller


import com.example.proyectinvoice.model.Detail
import com.example.proyectinvoice.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/detail")
class DetailController {
    @Autowired
    lateinit var detailService: DetailService
    @GetMapping
    fun list(): List<Detail> {
        return detailService.list()
    }


    @PostMapping
    fun save(@RequestBody detail: Detail): ResponseEntity<Detail> {
        return ResponseEntity(detailService.save(detail), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody detail: Detail):ResponseEntity< Detail> {
        return ResponseEntity( detailService.update(detail), HttpStatus.OK)
    }

    @PatchMapping
    fun updateQuantity(@RequestBody detail: Detail):ResponseEntity< Detail> {
        return ResponseEntity(detailService.updateQuantity(detail), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity< String> {
        detailService.delete(id)
        return ResponseEntity( "Detalle Eliminado",HttpStatus.OK)
    }
}