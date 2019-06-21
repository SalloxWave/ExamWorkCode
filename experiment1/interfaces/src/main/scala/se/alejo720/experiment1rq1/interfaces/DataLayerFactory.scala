package se.alejo720.experiment1rq1.interfaces

import org.python.core.PyObject
import org.python.core.PyString
import org.python.util.PythonInterpreter
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.time.{Duration, Instant}
import java.util.Properties

import scala.collection.mutable.ArrayBuffer
import collection.JavaConverters._

class DataLayerFactory {

/**
  * Create a new PythonInterpreter object, then use it to
  * execute some python code. In this case, we want to
  * import the python module that we will coerce.
  *
  * Once the module is imported than we obtain a reference to
  * it and assign the reference to a Java variable
  */
    private var buildingClass: PyObject = null
    var interpreter: PythonInterpreter = null
    try {
        val p = new Properties
        p.setProperty("python.path", "C:\\jython2.7.0\\Lib;C\\Users\\AlexanderJ\\Google Drive\\Universitet\\Exjobb\\intellijidea\\datalayer\\se\\alejo720\\experiment1rq1\\datalayer")
        p.setProperty("python.home", "C:\\jython2.7.0\\Lib")
        p.setProperty("python.prefix", "C:\\jython2.7.0\\Lib")
        val argv = null
        PythonInterpreter.initialize(System.getProperties, p, argv)
        interpreter = new PythonInterpreter
    } catch {
        case ex: Exception =>
            System.out.println("Exception while creating python interpreter: " + ex.toString)
    }

    //var interpreter: PythonInterpreter = new PythonInterpreter()
    interpreter.exec("from datalayersym import DataLayer")
    buildingClass = interpreter.get("DataLayer")

    /**
      * The create method is responsible for performing the actual
      * coercion of the referenced python module into Java bytecode
      */
    def create(): DataLayerType = {
        val datalayerObject = buildingClass.__call__()
        datalayerObject.__tojava__(classOf[DataLayerType]).asInstanceOf[DataLayerType]
    }
}


/*
Old code:
    var interpreter: PythonInterpreter = null
    private var buildingClass: PyObject = null
    try {
        val p = new Properties
        p.setProperty("python.path", "C:\\jython2.7.0\\Lib;C\\Users\\AlexanderJ\\Google Drive\\Universitet\\Exjobb\\intellijidea\\datalayer\\se\\alejo720\\experiment1rq1\\datalayer")
        p.setProperty("python.home", "C:\\jython2.7.0\\Lib")
        p.setProperty("python.prefix", "C:\\jython2.7.0\\Lib")
        val argv = null
        PythonInterpreter.initialize(System.getProperties, p, argv)
        interpreter = new PythonInterpreter
    } catch {
        case ex: Exception =>
            System.out.println("Exception while creating python interpreter: " + ex.toString)
    }
    //PythonInterpreter interpreter = new PythonInterpreter();
    //String path = "C\\Users\\AlexanderJ\\Google\\\\ Drive\\Universitet\\Exjobb\\intellijidea\\datalayer\\se\\alejo720\\experiment1rq1\\datalayer";
    //String path = "C/Users/AlexanderJ/Google\\ Drive/Universitet/Exjobb/intellijidea/datalayer/se/alejo720/experiment1rq1/datalayer";
    //String path = "C\\Users\\AlexanderJ\\Documents\\tmp";
    //path = path.replace("\\", "/");
    //interpreter.exec("import sys");
    //interpreter.exec("print(sys.path)");
    //interpreter.exec("from datalayer import datalayersym");
    interpreter.exec("from datalayersym import DataLayer")
    //../../../../../../../../datalayer/se/alejo720/experiment1rq1/datalayer
    //interpreter.exec("sys.path.insert(0," + path + ")");
    //interpreter.exec("from datalayer import DataLayer");
    /*System.out.println(new PyString(path));
            String tmp = "from " + path +" import datalayer";
            System.out.println(tmp);
            interpreter.exec(tmp);*/
    //Might be print that has double backspace
    //interpreter.execfile(new ByteArrayInputStream("import sys".getBytes()) {});
    //interpreter.execfile(new ByteArrayInputStream(("sys.path.insert(0," + path + ")").getBytes()) {});
    //interpreter.execfile(new ByteArrayInputStream("from .datalayer import DataLayer".getBytes()) {});
    //interpreter.exec("print(datalayer.hello())");
    //interpreter.exec("import ../../../../../../../../datalayer/se/alejo720/experiment1rq1/datalayer");
    System.out.println(interpreter.getLocals)
    //System.out.println(interpreter.get("datalayer.DataLayer"));
    buildingClass = interpreter.get("DataLayer")
 */