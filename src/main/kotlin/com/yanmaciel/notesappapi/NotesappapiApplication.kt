package com.yanmaciel.notesappapi

import io.thedocs.cookie.CookieSameSiteNoneChecker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication (exclude = [SecurityAutoConfiguration::class])
class NotesappapiApplication

fun main(args: Array<String>) {
	CookieSameSiteNoneChecker().isSameSiteNoneIncompatible("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36")

	runApplication<NotesappapiApplication>(*args)
}
