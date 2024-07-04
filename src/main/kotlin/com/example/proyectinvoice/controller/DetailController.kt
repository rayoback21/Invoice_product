package com.example.proyectinvoice.controller



import com.example.proyectinvoice.entity.Detail
import com.example.proyectinvoice.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
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

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Detail {
        return detailService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody detail: Detail): Detail {
        return detailService.save(detail)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody detail: Detail): Detail {
        return detailService.update(id, detail)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        detailService.delete(id)
        return "Detail with id $id deleted successfully"
    }
}