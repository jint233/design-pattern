package com.cesponsibilitychain.demo.router;


import com.cesponsibilitychain.demo.dto.Person;
import com.cesponsibilitychain.demo.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 10:30
 * @update: 2021-04-12 10:30
 * @intention: 根路由，以此节点为入口，调用其applyStrategy方法，内部根据路由实现转发处理
 */
@Component
public class StrategyRootRouter extends AbstractStrategyRouter {
    private static final Logger log = LoggerFactory.getLogger(StrategyRootRouter.class);

    private final YouthHandler youthHandler;

    private final TeenagerHandlerRouter teenagerHandlerRouter;

    private final MiddleAgedHandler middleAgedHandler;

    private final OldHandler oldHandler;

    @Autowired
    public StrategyRootRouter(YouthHandler youthHandler, TeenagerHandlerRouter teenagerHandlerRouter, MiddleAgedHandler middleAgedHandler, OldHandler oldHandler) {
        this.youthHandler = youthHandler;
        this.teenagerHandlerRouter = teenagerHandlerRouter;
        this.middleAgedHandler = middleAgedHandler;
        this.oldHandler = oldHandler;
    }

    @Override
    protected StrategyMapper registerStrategyMapper() {
        return param -> {
            if (param instanceof Person) {
                int age = ((Person) param).getAge();
                if (age < 18) {
                    return youthHandler;
                } else if (age < 35) {
                    return teenagerHandlerRouter;
                } else if (age < 60) {
                    return middleAgedHandler;
                } else {
                    return oldHandler;
                }
            }
            log.error("Strategy can not deal this req!");
            return new DefaultHandler();
        };
    }
}
