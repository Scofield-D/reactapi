package com.uscma.reactapi.service.admin.impl;

import com.uscma.reactapi.domain.mapper.admin.RoleMenuMapper;
import com.uscma.reactapi.domain.model.admin.RoleMenuDTO;
import com.uscma.reactapi.domain.model.admin.TreeRoleMenuDTO;
import com.uscma.reactapi.domain.request.admin.MenuReq;
import com.uscma.reactapi.service.admin.RoleMenuService;
import com.uscma.reactapi.utils.TreeHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author rp
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    private final RoleMenuMapper roleMenuMapper;

    public RoleMenuServiceImpl(RoleMenuMapper roleMenuMapper) {
        this.roleMenuMapper = roleMenuMapper;
    }

    @Override
    public List<RoleMenuDTO> findByRoleMenus(String search) {
        List<RoleMenuDTO> roleMenuS;
        if (StringUtils.isEmpty(search)){
            roleMenuS = roleMenuMapper.findByRoleMenus();
        }else{
            roleMenuS = roleMenuMapper.findByRoleMenusLike(search);
        }
        return TreeHelper.getSortedNodes(roleMenuS);
    }

    @Override
    public List<TreeRoleMenuDTO> findRoleMenus() {
        List<TreeRoleMenuDTO> treeRoleMenuDTOS = roleMenuMapper.findRoleMenus();
        return TreeHelper.getSortedTreeNodes(treeRoleMenuDTOS);
    }

    @Override
    public boolean creatMenu(MenuReq menuReq) {
        menuReq.setLevel(menuReq.getLevel() + 1);
        Integer row = roleMenuMapper.creatMenu(menuReq);
        return row > 0;
    }

    @Override
    public void deleteById(String id) {
        //并且删除子菜单
        roleMenuMapper.deleteById(id);
    }

    @Override
    public boolean updateMenu(MenuReq menuReq) {
        Integer row = roleMenuMapper.updateMenu(menuReq);
        return row > 0;
    }
}
