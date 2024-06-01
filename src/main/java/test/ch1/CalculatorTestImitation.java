package test.ch1;

public class CalculatorTestImitation {
    private int nbErrors=0;

    public void testAdd(){
        Calculator calculator=new Calculator();
        double result=calculator.add(10,50);
        if (result!=60){
            throw new IllegalStateException("Плохой результат: "+result);
        }
    }

    public int getNbErrors() {
        return nbErrors++;
    }
}
