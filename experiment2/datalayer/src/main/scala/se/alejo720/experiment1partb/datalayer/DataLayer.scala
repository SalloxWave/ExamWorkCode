package se.alejo720.experiment1partb.datalayer
import java.io.File
import java.time.{Duration, Instant}

import com.github.tototoshi.csv._

import scala.collection.mutable

class Movie(ctitle: String, cgenres: List[String], cavgScore: Float) {
  var title: String = ctitle
  var genres: List[String] = cgenres
  var avgScore: Float = cavgScore
}

class DataLayer {
  val starts = Instant.now()
  val path = "C:\\Users\\AlexanderJ\\Google Drive\\Universitet\\Exjobb\\intellijidea-projects\\experiment1partB\\datalayer\\src\\main\\resources\\tmdb-movies.csv"
  var movies: mutable.MutableList[Movie] = mutable.MutableList[Movie]()

  loadMovies()
  val ends = Instant.now()
  println("Data-layer: " + Duration.between(starts, ends).toMillis() + " ms")

  private def loadMovies(): Unit = {
    //val resStream: InputStream = this.getClass.getResourceAsStream(filename)
    //val res: URL = this.getClass.getResource(filename)
    val reader: CSVReader = CSVReader.open(new File(path))
    val all: List[List[String]] = reader.all()

    for (row <- all.slice(1, all.length)) {
      movies.+=(new Movie(row(5), row(13).split('|').toList, row(17).toFloat))
    }
  }

  def getMoviesByGenre(genre: String): List[Movie] = {
    val starts = Instant.now()

    val res = movies.filter(_.genres.contains(genre)).toList

    val ends = Instant.now()
    println("Data-layer calc-score: " + Duration.between(starts, ends).toMillis + " ms")

    res
  }

  def getGenres: List[String] = {
    var genres: List[String] = movies.flatMap(_.genres).toSet.toList
    genres.filter(genre => genre!="")  // Remove empty genres if there are any
  }
}

/*object DataLayer {
  def main(args: Array[String]): Unit = {
    println("WHY?")
    new DataLayer().getGenres
  }
}*/
