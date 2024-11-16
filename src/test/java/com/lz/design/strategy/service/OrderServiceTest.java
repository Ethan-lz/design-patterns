package com.lz.design.strategy.service;

import com.lz.design.strategy.enums.PayTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ethan
 * @date 2024/11/16 14:05
 */
@SpringBootTest
@Slf4j
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void strategyPayTest() {
        orderService.strategyPay(PayTypeEnum.alipay.name());
        orderService.strategyPay(PayTypeEnum.wechatPay.name());
        orderService.strategyPay(PayTypeEnum.unionPay.name());
        orderService.strategyPay("other");
    }

    @Test
    void normalPayTest() {
        orderService.normalPay(PayTypeEnum.alipay.name());
        orderService.normalPay(PayTypeEnum.wechatPay.name());
        orderService.normalPay(PayTypeEnum.unionPay.name());
        orderService.normalPay("other");
    }
}
