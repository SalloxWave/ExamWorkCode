package se.alejo720.experiment1rq1.javainterfaces;
//import interfaces-1.0-SNAPSHOT;

public class Main {
    public static void main(String[] args) {
        DataLayerFactoryJava factory = new DataLayerFactoryJava();
        DataLayerTypeJava obj = factory.create("Cool name");
        System.out.println(obj.getdName());
    }
}
