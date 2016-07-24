package Calc.model;

public class Calculator {
    private int id;
    private String inPut;
    private String outPut;



    private double eval(String str) {
        return new Object() {
            int pos = -1, ch;
    
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
    
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
    
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
    
    
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // suma
                    else if (eat('-')) x -= parseTerm(); // resta
                    else return x;
                }
            }
    
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplicacion
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
    
            double parseFactor() {
                if (eat('+')) return parseFactor(); // suma unaria
                if (eat('-')) return -parseFactor(); // resta unaria
    
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentesis
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numeros
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { 
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    x = parseFactor();
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
    
              
                return x;
            }
        }.parse();
    }
    public Calculator(){
        this.id = 0;
    }

    public Calculator(String inPut) {
        this.inPut = inPut.replace('$','+');
        this.outPut = String.valueOf(eval(this.inPut));
    } 

    public int getId() {
        return id;
    }

    public String getInPut() {
        return inPut;
    }
    public String getOutPut(){
        return outPut;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setInPut(String inPut) {
        this.inPut = inPut;
    }
    public void setOutPut(String outPut){
        this.outPut = outPut;
    }
}
