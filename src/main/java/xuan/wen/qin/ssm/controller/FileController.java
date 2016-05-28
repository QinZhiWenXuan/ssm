package xuan.wen.qin.ssm.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import xuan.wen.qin.ssm.model.entity.form.file.ImageForm;
import xuan.wen.qin.ssm.model.entity.form.file.UploadForm;

/**
 * FileController<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日上午11:05:48
 * @Version 1.0
 * @Address by siShangJie
 */
@Controller
@RequestMapping(value = "/file/")
public class FileController extends BasiceController {
	private static final Logger logger = LoggerFactory
			.getLogger(FileController.class);

	/***
	 * 异步输出图片
	 */
	@RequestMapping(value = "async/**/{fileName}.jspx", method = RequestMethod.GET)
	public StreamingResponseBody load(@Valid final ImageForm form,
			HttpServletRequest request, BindingResult error) {
		this.valided(error);
		form.parse(request.getRequestURI());
		logger.debug("{}", form);
		return new StreamingResponseBody() {
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				fileService.load(form, outputStream);
			}
		};
	}

	@RequestMapping(value = "upload.jspx", method = RequestMethod.GET)
	public void upload(HttpServletResponse response) {
		/** 返回204表示此文件块不存在，将会触发POST该文件块；返回200表示此文件块存在，将不会触发POST; */
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/***
	 * 上传
	 * 
	 * @param form
	 *            上传参数
	 * @param file
	 *            目标文件
	 * @return 上传结果
	 */
	@RequestMapping(value = "upload.jspx", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public Callable<Map<String, Object>> upload(@Valid final UploadForm form,
			@RequestParam("file") final MultipartFile file, BindingResult error) {
		this.valided(error);
		return new Callable<Map<String, Object>>() {
			@Override
			public Map<String, Object> call() throws Exception {
				String fileName = fileService.upload(form,
						file.getInputStream());
				return null;
			}

		};
	}
}
