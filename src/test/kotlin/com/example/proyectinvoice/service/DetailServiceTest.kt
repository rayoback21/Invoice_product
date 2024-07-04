package com.example.proyectinvoice.service

import com.example.proyectinvoice.entity.Detail
import com.example.proyectinvoice.repository.DetailRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class DetailServiceTest {
    @InjectMocks
    lateinit var detailService: DetailService
    @Mock
    lateinit var detailRepository: DetailRepository
    val jsonString= File ("./src/test/resources/detail/newDetail.json").readText(Charsets.UTF_8)
    val detailMock = Gson().fromJson(jsonString, Detail::class.java)

    @Test
    fun saveWhenQuantityIsPositive() {
        detailMock.quantity = 10
        Mockito.`when`(detailRepository.save(Mockito.any(Detail::class.java))).thenReturn(detailMock)
        val response = detailService.validateQuantity(detailMock.quantity)
        Assertions.assertEquals(true,response)
    }
}