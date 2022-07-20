package atm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {
    @Bean // tells Spring that this is an object
    public DataSource dataSource() {
        return new DataSourceFile("customers.txt");
    }

    @Bean
    public Bank bank() {
        return new Bank("My Bank", dataSource());
    }
    @Bean
    public ATM atm() {
        return new ATM(bank());
    }
    @Bean
    public AtmUI atmui(){
        return new AtmUI(atm());
    }

}