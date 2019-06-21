package se.alejo720.experiment1partb.logiclayer
import se.alejo720.experiment1partb.datalayer.*
import java.time.Duration
import java.time.Instant

/*
C:\Users\AlexanderJ\Google Drive\Universitet\Exjobb\intellijidea-projects\experiment1partB\datalayer\build\libs\datalayer-1.0-SNAPSHOT.jar
* */
/*fun main(args: Array<String>) {
    println("(LogicLayer) Hello world from Kotlin!")
    LogicLayer()
}*/

class LogicLayer {

    val datalayer = DataLayer()

    init {
        val starts = Instant.now()
        println("(LogicLayer) Initializing")
        println("(LogicLayer) Initialized")
        val ends = Instant.now()
        println("Logic-layer: " + Duration.between(starts, ends).toMillis() + " ms")
    }

    fun calculateAverageScore(genre: String): Float {
        val starts = Instant.now()

        val movies: scala.collection.immutable.List<Movie> = datalayer.getMoviesByGenre(genre)

        var sum = 0.0f
        for (movie in movies) {
            sum+=movie.avgScore()
        }

        val average = sum / movies.size()

        val ends = Instant.now()
        println("Logic-layer calc-score: " + Duration.between(starts, ends).toMillis() + " ms")
        return average
    }

    fun getGenres(): List<String> {
        val ktlGenres = mutableListOf<String>()
        val genres = datalayer.getGenres()
        for(genre in genres) {
            ktlGenres.add(genre)
        }
        return ktlGenres
    }
}
