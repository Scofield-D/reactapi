package com.uscma.reactapi.service.web.impl;

import com.uscma.reactapi.domain.exception.CustomizeException;
import com.uscma.reactapi.domain.mapper.web.StickInfoMapper;
import com.uscma.reactapi.domain.model.web.StickInfoDTO;
import com.uscma.reactapi.domain.request.web.StickInfoReq;
import com.uscma.reactapi.enums.ResponseEnum;
import com.uscma.reactapi.service.web.StickInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author rp
 */
@Service
public class StickInfoServiceImpl implements StickInfoService {

    private final StickInfoMapper stickInfoMapper;

    public StickInfoServiceImpl(StickInfoMapper stickInfoMapper) {
        this.stickInfoMapper = stickInfoMapper;
    }

    @Override
    public PageInfo<StickInfoDTO> findStickInfos(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<StickInfoDTO> stickInfos = stickInfoMapper.findStickInfos();
        return new PageInfo<>(stickInfos);
    }

    @Override
    public boolean updateStickInfo(StickInfoReq stickInfoReq) {
        Optional<StickInfoDTO> optional = stickInfoMapper.findByStickDay(stickInfoReq.getStickDay());
        if (optional.isPresent() && !optional.get().getId().equals(stickInfoReq.getId())){
            throw new CustomizeException(ResponseEnum.STICK_INFO_DAT_EXIST);
        }
        Integer row = stickInfoMapper.updateStickInfo(stickInfoReq);
        return row > 0;
    }

    @Override
    public boolean createStickInfo(StickInfoReq stickInfoReq) {
        Optional<StickInfoDTO> optional = stickInfoMapper.findByStickDay(stickInfoReq.getStickDay());
        if (optional.isPresent()){
            throw new CustomizeException(ResponseEnum.STICK_INFO_DAT_EXIST);
        }
        Integer row = stickInfoMapper.createStickInfo(stickInfoReq);
        return row > 0;
    }

    @Override
    public void deletes(String ids) {
        String[] split = ids.split(",");
        List stickIds= Arrays.asList(split);
        stickInfoMapper.deletes(stickIds);
    }
}
