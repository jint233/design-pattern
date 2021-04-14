package com.cesponsibilitychain.demo.handler;


import org.springframework.stereotype.Component;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 14:58
 * @update: 2021-04-12 14:58
 * @intention: 默认Handler
 */
@Component
public class DefaultHandler implements StrategyHandler {
    @Override
    public Object apply(Object param) {
        return "I am default";
    }
}
