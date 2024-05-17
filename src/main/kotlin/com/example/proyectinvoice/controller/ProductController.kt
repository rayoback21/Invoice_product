package com.example.proyectinvoice.controller

import com.example.proyectinvoice.entity.Product
import com.example.proyectinvoice.service.ProductService
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
@RequestMapping("/product")
class ProductController {
    @Autowired
    lateinit var productService: ProductService
    @GetMapping
    fun list(): List<Product> {
        return productService.list()
    }

    @PostMapping
    fun save(@RequestBody product: Product):ResponseEntity<Product> {
        return ResponseEntity(productService.save(product), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody product: Product):ResponseEntity< Product> {
        return ResponseEntity( productService.update(product), HttpStatus.OK)
    }

    @PatchMapping
    fun updateDescription(@RequestBody product: Product):ResponseEntity< Product> {
        return ResponseEntity(productService.updateDescription(product), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity< String> {
        productService.delete(id)
        return ResponseEntity( "Producto Eliminado",HttpStatus.OK)
    }
}