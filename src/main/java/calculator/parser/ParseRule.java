package calculator.parser;

public abstract class ParseRule {

    public final Object apply(Parser parser) {
        int count = parser.getRecognized();
        Object result = applySpecial(parser);
        if (result == null) parser.setRecognized(count);
        return result;
    }

    protected abstract Object applySpecial(Parser p);

}
