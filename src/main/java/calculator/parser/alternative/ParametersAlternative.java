package calculator.parser.alternative;

import calculator.parser.sequence.BooleanSequence;
import calculator.parser.sequence.ParametersSequence;

public class ParametersAlternative extends Alternative {

    public ParametersAlternative(RootAlternative root) {
//        getAlternatives().add(new BooleanSequence(root)); // if(a > b)
        getAlternatives().add(new ParametersSequence(root, this));
        getAlternatives().add(root);
    }
}