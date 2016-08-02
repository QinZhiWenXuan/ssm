package xuan.wen.qin.ssm.common.utils.io.impl;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import xuan.wen.qin.ssm.common.utils.io.FileTools;

/**
 * FileToolsImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午12:05:18
 * @Version 1.0
 * @Address by siShangJie
 */
@Component(value = "fileTools")
public class FileToolsImpl implements FileTools {
	private static final Logger logger = LoggerFactory
			.getLogger(FileToolsImpl.class);
	private static final int width = 240;
	private static final int height = 240;

	/***
	 * 保存文件
	 * 
	 * @param target
	 *            保存目标
	 * @param source
	 *            保存原文件
	 * @throws IOException
	 */
	@Override
	@Async
	public void save(File target, File source) throws IOException {
		logger.debug("save begin ....");
		Thumbnails.of(source).size(width, height).toFile(target);
		logger.debug("save end ....");
	}

	/***
	 * 创建目录
	 * 
	 * @param directory
	 *            目录
	 */
	@Override
	public void makeDir(String directory) {
		if (StringUtils.hasText(directory)) {
			this.makeDir(new File(directory));
		}

	}

	/***
	 * 创建目录
	 * 
	 * @param directory
	 *            目录
	 */
	@Override
	public void makeDir(File directory) {
		if (null != directory) {
			if (!directory.exists()) {
				directory.mkdirs();
			}
		}

	}
}
