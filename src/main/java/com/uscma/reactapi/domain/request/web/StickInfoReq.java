package com.uscma.reactapi.domain.request.web;

import lombok.Data;

/**
 * @author rp
 */
@Data
public class StickInfoReq {

    private Long id;

    private Long stickDay;

    private Long stickPrice;
}
