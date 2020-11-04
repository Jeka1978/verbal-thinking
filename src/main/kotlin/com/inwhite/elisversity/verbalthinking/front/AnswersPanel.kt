package com.inwhite.elisversity.verbalthinking.front

import java.awt.GridLayout
import javax.swing.JPanel

/**
 * @author Evgeny Borisov
 */
class AnswersPanel(picUrls: List<String>) : JPanel() {
    init {
        layout = GridLayout(2, 2)
        var i = 1
        picUrls.map { AnswerPanel(it, i++) }.forEach { add(it) }
    }
}