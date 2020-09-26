package com.uscma.reactapi.service.web.impl;

import com.uscma.reactapi.domain.mapper.web.SystemInfoMapper;
import com.uscma.reactapi.domain.model.web.SystemInfoDTO;
import com.uscma.reactapi.domain.request.web.SystemInfoReq;
import com.uscma.reactapi.service.web.SystemInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rp
 */
@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    private final SystemInfoMapper systemInfoMapper;

    public SystemInfoServiceImpl(SystemInfoMapper systemInfoMapper) {
        this.systemInfoMapper = systemInfoMapper;
    }

    @Override
    public List<SystemInfoDTO> findSystemInfo() {
        return systemInfoMapper.findSystemInfo();
    }

    @Override
    public boolean updateSystemInfo(SystemInfoReq systemInfoReq) {
        Integer row = systemInfoMapper.updateSystemInfo(systemInfoReq);
        return row > 0;
    }

    @Override
    public void delete(Long id) {
        systemInfoMapper.delete(id);
    }

    @Override
    public boolean createSystemInfo(SystemInfoReq systemInfoReq) {
        Integer row = systemInfoMapper.createSystemInfo(systemInfoReq);
        return row > 0;
    }
}

