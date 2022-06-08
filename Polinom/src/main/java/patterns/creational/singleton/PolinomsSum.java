package patterns.creational.singleton;

import model.Polinom;
import model.interfaces.Polinomable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("polinomSum")
public class PolinomsSum extends Polinom {
    private static PolinomsSum sum;
    private static double result;

    public static synchronized PolinomsSum getPolinomsSum(){
        if(sum == null){
            sum = new PolinomsSum();
        }
        return sum;
    }

//    private PolinomsSum(){}

    public void addPolinomResult(Polinomable polinom){
        result += polinom.getResult();
    }

    public double getSum(){
        return result;
    }
}
