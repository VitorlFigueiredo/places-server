package com.example.places_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class PlacesApiApplication

fun main(args: Array<String>) {
	runApplication<PlacesApiApplication>(*args)
}




