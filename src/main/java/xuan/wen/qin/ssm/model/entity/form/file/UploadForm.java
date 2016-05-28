package xuan.wen.qin.ssm.model.entity.form.file;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UploadForm<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午3:32:13
 * @Version 1.0
 * @Address by siShangJie
 */
@Data
@ToString(exclude = { "logger" })
public class UploadForm {
	private static final Logger logger = LoggerFactory
			.getLogger(UploadForm.class);
	@NotEmpty(message = "{image.form.path}")
	@Size(min = 2, max = 255, message = "{image.form.path.size}")
	@Pattern(regexp = "(/\\w+)+/$", message = "{image.form.path.format}")
	/** 相对路径 */
	private String path;
	private String originalFileName;
	private String fileName;
	private String extension;

	public void setOriginalFilename(String filename) {
		this.originalFileName = filename;
		int pointIndex = filename.lastIndexOf(".");
		this.extension = filename.substring(pointIndex);
		logger.debug("extension: {}", this.extension);
	}
}
