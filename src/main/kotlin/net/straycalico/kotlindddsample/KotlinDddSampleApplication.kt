package net.straycalico.kotlindddsample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinDddSampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDddSampleApplication::class.java, *args)
}
