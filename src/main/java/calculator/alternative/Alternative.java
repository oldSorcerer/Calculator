package calculator.alternative;

import calculator.parser.ParseRule;
import calculator.parser.Parser;
import lombok.Getter;

import java.util.LinkedList;
@Getter
public class Alternative extends ParseRule {

    private final LinkedList<ParseRule> alternatives = new LinkedList<>();

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
