package cn.chnzxg.yhx.config;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.SqlServerMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author chnzxg
 * @date 2020/11/3 11:38 上午
 */
public interface BaseMapper<T> extends BaseSelectMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T>, SqlServerMapper<T>,
        ConditionMapper<T>, RowBoundsMapper<T>, InsertListMapper<T>, Marker {
}
