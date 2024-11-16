package com.lz.design.strategy.service;

/**
 * @author Ethan
 * @date 2024/11/16 14:02
 */
public interface OrderService {

    /**
     * 普通付款
     *
     * @param payType 付款方式
     */
    void normalPay(String payType);

    /**
     * 策略模式改造后的付款
     *
     * @param payType 付款方式
     */
    void strategyPay(String payType);
}
