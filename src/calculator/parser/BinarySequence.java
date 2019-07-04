package calculator.parser;

import calculator.dom.BinaryExpression;
import calculator.dom.BinaryOperator;
import calculator.dom.Expression;
import calculator.lexer.Lex;
import calculator.lexer.LexType;

public class BinarySequence extends Sequence {

    public BinarySequence (RootAlternative root){
        getMembers().add(new RootAlternative(true));
        getMembers().add(new Terminal(LexType.Operator));
        getMembers().add(root);
    }

    @Override
    protected Object collect(Object[] results) {
        BinaryExpression result = new BinaryExpression();
        result.setLeft((Expression) results[0]);
        result.setOperator(BinaryOperator.fromChar(((Lex)results[1]).getText().charAt(0)));
        result.setRight((Expression) results[2]);

        return result;
    }
}
