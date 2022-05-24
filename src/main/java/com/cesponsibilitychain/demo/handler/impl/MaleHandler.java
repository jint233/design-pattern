package com.cesponsibilitychain.demo.handler.impl;


import com.cesponsibilitychain.demo.dto.Person;
import com.cesponsibilitychain.demo.handler.StrategyHandler;
import org.springframework.stereotype.Component;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 11:00
 * @update: 2021-04-12 11:00
 * @intention: teenager -> male 时处理Handler
 */
@Component
@SuppressWarnings("rawtypes")
public class MaleHandler implements StrategyHandler<Person, String> {
    @Override
    public String apply(Person person) {
        return "I am " + person.getName() + ", " +
                person.getAge() + " years old" + ". " +
                "I am teenager and male";
    }
}
