# 设计模式

## 1. 策略模式

问题：如果一个订单有多种付款方式,需要根据不同的付款方式走不同的付款方法进行付款

传统代码：

```java
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
```

那么如果要扩展新的付款方式，我们需要添加新的`if-else`去实现功能。

策略模式：

```java
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
```

每个付款模式实现`PayStrategy`接口，扩展新的支付方式时，同样也只需要添加新的实现类

```java

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
```

```java
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
public void strategyPay(String payType) {
    PayStrategy payStrategy = payServiceMap.get(payType);
    if (payStrategy == null) {
        log.error("没有这个支付方式");
        return;
    }
    payStrategy.pay();
}
```