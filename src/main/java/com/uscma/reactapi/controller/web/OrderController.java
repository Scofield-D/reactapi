package com.uscma.reactapi.controller.web;

import com.uscma.reactapi.domain.model.web.OrderDTO;
import com.uscma.reactapi.domain.response.ResultVO;
import com.uscma.reactapi.service.web.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rp
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 分页查询订单
     * */
    @GetMapping
    public ResultVO findByOrders(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
                                 String search){
        PageInfo<OrderDTO> orders = orderService.findByOrders(page,pageSize,search);
        return ResultVO.success(orders);
    }


}
