package calculator.parser.alternative;

import calculator.parser.sequence.ParametersSequence;

public class ParametersAlternative extends Alternative {

    public ParametersAlternative(RootAlternative root) {
        getAlternatives().add(new ParametersSequence(root, this));
        getAlternatives().add(root);
    }
}
