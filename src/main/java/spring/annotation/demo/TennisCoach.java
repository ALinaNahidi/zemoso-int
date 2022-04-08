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

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    public TennisCoach(){
        log.info("Inside Constructor for fortune service");
    }

//    @Autowired
//    public void getFortuneService(FortuneService fortuneService){
//        log.info("Inside Setter for fortune service");
//        this.fortuneService=fortuneService;
//    }


    @Override
    public String getDailyWorkout() {
        return "Practice tennis";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortuneService();
    }

    @PostConstruct
    public void MethodPostConstruct(){
        log.info("Inside MethodPostConstruct");
    }

    @PreDestroy
    public void MethodPreDestroy(){
        log.info("Inside MethodPreDestroy");
    }
}
