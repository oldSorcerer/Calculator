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
            getAlternatives().add(new BinarySequence(this));
        getAlternatives().add(new DoubleSequence());
        getAlternatives().add(new IntegerTerminal());
        getAlternatives().add(new XTerminal());
        getAlternatives().add(new BracketSequence(isLeft && root != null ? root : this));
        getAlternatives().add(new FunctionSequence(root != null ? root : this));
    }
}
