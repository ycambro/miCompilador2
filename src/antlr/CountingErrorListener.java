package antlr;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class CountingErrorListener extends BaseErrorListener {
    private int errorCount = 0;
    private List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errorCount++;
        errors.add("line " + line + ":" + charPositionInLine + " " + msg);
        System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
    }

    public boolean hasErrors() {
        return errorCount > 0;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public List<String> getErrors() {
        return errors;
    }
}
