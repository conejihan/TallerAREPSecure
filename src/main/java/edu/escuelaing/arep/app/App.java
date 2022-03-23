package edu.escuelaing.arep.app;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        secure(getKeyStore(), "nicolas1234", null, null);
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystore/ecikeystore.p12";
    }
}
