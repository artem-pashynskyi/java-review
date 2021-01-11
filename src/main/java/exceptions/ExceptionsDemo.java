package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {

    public static void show() {
        try (
            var reader = new FileReader("file.txt");
            var writer = new FileWriter("...");
        ) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
            System.out.println("File opened");
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist.");
            System.out.println(ex.getMessage());
        } catch (IOException | ParseException e) { //Multiple exceptions
            System.out.println("Could not read data.");
        }
//        finally {
//            if(reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        sayHello(null);
    }

    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }
}
