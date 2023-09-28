package io.sancta.sanctorum.calculator.parser.alternative;

import io.sancta.sanctorum.calculator.parser.sequence.ParametersSequence;

public class ParametersAlternative extends Alternative {

    public ParametersAlternative(RootAlternative root) {
//        getAlternatives().add(new BooleanSequence(root)); // if(a > b)
        getAlternatives().add(new ParametersSequence(root, this));
        getAlternatives().add(root);
    }
}