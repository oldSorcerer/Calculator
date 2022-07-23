package calculator.parser;

import java.util.ArrayList;

public abstract class Sequence extends ParseRule {

    private ArrayList<ParseRule> members = new ArrayList<>(); // звенья последовательности

    public ArrayList<ParseRule> getMembers() {
        return members;
    }

    @Override
    protected Object applySpecial(Parser p){

        Object results[] = new Object[members.size()];
        for (int i = 0; i < results.length; i++ ) {
            results [i] = members.get(i).apply(p);
            if (results[i] == null)
                return null;
        }
       return collect(results);
    }

    protected abstract Object collect (Object results[]);
}
