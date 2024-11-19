package antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class CountingErrorListener extends BaseErrorListener {
    private int errorCount = 0;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errorCount++;
        System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
    }

    public boolean hasErrors() {
        return errorCount > 0;
    }
}
