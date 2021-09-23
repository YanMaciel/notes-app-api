package com.yanmaciel.notesappapi.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.web.bind.annotation.CrossOrigin
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity(name = "notes")
@CrossOrigin
data class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @field:NotBlank
    var content: String = "",

    @field:NotBlank
    var title: String = "",

    @ManyToOne
    @JsonIgnore
    var author: User? = null,

    val date: LocalDateTime = LocalDateTime.now()
)