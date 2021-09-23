package com.yanmaciel.notesappapi.controllers

import com.yanmaciel.notesappapi.dto.NoteDTO
import com.yanmaciel.notesappapi.models.Note
import com.yanmaciel.notesappapi.services.NoteService
import com.yanmaciel.notesappapi.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("v1/notes")
@CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
@Validated
class NoteController(private val noteService: NoteService, private val userService: UserService) {

    @GetMapping
    fun getAllNotes(@CookieValue("jwt") jwt: String?) : ResponseEntity<List<Note>>
            = userService.getAllNotes(jwt)

    @PostMapping
    @Transactional
    fun createNote(@Valid @RequestBody note: NoteDTO, @CookieValue("jwt") jwt: String?): ResponseEntity<Note>
        = noteService.createNote(note, jwt)

    @DeleteMapping
    @Transactional
    fun deleteNote(@RequestBody note: Note, @CookieValue("jwt") jwt: String?): ResponseEntity<Unit>
            = noteService.deleteNote(note, jwt)
}