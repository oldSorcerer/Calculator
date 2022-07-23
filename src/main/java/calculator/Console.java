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
        String text = "";
        double x = 0;
        try {
            Parser p = new Parser(Lexer.run(text = reader.readLine()));
            if (text.contains("x")) {
                System.out.println("Введите x:");
                x = Double.parseDouble(reader.readLine());
            }
            System.out.println(p.parse().accept(new CalculateExpressionVisitor(x)));
        }
        catch (ParserException ex){
            System.out.println(ex);
            System.out.println("Incorrect symbols: ");
            for (int pos : ex.getPosition())
                System.out.println(text.charAt(pos));
        }
    }
}
