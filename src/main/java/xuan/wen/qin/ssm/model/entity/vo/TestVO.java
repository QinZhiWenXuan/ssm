package xuan.wen.qin.ssm.model.entity.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * TestVO<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月26日下午2:41:49
 * @Version 1.0
 * @Address by siShangJie
 */
@Data
public class TestVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String remark;
	private String description;
	private boolean deleted;
	private Date addTime;
	private Date editTime;
}
