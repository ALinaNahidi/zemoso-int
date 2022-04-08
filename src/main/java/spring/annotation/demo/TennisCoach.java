package spring.annotation.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
@Slf4j
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;


    public TennisCoach(){
        log.info("Inside Constructor for fortune service");
    }



    @Override
    public String getDailyWorkout() {
        return "Practice tennis";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortuneService();
    }

    @PostConstruct
    public void methodPostConstruct(){
        log.info("Inside MethodPostConstruct");
    }

    @PreDestroy
    public void methodPreDestroy(){
        log.info("Inside MethodPreDestroy");
    }
}
