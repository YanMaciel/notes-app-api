package com.yanmaciel.notesappapi.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @field:JsonIgnore
    var id: Long? = null

    @Column(length = 20)
    @field:NotNull
    var name: String = ""

    @Column(unique = true, length = 120)
    @field:Email
    @field:NotNull
    var email: String = ""

    @Column
    @field:NotNull
    @field:JsonIgnore
    var password: String = ""
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    var notes: List<Note> = ArrayList()

    fun validatePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}