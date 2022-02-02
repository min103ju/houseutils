package com.citizen.houseutils.policy;

/**
 * author : citizen103
 */
public interface BrokeragePolicy {

    BrokerageRule createBrokerageRule(Long price);

    default Long calculate(Long price) {
        return createBrokerageRule(price).calcMaxBrokerage(price);
    }
}
