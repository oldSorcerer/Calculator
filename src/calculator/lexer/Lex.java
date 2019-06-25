package calculator.lexer;

public class Lex {

    private String text;
    private LexType type;

    public Lex(String text, LexType type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    /*public void setText(String text) {
        this.text = text;
    }*/

    public LexType getType() {
        return type;
    }
/*
    public void setType(LexType type) {
        this.type = type;
    }*/
}
