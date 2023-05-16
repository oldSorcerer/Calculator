package calculator.lexer;

import java.util.*;

import calculator.dom.*;

public class Lexer {

    private static final LexemeRule[] rules = new LexemeRule[]
            {
                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.Digits;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            int i = 0;

                            while (i < text.length() && Character.isDigit(text.charAt(i)))
                                i++;

                            return i;
                        }
                    },
                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.Dot;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            if (text.charAt(0) == '.')
                                return 1;
                            else return 0;
                        }
                    },
                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.Space;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            int i = 0;

                            while (i < text.length() && Character.isSpaceChar(text.charAt(i)))
                                i++;

                            return i;
                        }
                    },
                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.Operator;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            return BinaryOperator.fromChar(text.charAt(0)) != null ? 1 : 0;
                        }
                    },
                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.CompareOperator;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            return BooleanOperator.fromChar(text.charAt(0)) != null ? 1 : 0;
                        }
                    },
                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.OpenBracket;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            if (text.charAt(0) == '(')
                                return 1;
                            else return 0;
                        }
                    },
                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.CloseBracket;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            if (text.charAt(0) == ')')
                                return 1;
                            else return 0;
                        }
                    },

                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.X;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            if (text.charAt(0) == 'x' || text.charAt(0) == 'X')
                                return 1;
                            return 0;
                        }
                    },

                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.NameFunc;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            for (FunctionType fun : FunctionType.values())
                                if (text.startsWith(fun.toString().toLowerCase()))
                                    return fun.toString().length();
                            return 0;
                        }
                    },

                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.Comma;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            if (text.charAt(0) == ',')
                                return 1;
                            return 0;
                        }
                    },

                    new LexemeRule() {
                        @Override
                        public LexemeType getType() {
                            return LexemeType.Error;
                        }

                        @Override
                        public int getSymbolCount(String text) {
                            return 1;
                        }
                    }
            };

    public static List<Lexeme> run(String text) {
        List<Lexeme> lexes = new ArrayList<>();

        int position = 0;

        while (text.length() > 0) {
            for (LexemeRule rule : rules) {
                int length = rule.getSymbolCount(text);

                if (length > 0) {
                    lexes.add(new Lexeme(text.substring(0, length), rule.getType(), position));
                    text = text.substring(length);
                    position += length;
                    break;
                }
            }
        }
        return lexes;
    }
}
