package calculator.lexer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Lexeme {

    private final String text;
    private final LexemeType type;
    private final int position;

}
