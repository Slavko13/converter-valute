package ru.converter.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Application {


    @SuppressWarnings("InfiniteLoopStatement")
    public void start(Class configClass) throws InterruptedException {
        new AnnotationConfigApplicationContext(configClass);
        while (true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }

}
