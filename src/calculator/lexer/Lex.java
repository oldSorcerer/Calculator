package calculator.lexer;

public class Lex {

    private String text;
    private LexType type;
    private int position;

    public Lex(String text, LexType type, int position) {
        this.text = text;
        this.type = type;
        this.position = position;
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

    public int getPosition(){
        return position;
    }
}
