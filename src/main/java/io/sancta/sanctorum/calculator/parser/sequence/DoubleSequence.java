package io.sancta.sanctorum.calculator.parser.sequence;

import io.sancta.sanctorum.calculator.dom.NumberExpression;
import calculator.lexer.*;
import io.sancta.sanctorum.calculator.parser.terminal.Terminal;

public class DoubleSequence extends Sequence {

    public DoubleSequence() {
        getMembers().add(new Terminal(LexemeType.Digits));
        getMembers().add(new Terminal(LexemeType.Dot));
        getMembers().add(new Terminal(LexemeType.Digits));
    }

    @Override
    protected Object collect(Object[] results) {
        return new NumberExpression(Double.parseDouble(
                        ((Lexeme) results[0]).getText() +
                        "." +
                        ((Lexeme) results[2]).getText())
        );
    }
}
