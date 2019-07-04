package calculator.parser;

public class RootAlternative extends Alternative {
    public RootAlternative(boolean isLeft){
        this(isLeft, null);
    }
    public RootAlternative(boolean isLeft, RootAlternative root){
        if(!isLeft)
            getAlternatives().add(new BinarySequence(this));
        getAlternatives().add(new DoubleSequence());
        getAlternatives().add(new IntegerTerminal());
        getAlternatives().add(new BracketSequence(isLeft && root != null ? root : this));
    }
}
