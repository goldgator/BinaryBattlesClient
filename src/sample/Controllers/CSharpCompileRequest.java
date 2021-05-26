package sample.Controllers;


import org.json.JSONObject;
import sample.Models.CompilationType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CSharpCompileRequest {

    private static String[] testNames = new String[]{ "CSHSquare", "CSHAbsoluteValue" };
    private static String getString = "https://binarybattlesapi.azurewebsites.net/api/values?testName=";
    private static String postString = "https://binarybattlesapi.azurewebsites.net/api/values";

    public static String getTestName(int index) {
        return testNames[index];
    }

    public static String returnCodeBase(int testNum) {
        URL url;
        String codeBase = "";

        try {
            url = new URL(getString + testNames[testNum]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(("GET"));

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while(in.ready()) {
                codeBase += in.readLine();
            }

        } catch (MalformedURLException mue) {
            System.out.println("Faulty URL, please fix it\n" + mue.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return codeBase;
    }

    public static String returnTestResults(String testName, String userCode) {
        URL url;
        String response = "";

        try {
            url = new URL(postString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(("POST"));
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true);

            String jsonSend = "{\"testName\": \"" + testName + "\", \"test\": \"" + userCode + "\" }";

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonSend.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while(in.ready()) {
                response += in.readLine();
            }

        } catch (MalformedURLException mue) {
            System.out.println("Faulty URL, please fix it\n" + mue.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return response;
    }


}
