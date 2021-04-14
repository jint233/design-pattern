package com.cesponsibilitychain.demo.handler;


import com.cesponsibilitychain.demo.dto.Person;
import org.springframework.stereotype.Component;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 11:01
 * @update: 2021-04-12 11:01
 * @intention: teenager -> female 时处理Handler
 */
@Component
public class FemaleHandler implements StrategyHandler {
    @Override
    public Object apply(Object param) {
        Person person = (Person) param;
        return new StringBuilder().append("I am ").append(person.getName()).append(", ")
                .append(person.getAge()).append(" years old").append(". ")
                .append("I am teenager and female").toString();
    }
}
