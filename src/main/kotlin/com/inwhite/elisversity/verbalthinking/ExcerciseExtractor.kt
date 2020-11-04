package com.inwhite.elisversity.verbalthinking

import java.io.File

interface ExcerciseExtractor {
    fun extract(questionLines: List<String>,rootDirectory:File):VerbalExercise

}
