package com.uscma.reactapi.domain.request.admin;

import lombok.Data;

/**
 * @author rp
 */
@Data
public class AdminBindReq {

    private String username;

    private String password;

    private String openId;

}
