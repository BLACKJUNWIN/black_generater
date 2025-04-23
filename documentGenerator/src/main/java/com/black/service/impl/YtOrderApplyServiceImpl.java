package com.black.service.impl;

import com.black.entity.YtOrderApply;
import com.black.mapper.YtOrderApplyMapper;
import com.black.service.IYtOrderApplyService;
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
 * @since 2024-12-03 11:59:30
 */
@Service
public class YtOrderApplyServiceImpl extends ServiceImpl<YtOrderApplyMapper, YtOrderApply> implements IYtOrderApplyService {
    @Autowired
    private YtOrderApplyMapper ytOrderApplyMapper;


    /**
    * 查询任意数据
    * @param ytOrderApply 对象数据
    * @return 对象数组
    */
    @Override
    public List<YtOrderApply> findAll(YtOrderApply ytOrderApply){
     return ytOrderApplyMapper.selectAll(ytOrderApply);
    }

    /**
    * 修改任意数据
    * @param ytOrderApply 对象数据
    * @return 对象数组
    */
    @Override
    public int modifyAll(YtOrderApply ytOrderApply){
     return ytOrderApplyMapper.updateAll(ytOrderApply);
    }
}
