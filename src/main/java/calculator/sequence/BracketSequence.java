package calculator.sequence;

import calculator.expression.Expression;
import calculator.lexer.LexType;
import calculator.expression.ExpressionBrackets;
import calculator.terminal.Terminal;
import calculator.alternative.RootAlternative;

public class BracketSequence extends Sequence {

    public BracketSequence(RootAlternative root) {
        getMembers().add(new Terminal(LexType.OpenBracket));
        getMembers().add(root);
        getMembers().add(new Terminal(LexType.CloseBracket));
    }

    @Override
    protected Object collect(Object[] results) {
        return new ExpressionBrackets((Expression) results[1]);
    }
}
