package com.inwhite.elisversity.verbalthinking

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.io.File

@Component
@Profile(Profiles.HEBREW_SYLLABLE_COUNING)
class SmallHebrewWordsSyllableAnswerExtractor : ExcerciseExtractor {

    @Value("\${questions.path.to.dir}")
    private lateinit var path: String

    override fun extract(questionLines: List<String>, rootDirectory: File): VerbalExercise {
        val fileNames = CharRange('1', '4').map { path + "\\" + it + ".jpg" }
        return VerbalExercise(
                question =LinesExtractor.getSyllables(questionLines,Language.HEBREW.lineNumber),
                answers = Pair(fileNames, LinesExtractor.getSyllables(questionLines, Language.HEBREW.lineNumber).size)

        )
    }
}