package com.inwhite.elisversity.verbalthinking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VerbalThinkingApplication

fun main(args: Array<String>) {
    System.setProperty("java.awt.headless", "false")
//    System.setProperty("spring.profiles.active", Profiles.RUSSIAN_READING+","+Profiles.RUSSIAN_SYLLABLE_COUNING+","+Profiles.HEBREW_SYLLABLE_COUNING+","+Profiles.HEBREW_READING)
    System.setProperty("spring.profiles.active",Profiles.HEBREW_SYLLABLE_COUNING+","+Profiles.HEBREW_READING)

    val context = runApplication<VerbalThinkingApplication>(*args)
    println()
}
