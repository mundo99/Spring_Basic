package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefullServiceTest {
    @Test
    void statefullServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefullService statefullService1 = ac.getBean(StatefullService.class);
        StatefullService statefullService2 = ac.getBean(StatefullService.class);

        //ThreadA: A사용자가 10000원 주문
        int userAprice = statefullService1.order("userA",10000);
        //ThreadB: B사용자가 20000원 주문
        int userBprice = statefullService2.order("userB",20000);
        
        //ThreadA: 사용자A 주문 금액 조회
        //int price = statefullService1.getPrice();
        System.out.println("price = " + userAprice);

       // Assertions.assertThat(statefullService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefullService statefullService(){
            return new StatefullService();
        }
    }

}