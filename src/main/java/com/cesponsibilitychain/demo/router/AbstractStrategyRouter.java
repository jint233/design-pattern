package com.cesponsibilitychain.demo.router;

import com.cesponsibilitychain.demo.handler.StrategyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @program demo
 * @description: 策略 + 责任链模式
 * @author: Jin
 * @create: 2021-04-12 10:18
 * @update: 2021-04-12 10:18
 * @intention: 路由抽象父类，所有路由节点（从根结点起）均需要继承该抽象父类
 * 并实现其registerStrategyMapper方法注册路由信息，具有转发功能的叶子节点
 * 除实现该抽象类外，也需要实现StrategyHandler接口，重写apply方法。
 */
@Component
public abstract class AbstractStrategyRouter<T, R> {

    private static final Logger log = LoggerFactory.getLogger(AbstractStrategyRouter.class);

    /**
     * 策略映射器，根据指定的入参路由到对应的策略处理者。
     *
     * @param <T> 策略的入参类型
     * @param <R> 策略的返回值类型
     */
    public interface StrategyMapper<T, R> {
        /**
         * 根据入参获取到对应的策略处理者。可通过 if-else 实现，也可通过 Map 实现。
         *
         * @param param 入参
         * @return 策略处理者
         */
        StrategyHandler<T, R> get(T param);
    }

    private StrategyMapper<T, R> strategyMapper;

    /**
     * 类初始化时注册分发策略 Mapper
     */
    @PostConstruct
    private void abstractInit() {
        strategyMapper = registerStrategyMapper();
        Objects.requireNonNull(strategyMapper, "strategyMapper cannot be null");
    }

    @SuppressWarnings("unchecked")
    protected final StrategyHandler<T, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    /**
     * 执行策略，框架会自动根据策略分发至下游的 Handler 进行处理
     *
     * @param param 入参
     * @return 下游执行者给出的返回值
     */
    public R applyStrategy(T param) {
        final StrategyHandler<T, R> strategyHandler = strategyMapper.get(param);
        if (Objects.isNull(strategyHandler)) {
            log.error("no such handler!");
            return defaultStrategyHandler.apply(param);
        }
        return strategyHandler.apply(param);

    }

    /**
     * 抽象方法，需要子类实现策略的分发逻辑
     *
     * @return 分发逻辑 Mapper 对象
     */
    protected abstract StrategyMapper<T, R> registerStrategyMapper();

}
