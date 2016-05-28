package xuan.wen.qin.ssm.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import xuan.wen.qin.ssm.model.entity.form.file.ImageForm;
import xuan.wen.qin.ssm.model.entity.form.file.UploadForm;

/**
 * FileService<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午12:16:31
 * @Version 1.0
 * @Address by siShangJie
 */
public interface FileService extends BasiceService {

	/***
	 * 把图片写出去
	 * 
	 * @param form
	 *            图片参数
	 * @param outputStream
	 *            OutputStream
	 * @throws IOException
	 */
	void load(ImageForm form, OutputStream outputStream) throws IOException;

	/***
	 * 图片上传
	 * 
	 * @param form
	 *            图片参数
	 * @param inputStream
	 *            InputStream
	 * @return 文件名
	 * @throws IOException
	 */
	String upload(UploadForm form, InputStream inputStream) throws IOException;

}
