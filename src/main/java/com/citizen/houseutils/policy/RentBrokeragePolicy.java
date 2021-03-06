package com.citizen.houseutils.policy;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

/**
 * author : citizen103
 * 
 * 임대차일 떄 중개수수료를 계산해주는 클래스
 */
@Getter
public class RentBrokeragePolicy implements BrokeragePolicy{

    private final List<BrokerageRule> rules;

    public RentBrokeragePolicy() {
        rules = Arrays.asList(
            new BrokerageRule(50_000_000L, 0.5, 200_000L),
            new BrokerageRule(100_000_000L,0.4, 300_000L),
            new BrokerageRule(300_000_000L, 0.3),
            new BrokerageRule(600_000_000L, 0.4),
            new BrokerageRule(Long.MAX_VALUE, 0.8)
        );
    }

}
