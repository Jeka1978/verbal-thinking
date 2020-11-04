package com.inwhite.elisversity.verbalthinking

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.io.File
import kotlin.random.Random

@Component
@Profile(Profiles.RUSSIAN_READING)
class SmallRussianWordsReadAnswerExtractor : ExcerciseExtractor {


    override fun extract(questionLines: List<String>, rootDirectory: File): VerbalExercise {
        val path = rootDirectory.absolutePath
        val fileNames = CharRange('1', '3').map { path + "\\" + it + ".jpg" }.toMutableList()
        val correctAnswerPosition = Random.nextInt(fileNames.size)
        fileNames.add(correctAnswerPosition, path + "\\correct.jpg")
        return VerbalExercise(
                question = LinesExtractor.getSyllables(questionLines, Language.RUSS.lineNumber),
                answers = Pair(fileNames, correctAnswerPosition+1)
        )

    }


}