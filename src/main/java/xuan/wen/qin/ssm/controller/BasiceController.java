package xuan.wen.qin.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import xuan.wen.qin.ssm.common.exception.SsmVaildException;
import xuan.wen.qin.ssm.service.TestService;

/**
 * BasiceController<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午10:42:43
 * @Version 1.0
 * @Address by siShangJie
 */
@Controller
public abstract class BasiceController {
	protected static final String CODE = "code";
	protected static final String MESSAGE = "message";
	@Autowired(required = true)
	@Qualifier(value = "testService")
	protected TestService testService;

	protected void valided(BindingResult error) {
		if (error.hasErrors()) {
			throw new SsmVaildException(error.getFieldError()
					.getDefaultMessage());
		}

	}
}
