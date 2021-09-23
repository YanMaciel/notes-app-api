package com.yanmaciel.notesappapi.controllers

import com.yanmaciel.notesappapi.dto.LoginDTO
import com.yanmaciel.notesappapi.dto.UserDTO
import com.yanmaciel.notesappapi.models.User
import com.yanmaciel.notesappapi.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@RequestMapping("v1/auth")
@CrossOrigin(origins = ["http://localhost:3000"], allowCredentials = "true")
class AuthController(private val userService: UserService) {

    @PostMapping("register")
    fun registerUser(@Valid @RequestBody user: UserDTO) = userService.create(user)

    @PostMapping("login")
    fun login(@RequestBody loginDetails: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> =
        userService.login(loginDetails, response)

    @GetMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> =
        userService.logout(response)


    @GetMapping("/{id}")
    fun userInformation(@PathVariable id: Long): ResponseEntity<User>? =
        userService.getById(id)
}