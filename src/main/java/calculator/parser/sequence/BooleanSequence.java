package calculator.parser.sequence;

import calculator.dom.BooleanExpression;
import calculator.dom.BooleanOperator;
import calculator.dom.Expression;
import calculator.lexer.Lexeme;
import calculator.lexer.LexemeType;
import calculator.parser.alternative.RootAlternative;
import calculator.parser.terminal.Terminal;

public class BooleanSequence extends Sequence {

    public BooleanSequence(RootAlternative root) {
        getMembers().add(root);
        getMembers().add(new Terminal(LexemeType.CompareOperator));
        getMembers().add(root);
    }

    @Override
    protected Object collect(Object[] results) {
        BooleanExpression booleanExpression = new BooleanExpression();

        booleanExpression.setLeft((Expression) results[0]);
        booleanExpression.setOperator(BooleanOperator.fromChar( ((Lexeme)results[1]).getText().charAt(0)) );
        booleanExpression.setRight((Expression) results[2]);


        return booleanExpression;
    }
}
