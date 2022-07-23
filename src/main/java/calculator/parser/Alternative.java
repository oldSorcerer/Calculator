package calculator.parser;

import java.util.LinkedList;

public class Alternative extends ParseRule {

    private LinkedList <ParseRule> alternatives = new LinkedList<>();

    public LinkedList<ParseRule> getAlternatives() {
        return alternatives;
    }

    @Override
    protected Object applySpecial(Parser p) {
        for (ParseRule alt : alternatives) {
            Object result = alt.apply(p);
            if (result != null)
                return result;
        }
        return null;
    }
}
