package calculator.lexer;

public interface LexemeRule {

    LexemeType getType();

    int getSymbolCount(String text);
}
