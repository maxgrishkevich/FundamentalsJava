package patterns.structural.decorator;

public class SimplePolinom extends PolinomDecorator {
    public SimplePolinom(PolinomResult polinom) {
        super(polinom);
    }

    public String printPolinom() {
        return polinom.toString();
    }

    @Override
    public String getSpecialInfo() {
        return super.getSpecialInfo() + "\n" + printPolinom();
    }
}
