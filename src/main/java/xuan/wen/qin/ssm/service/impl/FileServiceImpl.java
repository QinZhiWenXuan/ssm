package xuan.wen.qin.ssm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.stereotype.Service;

import xuan.wen.qin.ssm.model.entity.form.file.ImageForm;
import xuan.wen.qin.ssm.model.entity.form.file.UploadForm;
import xuan.wen.qin.ssm.service.FileService;

import com.google.common.base.Optional;
import com.google.common.io.ByteStreams;

/**
 * FileServiceImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午12:16:52
 * @Version 1.0
 * @Address by siShangJie
 */
@Service(value = "fileService")
public class FileServiceImpl extends BasiceServiceImpl implements FileService {
	private static final int width = 240;
	private static final int height = 240;
	private final static String JPEG = "jpg";

	/***
	 * 把图片写出去
	 * 
	 * @param form
	 *            图片参数
	 * @param outputStream
	 *            OutputStream
	 * @throws IOException
	 */
	@Override
	public void load(ImageForm form, OutputStream outputStream)
			throws IOException {
		File targetFile = form.getFile(rootPath);
		if (targetFile.exists()) {
			FileInputStream in = new FileInputStream(targetFile);
			byte[] byteArr = ByteStreams.toByteArray(in);
			outputStream.write(byteArr);
		} else {
			Optional<File> optional = form.getSourceFile(rootPath);
			if (optional.isPresent()) {
				File sourceFile = optional.get();
				Thumbnails.of(sourceFile).size(width, height)
						.toOutputStream(outputStream);
				fileTools.save(targetFile, sourceFile);
			}
		}
	}

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
	@Override
	public String upload(UploadForm form, InputStream inputStream)
			throws IOException {
		String directoryPath = rootPath + form.getPath();
		File directory = new File(directoryPath);
		fileTools.makeDir(directory);
		String fileName = UUID.randomUUID().toString().toUpperCase()
				.replaceAll("-", "");
		String fullName = directoryPath + fileName;
		File targetFile = new File(fullName);
		Thumbnails.of(inputStream).size(width, height).outputFormat(JPEG)
				.toFile(targetFile);
		return fileName;
	}

}
