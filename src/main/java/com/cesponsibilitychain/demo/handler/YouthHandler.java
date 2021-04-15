package com.cesponsibilitychain.demo.handler;


import com.cesponsibilitychain.demo.dto.Person;
import org.springframework.stereotype.Component;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 10:56
 * @update: 2021-04-12 10:56
 * @intention: youth时处理Handler
 */
@Component
@SuppressWarnings("rawtypes")
public class YouthHandler implements StrategyHandler {
    @Override
    public Object apply(Object param) {
        Person person = (Person) param;
        return "I am " + person.getName() + ", " +
                person.getAge() + " years old" + "," +
                "I am youth";
    }
}
