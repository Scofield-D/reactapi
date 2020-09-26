package com.uscma.reactapi.controller.web;

import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.service.web.ImageService;
import com.uscma.reactapi.utils.qiniu.ImageKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author rp
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ImageService imageService;

    /**
     * 上传图片
     * */
    @PostMapping
    public ResultVO upload(@RequestParam("file") MultipartFile file, @RequestParam("type") Integer type) {
        ImageKit image = imageService.upload(file, type);
        return ResultVO.success(image);
    }

    /**
     * 删除图片
     * */
    @DeleteMapping
    public ResultVO delete(@RequestParam("key") String key) {
        imageService.delete(key);
        return ResultVO.success();
    }

    /**
     * 批量删除图片
     * */
    @DeleteMapping("/deletes")
    public ResultVO deletes(@RequestParam("keys") String[] keys){
        imageService.deletes(keys);
        return ResultVO.success();
    }
}
