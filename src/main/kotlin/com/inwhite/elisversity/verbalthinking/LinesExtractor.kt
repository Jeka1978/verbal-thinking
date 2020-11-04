package com.inwhite.elisversity.verbalthinking

/**
 * @author Evgeny Borisov
 */
object LinesExtractor {
    fun getSyllables(lines:List<String>,numberOfLine:Int): List<String> {
        return lines.get(numberOfLine).split("-")
    }
}