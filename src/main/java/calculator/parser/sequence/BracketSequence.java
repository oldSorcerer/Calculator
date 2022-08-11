package calculator.parser.sequence;

import calculator.dom.expression.Expression;
import calculator.lexer.LexType;
import calculator.dom.expression.ExpressionBrackets;
import calculator.parser.terminal.Terminal;
import calculator.parser.alternative.RootAlternative;

public class BracketSequence extends Sequence {

    public BracketSequence(RootAlternative root){
        getMembers().add(new Terminal(LexType.OpenBracket));
        getMembers().add(root);
        getMembers().add(new Terminal(LexType.CloseBracket));
    }

    @Override
    protected Object collect(Object[] results) {
        return new ExpressionBrackets((Expression)results[1]);
    }
}
