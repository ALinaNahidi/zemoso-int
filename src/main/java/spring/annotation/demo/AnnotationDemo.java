package spring.annotation.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class AnnotationDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext");

        Coach coach = context.getBean("tennisCoach",Coach.class);

        log.info(coach.getDailyWorkout());
        log.info(coach.getDailyFortune());

        ((ConfigurableApplicationContext)context).close();
    }
}
