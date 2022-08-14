package calculator.parser;

import lombok.Getter;

@Getter
public class ParserException  extends Exception {

    private final int[] position;

    public ParserException (String text, int[] position){
        super(text);
        this.position = position;
    }
}
