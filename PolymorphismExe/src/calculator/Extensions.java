package calculator;

public class Extensions {
 private Extensions(){

 }
    public static  ExtendedInterpreter buildInterpreter(CalculationEngine engine){
        return new ExtendedInterpreter(engine);
    }
}
