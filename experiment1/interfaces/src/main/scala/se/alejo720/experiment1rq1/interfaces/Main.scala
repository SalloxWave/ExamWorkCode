package se.alejo720.experiment1rq1.interfaces

object HelloWorld {
    def main(args: Array[String]): Unit = {
        val factory = new DataLayerFactory()
        val obj = factory.create()
    }
}
