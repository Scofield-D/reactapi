package com.uscma.reactapi.controller.web;

import com.uscma.reactapi.domain.model.web.StickInfoDTO;
import com.uscma.reactapi.domain.request.web.StickInfoReq;
import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.enums.ResponseEnum;
import com.uscma.reactapi.service.web.StickInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author rp
 */
@RestController
@RequestMapping("/sticks")
public class StickInfoController {

    @Autowired
    private StickInfoService stickInfoService;

    /**
     * 分页查询置顶设置信息
     * */
    @GetMapping
    public ResultVO findStickInfos(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize){
        PageInfo<StickInfoDTO> stickInfoDTOS = stickInfoService.findStickInfos(page, pageSize);
        return ResultVO.success(stickInfoDTOS);
    }

    /**
     * 修改置顶设置信息
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_NORMAL_UPDATE_USER','ROLE_SUPER_ADMIN')")
    @PutMapping
    public ResultVO updateStickInfo(@RequestBody StickInfoReq stickInfoReq){
        boolean updateSuccess = stickInfoService.updateStickInfo(stickInfoReq);
        return updateSuccess ? ResultVO.success() : ResultVO.fail(ResponseEnum.SYSTEM_SETTING_ERROR);
    }

    /**
     * 创建置顶设置信息
     * */
    @PostMapping
    public ResultVO createStickInfo(@RequestBody StickInfoReq stickInfoReq){
        boolean updateSuccess = stickInfoService.createStickInfo(stickInfoReq);
        return updateSuccess ? ResultVO.success() : ResultVO.fail(ResponseEnum.SYSTEM_SETTING_ERROR);
    }

    /**
     * 批量删除置顶设置信息
     * */
    @PreAuthorize("hasAnyAuthority('SETTING_NORMAL_DELETE_USER','ROLE_SUPER_ADMIN')")
    @DeleteMapping
    public ResultVO stickInfoDeletes(@RequestParam String ids) {
        stickInfoService.deletes(ids);
        return ResultVO.success();
    }


}
