package sample.Models;

public class TestModel {

    public CompilationType type;
    public String testName;
    public String[] codeSplit;

    public TestModel(CompilationType newType, String newName, String[] newSplit) {
        type = newType;
        testName = newName;
        codeSplit = newSplit;
    }
}
