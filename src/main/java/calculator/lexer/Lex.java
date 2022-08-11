package calculator.lexer;

import lombok.Getter;

@Getter
public class Lex {

    private String text;
    private LexType type;
    private int position;

    public Lex(String text, LexType type, int position) {
        this.text = text;
        this.type = type;
        this.position = position;
    }
}
