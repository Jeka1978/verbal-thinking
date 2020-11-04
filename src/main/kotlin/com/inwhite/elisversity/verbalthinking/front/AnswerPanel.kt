package com.inwhite.elisversity.verbalthinking.front

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Font
import java.io.File
import javax.imageio.ImageIO
import javax.swing.BorderFactory
import javax.swing.ImageIcon
import javax.swing.JLabel
import javax.swing.JPanel

/**
 * @author Evgeny Borisov
 */
class AnswerPanel(picUrl: String, number: Int) : JPanel() {
    init {
        layout = BorderLayout()
        val lbl = JLabel(number.toString())
        lbl.font = Font("Courier", Font.BOLD, 60)
        add(lbl, BorderLayout.NORTH)
        val image = ImageIO.read(File(picUrl))
        val icon = ImageIcon(image)
        val imgLbl = JLabel()
        imgLbl.icon = icon
        add(imgLbl, BorderLayout.CENTER)
        border = BorderFactory.createLineBorder(Color.BLACK,10)
    }

}