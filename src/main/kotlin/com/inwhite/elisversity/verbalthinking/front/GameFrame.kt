package com.inwhite.elisversity.verbalthinking.front

import com.inwhite.elisversity.verbalthinking.DesktopVerbalExerciseCreator
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Font
import java.awt.Toolkit
import java.io.File
import javax.annotation.PostConstruct
import javax.imageio.ImageIO
import javax.swing.*

/**
 * @author Evgeny Borisov
 */
@Component
class GameFrame(val exerciseCreator: DesktopVerbalExerciseCreator) : JFrame() {

    @Value("\${questions.path.to.dir}")
    lateinit var path: String
    lateinit var noImg: ImageIcon


    @PostConstruct
    fun readNoImg() {
        noImg = ImageIcon(ImageIO.read(File(path + "\\no.jpg")))
    }

    init {
        drawPanel()
    }

    private fun drawPanel() {
        val exercise = exerciseCreator.create()
        val questionLbl = JLabel("        " + exercise.question.joinToString(separator = "-") + "        ")
        val font1 = Font("Courier", Font.BOLD, 200)
        val font = Font("Courier", Font.BOLD, 60)
        questionLbl.font = font1
        val answersPanel = AnswersPanel(exercise.answers.first)
        val answerTextField = JTextField()

        answerTextField.addActionListener {

            if (answerTextField.text == exercise.answers.second.toString()) {
                println("correct")
                val image = ImageIO.read(File(exercise.winnerPic))
                val icon = ImageIcon(image)
                JOptionPane.showMessageDialog(this@GameFrame, "", "", 1, icon)
                drawPanel()
                answerTextField.grabFocus()
                answerTextField.requestFocus()
            } else {
                JOptionPane.showMessageDialog(this@GameFrame, "", "", 1, noImg)

            }
            answerTextField.text = ""
        }


        answerTextField.setFont(font)
        answerTextField.preferredSize = Dimension(100, 100)
        val mainPanel = JPanel()
        mainPanel.layout = BorderLayout()
        mainPanel.add(questionLbl, BorderLayout.NORTH)
        mainPanel.add(answersPanel, BorderLayout.CENTER)
        mainPanel.add(answerTextField, BorderLayout.SOUTH)
        contentPane = mainPanel
        setSize(Toolkit.getDefaultToolkit().getScreenSize())
        isVisible = true
    }
}