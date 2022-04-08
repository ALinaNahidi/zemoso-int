package spring.annotation.demo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] messages ={
            "Random message 1",
            "Random message 2",
            "Random message 3"
    };

    private Random random = new Random();

    @Override
    public String getFortuneService() {
        return messages[random.nextInt(messages.length)];
    }
}
