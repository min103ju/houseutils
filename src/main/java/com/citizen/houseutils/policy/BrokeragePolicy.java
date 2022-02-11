package com.citizen.houseutils.policy;

import com.citizen.houseutils.exception.ErrorCode;
import com.citizen.houseutils.exception.HouseUtilsException;
import java.util.List;

/**
 * author : citizen103
 */
public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price) {
        BrokerageRule brokerageRule = getRules().stream()
            .filter(rule -> price < rule.getLessThan())
            .findFirst()
            .orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));

        return brokerageRule.calcMaxBrokerage(price);
    }
}
