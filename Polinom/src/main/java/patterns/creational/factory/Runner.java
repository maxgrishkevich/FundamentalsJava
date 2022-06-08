package patterns.creational.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Factory polf = context.getBean("polinomFactory", PolinomFactory.class);
        Factory ratf = context.getBean("rationalFactory", RationalPolinomFactory.class);
        double pol = polf.createPolinom().getResult();
        double rat = ratf.createPolinom().getResult();
        System.out.println("Polinom: " + pol);
        System.out.println("Rational polinom: " + rat);
    }

}
