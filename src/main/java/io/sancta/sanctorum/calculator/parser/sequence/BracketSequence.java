package io.sancta.sanctorum.calculator.parser.sequence;

import io.sancta.sanctorum.calculator.dom.Expression;
import io.sancta.sanctorum.calculator.dom.ExpressionBrackets;
import io.sancta.sanctorum.calculator.parser.alternative.RootAlternative;
import io.sancta.sanctorum.calculator.lexer.LexemeType;
import io.sancta.sanctorum.calculator.parser.terminal.Terminal;

public class BracketSequence extends Sequence {

    public BracketSequence(RootAlternative root) { //(x + y)
        getMembers().add(new Terminal(LexemeType.OpenBracket));
        getMembers().add(root);
        getMembers().add(new Terminal(LexemeType.CloseBracket));
    }

    @Override
    protected Object collect(Object[] results) {
        return new ExpressionBrackets((Expression) results[1]);
    }
}
