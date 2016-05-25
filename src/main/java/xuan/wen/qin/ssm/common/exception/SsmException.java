package xuan.wen.qin.ssm.common.exception;

/**
 * SsmException<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日上午11:32:13
 * @Version 1.0
 * @Address by siShangJie
 */
public class SsmException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SsmException() {
		super();
	}

	public SsmException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SsmException(String message, Throwable cause) {
		super(message, cause);
	}

	public SsmException(String message) {
		super(message);
	}

	public SsmException(Throwable cause) {
		super(cause);
	}

}
