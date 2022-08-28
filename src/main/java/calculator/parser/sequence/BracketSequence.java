package calculator.parser.sequence;

import calculator.dom.Expression;
import calculator.lexer.LexemeType;
import calculator.dom.ExpressionBrackets;
import calculator.parser.terminal.Terminal;
import calculator.parser.alternative.RootAlternative;

public class BracketSequence extends Sequence {

    public BracketSequence(RootAlternative root) {
        getMembers().add(new Terminal(LexemeType.OpenBracket));
        getMembers().add(root);
        getMembers().add(new Terminal(LexemeType.CloseBracket));
    }

    @Override
    protected Object collect(Object[] results) {
        return new ExpressionBrackets((Expression) results[1]);
    }
}
