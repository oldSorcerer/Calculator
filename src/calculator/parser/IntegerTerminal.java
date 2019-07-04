package calculator.parser;

import calculator.dom.NumberExpression;
import calculator.lexer.*;

public class IntegerTerminal extends Terminal {

    public IntegerTerminal() {
        super(LexType.Digits);
    }

    @Override
    protected Object applySpecial(Parser p) {
        Lex lex = (Lex)super.applySpecial(p);
        return lex != null ? new NumberExpression(Integer.parseInt(lex.getText())) : null;
    }

}
