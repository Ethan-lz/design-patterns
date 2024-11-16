package com.lz.design.strategy;

import com.lz.design.strategy.enums.PayTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ethan
 * @date 2024/11/16 0:21
 */
@Slf4j
@Component
public class WechatPayStrategy implements PayStrategy {
    @Override
    public String getPayType() {
        return PayTypeEnum.wechatPay.name();
    }

    @Override
    public void pay() {
        log.info("微信支付成功");
    }
}
