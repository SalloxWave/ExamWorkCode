import org.python.core.*;

public class datalayer extends java.lang.Object {
    static String[] jpy$mainProperties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions"};
    static String[] jpy$proxyProperties = new String[] {"python.modules.builtin", "exceptions:org.python.core.exceptions", "python.options.showJavaExceptions", "true"};
    static String[] jpy$packages = new String[] {"java.lang", null};
    
    public static class _PyInner extends PyFunctionTable implements PyRunnable {
        private static PyObject s$0;
        private static PyObject i$1;
        private static PyObject i$2;
        private static PyObject s$3;
        private static PyFunctionTable funcTable;
        private static PyCode c$0_jython_max;
        private static PyCode c$1_main;
        private static void initConstants() {
            s$0 = Py.newString("Max is: ");
            i$1 = Py.newInteger(10);
            i$2 = Py.newInteger(5);
            s$3 = Py.newString("C:\\Users\\AlexanderJ\\Google Drive\\Universitet\\Exjobb\\intellijidea\\datalayer\\src\\main\\jython\\se\\alejo720\\experiment1rq1\\datalayer\\datalayer.py");
            funcTable = new _PyInner();
            c$0_jython_max = Py.newCode(2, new String[] {"a", "b"}, "C:\\Users\\AlexanderJ\\Google Drive\\Universitet\\Exjobb\\intellijidea\\datalayer\\src\\main\\jython\\se\\alejo720\\experiment1rq1\\datalayer\\datalayer.py", "jython_max", false, false, funcTable, 0, null, null, 0, 17);
            c$1_main = Py.newCode(0, new String[] {}, "C:\\Users\\AlexanderJ\\Google Drive\\Universitet\\Exjobb\\intellijidea\\datalayer\\src\\main\\jython\\se\\alejo720\\experiment1rq1\\datalayer\\datalayer.py", "main", false, false, funcTable, 1, null, null, 0, 16);
        }
        
        
        public PyCode getMain() {
            if (c$1_main == null) _PyInner.initConstants();
            return c$1_main;
        }
        
        public PyObject call_function(int index, PyFrame frame) {
            switch (index){
                case 0:
                return _PyInner.jython_max$1(frame);
                case 1:
                return _PyInner.main$2(frame);
                default:
                return null;
            }
        }
        
        private static PyObject jython_max$1(PyFrame frame) {
            Py.println(Py.None, s$0._add(frame.getglobal("str").__call__(frame.getglobal("int").__call__(frame.getglobal("Math").__getattr__("max").__call__(frame.getlocal(0), frame.getlocal(1))))));
            return Py.None;
        }
        
        private static PyObject main$2(PyFrame frame) {
            frame.setglobal("__file__", s$3);
            
            // Temporary Variables
            PyObject[] t$0$PyObject__;
            
            // Code
            t$0$PyObject__ = org.python.core.imp.importFrom("java.lang", new String[] {"Math"}, frame);
            frame.setlocal("Math", t$0$PyObject__[0]);
            t$0$PyObject__ = null;
            frame.setlocal("jython_max", new PyFunction(frame.f_globals, new PyObject[] {}, c$0_jython_max));
            frame.getname("jython_max").__call__(i$1, i$2);
            return Py.None;
        }
        
    }
    public static void moduleDictInit(PyObject dict) {
        dict.__setitem__("__name__", new PyString("datalayer"));
        Py.runCode(new _PyInner().getMain(), dict, dict);
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        String[] newargs = new String[args.length+1];
        newargs[0] = "datalayer";
        java.lang.System.arraycopy(args, 0, newargs, 1, args.length);
        Py.runMain(datalayer._PyInner.class, newargs, datalayer.jpy$packages, datalayer.jpy$mainProperties, null, new String[] {"datalayer"});
    }
    
}
