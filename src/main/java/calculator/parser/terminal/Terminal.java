package calculator.parser.terminal;

import calculator.lexer.LexType;
import calculator.parser.ParseRule;
import calculator.parser.Parser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Terminal extends ParseRule {

    private final LexType lexType;

    @Override
    protected Object applySpecial(Parser p) {
        if (p.recognized >= p.size())
            return null;
        return p.get(p.recognized).getType() == lexType ? p.get(p.recognized++) : null;
    }
}
