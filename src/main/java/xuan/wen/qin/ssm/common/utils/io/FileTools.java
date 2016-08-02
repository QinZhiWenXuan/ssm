package xuan.wen.qin.ssm.common.utils.io;

import java.io.File;
import java.io.IOException;

/**
 * FileTools<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月28日下午12:05:01
 * @Version 1.0
 * @Address by siShangJie
 */
public interface FileTools {

	/***
	 * 保存文件
	 * 
	 * @param target
	 *            保存目标
	 * @param source
	 *            保存原文件
	 * @throws IOException
	 */
	void save(File target, File source) throws IOException;

	/***
	 * 创建目录
	 * 
	 * @param directory
	 *            目录
	 */
	void makeDir(String directory);

	/***
	 * 创建目录
	 * 
	 * @param directory
	 *            目录
	 */
	void makeDir(File directory);
}
