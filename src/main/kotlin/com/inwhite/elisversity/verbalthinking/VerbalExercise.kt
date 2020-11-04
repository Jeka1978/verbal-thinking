package com.inwhite.elisversity.verbalthinking

/**
 * @author Evgeny Borisov
 * answers can contain as a key list of pictures urls or numbers of syllables,
 * and the value is an index of correct answer in the list
 */


data class VerbalExercise(val question:List<String>, val answers:Pair<List<String>,Int>, var winnerPic:String="") {

}