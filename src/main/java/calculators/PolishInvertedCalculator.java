package calculators;

import TDAs.Stack;

public class PolishInvertedCalculator extends Calculator{
    //----- ATRIBUTOS -----
    private Stack digits;

    //----- CONSTRUCTOR -----
    public PolishInvertedCalculator(){
        this.digits = new Stack();
    }

    //----- METODOS -----
    public void append(int digit){
        this.digits.push(digit);
    }

    public void append(char operator){
        switch (operator){
            case '+':
                digits.push(super.add(digits.pop(), digits.pop()));
                break;
            case '-':
                digits.push(super.subtraction(digits.pop(), digits.pop()));
                break;
            case '*':
                digits.push(super.multiplication(digits.pop(), digits.pop()));
                break;
            case '/':
                digits.push(super.division(digits.pop(), digits.pop()));
                break;
        }
    }

    public int resolve(String expression){
        String[] array= expression.split(" ");
        for (int i=0 ; i < array.length ; i++){
            String aux = array[i];
            if(aux.matches("\\d*")){
                System.out.println("numero");
                append(Integer.parseInt(aux));
            }else{
                System.out.println("signo");
                append(aux.charAt(0));
            }
        }
        return digits.top();
    }
}
