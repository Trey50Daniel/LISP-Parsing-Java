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
        boolean validForm = checkForValidForm(lisp);
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
                    haveOperator = true;
                    op = operator.ADD;
                    evaluateStack(op,haveOperator);
                    break;
                case '-':
                    haveOperator = true;
                    op = operator.SUBTRACT;
                    evaluateStack(op, haveOperator);
                    break;
                case '*':
                    haveOperator = true;
                    op = operator.MULTIPLY;
                    evaluateStack(op,haveOperator);
                    break;
                case '/':
                    op = operator.DIVIDE;
                    evaluateStack(op,haveOperator);
                    haveOperator = true;
                    break;
                case ')':
                    evaluateStack(op,inParenthes);
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
    //check operator and carryout operation 
    public double evaluateStack(operator o, boolean result){
        double rightOperand, leftOperand, newResult;
        
        rightOperand = Double.parseDouble(Character.toString((char) lispParser.pop()));
        leftOperand = (int)lispParser.pop();
        if(result = true){
            if(o == operator.ADD){
               newResult = rightOperand + leftOperand;
            }else if(o == operator.SUBTRACT){
              newResult = rightOperand - leftOperand;
            }else if(o == operator.MULTIPLY){
              newResult = rightOperand * leftOperand;
            }else if(o == operator.DIVIDE){
              newResult = rightOperand / leftOperand;
            }else {
                return 0;
            }
        }
        return 0;
    }

//ask for the fuction
// loop through the function
// get operators {+, -, /, *}
// loop through the array add only the operands to the stack
// get operator function
// push the operands on to the stack
// execute the appropiate operation 
    
    public boolean checkForValidForm(String str){
        boolean haveParenthesis = false;
        int countOpenParenthesis = 0;
        int countCloseParenthesis = 0;
        
        for(int i = 0; i < str.length(); i++){
             if(str.charAt(i)== ')' || str.charAt(i) == '('){
                 haveParenthesis = true;
             }
             if(str.charAt(i)== ')'){
                 countCloseParenthesis ++;
             }
             else if(){
        }
    }
    

}


