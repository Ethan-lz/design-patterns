package com.lz.design.strategy;

/**
 * @author Ethan
 * @date 2024/11/16 0:19
 */
public interface PayStrategy {

    /**
     * 获取付款方式
     *
     * @return 付款方式
     */
    String getPayType();

    /**
     * 付款方法实现
     */
    void pay();
}
