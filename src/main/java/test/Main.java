package test;


import test.ch1.CalculatorTestImitation;

public class Main {
    public static void main(String[] args) {
        CalculatorTestImitation test=new CalculatorTestImitation();
        try{
            test.testAdd();
        }catch (Throwable e){
            test.getNbErrors();
            e.printStackTrace();
        }
         if (test.getNbErrors()>0){
             throw new IllegalStateException("Было "+test.getNbErrors()+" ошибка(и)");
         }
    }
}
