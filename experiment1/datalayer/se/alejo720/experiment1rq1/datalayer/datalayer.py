# import sys
# import os
# PATH = os.path.dirname(os.path.abspath(__file__))
# print(PATH)
# #print(os.path.abspath(PATH))
# print(os.path.realpath(__file__))
# sys.path.insert(0, PATH)

import csv
from java.time import Duration, Instant
from se.alejo720.experiment1rq1.interfaces import DataLayerType

print("Running datalayer file from project!")

class Movie:
    def __init__(self, title, genres, score):
        self.title = title
        self.genres = genres
        self.score = score

class DataLayer(DataLayerType):
    FILENAME = "C:/Users/AlexanderJ/Google Drive/Universitet/Exjobb/intellijidea/datalayer/se/alejo720/experiment1rq1/datalayer/resources/tmdb-movies.csv"
    def __init__(self):
        starts = Instant.now()
        self.movies = []
        self.__load_movies()
        ends = Instant.now()
        print("Data-layer: {0} ms".format(Duration.between(starts, ends).toMillis()))

    def __load_movies(self):
        print "Loading movies from", self.FILENAME
        with open(self.FILENAME, "r") as csv_file:
            csv_reader = csv.reader(csv_file, delimiter=',')
            for index, row in enumerate(csv_reader):
                if index == 0: continue # Skip first row
                self.movies.append(Movie(row[5], row[13].split('|'), float(row[17])))

    def oldgetMovieScores(self, genre, return_title = False):
        movies = []
        for movie in self.movies:
            if genre in movie.genres:
                if return_title:
                    movies.append(movie.title + "|" + str(movie.score))
                else:
                    movies.append(movie.score)
        return movies

    def getMovieScores(self, genre, return_title = False):
        starts = Instant.now()

        tmp = map(lambda m: m.score, list(filter(lambda m: genre in m.genres, self.movies)))

        ends = Instant.now()
        print("Data-layer calc-score: {0} ms".format(Duration.between(starts, ends).toMillis()))
        return tmp

    def getGenres(self):
        genres = list(set([item for sublist in map(lambda m: m.genres, self.movies) for item in sublist]))
        genres.remove("")
        print("genres", genres)
        return genres

    def test(self, t1, t2):
        return "2" + t1 + t2

    def test(self, t1):
        return "1" + t1


        """
        genres = []
        for movie in self.movies:
            for genre in movie.genres:
                if genre not in genres:
                    genres.append(genre)
        genres.remove("")
        return genres
        """
