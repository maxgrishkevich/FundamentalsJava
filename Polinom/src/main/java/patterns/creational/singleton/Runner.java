package patterns.creational.singleton;

import model.Polinom;
import model.RationalPolinom;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import printing.Formalization;

public class Runner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");
        PolinomsSum sum = context.getBean("polinomSum", PolinomsSum.class);

        Polinom polinom1 = context.getBean("polinomConstr", Polinom.class);
        System.out.println(polinom1);
        sum.addPolinomResult(polinom1);

        Polinom polinom2 = context.getBean("polinomConstrPar", Polinom.class);
        System.out.println(polinom2);
        sum.addPolinomResult(polinom2);

        RationalPolinom polinom3 = context.getBean("rationalPolinomConstr", RationalPolinom.class);
        System.out.println(polinom3);
        sum.addPolinomResult(polinom3);

        Formalization.title("Result of adding few results");
        System.out.println(Formalization.result(sum.getSum()));
    }
}
