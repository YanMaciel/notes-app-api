package com.yanmaciel.notesappapi.services

import com.yanmaciel.notesappapi.dto.NoteDTO
import com.yanmaciel.notesappapi.models.Note
import com.yanmaciel.notesappapi.repository.NoteRepository
import io.jsonwebtoken.Jwts
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val notesRepository: NoteRepository,
    private val userService: UserService
    ) {
    fun createNote(note: NoteDTO, jwt: String?): ResponseEntity<Note> {
        if (jwt == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()

        try {
            val jwtBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            userService.getById(jwtBody.issuer.toLong())
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
        val jwtBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
        val responseUser = userService.getById(jwtBody.issuer.toLong())
        val author = responseUser?.body

        val newNote = Note(author = author!!)
        newNote.title = note.title
        newNote.content = note.content

        return ResponseEntity.ok(notesRepository.save(newNote))
    }

    fun deleteNote(note: Note, jwt: String?): ResponseEntity<Unit> {
        if (jwt == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()

        try {
            val jwtBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            userService.getById(jwtBody.issuer.toLong())
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
        val jwtBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
        val responseUser = userService.getById(jwtBody.issuer.toLong())
        val authorId = responseUser?.body?.id

        return notesRepository.findById(note.id!!).map {
            if (it.author?.id !== authorId) {
                ResponseEntity<Unit>(HttpStatus.NO_CONTENT)
            } else {
                notesRepository.delete(it)
                ResponseEntity<Unit>(HttpStatus.NO_CONTENT)
            }
        }.orElse(ResponseEntity.notFound().build())
    }

}