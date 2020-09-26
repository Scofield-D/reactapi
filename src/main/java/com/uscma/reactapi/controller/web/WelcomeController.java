package com.uscma.reactapi.controller.web;

import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.domain.response.WelcomeVO;
import com.uscma.reactapi.service.web.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renpei
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    /**
     * 统计
     * */
    @GetMapping
    public ResultVO welcome() {
        WelcomeVO welcomeVO = welcomeService.welcomeCount();
        return ResultVO.success(welcomeVO);
    }
}
