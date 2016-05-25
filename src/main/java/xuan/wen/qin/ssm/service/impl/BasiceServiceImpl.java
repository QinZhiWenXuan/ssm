package xuan.wen.qin.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xuan.wen.qin.ssm.model.repository.mapper.TestMapper;
import xuan.wen.qin.ssm.service.BasiceService;

/**
 * BasiceServiceImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:24:56
 * @Version 1.0
 * @Address by siShangJie
 */
@Service(value = "basiceService")
public abstract class BasiceServiceImpl implements BasiceService {
	@Autowired(required = true)
	@Qualifier(value = "testMapper")
	protected TestMapper testMapper;
}
