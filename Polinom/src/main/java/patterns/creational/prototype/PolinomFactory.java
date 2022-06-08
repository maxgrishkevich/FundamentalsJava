package patterns.creational.prototype;

import model.Polinom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PolinomFactory {
    Polinom polinom;

    public PolinomFactory(Polinom polinom) {
        this.polinom = polinom;
    }

    public void setPolinom(Polinom polinom) {
        this.polinom = polinom;
    }

    Polinom clonePolinom(){
        return (Polinom) polinom.copy();
    }
}
