package io.sancta.sanctorum.calculator.parser.terminal;

import io.sancta.sanctorum.calculator.dom.XExpression;
import io.sancta.sanctorum.calculator.lexer.LexemeType;
import io.sancta.sanctorum.calculator.parser.Parser;

public class XTerminal extends Terminal {

    public XTerminal() {
        super(LexemeType.X);
    }

    @Override
    protected Object applySpecial(Parser parser) {
        return super.applySpecial(parser) == null ? null : new XExpression();
    }
}
