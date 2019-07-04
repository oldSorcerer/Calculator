package calculator.parser;

public class RootAlternative extends Alternative {
    public RootAlternative(boolean isLeft){
        if(!isLeft)
            getAlternatives().add(new BinarySequence(this));
        getAlternatives().add(new DoubleSequence());
        getAlternatives().add(new IntegerTerminal());
        getAlternatives().add(new BracketSequence(this));
    }
}
