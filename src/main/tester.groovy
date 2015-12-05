package main

/**
 * Created by Rob on 12/5/15.
 */
class tester {
    public static int method(String arg) {
        println("hi");
        return 1;
    }
    public int method(Object arg) {
        return 2;
    }
    void teste() {
        Object o = "Object";
        int result = method(o);
        println result;
    }

}
