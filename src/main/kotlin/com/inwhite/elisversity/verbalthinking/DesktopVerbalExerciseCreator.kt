package com.inwhite.elisversity.verbalthinking

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import javax.annotation.PostConstruct

@Service
@ConditionalOnDesktopMode
class DesktopVerbalExerciseCreator : VerbalExerciseCreator {

    @Autowired
    private lateinit var excerciseExtractors: List<ExcerciseExtractor>

    @Value("\${questions.path.to.dir}")
    lateinit var path: String

    private lateinit var exercises: List<VerbalExercise>
    private var exerciseNumber: Int = 0

    @PostConstruct
    fun initCache() {
        val questionDir = File(path)

        exercises = questionDir.list()
                .map { File(path+"\\"+it) }
                .filter { it.isDirectory }
                .flatMap { buildExerciseFromDirectory(it) }.shuffled()

        println()

    }


    private fun buildExerciseFromDirectory(file: File): List<VerbalExercise> {
        val exercises: MutableList<VerbalExercise> = mutableListOf()
        val questionsFile = File(file.absolutePath + "\\" + "question.txt")

        for (excerciseExtractor in excerciseExtractors) {
            val exercise = excerciseExtractor.extract(questionLines = questionsFile.readLines(), rootDirectory = file)
            exercise.winnerPic = file.absolutePath + "\\win.jpg"
            exercises.add(exercise)
        }
        return exercises.toList()
    }


    override fun create(): VerbalExercise {
        if (exerciseNumber == exercises.size) {
            exerciseNumber = 0
        }
        return exercises[exerciseNumber++]
    }
}


