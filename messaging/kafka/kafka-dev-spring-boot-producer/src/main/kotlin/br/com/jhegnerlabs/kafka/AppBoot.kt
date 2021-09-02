package br.com.jhegnerlabs.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppBoot

fun main(args: Array<String>) {
	runApplication<AppBoot>(*args)
}
