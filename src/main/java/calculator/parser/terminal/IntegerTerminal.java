package calculator.parser.terminal;

import calculator.dom.NumberExpression;
import calculator.lexer.*;
import calculator.parser.Parser;

public class IntegerTerminal extends Terminal {

    public IntegerTerminal() {
        super(LexType.Digits);
    }

    @Override
    protected Object applySpecial(Parser parser) {
        Lex lex = (Lex)super.applySpecial(parser);
        return lex != null ? new NumberExpression(Integer.parseInt(lex.getText())) : null;
    }

}
