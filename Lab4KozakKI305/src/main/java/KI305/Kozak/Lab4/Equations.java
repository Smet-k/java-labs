package KI305.Kozak.Lab4;

/**
 * 
 */
class CalcException extends ArithmeticException {
    public CalcException() {}

    public CalcException(String e) {
        super(e);
    }
}

/**
 * 
 */
public class Equations {
    /**
     * 
     * @param rad
     * @return
     */
    private double cot(double rad){
        return 1.0 / Math.tan(rad);
    }
    /**
     * 
     * @param x
     * @return
     * @throws CalcException
     */
    public double calculate(int x) throws CalcException{
        double y, rad;
        rad = x * Math.PI / 180.0;

        try{
            if(x == 90 || x == -90 || x % 180 == 0)
                throw new ArithmeticException();
                
            y = Math.tan(rad)/cot(rad);

            if(Double.isNaN(y) || Double.isInfinite(y))
                throw new ArithmeticException();
        }catch(ArithmeticException ex){
            if(Math.abs(rad)==Math.PI/2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else if(Math.abs(rad % Math.PI) == 0.0)
                throw new CalcException("Exception reason: Illegal value of X for cotangent calculation");
            else if(x == 0)
                throw new CalcException("Exception reason: X = 0");
            else
                throw new CalcException("Unknown exception reason");
        }   

        return y;
    }
}
