package com.uscma.reactapi.controller.web;

import com.uscma.reactapi.domain.model.web.SystemInfoDTO;
import com.uscma.reactapi.domain.request.web.SystemInfoReq;
import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.enums.ResponseEnum;
import com.uscma.reactapi.service.web.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rp
 */
@RestController
@RequestMapping("/system")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    /**
     * 查询推广设置信息
     * */
    @GetMapping
    public ResultVO findSystemInfo(){
        List<SystemInfoDTO> systemInfos = systemInfoService.findSystemInfo();
        return ResultVO.success(systemInfos);
    }

    /**
     * 修改推广设置信息
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_NORMAL_UPDATE_USER','ROLE_SUPER_ADMIN')")
    @PutMapping
    public ResultVO updateSystemInfo(@RequestBody SystemInfoReq systemInfoReq){
        boolean updateSuccess = systemInfoService.updateSystemInfo(systemInfoReq);
        return updateSuccess ? ResultVO.success() : ResultVO.fail(ResponseEnum.SYSTEM_SETTING_ERROR);
    }

    /**
     * 新增
     * */
    @PostMapping
    public ResultVO createSystemInfo(@RequestBody SystemInfoReq systemInfoReq){
        boolean createSuccess = systemInfoService.createSystemInfo(systemInfoReq);
        return createSuccess ? ResultVO.success() : ResultVO.fail(ResponseEnum.SYSTEM_SETTING_ERROR);
    }


    /**
     * 删除
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_NORMAL_DELETE_USER','ROLE_SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable("id") Long id){
        systemInfoService.delete(id);
        return ResultVO.success();
    }
}
