package com.cesponsibilitychain.demo.handler.impl;


import com.cesponsibilitychain.demo.dto.Person;
import com.cesponsibilitychain.demo.handler.StrategyHandler;
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
@SuppressWarnings("rawtypes")
public class FemaleHandler implements StrategyHandler<Person, String> {
    @Override
    public String apply(Person person) {
        return "I am " + person.getName() + ", " +
                person.getAge() + " years old" + ". " +
                "I am teenager and female";
    }
}
