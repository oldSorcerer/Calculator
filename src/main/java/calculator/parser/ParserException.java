package calculator.parser;

public class ParserException  extends Exception {

    private int[] position;

    public int [] getPosition() {
        return position;
    }

    public ParserException (String text, int[] position){
        super(text);
        this.position = position;
    }

}
