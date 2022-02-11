package com.citizen.houseutils.policy;

import com.citizen.houseutils.constants.ActionType;
import com.citizen.houseutils.exception.ErrorCode;
import com.citizen.houseutils.exception.HouseUtilsException;

/**
 * author : citizen103
 */
public class BrokeragePolicyFactory {

    private static final RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();
    private static final PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case PURCHASE:
                return purchaseBrokeragePolicy;
            case RENT:
                return rentBrokeragePolicy;
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 액션 Type에 대한 정책이 존재하지 않습니다.");
        }
    }

}
