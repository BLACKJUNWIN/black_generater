package com.black.mapper;

import com.black.entity.YtOrderApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BlackJun
 * @since 2024-12-03 11:59:30
 */
@Mapper
public interface YtOrderApplyMapper extends BaseMapper<YtOrderApply> {
      /**
      * 查询任意数据
      * @param ytOrderApply 对象数据
      * @return 对象数组
      */
      List<YtOrderApply> selectAll(YtOrderApply ytOrderApply);

      /**
      * 修改任意数据
      * @param ytOrderApply 对象数据
      * @return 对象数组
      */
      int updateAll(YtOrderApply ytOrderApply);
}
