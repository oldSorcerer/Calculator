package calculator.parser.terminal;

import calculator.lexer.LexType;
import calculator.parser.ParseRule;
import calculator.parser.Parser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Terminal extends ParseRule {

    private final LexType lexType;

    @Override
    protected Object applySpecial(Parser parser) {
        if (parser.recognized >= parser.size())
            return null;

        return parser.get(parser.recognized).getType() == lexType ? parser.get(parser.recognized++) : null;
    }
}
