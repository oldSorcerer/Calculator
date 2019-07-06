package calculator.parser;

import calculator.dom.XExpression;
import calculator.lexer.LexType;

public class XTerminal extends Terminal {

    public XTerminal(){
        super(LexType.X);
    }
    @Override
    protected Object applySpecial(Parser p){
        return super.applySpecial(p) == null ? null: new XExpression();
    }
}
