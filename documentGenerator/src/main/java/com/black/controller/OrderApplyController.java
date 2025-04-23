package com.black.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.black.common.entity.ApiCode;
import com.black.common.entity.ApiRes;
import com.black.service.IOrderApplyService;
import com.black.entity.OrderApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BlackJun
 * @since 2024-12-03 14:33:28
 */
@CrossOrigin
@RestController
@RequestMapping("/order_apply")
public class OrderApplyController {
    @Autowired
    private IOrderApplyService iOrderApplyService;

    /**
    * 添加数据
    *
    */
    @PostMapping("/")
    public ApiRes<?> save(@RequestBody OrderApply orderApply){
        if (iOrderApplyService.save(orderApply)){
            return ApiRes.SuccessApi();
        }
        return ApiRes.FailApi();
    }

    /**
    * 删除数据
    *
    */
    @DeleteMapping("/{id}")
    public ApiRes<?> remove(@PathVariable("id") Long id){
        if(iOrderApplyService.removeById(id)){
            return ApiRes.SuccessApi();
        }
        return ApiRes.FailApi();
    }

    /**
    * 修改数据
    *
    */
    @PutMapping("/")
    public ApiRes<?> modify(@RequestBody OrderApply orderApply){
        if(iOrderApplyService.modifyAll(orderApply)!=0){
            return ApiRes.SuccessApi();
        }
        return ApiRes.FailApi();
    }
    /**
    * 查询全部
    *
    */
    @GetMapping("/")
    public ApiRes<?> findAll(){
        PageHelper.startPage(0,10);
        return new ApiRes<>(new PageInfo<>(iOrderApplyService.list()));
    }
    /**
    * 任意查询
    *
    */
    @PatchMapping("/")
    public ApiRes<?> findBy(@RequestBody OrderApply orderApply){
        PageHelper.startPage(orderApply.getPageNum(),orderApply.getPageSize());
        return new ApiRes<>(new PageInfo<>(iOrderApplyService.findAll(orderApply)));
    }
}
