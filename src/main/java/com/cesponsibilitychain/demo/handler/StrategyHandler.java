package com.cesponsibilitychain.demo.handler;

/**
 * Handler通用接口,除了根结点外，所有子节点都需要实现该接口
 *
 * @param <T> 策略的入参类型
 * @param <R> 策略的返回值类型
 */
@SuppressWarnings("rawtypes")
public interface StrategyHandler<T, R> {
    /**
     * 默认执行
     *
     */
    StrategyHandler DEFAULT = t -> "I am default response";

    /**
     * apply strategy
     *
     * @param param 入参
     * @return 策略执行者执行结果
     */
    R apply(T param);
}
