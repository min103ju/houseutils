package com.citizen.houseutils.constants;

import lombok.AllArgsConstructor;

/**
 * author : citizen103
 */
@AllArgsConstructor
public enum ActionType {
    PURCHASE("매매"),
    RENT("임대차");

    private String description;

}
