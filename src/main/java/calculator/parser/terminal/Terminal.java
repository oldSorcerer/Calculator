package calculator.parser.terminal;

import calculator.lexer.Lexeme;
import calculator.lexer.LexemeType;
import calculator.parser.ParseRule;
import calculator.parser.Parser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Terminal extends ParseRule {

    private final LexemeType lexType;

    @Override
    protected Object applySpecial(Parser parser) {
        if (parser.getRecognized() >= parser.getLexemes().size()) return null;

        if (parser.getLexemes().get(parser.getRecognized()).getType() == lexType) {
            Lexeme lexeme = parser.getLexemes().get(parser.getRecognized());
            parser.setRecognized(parser.getRecognized() + 1);
            return lexeme;
        }
        return  null;

//      return parser.getLexemes().get(parser.recognized).getType() == lexType ? parser.getLexemes().get(parser.recognized++) : null;

    }
}
