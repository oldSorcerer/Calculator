package calculator.parser.alternative;

import calculator.parser.ParseRule;
import calculator.parser.Parser;

import java.util.LinkedList;

public class Alternative extends ParseRule {

    private final LinkedList <ParseRule> alternatives = new LinkedList<>();

    public LinkedList<ParseRule> getAlternatives() {
        return alternatives;
    }

    @Override
    protected Object applySpecial(Parser parser) {
        for (ParseRule alt : alternatives) {
            Object result = alt.apply(parser);
            if (result != null)
                return result;
        }
        return null;
    }
}
