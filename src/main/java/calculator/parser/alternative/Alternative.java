package calculator.parser.alternative;

import calculator.parser.ParseRule;
import calculator.parser.Parser;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Alternative extends ParseRule {

    private final List<ParseRule> alternatives = new ArrayList<>();

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
