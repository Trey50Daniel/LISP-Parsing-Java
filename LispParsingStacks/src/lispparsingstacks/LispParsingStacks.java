/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lispparsingstacks;


import java.util.*;

/**
 *
 * @author tagg8
 */
public class LispParsingStacks {
    public enum operator {MULTIPLY, DIVIDE, ADD, SUBTRACT, NONE };
    boolean haveOperator = false;
    boolean inParenthes = false;
    Stack<String> lispParser = new Stack<String>();
    boolean opDouble = false;
    operator op;
   
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String lispString1 = "(+15 2 3)";
        String lispString2 = "(-15 2 3)";
        String lispString3 = "(*15 2 3)";
        String lispString4 = "(/15 2 3)";
        
        LispParsingStacks newStack = new LispParsingStacks();
        newStack.LoadEquation(lispString1);
    /**
        
        
        LispParsingStacks newStack = new LispParsingStacks();
        newStack.LoadEquation();
       // newStack.LoadEquation();
      //  newStack.LoadEquation();
      //  newStack.LoadEquation();        
    }*/

    /**
     * LispParsingStacks newStack = new LispParsingStacks();
        newStack.LoadEquation();
       // newStack.LoadEquation();
      //  newStack.LoadEquation();
      //  newStack.LoadEquation();        
    }
     
     * }     */
    }
    public void LoadEquation(String str){
        int len = str.length();
       String[] newString = new String[len];
       for(int i = 0; i < len; i++){
           newString[i] = String.valueOf(str.charAt(i));
       }
        parseLispString(newString);
     //   parseLispString(lispString2);
     //   parseLispString(lispString3);
     //   parseLispString(lispString4);  
    
    }
    public void parseLispString(String[] lisp) {
        boolean isDigit = false;
        String[] lisp1 = lisp;
         boolean validForm = checkForValidForm(lisp);
        if(validForm = false){
            System.out.println("Invalid form of equation.");
        }
        if(validForm = true){//  while(validForm){
                op = operator.NONE;
                boolean haveOperator = false;
            for(int i = lisp1.length-1; i >= 0; i--){
                String str = lisp1[i];
                boolean result = containsDigit(str);
                if(result = false){
                   continue;
                    
                }
                else if(result = true){
                    lispParser.push(lisp[i]);
                    printStack(lispParser);
                }
               
                if("+".equals(lisp[i])){
                    op = operator.ADD;
                    haveOperator = true;
                }
                else if("-".equals(lisp[i])){
                    op = operator.SUBTRACT;
                    haveOperator = true;
                }
                else if("/".equals(lisp[i])){
                    op = operator.DIVIDE;
                    haveOperator = true;
                }
                else if("*".equals(lisp[i])){
                    op = operator.MULTIPLY;
                    haveOperator = true;
                }
                
            }
            
       //     evaluateStack(op, haveOperator);
        }
       
        /*operator op = operator.NONE;
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
            
        }*/
    }
    private static void printStack(Stack<String> s){
		if(s.isEmpty()){
			System.out.println("You have nothing in your stack");
		}
		else{
			System.out.printf("%s Top\n ", s);
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
   /* public void evaluateStack(operator o, boolean result){
        int rightOperand, leftOperand, newResult;
        int outCome;
        
        rightOperand = Integer.parseInt(lispParser.pop());
        leftOperand = Integer.parseInt(lispParser.pop());
        if(result = true){
            if(o == operator.ADD){
                outCome = rightOperand + leftOperand;
               lispParser.push(String.valueOf(outCome));
            }else if(o == operator.SUBTRACT){
              newResult = rightOperand - leftOperand;
             
            }else if(o == operator.MULTIPLY){
              newResult = rightOperand * leftOperand;
              
            }else if(o == operator.DIVIDE){
              newResult = rightOperand / leftOperand;
             
            }else {
              operator op = operator.NONE;
            }
        }
        System.out.println(lispParser.peek());
      
    }*/
    

//ask for the fuction
// loop through the function
// get operators {+, -, /, *}
// loop through the array add only the operands to the stack
// get operator function
// push the operands on to the stack
// execute the appropiate operation 
    
    public boolean checkForValidForm(String[] str){
        boolean validForm = false;
        boolean haveParenthesis = false;
        int countOpenParenthesis = 0;
        int countCloseParenthesis = 0;
        //have a function running from here that checks if we have parethesis.
        for(int i = 0; i < str.length; i++){
             if(")".equals(str[i]) || ")".equals(str[i])){
                 haveParenthesis = true;
             }
             if(haveParenthesis && ")".equals(str[i])){
                 countCloseParenthesis++;
             }
             if(haveParenthesis && "(".equals(str[i])){
                 countOpenParenthesis++;
             }
        }
        if(countCloseParenthesis == countOpenParenthesis){
            validForm = true;
            return validForm;
        }
        else{
            return validForm;
        }
        
    }
    public static boolean containsDigit(String s) {
    if (s != null && !s.isEmpty()) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
    }
    return false;
}
    
    public boolean isDigit(String str){
        
        boolean isDigit = false;
         try{
             Integer.parseInt(str);
             isDigit = true;
             return isDigit;
         }catch (Exception  e){
          return isDigit;
         }
    }

}
