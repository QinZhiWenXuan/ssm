package xuan.wen.qin.ssm.common.exception;

/**
 * SsmVaildException<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日下午6:17:45
 * @Version 1.0
 * @Address by siShangJie
 */
public class SsmVaildException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SsmVaildException() {
		super();
	}

	public SsmVaildException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SsmVaildException(String message, Throwable cause) {
		super(message, cause);
	}

	public SsmVaildException(String message) {
		super(message);
	}

	public SsmVaildException(Throwable cause) {
		super(cause);
	}

}
