package com.citizen.houseutils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * author : citizen103
 * <p>
 * 가격이 특정 범위일 때 상한효율과 상한금액을 가지는 클래스
 */
@AllArgsConstructor
@Getter
public class BrokerageRule {
    private Long lessThan;
    private Double brokeragePercent;

    @Nullable
    private Long limitAmount;

    public Long calcMaxBrokerage(Long price) {
        if (limitAmount == null) {
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
