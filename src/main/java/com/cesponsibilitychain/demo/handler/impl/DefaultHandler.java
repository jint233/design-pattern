package com.cesponsibilitychain.demo.handler.impl;

import com.cesponsibilitychain.demo.dto.Person;
import com.cesponsibilitychain.demo.handler.StrategyHandler;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @create 2022/5/24 23:16
 */
@Component
public class DefaultHandler implements StrategyHandler<Person, String> {

    @Override
    public String apply(Person param) {
        return "I am default response";
    }
}
