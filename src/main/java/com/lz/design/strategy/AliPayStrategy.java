package com.lz.design.strategy;

import com.lz.design.strategy.enums.PayTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ethan
 * @date 2024/11/16 0:20
 */
@Slf4j
@Component
public class AliPayStrategy implements PayStrategy {
    @Override
    public String getPayType() {
        return PayTypeEnum.alipay.name();
    }

    @Override
    public void pay() {
        log.info("支付宝支付成功");
    }
}
