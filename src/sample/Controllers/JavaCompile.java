package sample.Controllers;

import sample.Resources.ResourceManager;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaCompile extends ClassLoader {

    private static String[] testNames = new String[]{ "JVinchesToFeet", "JVisEven", "JVremoveWhiteSpace", "JVreverseString", "JVwordCount" };
    public static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    private static JavaCompile __instance
            = new JavaCompile();

    private static final Logger logger =
            Logger.getLogger(JavaCompile.class.getName());

    private Pattern namePattern;
    private Pattern packagePattern;

    private JavaCompile() {
        this.namePattern =
                Pattern.compile(".*class[ ]+([a-zA-Z0-9$_]+).*");
        this.packagePattern =
                Pattern.compile(".*package[ ]+([a-zA-Z0-9$_.]+).*");
    }

    public static JavaCompile getInstance() {
        return __instance;
    }

    public static String getTestName(int index) {
        return testNames[index];
    }

    // load the class file after compiling the code
    public Class<?> loadClassFromString(final String program, String testName) throws ClassNotFoundException {
        final String className = getClassName(program);
        final String packagePath = getPackagePath(program);

        final String fullClassName;
        if (packagePath != null) {
            fullClassName = packagePath + '.' + className;
        } else {
            fullClassName = className;
        }

        System.out.println("Loading " + fullClassName);

        // compile it!
        boolean result =
                JavaStringCompile.INSTANCE
                        .compileStringCode(fullClassName, program);

        if (result) {
            byte[] classBytes = getClassBytes(className);
            if (classBytes != null) {
                System.out.println("Loaded " + fullClassName);
                return defineClass(fullClassName, classBytes, 0, classBytes.length);
            } else
                throw new ClassNotFoundException("Unable to load: " + fullClassName +
                        ". Reason = failed to load class bytes.");
        } else
            throw new ClassNotFoundException("Unable to load: " + fullClassName +
                    ". Reason = compilation failed.");
    }

    private String getClassName(final String program) {
        Matcher m = namePattern.matcher(program);
        m.find();

        if ((m.groupCount() == 1)) {
            return m.group(1);
        }
        throw new RuntimeException("Could not find main class to load!");
    }

    private String getPackagePath(final String program) {
        Matcher m = packagePattern.matcher(program);
        m.find();

        if ((m.groupCount() == 1)) {
            return m.group(1);
        }
        return null;
    }

    private byte[] getClassBytes(final String className) {
        final String classFilePath =
                className.replace('.', File.separatorChar) + ".class";

        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(classFilePath));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4 * 1024];
            int bytesRead = -1;

            while ((bytesRead = bin.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // delete the class file before returning
            try {
                Files.deleteIfExists(Paths.get(classFilePath));
            } catch (IOException ex) {
                //
            }

            return baos.toByteArray();
        } catch (IOException ex) {
            return null;
        }
    }


    public static String returnCodeBase(int testNum) {
        return ResourceManager.readResource(testNames[testNum] + ".txt");
    }

    public static String returnTestResults(String testName, String userCode) throws Throwable {
        Method method;
        try {
            method = JavaCompile.class.getMethod(testName, String.class);
        } catch (NoSuchMethodException nsm) {
            System.out.println(nsm.getMessage());
            return null;
        }

        try {
            ArrayList<TestReport> reports = (ArrayList<TestReport>) method.invoke(null, userCode);
            if (reports.size() <= 0) return "You passed all tests!";
            return TestReport.ListOfReports(reports);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (InvocationTargetException.class == e.getClass()) {
                InvocationTargetException ite = (InvocationTargetException) e;
                throw ite.getCause();
            }
            return null;
        }
    }


    public static ArrayList<TestReport> JVinchesToFeet(String code)  throws Exception {
        ArrayList<TestReport> reports = new ArrayList<TestReport>();
        ArrayList<TestReport> failedTests = new ArrayList<TestReport>();

        reports.add(new TestReport(12f, 1f));
        reports.add(new TestReport(24f, 2f));
        reports.add(new TestReport(18f, 1.5f));
        reports.add(new TestReport(9f, 9f / 12f));

        Method method;
        try {
            Class<?> compiled = __instance.loadClassFromString(code, "InchesConversion");

            __instance = new JavaCompile();

            method = compiled.getDeclaredMethod("inchesToFeet", float.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (TestReport report : reports)
        {
            report.actual = method.invoke(null, report.parameter);

            report.success = (report.actual.equals(report.expected));
            if (!report.success) failedTests.add(report);
        }

        return failedTests;
    }

    public static ArrayList<TestReport> JVisEven(String code)  throws Exception {
        ArrayList<TestReport> reports = new ArrayList<TestReport>();
        ArrayList<TestReport> failedTests = new ArrayList<TestReport>();

        reports.add(new TestReport(12, true));
        reports.add(new TestReport(3, false));
        reports.add(new TestReport(0, true));
        reports.add(new TestReport(9, false));

        Method method;
        try {
            Class<?> compiled = __instance.loadClassFromString(code, "EvenTest");

            __instance = new JavaCompile();

            method = compiled.getDeclaredMethod("isEven", int.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (TestReport report : reports)
        {
            report.actual = method.invoke(null, report.parameter);

            report.success = (report.actual.equals(report.expected));
            if (!report.success) failedTests.add(report);
        }

        return failedTests;
    }

    public static ArrayList<TestReport> JVremoveWhiteSpace(String code)  throws Exception {
        ArrayList<TestReport> reports = new ArrayList<TestReport>();
        ArrayList<TestReport> failedTests = new ArrayList<TestReport>();

        reports.add(new TestReport(" dog ", "dog"));
        reports.add(new TestReport(" d o g ", "dog"));
        reports.add(new TestReport("red green blue ", "redgreenblue"));
        reports.add(new TestReport("re d gr een blue", "redgreenblue"));

        Method method;
        try {
            Class<?> compiled = __instance.loadClassFromString(code, "WhiteSpace");

            __instance = new JavaCompile();

            method = compiled.getDeclaredMethod("removeWhiteSpace", String.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (TestReport report : reports)
        {
            report.actual = method.invoke(null, report.parameter);

            report.success = (report.actual.equals(report.expected));
            if (!report.success) failedTests.add(report);
        }

        return failedTests;
    }

    public static ArrayList<TestReport> JVreverseString(String code)  throws Exception {
        ArrayList<TestReport> reports = new ArrayList<TestReport>();
        ArrayList<TestReport> failedTests = new ArrayList<TestReport>();

        reports.add(new TestReport("cat", "tac"));
        reports.add(new TestReport("12345", "54321"));
        reports.add(new TestReport("elcycirT", "Tricycle"));
        reports.add(new TestReport("madam", "madam"));

        Method method;
        try {
            Class<?> compiled = __instance.loadClassFromString(code, "ReverseStringTest");

            __instance = new JavaCompile();

            method = compiled.getDeclaredMethod("reverseString", String.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (TestReport report : reports)
        {
            report.actual = method.invoke(null, report.parameter);

            report.success = (report.actual.equals(report.expected));
            if (!report.success) failedTests.add(report);
        }

        return failedTests;
    }

    public static ArrayList<TestReport> JVwordCount(String code)  throws Exception {
        ArrayList<TestReport> reports = new ArrayList<TestReport>();
        ArrayList<TestReport> failedTests = new ArrayList<TestReport>();

        reports.add(new TestReport("cat", 1));
        reports.add(new TestReport("this is epic", 3));
        reports.add(new TestReport("yo, waddup, how are you doing", 6));
        reports.add(new TestReport("  ", 0));

        Method method;
        try {
            Class<?> compiled = __instance.loadClassFromString(code, "WordCount");

            __instance = new JavaCompile();

            method = compiled.getDeclaredMethod("wordCount", String.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (TestReport report : reports)
        {
            report.actual = method.invoke(null, report.parameter);

            report.success = (report.actual.equals(report.expected));
            if (!report.success) failedTests.add(report);
        }

        return failedTests;
    }
}
