package sample.Resources;

import javax.sound.sampled.Port;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ResourceManager {


    public static String readResource(String fileName) {
        InputStream is = ResourceManager.class.getResourceAsStream(fileName);
        BufferedReader buffy = new BufferedReader(new InputStreamReader(is));

        String text = "";

        try {
            while (buffy.ready()) {
                text += buffy.readLine() + "\n";
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return text;
    }

}
