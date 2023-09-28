# Calculator

План:
dom
1. Объетная модель (О.М.) (extends Expression 0)
2. Вычисление О.М. (CalculateExpressionVisitor)
3. Преоброзование О.М. в текст (StringExpressionVisitor)

4. Лексер текст -> Lex[]
5. Парсер Lex[] -> О.М.
6. Обработка ошибок 
7. Поддержка Х
8. Поддержка мат. функций

9. Тернарный оператор - в процессе (? :)
10. Графики  - в процессе
    
*  text -> lexer -> Lexeme -> parser -> dom -> результат

* добавить возведение в степень (^), min max