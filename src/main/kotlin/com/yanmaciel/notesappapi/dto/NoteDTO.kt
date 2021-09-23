package com.yanmaciel.notesappapi.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class NoteDTO (
    @field:NotBlank(message = "Content is required")
    val title: String,
    @field:NotBlank(message = "Title is required")
    val content: String
)