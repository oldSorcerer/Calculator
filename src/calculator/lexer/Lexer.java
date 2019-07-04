package calculator.lexer;

import java.util.*;

import calculator.dom.*;

public class Lexer {

    private static LexRule rules [] = new LexRule[]
    {
        new LexRule() {
            @Override
            public LexType getType() {
                return LexType.Digits;
            }

            @Override
            public int getSymbolCount(String text) {
                int i = 0;

                while (i < text.length() && Character.isDigit( text.charAt(i)))
                    i++;

                return i;
            }
        },
        new LexRule() {
            @Override
            public LexType getType() {
                return LexType.Dot;
            }

            @Override
            public int getSymbolCount(String text) {
                if (text.charAt(0) == '.')
                    return 1;
                else return 0;
            }
        },
        new LexRule() {
            @Override
            public LexType getType() {
                return LexType.Space;
            }

            @Override
            public int getSymbolCount(String text) {
                int i = 0;

                while (i < text.length() && Character.isSpaceChar(text.charAt(i)))
                    i++;

                return i;
            }
        },
        new LexRule() {
            @Override
            public LexType getType() {
                return LexType.Operator;
            }

            @Override
            public int getSymbolCount(String text) {
                if (BinaryOperator.fromChar(text.charAt(0)) != null )
                    return 1;
                else return 0;
            }
        },
        new LexRule() {
            @Override
            public LexType getType() {
                return LexType.OpenBracket;
            }

            @Override
            public int getSymbolCount(String text) {
                if (text.charAt(0) == '(')
                    return 1;
                else return 0;
            }
        },
        new LexRule() {
                @Override
                public LexType getType() {
                    return LexType.CloseBracket;
                }

                @Override
                public int getSymbolCount(String text) {
                    if (text.charAt(0) == ')')
                        return 1;
                    else return 0;
                }
            },
        new LexRule() {
            @Override
            public LexType getType() {
                return LexType.Error;
            }

            @Override
            public int getSymbolCount(String text) {
                return 1;
            }
        }
    };

    public static List<Lex> run(String text){
        List<Lex> lexes = new ArrayList<>();

        while (text.length() > 0){
            for (LexRule rule : rules){
                int length = rule.getSymbolCount(text);

                if (length > 0){
                    lexes.add(new Lex(text.substring(0, length), rule.getType()));
                    text = text.substring(length);
                    break;
                }
            }
        }

        return lexes;
    }
}
