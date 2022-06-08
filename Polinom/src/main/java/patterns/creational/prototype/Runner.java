package patterns.creational.prototype;

import model.Polinom;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import printing.Formalization;

public class Runner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

        Polinom polinom = context.getBean("polinomConstr", Polinom.class);
        Formalization.title("Creating polinom");
        System.out.println(polinom);

        PolinomFactory factory = context.getBean("polFac", PolinomFactory.class);
        Polinom polinomClone = factory.clonePolinom();
        Formalization.title("Cloning polinom");
        System.out.println(polinomClone);
    }
}
