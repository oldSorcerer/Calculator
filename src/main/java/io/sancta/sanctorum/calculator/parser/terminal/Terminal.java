package io.sancta.sanctorum.calculator.parser.terminal;

import io.sancta.sanctorum.calculator.lexer.Lexeme;
import io.sancta.sanctorum.calculator.lexer.LexemeType;
import io.sancta.sanctorum.calculator.parser.ParseRule;
import io.sancta.sanctorum.calculator.parser.Parser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Terminal extends ParseRule {

    private final LexemeType lexType;

    @Override
    protected Object applySpecial(Parser parser) {
        if (parser.getLexemes().get(parser.getRecognized()).getType() == lexType) {
            Lexeme lexeme = parser.getLexemes().get(parser.getRecognized());
            parser.setRecognized(parser.getRecognized() + 1);
            return lexeme;
        }
        return  null;
    }
}
//      return parser.getLexemes().get(parser.recognized).getType() == lexType ? parser.getLexemes().get(parser.recognized++) : null;
