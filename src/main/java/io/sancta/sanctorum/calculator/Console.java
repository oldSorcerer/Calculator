package io.sancta.sanctorum.calculator;

import io.sancta.sanctorum.calculator.lexer.Lexer;
import io.sancta.sanctorum.calculator.dom.processing.CalculateExpressionVisitor;
import io.sancta.sanctorum.calculator.parser.Parser;
import io.sancta.sanctorum.calculator.parser.ParserException;

import java.io.*;

public class Console {
    public static void main(String[] args) throws IOException {
        String text = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите выражения:");
            double x = 0;
            Parser p = new Parser(Lexer.run(text = reader.readLine()));
            if (text.contains("x")) {
                System.out.println("Введите x:");
                x = Double.parseDouble(reader.readLine());
            }
            System.out.println(p.parse().accept(new CalculateExpressionVisitor(x)));
        } catch (ParserException exception) {
            System.out.println(exception + "");
            for (int position : exception.getPosition())
                System.out.println(text.charAt(position));
        }
    }
}