package se.alejo720.experiment1rq1.guilayer
import se.alejo720.experiment1rq1.logiclayer.*
import java.awt.Font
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import java.time.Duration
import java.time.Instant
import java.awt.Font.BOLD

class GUILayer {
    var logicLayer = LogicLayer()
    var avgScoreLabel: JLabel = JLabel()
    var genresComboBox: JComboBox<String> = JComboBox()

    init {
        val starts = Instant.now()
        setupGUI()
        val ends = Instant.now()
        println("GUI-layer: " + Duration.between(starts, ends).toMillis() + " ms")
        //val testNull2: Movie = logicLayer.testNullable()

        // Will compile and work during runtime
        val testNull1 = logicLayer.testNullable()
        val testNull3: Movie? = logicLayer.testNullable()














        // Will compile but fail during runtime
        val testNull: Movie = logicLayer.testNullable()











/*
        //println(testNull)
        val testNull = File(...).getParent()
        val testNull: String = File(...).getParent()
        val testNull: String? = File(...).getParent()
        // Will compile but fail during runtime
        val testNull: String = <Java-function returning null>

        // Will compile and work during runtime
        val testNull = <Java-function returning null>
        val testNull: String? = <Java-function returning null>*/
    }

    fun setupGUI() {
        val frame = JFrame("Experiment - Calculate average score of genre")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setSize(1280, 1024)
        frame.setLocationRelativeTo(null)
        frame.layout = GridLayout(0, 1)

        val font = Font(Font.SANS_SERIF, BOLD, 32)
        UIManager.put("Button.font", font)
        UIManager.put("ComboBox.font", font)
        UIManager.put("Label.font", font)

        val genres: Array<String> = logicLayer.getGenres()
        genresComboBox = JComboBox(genres)
        genresComboBox.maximumRowCount = 3

        val btnCalc = JButton("Calculate average score")
        btnCalc.actionCommand = "CalculateScore"
        btnCalc.addActionListener(ButtonClickListener())

        avgScoreLabel = JLabel("Average score: xx.xx")

        frame.contentPane.add(genresComboBox)
        frame.contentPane.add(btnCalc)
        frame.contentPane.add(avgScoreLabel)

        frame.setVisible(true)
    }

    private inner class ButtonClickListener: ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            if (e?.actionCommand.equals("CalculateScore")) {
                val starts = Instant.now()

                val genre: String = genresComboBox.selectedItem.toString()
                val score: Float = logicLayer.calculateAverageScore(genre)
                val scoreStr = "%.2f".format(score)
                avgScoreLabel.text = "Average score of genre " + genre + ": " + scoreStr

                val ends = Instant.now()
                println("GUI-layer calc-score: " + Duration.between(starts, ends).toMillis() + " ms\n")
            }
        }
    }
}

fun main(args: Array<String>) {
    val starts = Instant.now()
    GUILayer()
    val ends = Instant.now()
    println("Total: " + Duration.between(starts, ends).toMillis() + " ms to run program")
}































