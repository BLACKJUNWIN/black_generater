package com.black.service.impl;

import com.black.entity.OrderApply;
import com.black.mapper.OrderApplyMapper;
import com.black.service.IOrderApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BlackJun
 * @since 2024-12-03 14:33:28
 */
@Service
public class OrderApplyServiceImpl extends ServiceImpl<OrderApplyMapper, OrderApply> implements IOrderApplyService {
    @Autowired
    private OrderApplyMapper orderApplyMapper;


    /**
    * 查询任意数据
    * @param orderApply 对象数据
    * @return 对象数组
    */
    @Override
    public List<OrderApply> findAll(OrderApply orderApply){
     return orderApplyMapper.selectAll(orderApply);
    }

    /**
    * 修改任意数据
    * @param orderApply 对象数据
    * @return 对象数组
    */
    @Override
    public int modifyAll(OrderApply orderApply){
     return orderApplyMapper.updateAll(orderApply);
    }
}
