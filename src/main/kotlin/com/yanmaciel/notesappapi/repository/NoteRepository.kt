package com.yanmaciel.notesappapi.repository

import com.yanmaciel.notesappapi.models.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository: JpaRepository<Note, Long> {
}