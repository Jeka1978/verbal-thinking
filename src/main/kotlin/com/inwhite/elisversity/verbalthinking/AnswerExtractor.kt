package com.inwhite.elisversity.verbalthinking

import java.io.File

interface AnswerExtractor {
    fun extract(questionLines:List<String>): Pair<List<String>,Int>

}
