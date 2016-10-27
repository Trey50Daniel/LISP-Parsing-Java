/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lispparsingstacks;

import java.util.Stack;

/**
 *
 * @author tagg8
 */
public class LispParsingStacks {
    public enum operator {MULTIPLY, DIVIDE, ADD, SUBTRACT, NONE };
    boolean haveOperator = false;
    boolean inParenthes = false;
    public Stack lispParser = new Stack();
    boolean opDouble = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String lispString = "(+15 2 3)";
        String lispString2 = "(-15 2 3)";
        String lispString3 = "(*15 2 3)";
        String lispString4 = "(/15 2 3)";
        
        
        LispParsingStacks newStack = new LispParsingStacks();
        newStack.parseLispString(lispString);
        newStack.parseLispString(lispString2);
        newStack.parseLispString(lispString3);
        newStack.parseLispString(lispString4);
    }
    
    public void parseLispString(String lisp) {
        operator op = operator.NONE;
        for(int i = 0; i < lisp.length(); i++) {
            boolean stringInt = isStringInt(Character.toString(lisp.charAt(i)));
            if(stringInt || lisp.charAt(i) != ' ') {
                if(lisp.charAt(i) == ' ') {
                    continue;
                }
                else {
                    if(inParenthes){
                       lispParser.push(lisp.charAt(i));
                    }
                }
            }
            switch(lisp.charAt(i)) {
                case '.':
                    opDouble = true;
                    break;
                case '(':
                    inParenthes = true;
                    break;
                case '+':
                    op = operator.ADD;
                    haveOperator = true;
                    break;
                case '-':
                    op = operator.SUBTRACT;
                    haveOperator = true;
                    break;
                case '*':
                    op = operator.MULTIPLY;
                    haveOperator = true;
                    break;
                case '/':
                    op = operator.DIVIDE;
                    haveOperator = true;
                    break;
                case ')':
                    evaluateStack(op);
                    op = operator.NONE;
                    inParenthes = false;
                    break;
                default:
                    break; 
            }
        }
    }
    
    public boolean isStringInt(String s){
    try{
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException ex){
        return false;
    }
}
    public void evaluateStack(operator o){
        
    
    }
    
}
