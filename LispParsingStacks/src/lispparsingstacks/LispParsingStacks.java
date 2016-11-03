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
    public ArrayList<Integer> operands = new ArrayList<>();
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
        newStack.LoadEquation(lispString2);
        newStack.LoadEquation(lispString3);
        newStack.LoadEquation(lispString4);
    

    
    }
    public void LoadEquation(String str){
        int len = str.length();
       String[] newString = new String[len];
       for(int i = 0; i < len; i++){
           newString[i] = String.valueOf(str.charAt(i));
       }
        parseLispString(newString); 
    
    }
    public void parseLispString(String[] lisp) {
        for(int i = 0; i < lisp.length-1; i++){
            //System.out.println(lisp[i]);
        }
     //   boolean isDigit = false;
       // String[] lisp1 = lisp;
         boolean validForm = checkForValidForm(lisp);
        if(validForm = false){
            System.out.println("Invalid form of equation.");
        }
        if(validForm = true){//  while(validForm){
                op = operator.NONE;
                boolean result = false;
                boolean result2 = false;
                boolean result3 = false;
                boolean haveOperator = false;
            for(int i = 0; i < lisp.length-1;i++){
                //String str = lisp1[i];
                result = isDigit(lisp[i]);
                result2 = isDigit(lisp[i+1]);
                result3 = isParenthesis(lisp[i]);
            //    if(result = false){
             //      i--;
              //  }
              //  if(result2 = false){System.out.println("");}
               if(result != true || result2 != true){
                   // lispParser.push(lisp[i]);
                   //System.out.println("P");
                    
                }
                
                
                   if(result && result2){
                    String newString = "";
                    newString += lisp[i];
                    //System.out.println(newString);
                    newString += lisp[i+1];
                    //System.out.println("2nd " +newString);
                    lispParser.push(newString);
                    printStack(lispParser);
                    i++;
                    
                }
                else if(result = true && result2 != true){
                    lispParser.push(lisp[i]);
                    //printStack(lispParser);
                }
                
            
            
        
                if("+".equals(lisp[i])){
                    //System.out.println("Add");
                    op = operator.ADD;
                    haveOperator = true;
                }
                else if("-".equals(lisp[i])){
                     //System.out.println("Subtract");
                    op = operator.SUBTRACT;
                    haveOperator = true;
                }
                else if("/".equals(lisp[i])){
                     //System.out.println("Divide");
                    op = operator.DIVIDE;
                    haveOperator = true;
                }
                else if("*".equals(lisp[i])){
                     //System.out.println("Multipy");
                    op = operator.MULTIPLY;
                    haveOperator = true;
                }
            
            }
           
            evaluateStack(op, haveOperator);
        }
    }
    private static void printStack(Stack<String> s){
		if(s.isEmpty()){
			//System.out.println("You have nothing in your stack");
		}
		else{
			//System.out.printf("%s Top\n ", s);
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
    public void evaluateStack(operator o, boolean result){
        int rightOperand, secondOperand, thirdOperand,newResult;
        int outCome = 0;
        /*for(String s : lispParser) {
            System.out.println(s);
        }*/
        //String s = lispParser.pop();
        //rightOperand = Integer.parseInt(s);
        //s = "";
        //System.out.println(rightOperand);
       // s = lispParser.pop();
        //secondOperand = Integer.parseInt(s);
        //System.out.println(secondOperand);
        //s = lispParser.pop();
        //thirdOperand = Integer.parseInt(s);
        //System.out.println(thirdOperand);
        if(o== operator.ADD){
            //System.out.println(lispParser);
            for(String st : lispParser) {
                if(st.equals("(")) {
                    //System.out.println("Wow I'm dumb");
                }
                else {
                    String temp = st;
                    //System.out.println("'" + temp + "'");
                    int tempInt = Integer.parseInt(st);
                    outCome += tempInt;
                }
                //lispParser.pop();
                //String s = lispParser.pop();
            }
            System.out.println(outCome);
        }else if(o== operator.SUBTRACT){
            //System.out.println(lispParser);
            int i = 0;
            for(String st2 : lispParser) {
                i++;
                if(st2.equals("(")) {
                    //System.out.println("Wow I'm dumb");
                }
                else {
                    if(i == 2 && !st2.equals("(")) {
                        String temp2 = st2;
                        int tempInt2 = Integer.parseInt(temp2);
                        outCome = tempInt2;
                    }
                    else {
                        String temp2 = st2;
                        //System.out.println("'" + temp2 + "'");
                        int tempInt2 = Integer.parseInt(temp2);
                        outCome -= tempInt2;
                        //System.out.println(outCome);
                        //System.out.println("it worked eureka!");
                    }
                }
            }
            System.out.println(outCome);
        }
        else if(o== operator.MULTIPLY){
            //System.out.println(lispParser);
            int i = 0;
            for(String st2 : lispParser) {
                i++;
                if(st2.equals("(")) {
                    //System.out.println("Wow I'm dumb");
                }
                else {
                    if(i == 2 && !st2.equals("(")) {
                        String temp2 = st2;
                        int tempInt2 = Integer.parseInt(temp2);
                        outCome = tempInt2;
                    }
                    else {
                        String temp2 = st2;
                        //System.out.println("'" + temp2 + "'");
                        int tempInt2 = Integer.parseInt(temp2);
                        outCome *= tempInt2;
                        //System.out.println(outCome);
                        //System.out.println("it worked eureka!");
                    }
                }
            }
            System.out.println(outCome);
        }
        else if(o== operator.DIVIDE){
            //System.out.println(lispParser);
            double doubleOutcome = 0;
            int i = 0;
            for(String st2 : lispParser) {
                i++;
                if(st2.equals("(")) {
                    //System.out.println("Wow I'm dumb");
                }
                else {
                    if(i == 2 && !st2.equals("(")) {
                        String temp2 = st2;
                        double tempDub = Double.parseDouble(temp2);
                        doubleOutcome = tempDub;
                    }
                    else {
                        String temp2 = st2;
                        //System.out.println("'" + temp2 + "'");
                        double tempDub = Double.parseDouble(temp2);
                        doubleOutcome /= tempDub;
                        //System.out.println("it worked eureka!");
                    }
                }
            }
            System.out.println(doubleOutcome);
        }
        lispParser.clear();
        
        outCome = 0;
        printStack(lispParser);
        
      
    }
    

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
    
    public static boolean isDigit(String str){
        if(")".equals(str) || "(".equals(str)){
            return false;
        }
        boolean isDigit = false;
         try{
             Integer.parseInt(str);
             isDigit = true;
             return isDigit;
         }catch (Exception  e){
          //str is not a int
         }
         return isDigit;
    }
    public static boolean isParenthesis(String s){
       boolean result = false;
       if(s == ""){
           result = true;
          
       }
       else{
           result = false;
       }
       return result;
    }
 
}
//((15+2) (5+2))
//if inside parenthesis carry out the operator which is inside the parenthesis
// stop once you reach the closing parenthis then push the result on the stack