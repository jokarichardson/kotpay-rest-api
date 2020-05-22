package com.richardson.kotpay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotpayApplication

fun main(args: Array<String>) {
	runApplication<KotpayApplication>(*args)
}
