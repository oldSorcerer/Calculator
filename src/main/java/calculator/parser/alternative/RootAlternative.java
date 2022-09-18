package calculator.parser.alternative;

import calculator.parser.terminal.IntegerTerminal;
import calculator.parser.terminal.XTerminal;
import calculator.parser.sequence.*;

public class RootAlternative extends Alternative {

    public RootAlternative(boolean isLeft) {
        this(isLeft, null);
    }

    public RootAlternative(boolean isLeft, RootAlternative root) {
        if (!isLeft)
            getAlternatives().add(new BinarySequence(this)); // a + c
        getAlternatives().add(new DoubleSequence()); //3.14
        getAlternatives().add(new IntegerTerminal()); //55444
        getAlternatives().add(new XTerminal()); // x
        getAlternatives().add(new BracketSequence(isLeft && root != null ? root : this)); // ( что-то )
        getAlternatives().add(new FunctionSequence(root != null ? root : this)); // sin()
    }
}
