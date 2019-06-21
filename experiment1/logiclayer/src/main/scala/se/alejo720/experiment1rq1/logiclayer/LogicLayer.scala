package se.alejo720.experiment1rq1.logiclayer
import java.time.{Duration, Instant}

import se.alejo720.experiment1rq1.interfaces.{DataLayerFactory, DataLayerType}

import scala.collection.mutable.ArrayBuffer

class Movie() {
    val score = 10.0f
}

class LogicLayer {
    val starts = Instant.now()
    val factory: DataLayerFactory = new DataLayerFactory()
    val ends = Instant.now()
    println("Logic-layer " + Duration.between(starts, ends).toMillis + " ms")
    //val ends = Instant.now()
    //println("Init DataLayerFactory " + Duration.between(starts, ends).toMillis + " ms")
    var datalayer: DataLayerType = null

    createDatalayer











    private def createDatalayer: Unit = {
        datalayer = factory.create()
    }










/*    def oldcalculateAverageScore(genre: String): Float = {
        var scores: Array[Float] = datalayer.getMovieScores(genre)
        val average: Float = scores.sum./(scores.length)
        average
    }*/

    def calculateAverageScoreKotlinVersion(genre: String): Float = {
        var scores: Array[Float] = datalayer.getMovieScores(genre)

        var sum = 0.0f
        for (score <- scores) {
            sum+=score
        }

        sum./(scores.length)
    }






    def average(list: Iterable[Float]): Float = {
        list.sum./(list.size)
    }

    def calculateAverageScore(genre: String): Float = {
       average(datalayer.getMovieScores(genre))
    }





    def tmpcalculateAverageScore(genre: String): Float = {
        val starts = Instant.now()

        val movieScores: Array[Float] = datalayer.getMovieScores(genre)

        val ends = Instant.now()
        println("Logic-layer calc-score: " + Duration.between(starts, ends).toMillis + " ms")

        average(movieScores)
    }

    /*def getGenres: Array[String] = {
        datalayer.getGenres()
    }*/

    def getGenres: Array[String] = {
        var scalaGenres = ArrayBuffer[String]()
        val genres = datalayer.getGenres()
        for(genre <- genres) {
            scalaGenres.+=(genre)
        }
        scalaGenres.toArray
    }

/*
    def testInteger(): Int = {
        5
    }
*/

    // Scala code
    def testNullable(): Movie ={
        null
    }

    /*def average(list: Iterable[Float]): Float = {
        list.sum./(list.size)
    }

    def calculateAverageScore(genre: String): Float = {
        val movies: List[Movie] = datalayer.getMovieScores(genre)
        average(movies.map(movie => movie.score))
    }*/
}

/*object LogicLayerMain {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
    sayHello("Scala")

    calculateAverageScore("Action")
  }

  def sayHello(name: String): Unit = {
    println("Hello " + name)
  }

  private def createDatalayer(): DataLayerType = {
    val factory = new DataLayerFactory()
    val obj = factory.create()
    obj
  }

  def calculateAverageScore(genre: String): Float = {
    var datalayer: DataLayerType = createDatalayer()
    var movies: Array[Float] = datalayer.getMovieScores(genre)

    var sum: Float = 0.0f
    var score: Float = 0.0f
    for (movie <- movies) {
      println(movie)
      score = movie.toFloat
      sum = sum.+(score)
    }
    val average: Float = sum./(movies.length)
    println("SUM: " + sum)
    println("Average: " + average)
    return 0.0f
  }
}*/
