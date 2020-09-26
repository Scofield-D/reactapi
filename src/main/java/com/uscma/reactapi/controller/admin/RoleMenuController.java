package com.uscma.reactapi.controller.admin;

import com.uscma.reactapi.domain.model.admin.RoleMenuDTO;
import com.uscma.reactapi.domain.model.admin.TreeRoleMenuDTO;
import com.uscma.reactapi.domain.request.admin.MenuReq;
import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.enums.ResponseEnum;
import com.uscma.reactapi.service.admin.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单相关
 * @author rp
 */
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 菜单选择
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_SELECT','ROLE_SUPER_ADMIN','MENU_ADMIN_USER')")
    @GetMapping("/getMenus")
    public ResultVO getMenus(){
        List<TreeRoleMenuDTO> treeRoleMenus = roleMenuService.findRoleMenus();
        return ResultVO.success(treeRoleMenus);
    }

    /**
     * 菜单列表(目录/菜单)
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_SELECT','ROLE_SUPER_ADMIN','MENU_ADMIN_USER')")
    @GetMapping
    public ResultVO findByRoleMenus(String search){
        List<RoleMenuDTO> roleMenus = roleMenuService.findByRoleMenus(search);
        return ResultVO.success(roleMenus);
    }

    /**
     * 修改菜单
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_UPDATE','ROLE_SUPER_ADMIN')")
    @PutMapping
    public ResultVO updateMenu(@RequestBody MenuReq menuReq){
        boolean updateSuccess = roleMenuService.updateMenu(menuReq);
        return updateSuccess ? ResultVO.success() : ResultVO.fail(ResponseEnum.PERMISSION_UPDATE_ERROR);
    }


    /**
     * 删除菜单
     * */
    @PreAuthorize("hasAnyAuthority('SRTTING_DELETE','ROLE_SUPER_ADMIN')")
    @DeleteMapping
    public ResultVO delete(@RequestParam String id){
        roleMenuService.deleteById(id);
        return ResultVO.success();
    }

    /**
     * 新增菜单
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_ADD','ROLE_SUPER_ADMIN')")
    @PostMapping
    public ResultVO creatMenu(@RequestBody MenuReq menuReq){
        boolean createSuccess = roleMenuService.creatMenu(menuReq);
        return createSuccess ? ResultVO.success() : ResultVO.fail(ResponseEnum.PERMISSION_CREATE_ERROR);
    }
}
