package com.lz.design.strategy.service.impl;

import com.lz.design.strategy.PayStrategy;
import com.lz.design.strategy.enums.PayTypeEnum;
import com.lz.design.strategy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ethan
 * @date 2024/11/16 0:24
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final Map<String, PayStrategy> payServiceMap;

    /**
     * 将所有付款方式的实现放入payServiceMap
     *
     * @param payStrategies 付款方式的实现
     */
    public OrderServiceImpl(List<PayStrategy> payStrategies) {
        this.payServiceMap = new HashMap<>();
        for (PayStrategy payStrategy : payStrategies) {
            this.payServiceMap.put(payStrategy.getPayType(), payStrategy);
        }
    }

    @Override
    public void normalPay(String payType) {
        if (PayTypeEnum.alipay.name().equals(payType)) {
            log.info("支付宝支付成功");
        } else if (PayTypeEnum.wechatPay.name().equals(payType)) {
            log.info("微信支付成功");
        } else if (PayTypeEnum.unionPay.name().equals(payType)) {
            log.info("银行卡支付成功");
        } else {
            log.info("没有这个支付方式");
        }
    }

    @Override
    public void strategyPay(String payType) {
        PayStrategy payStrategy = payServiceMap.get(payType);
        if (payStrategy == null) {
            log.error("没有这个支付方式");
            return;
        }
        payStrategy.pay();
    }
}
