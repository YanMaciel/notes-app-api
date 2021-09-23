package com.yanmaciel.notesappapi.repository

import com.yanmaciel.notesappapi.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}