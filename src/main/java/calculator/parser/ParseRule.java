package calculator.parser;

public abstract class ParseRule {

    public final Object apply(Parser parser) {
        int count = parser.recognized;
        Object result = applySpecial(parser);
        if (result == null)
            parser.recognized = count;
        return result;
    }

    protected abstract Object applySpecial(Parser p);

}
