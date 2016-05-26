package xuan.wen.qin.ssm.model.entity.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * TestEditForm<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月26日下午5:42:06
 * @Version 1.0
 * @Address by siShangJie
 */
@Data
public class TestEditForm {
	@Min(value = 1, message = "{test.id.size}")
	private int id;
	@Size(max = 32, min = 2, message = "{test.remark.size}")
	private String remark;
	@Size(max = 32, min = 2, message = "{test.description.size}")
	private String description;
}
