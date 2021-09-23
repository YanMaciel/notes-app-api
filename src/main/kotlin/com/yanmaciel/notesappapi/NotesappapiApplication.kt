package com.yanmaciel.notesappapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication (exclude = [SecurityAutoConfiguration::class])
class NotesappapiApplication

fun main(args: Array<String>) {
	runApplication<NotesappapiApplication>(*args)
}
