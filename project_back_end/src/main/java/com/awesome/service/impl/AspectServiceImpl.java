package com.awesome.service.impl;

import com.awesome.entity.Aspect;
import com.awesome.entity.Mark;
import com.awesome.mapper.AspectMapper;
import com.awesome.service.IAspectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yiqi Li
 */
@Service
public class AspectServiceImpl extends ServiceImpl<AspectMapper, Aspect> implements IAspectService {
}
