package com.black.mapper;

import com.black.entity.OrderApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BlackJun
 * @since 2024-12-03 14:33:28
 */
@Mapper
public interface OrderApplyMapper extends BaseMapper<OrderApply> {
      /**
      * 查询任意数据
      * @param orderApply 对象数据
      * @return 对象数组
      */
      List<OrderApply> selectAll(OrderApply orderApply);

      /**
      * 修改任意数据
      * @param orderApply 对象数据
      * @return 对象数组
      */
      int updateAll(OrderApply orderApply);
}
