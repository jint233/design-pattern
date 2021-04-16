package com.cesponsibilitychain.demo.controller;


import com.cesponsibilitychain.demo.dto.Person;
import com.cesponsibilitychain.demo.dto.User;
import com.cesponsibilitychain.demo.router.StrategyRootRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program demo
 * @description: 测试策略 + 责任链模式转发处理请求
 * @author: Jin
 * @create: 2021-04-06 15:23
 * @update: 2021-04-06 15:23
 * @intention:
 */
@RestController
@SuppressWarnings({"unchecked"})
public class TestController {

    private final StrategyRootRouter register;

    @Autowired
    public TestController(StrategyRootRouter register) {
        this.register = register;
    }


    @GetMapping("/test")
    public String test(Person person) {
        return (String) register.applyStrategy(person);
    }

    @GetMapping("/testUser")
    public String test(User person) {
        return (String) register.applyStrategy(person);
    }

}
