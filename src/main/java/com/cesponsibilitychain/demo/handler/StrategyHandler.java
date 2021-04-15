package com.cesponsibilitychain.demo.handler;

/**
 * Handler通用接口,除了根结点外，所有子节点都需要实现该接口
 *
 * @param <T> 策略的入参类型
 * @param <R> 策略的返回值类型
 */
public interface StrategyHandler<T, R> {
    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);
}
