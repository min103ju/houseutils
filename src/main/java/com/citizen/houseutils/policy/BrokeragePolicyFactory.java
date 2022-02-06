package com.citizen.houseutils.policy;

import com.citizen.houseutils.constants.ActionType;
import com.citizen.houseutils.exception.ErrorCode;
import com.citizen.houseutils.exception.HouseUtilsException;

/**
 * author : citizen103
 */
public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            case RENT:
                return new RentBrokeragePolicy();
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 액션 Type에 대한 정책이 존재하지 않습니다.");
        }
    }

}
