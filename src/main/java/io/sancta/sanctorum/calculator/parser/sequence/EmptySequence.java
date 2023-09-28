package io.sancta.sanctorum.calculator.parser.sequence;

public class EmptySequence extends Sequence {

    @Override
    protected Object collect(Object[] results) {
        return new Object();
    }
}
