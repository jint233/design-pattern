package com.cesponsibilitychain.demo.handler.impl;


import com.cesponsibilitychain.demo.dto.Person;
import com.cesponsibilitychain.demo.handler.StrategyHandler;
import org.springframework.stereotype.Component;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 10:59
 * @update: 2021-04-12 10:59
 * @intention: old时处理Handler
 */
@Component
@SuppressWarnings("rawtypes")
public class OldHandler implements StrategyHandler<Person, String> {

    @Override
    public String apply(Person person) {
        return "I am " + person.getName() + ", " +
                person.getAge() + " years old" + ". " +
                "I am old";
    }
}
