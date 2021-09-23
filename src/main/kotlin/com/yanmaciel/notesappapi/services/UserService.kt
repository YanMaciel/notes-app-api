package com.yanmaciel.notesappapi.services

import com.yanmaciel.notesappapi.dto.LoginDTO
import com.yanmaciel.notesappapi.dto.Message
import com.yanmaciel.notesappapi.dto.UserDTO
import com.yanmaciel.notesappapi.models.Note
import com.yanmaciel.notesappapi.models.User
import com.yanmaciel.notesappapi.repository.UserRepository
import io.jsonwebtoken.Jwts
import io.thedocs.cookie.CookieSameSiteNoneChecker
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@Service
class UserService(private val userRepository: UserRepository) {
    // @Value(VARIÁVEL DE AMBIENTE DO HEROKU OU APPLICATION PROPERTIES)
    // lateinit var SECRET: String -> em Kotlin não pode ter algo com valor nulo. lateinit, crio a variável e depois vou populá-la

//    @Value(Algorithm_KEY)
//    lateinit var SECRET: String

    fun create(user: UserDTO): User {
        val newUser = User()
        newUser.email = user.email
        newUser.name = user.name
        newUser.password = user.password

        return userRepository.save(newUser)
    }

    fun findByEmail(email:String): User? {
        return userRepository.findByEmail(email)
    }

    fun login(loginDetails: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user = userRepository.findByEmail(loginDetails.email)
            ?: return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message("Invalid information"))

        if (!user.validatePassword(loginDetails.password)) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Message("Invalid information"))
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 60000))  // 1 hour
            .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, "secret")
            .compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true
        cookie.path = "/"

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("Success"))
    }

    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0
        cookie.path = "/"

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("logged out"))
    }

    fun getById(id: Long): ResponseEntity<User>? {
        return userRepository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun getAllNotes(jwt: String?): ResponseEntity<List<Note>> {
        if (jwt == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()

        try {
            val jwtBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            getById(jwtBody.issuer.toLong())
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

        val jwtBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
        val responseUser = getById(jwtBody.issuer.toLong())
        val author = responseUser!!.body

        return ResponseEntity.ok(author!!.notes)
    }
}