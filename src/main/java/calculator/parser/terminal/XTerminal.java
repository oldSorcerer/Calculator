package calculator.parser.terminal;

import calculator.dom.XExpression;
import calculator.lexer.LexemeType;
import calculator.parser.Parser;

public class XTerminal extends Terminal {

    public XTerminal() {
        super(LexemeType.X);
    }

    @Override
    protected Object applySpecial(Parser parser) {
        return super.applySpecial(parser) == null ? null : new XExpression();
    }
}
