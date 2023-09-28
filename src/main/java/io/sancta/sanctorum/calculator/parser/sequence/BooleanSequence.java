package io.sancta.sanctorum.calculator.parser.sequence;

import io.sancta.sanctorum.calculator.dom.BooleanExpression;
import io.sancta.sanctorum.calculator.dom.BooleanOperator;
import io.sancta.sanctorum.calculator.dom.Expression;
import io.sancta.sanctorum.calculator.parser.alternative.RootAlternative;
import io.sancta.sanctorum.calculator.lexer.Lexeme;
import io.sancta.sanctorum.calculator.lexer.LexemeType;
import io.sancta.sanctorum.calculator.parser.terminal.Terminal;

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
