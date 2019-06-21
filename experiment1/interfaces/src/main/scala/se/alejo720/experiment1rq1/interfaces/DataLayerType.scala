package se.alejo720.experiment1rq1.interfaces

trait DataLayerType {
    def getMovieScores(genre: String): Array[Float]
    def getGenres(): Array[String]
}