package calculator.parser;

public abstract class ParseRule {

    public final Object apply (Parser p){
        int count = p.recognized;
        Object result = applySpecial(p);
        if (result == null)
            p.recognized = count;
        return result;
    }

    protected abstract Object applySpecial (Parser p);

}
