package com.uscma.reactapi.controller.admin;

import com.uscma.reactapi.domain.model.admin.RoleMenuDTO;
import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * @author rp
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 获取管理员权限菜单
     * */
    @GetMapping
    public ResultVO findByMenus(Principal principal){
        List<RoleMenuDTO> menus = adminUserService.findByMenus(principal.getName());
        return ResultVO.success(menus);
    }

}
