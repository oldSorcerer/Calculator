package calculator.sequence;

import calculator.expression.NumberExpression;
import calculator.lexer.*;
import calculator.terminal.Terminal;

public class DoubleSequence extends Sequence {
    public DoubleSequence() {
        getMembers().add(new Terminal(LexType.Digits));
        getMembers().add(new Terminal(LexType.Dot));
        getMembers().add(new Terminal(LexType.Digits));
    }

    @Override
    protected Object collect(Object[] results) {
        return new NumberExpression(Double.parseDouble(((Lex) results[0]).getText()
                + "." + ((Lex) results[2]).getText()));
    }
}
