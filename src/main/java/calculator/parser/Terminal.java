package calculator.parser;

import calculator.lexer.LexType;

public class Terminal extends ParseRule{

    private LexType lexType;

    public Terminal (LexType lexType){
        this.lexType = lexType;
    }

    @Override
    protected Object applySpecial(Parser p) {
        if (p.recognized >= p.size())
            return null;
        return p.get(p.recognized).getType()==lexType ? p.get(p.recognized++): null;
    }
}
