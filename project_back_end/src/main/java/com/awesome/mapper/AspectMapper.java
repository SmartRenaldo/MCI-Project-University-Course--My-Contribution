package com.awesome.mapper;

import com.awesome.entity.Aspect;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yiqi Li
 */
@Mapper
public interface AspectMapper extends BaseMapper<Aspect> {
}
