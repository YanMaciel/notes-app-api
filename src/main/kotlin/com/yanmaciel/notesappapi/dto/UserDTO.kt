package com.yanmaciel.notesappapi.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UserDTO(
    @field:Size
    @field:NotBlank
    val name: String,
    @field:Email
    @field:NotBlank
    val email: String,
    @field:Size(max = 255)
    @field:NotBlank
    val password: String
)