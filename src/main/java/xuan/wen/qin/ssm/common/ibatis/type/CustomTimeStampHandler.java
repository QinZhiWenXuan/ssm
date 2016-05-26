package xuan.wen.qin.ssm.common.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CustomTimeStampHandler<br>
 * 
 * @Remark 自定义日期类型转换
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月26日下午1:46:04
 * @Version 1.0
 * @Address by siShangJie
 */
public class CustomTimeStampHandler extends BaseTypeHandler<Date> {
	private static final Logger logger = LoggerFactory
			.getLogger(CustomTimeStampHandler.class);
	private final static String EXPRESSION = "yyyy-MM-dd HH:mm:ss";
	private final static DateFormat DATEFORMAT = new SimpleDateFormat(
			EXPRESSION);

	@Override
	public Date getNullableResult(ResultSet resultSet, String param)
			throws SQLException {
		Date date = null;
		try {
			String sqlTimestamp = resultSet.getString(param);
			if (sqlTimestamp != null) {
				date = DATEFORMAT.parse(sqlTimestamp);
			}
		} catch (Exception e) {
			logger.error("date format fail : {}", e.getLocalizedMessage());
		}
		return date;
	}

	@Override
	public Date getNullableResult(ResultSet resultSet, int param)
			throws SQLException {
		Date date = null;
		try {
			String sqlTimestamp = resultSet.getString(param);
			if (sqlTimestamp != null) {
				date = DATEFORMAT.parse(sqlTimestamp);
			}
		} catch (Exception e) {
			logger.error("date format fail : {}", e.getLocalizedMessage());
		}
		return date;
	}

	@Override
	public Date getNullableResult(CallableStatement statement, int param)
			throws SQLException {
		Date date = null;
		try {
			String sqlTimestamp = statement.getString(param);
			if (sqlTimestamp != null) {
				date = DATEFORMAT.parse(sqlTimestamp);
			}
		} catch (Exception e) {
			logger.error("date format fail : {}", e.getLocalizedMessage());
		}
		return date;
	}

	@Override
	public void setNonNullParameter(PreparedStatement statement, int param,
			Date date, JdbcType type) throws SQLException {
		statement.setString(param, String.valueOf(date.getTime()));
	}

}
