package patterns.creational.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public PolinomFactory polinomFactory(){
        return new PolinomFactory();
    }
    @Bean
    public RationalPolinomFactory rationalFactory(){
        return new RationalPolinomFactory();
    }
}
