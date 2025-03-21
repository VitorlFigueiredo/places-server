package com.example.places_api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/places")
class PlacesController(
    private val commercialPlaceRepository: CommercialPlaceRepository
) {

    @GetMapping("/{id}")
    fun listCommercialPlace(@PathVariable id: String): ResponseEntity<LocalCommercialPlace> {
        val commercialPlace = commercialPlaceRepository.findById(UUID.fromString(id))

        return if(commercialPlace.isPresent) {
             ResponseEntity.status(HttpStatus.OK).body(commercialPlace.get())
        }else{
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @GetMapping
    fun getPlaces() {
        commercialPlaceRepository.save(
            LocalCommercialPlace(
                type = "coffee",
                name = "Mais bob",
                rating = 12.0
            )
        )
    }
}