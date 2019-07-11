package calculator.parser;

public class EmptySequence extends Sequence {

    @Override
    protected Object collect(Object[] results) {
        return new Object();
    }
}
