package com.cesponsibilitychain.demo.router;


import com.cesponsibilitychain.demo.dto.Person;
import com.cesponsibilitychain.demo.handler.impl.DefaultHandler;
import com.cesponsibilitychain.demo.handler.impl.MiddleAgedHandler;
import com.cesponsibilitychain.demo.handler.impl.OldHandler;
import com.cesponsibilitychain.demo.handler.impl.YouthHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 10:30
 * @update: 2021-04-12 10:30
 * @intention: 根路由，以此节点为入口，调用其applyStrategy方法，内部根据路由实现转发处理
 */
@Component
public class StrategyRootRouter extends AbstractStrategyRouter<Person, String> {
    private static final Logger log = LoggerFactory.getLogger(StrategyRootRouter.class);

    private final DefaultHandler defaultHandler;

    private final YouthHandler youthHandler;

    private final TeenagerHandlerRouter teenagerHandlerRouter;

    private final MiddleAgedHandler middleAgedHandler;

    private final OldHandler oldHandler;


    @Autowired
    public StrategyRootRouter(DefaultHandler defaultHandler,
                              YouthHandler youthHandler,
                              TeenagerHandlerRouter teenagerHandlerRouter,
                              MiddleAgedHandler middleAgedHandler,
                              OldHandler oldHandler) {
        super(defaultHandler);
        this.defaultHandler = defaultHandler;
        this.youthHandler = youthHandler;
        this.teenagerHandlerRouter = teenagerHandlerRouter;
        this.middleAgedHandler = middleAgedHandler;
        this.oldHandler = oldHandler;
    }

    @Override
    protected StrategyMapper<Person, String> registerStrategyMapper() {
        return person -> {
            if (Objects.isNull(person)) {
                return null;
            }
            int age = person.getAge();
            if (age <= 0) {
                log.error("req param is error");
                return defaultHandler;
            }
            if (age < 18) {
                return youthHandler;
            } else if (age < 35) {
                return teenagerHandlerRouter;
            } else if (age < 60) {
                return middleAgedHandler;
            } else {
                return oldHandler;
            }
        };
    }
}
