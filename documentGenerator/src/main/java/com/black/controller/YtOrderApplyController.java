package com.black.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.black.common.entity.ApiCode;
import com.black.common.entity.ApiRes;
import com.black.service.IYtOrderApplyService;
import com.black.entity.YtOrderApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BlackJun
 * @since 2024-12-03 11:59:30
 */
@CrossOrigin
@RestController
@RequestMapping("/yt_order_apply")
public class YtOrderApplyController {
    @Autowired
    private IYtOrderApplyService iYtOrderApplyService;

    /**
    * 添加数据
    *
    */
    @PostMapping("/")
    public ApiRes<?> save(@RequestBody YtOrderApply ytOrderApply){
        if (iYtOrderApplyService.save(ytOrderApply)){
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
        if(iYtOrderApplyService.removeById(id)){
            return ApiRes.SuccessApi();
        }
        return ApiRes.FailApi();
    }

    /**
    * 修改数据
    *
    */
    @PutMapping("/")
    public ApiRes<?> modify(@RequestBody YtOrderApply ytOrderApply){
        if(iYtOrderApplyService.modifyAll(ytOrderApply)!=0){
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
        return new ApiRes<>(new PageInfo<>(iYtOrderApplyService.list()));
    }
    /**
    * 任意查询
    *
    */
    @PatchMapping("/")
    public ApiRes<?> findBy(@RequestBody YtOrderApply ytOrderApply){
        PageHelper.startPage(ytOrderApply.getPageNum(),ytOrderApply.getPageSize());
        return new ApiRes<>(new PageInfo<>(iYtOrderApplyService.findAll(ytOrderApply)));
    }
}
