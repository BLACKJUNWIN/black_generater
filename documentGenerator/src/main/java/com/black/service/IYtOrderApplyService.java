package com.black.service;

import com.black.entity.YtOrderApply;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BlackJun
 * @since 2024-12-03 11:59:30
 */
public interface IYtOrderApplyService extends IService<YtOrderApply> {

    /**
    * 查询任意数据
    * @param ytOrderApply 对象数据
    * @return 对象数组
    */
    List<YtOrderApply> findAll(YtOrderApply ytOrderApply);

    /**
    * 修改任意数据
    * @param ytOrderApply 对象数据
    * @return 对象数组
    */
    int modifyAll(YtOrderApply ytOrderApply);
}
