package sample.Controllers;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public enum JavaStringCompile {
    INSTANCE;

    private JavaCompiler compiler;
    private DiagnosticCollector<JavaFileObject> collector;
    private StandardJavaFileManager manager;

    private static final Logger logger =
            Logger.getLogger(JavaStringCompile.class.getName());

    private JavaStringCompile() {
        this.compiler = ToolProvider.getSystemJavaCompiler();
        this.collector  = new DiagnosticCollector<JavaFileObject>();
        this.manager = compiler.getStandardFileManager(collector, null, null);
    }

    // class to represent a string object as a source file
    class StringCodeObject extends SimpleJavaFileObject {
        private String code;

        StringCodeObject(final String name, final String code) {
            super(URI.create("string:///" + name.replace('.', '/') +
                            Kind.SOURCE.extension),
                    Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return this.code;
        }
    }

    // Compile the Java code stored inside the string
    public boolean compileStringCode(final String name, final String code) {
        logger.info("Compiling: " + name);

        boolean result = false;
        StringCodeObject source = new StringCodeObject(name, code);

           result = compiler.getTask(null, manager, null, null, null,
                Collections.unmodifiableList(Arrays.asList(source))).call();

        // display errors, if any
        for (Diagnostic<? extends JavaFileObject> d : collector.getDiagnostics()) {
            System.err.format("Error at line: %d, in file: %s\n",
                    d.getLineNumber(),
                    d.getSource().toUri());
        }

        try {
            manager.close();
        } catch (IOException ex) {
            //
        }

        logger.info("Finished compiling: " + name);

        return result;
    }
}
