package calculator.parser.terminal;

import calculator.dom.expression.XExpression;
import calculator.lexer.LexType;
import calculator.parser.Parser;

public class XTerminal extends Terminal {

    public XTerminal(){
        super(LexType.X);
    }
    @Override
    protected Object applySpecial(Parser p){
        return super.applySpecial(p) == null ? null: new XExpression();
    }
}
