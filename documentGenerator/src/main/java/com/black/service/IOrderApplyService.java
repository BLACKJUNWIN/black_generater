package com.black.service;

import com.black.entity.OrderApply;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BlackJun
 * @since 2024-12-03 14:33:28
 */
public interface IOrderApplyService extends IService<OrderApply> {

    /**
    * 查询任意数据
    * @param orderApply 对象数据
    * @return 对象数组
    */
    List<OrderApply> findAll(OrderApply orderApply);

    /**
    * 修改任意数据
    * @param orderApply 对象数据
    * @return 对象数组
    */
    int modifyAll(OrderApply orderApply);
}
