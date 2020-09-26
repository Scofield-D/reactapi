package com.uscma.reactapi.controller.admin;

import com.uscma.reactapi.domain.request.admin.AdminBindReq;
import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 微信公众号相关
 * @author rp
 */
@RestController
@RequestMapping("/wxOpen")
public class WxMpController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 网站扫码登录
     * */
    @GetMapping("/authQrCode")
    public ResultVO authQrCode(@RequestParam("code") String code){
        String token = adminUserService.authQrCode(code);
        return ResultVO.success(token);
    }

    /**
     * 绑定管理账号
     * */
    @PostMapping("/BindingWx")
    public ResultVO bindingWx(@RequestBody AdminBindReq adminBindReq){
        String token = adminUserService.bindingWx(adminBindReq);
        return ResultVO.success(token);
    }


}
