package day3;

import java.util.logging.*;

class LogExample {  

    private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );     
    
    private static void setupLogger() {
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logr.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("./src/day3/myLogger.log", true);
            fh.setLevel(Level.FINE);
            logr.addHandler(fh);
        } catch (java.io.IOException e) {            
            // don't stop my program but log out to console.
            logr.log(Level.SEVERE, "File logger not working.", e);
        }
    }
    //
    public static void main(String[] args) throws java.io.IOException {
        // setup the logger
        setupLogger();               

        // log some stuff
        logr.info("My first log");
        logr.fine("My second log");
        
        // test logger in another class.
        Test.test();


        // purposly throw an error and log it.
        try {
            throw new java.io.IOException("Fake error message");
        }
        catch (java.io.IOException e) {
            logr.log(Level.SEVERE, "A fake error occurred mate!", e);
            // let the error happen after we've logged it
            throw e;
        }          
       
    }
}
class Test {
    private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );     
    static void test(){
        logr.info("I'm from another class");
    }
}