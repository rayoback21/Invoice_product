package com.example.proyectinvoice.service


import com.example.proyectinvoice.entity.Detail
import com.example.proyectinvoice.repository.DetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository

    fun list(): List<Detail> {
        return detailRepository.findAll()
    }

    fun getById(id: Long): Detail {
        return detailRepository.findById(id).orElseThrow { RuntimeException("Detail not found") }
    }

    fun save(detail: Detail): Detail {
        return detailRepository.save(detail)
    }

    fun update(id: Long, detail: Detail): Detail {
        val existingDetail = detailRepository.findById(id).orElseThrow { RuntimeException("Detail not found") }
        existingDetail.quantity = detail.quantity
        existingDetail.price = detail.price
        existingDetail.subTotal = detail.subTotal
        existingDetail.invoiceId = detail.invoiceId
        existingDetail.productId = detail.productId
        return detailRepository.save(existingDetail)
    }

    fun delete(id: Long) {
        if (detailRepository.existsById(id)) {
            detailRepository.deleteById(id)
        } else {
            throw RuntimeException("Detail not found")
        }
    }
    fun validateQuantity(quantity: Long?): Boolean? {
        if (quantity == null) {
            return null
        }
        return try {
            val number = quantity.toInt()
            number > 0
        } catch (e: NumberFormatException) {
            false
        }
    }
}