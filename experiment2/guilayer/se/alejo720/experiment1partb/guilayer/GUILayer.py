"""
C:\Users\AlexanderJ\Google Drive\Universitet\Exjobb\intellijidea-projects\experiment1partB\logiclayer\build\libs\logiclayer-1.0-SNAPSHOT.jar
C:\Users\AlexanderJ\Google Drive\Universitet\Exjobb\intellijidea-projects\experiment1partB\datalayer\build\libs\datalayer-1.0-SNAPSHOT.jar
"""
from java.awt import GridLayout, Font
from javax.swing import JButton, JFrame, JComboBox, JLabel, UIManager
from java.time import Duration, Instant
from se.alejo720.experiment1partb.logiclayer import LogicLayer

class GUILayer:
    def __init__(self):
        self.logicLayer = LogicLayer()
        self.avgScoreLabel = JLabel()
        self.genresComboBox = JComboBox()
        starts = Instant.now()
        self.setupGUI()
        ends = Instant.now()
        print("GUI-layer: {0} ms".format(Duration.between(starts, ends).toMillis()))

    def calculate_score(self, event):
        starts = Instant.now()

        genre = self.genresComboBox.getSelectedItem()
        avgScore = self.logicLayer.calculateAverageScore(genre)
        scoreStr = "{0:.2f}".format(avgScore)
        self.avgScoreLabel.setText("Average score of genre " + genre + ": " + scoreStr)

        ends = Instant.now()
        print("GUI-layer calc-score: {0} ms\n".format(Duration.between(starts, ends).toMillis()))

    def setupGUI(self):
        frame = JFrame('Experiment - Calculate average score of genre')
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setSize(1280, 1024)
        frame.setLocationRelativeTo(None)
        frame.layout = GridLayout(0, 1)

        font = Font(Font.SANS_SERIF, Font.BOLD, 32)
        UIManager.put("Button.font", font)
        UIManager.put("ComboBox.font", font)
        UIManager.put("Label.font", font)

        genres = self.logicLayer.getGenres()
        self.genresComboBox = JComboBox(genres.toArray())
        self.genresComboBox.maximumRowCount = 3

        btnCalc = JButton('Calculate average score', actionPerformed=self.calculate_score)

        self.avgScoreLabel = JLabel("Average score: xx.xx")

        frame.getContentPane().add(self.genresComboBox)
        frame.getContentPane().add(btnCalc)
        frame.getContentPane().add(self.avgScoreLabel)

        frame.visible = True

starts = Instant.now()
tmp = GUILayer()
ends = Instant.now()
print("Total: {0} ms".format(Duration.between(starts, ends).toMillis()))
























