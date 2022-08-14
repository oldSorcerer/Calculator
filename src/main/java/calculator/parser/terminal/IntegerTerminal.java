package calculator.parser.terminal;

import calculator.om.NumberExpression;
import calculator.lexer.*;
import calculator.parser.Parser;

public class IntegerTerminal extends Terminal {

    public IntegerTerminal() {
        super(LexType.Digits);
    }

    @Override
    protected Object applySpecial(Parser p) {
        Lex lex = (Lex) super.applySpecial(p);
        return lex != null ? new NumberExpression(Integer.parseInt(lex.getText())) : null;
    }
}