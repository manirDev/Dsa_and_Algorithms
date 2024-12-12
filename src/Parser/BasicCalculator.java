package Parser;

import java.util.ArrayList;
import java.util.List;

enum TokenType{
    NUMBER,
    BINARY_OPERATOR,
}
class Token{
    public final String value;
    public final TokenType tokenType;
    public Token(String value, TokenType tokenType){
        this.value = value;
        this.tokenType = tokenType;
    }
}

class Lexer{
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    public Lexer(String source){
        this.source = source;
    }

    public List<Token> tokenize(){
        char[] sourceCode = source.toCharArray();
        int index = 0;
        while(index < sourceCode.length){
            char currChar = sourceCode[index];
            if(currChar == '-' || currChar == '+' || currChar == '*' || currChar == '/'){
                pushToken(String.valueOf(currChar), TokenType.BINARY_OPERATOR);
                index++;
            }
            else if(isDigit(currChar)){
                StringBuilder number = new StringBuilder();
                while(index < sourceCode.length && isDigit(sourceCode[index])){
                    number.append(sourceCode[index]);
                    index++;
                }
                pushToken(number.toString(), TokenType.NUMBER);
            }
            else{
                //white space is ignored.
                index++;
            }
        }
        return tokens;
    }
    private boolean isDigit(char currenChar){
        return (currenChar >= '0' && currenChar <= '9');
    }
    private void pushToken(String value, TokenType tokenType) {
        tokens.add(new Token(value, tokenType));
    }
}

//node in the AST(abstract syntax tree)
abstract class Node{
    public abstract int evaluate();
}

class NumberNode extends Node{
    private final int value;
    public NumberNode(int value){
        this.value = value;
    }

    @Override
    public int evaluate(){
        return value;
    }
}

class BinaryOperatorNode extends Node{
    private final Node left;
    private final Token operator;
    private final Node right;
    public BinaryOperatorNode(Node left, Token operator, Node right){
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public int evaluate(){
        int leftValue = left.evaluate();
        int rightValue = right.evaluate();

        int result;
        switch (operator.value) {
            case "+":
                result = leftValue + rightValue;
                break;
            case "-":
                result = leftValue - rightValue;
                break;
            case "*":
                result = leftValue * rightValue;
                break;
            case "/":
                result = leftValue / rightValue;
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator.value);
        }
        return result;
    }
}

class Parser{
    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Node parse() {
        return parseExpression();
    }

    private Node parseExpression() {
        Node node = parseTerm();

        while (match("+", "-")) {
            Token operator = previous();
            Node right = parseTerm();
            node = new BinaryOperatorNode(node, operator, right);
        }

        return node;
    }

    private Node parseTerm() {
        Node node = parseFactor();

        while (match("*", "/")) {
            Token operator = previous();
            Node right = parseFactor();
            node = new BinaryOperatorNode(node, operator, right);
        }

        return node;
    }

    private Node parseFactor() {
        if (match(TokenType.NUMBER)) {
            return new NumberNode(Integer.parseInt(previous().value));
        }

        throw new IllegalArgumentException("Unexpected token: " + peek());
    }

    private boolean match(String... operators) {
        if (isAtEnd()) return false;
        for (String op : operators) {
            if (peek().value.equals(op)) {
                advance();
                return true;
            }
        }
        return false;
    }

    private boolean match(TokenType type) {
        if (isAtEnd()) return false;
        if (peek().tokenType == type) {
            advance();
            return true;
        }
        return false;
    }

    private Token advance() {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd() {
        return current >= tokens.size();
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }
}

class BasicCalculator {
    public int calculate(String s) {
        Lexer scanner = new Lexer(s);
        List<Token> tokens = scanner.tokenize();
        Parser parser = new Parser(tokens);
        Node syntaxTree = parser.parse();
        int res = syntaxTree.evaluate();
        return res;
    }
}
