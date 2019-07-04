package calculator;

import calculator.dom.CalculateExpressionVisitor;
import calculator.lexer.Lexer;
import calculator.parser.Parser;
import calculator.parser.ParserException;

import java.io.*;

public class Console {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите выражения:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Parser p = new Parser(Lexer.run(reader.readLine()));
            System.out.println(p.parse().accept(new CalculateExpressionVisitor()));

        }
        catch (ParserException ex){
            System.out.println(ex);
            System.out.println("Position: " + ex.getPosition());
        }
    }
}
