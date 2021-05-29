package sample.Controllers;
import java.util.ArrayList;


public class TestReport {
    public boolean success;
    public String message = "";
    public Object parameter;
    public Object expected;
    public Object actual;

    public TestReport(Object newParameter, Object newExpected) {
        parameter = newParameter;
        expected = newExpected;
    }

    public TestReport(String newMessage) {
        message = newMessage;
    }

    @Override
    public String toString() {
        if (parameter != null) {
            String passedString = (success) ? "|Passed|" : "|Failed|";
            String output = passedString + " Expected: <" + expected + "> " + "Actual: <" + actual + "> " + "Parameter: <" + parameter + ">";
            return output;
        } else {
            String output = "Something went wrong:\n{message}";
            return output;
        }
    }


    public static String ListOfReports(ArrayList<TestReport> reports) {
        String output = "";

        for (TestReport report : reports)
        {
            output += report.toString() + "\n";
        }

        return output;
    }

}

