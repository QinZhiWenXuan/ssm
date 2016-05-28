package xuan.wen.qin.ssm.model.entity.form.file;

import java.io.File;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/**
 * ImageForm<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午2:10:59
 * @Version 1.0
 * @Address by siShangJie
 */
@Data
@NoArgsConstructor
@ToString(exclude = { "logger" })
public class ImageForm {
	private static final Logger logger = LoggerFactory
			.getLogger(ImageForm.class);
	private final static String JPEG_EXTENSION = ".jpg";
	private final static String PNG_EXTENSION = ".png";
	private final static String GIF_EXTENSION = ".gif";
	@NotEmpty(message = "{image.form.filename}")
	private String fileName;
	private String path;
	private String absolutePath;

	public void parse(String uri) {
		String absolutePath = uri.replace("/new/async", "")
				.replace(".jspx", "");
		String path = absolutePath.replace("/" + fileName, "");
		this.absolutePath = absolutePath;
		this.path = path;
	}

	public File getFile(String home) {
		logger.debug("ImageForm get file home : {}", home);
		return new File(home + absolutePath + JPEG_EXTENSION);
	}

	public Optional<File> getSourceFile(String home) {
		List<String> filenames = possible(home + absolutePath);
		File sourceFile = null;
		for (String filename : filenames) {
			File possibleFile = new File(filename);
			if (possibleFile.exists()) {
				sourceFile = possibleFile;
				break;
			}
		}
		Optional<File> optional = Optional.fromNullable(sourceFile);
		return optional;
	}

	private List<String> possible(String filename) {
		return Lists.newArrayList(filename + JPEG_EXTENSION, filename
				+ PNG_EXTENSION.toUpperCase(), filename + GIF_EXTENSION,
				filename + GIF_EXTENSION.toUpperCase());
	}
}
