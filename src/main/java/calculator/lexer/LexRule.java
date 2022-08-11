package calculator.lexer;

public interface LexRule {

    LexType getType();

    int getSymbolCount(String text);
}
