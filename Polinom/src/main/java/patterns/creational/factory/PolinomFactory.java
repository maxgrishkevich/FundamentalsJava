package patterns.creational.factory;

import model.Polinom;
import model.interfaces.Polinomable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class PolinomFactory implements Factory{
    @Override
    public Polinomable createPolinom(){
        return new Polinom();
    }
}
