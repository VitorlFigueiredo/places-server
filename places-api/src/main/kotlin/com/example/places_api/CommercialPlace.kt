package com.example.places_api

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


data class CommercialPlace(
    val type: String,
    val name: String,
    val rating: Double
)


@Entity
@Table(name="commercial_place")
data class LocalCommercialPlace(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    val type: String,
    val name: String,
    val rating: Double
)

@Repository
interface CommercialPlaceRepository: JpaRepository<LocalCommercialPlace, UUID>