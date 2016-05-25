package xuan.wen.qin.ssm.model.entity.form;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * TestSaveForm<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:42:15
 * @Version 1.0
 * @Address by siShangJie
 */
@Data
public class TestSaveForm {
	private int id;
	@Size(max = 32, min = 2, message = "{test.save.remark.size}")
	private String remark;
	@Size(max = 32, min = 2, message = "{test.save.description.size}")
	private String description;
}
