package calculator.lexer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Lex {

    private final String text;
    private final LexType type;
    private final int position;

}
