package xuan.wen.qin.ssm.common.ibatis.plugin.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xuan.wen.qin.ssm.common.ibatis.plugin.PageInterceptor;
import xuan.wen.qin.ssm.common.web.servlet.PageModel;

/**
 * PageInterceptorImpl<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月27日下午4:09:23
 * @Version 1.0
 * @Address by siShangJie
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PageInterceptorImpl implements PageInterceptor {
	private static final Logger logger = LoggerFactory
			.getLogger(PageInterceptorImpl.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		PageModel<?> pageModel = null;
		if (invocation.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler handler = (RoutingStatementHandler) invocation
					.getTarget();
			StatementHandler delegate = (StatementHandler) this.getField(
					handler, "delegate");
			BoundSql boundSql = delegate.getBoundSql();
			Object parameterObject = boundSql.getParameterObject();
			pageModel = this.getPageModel(parameterObject);
			if (null != pageModel) {
				String sql = boundSql.getSql();
				String countSql = this.getCountSql(sql);
				Connection connection = (Connection) invocation.getArgs()[0];
				int count = this.getCount(connection, countSql);
				pageModel.setTotal(count);
				String pageSql = this.getPageSql(pageModel, sql);
				this.setFieldValue(boundSql, "sql", pageSql);
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

	/***
	 * 通过反射获取成员变量
	 * 
	 * @param instance
	 *            目标
	 * @param fieldName
	 *            目标成员变量名称
	 * @return 成员变量
	 * @throws Throwable
	 */
	private Field getFileByName(Object instance, String fieldName)
			throws Throwable {
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field;
	}

	/***
	 * 通过反射获取成员变量的值
	 * 
	 * @param instance
	 *            目标
	 * @param fieldName
	 *            目标成员变量名称
	 * @return 成员变量的值
	 * @throws Throwable
	 */
	private Object getField(Object instance, String fieldName) throws Throwable {
		Field field = this.getFileByName(instance, fieldName);
		return field.get(instance);
	}

	/***
	 * 通过反射设置成员变量的值
	 * 
	 * @param instance
	 *            目标
	 * @param fieldName
	 *            目标成员变量名称
	 * @param fieldValue
	 *            成员变量的值
	 * @throws Throwable
	 */
	private void setFieldValue(Object instance, String fieldName,
			Object fieldValue) throws Throwable {
		Field field = this.getFileByName(instance, fieldName);
		field.setAccessible(true);
		field.set(instance, fieldValue);
	}

	/***
	 * 拼装查询总数sql
	 * 
	 * @param sql
	 *            目标sql
	 * @return 查询总数sql
	 */
	private String getCountSql(String sql) {
		StringBuilder result = new StringBuilder(" SELECT COUNT(*) ");
		int fromIndex = sql.toUpperCase().indexOf("FROM");
		int orderIndex = sql.toUpperCase().indexOf("ORDER");
		orderIndex = orderIndex > 0 ? orderIndex : sql.length();
		sql = sql.substring(fromIndex, orderIndex);
		result.append(sql);
		return result.toString();
	}

	/***
	 * 获取总数
	 * 
	 * @param connection
	 *            数据库连接
	 * @param sql
	 *            查询总数sql
	 * @return 总条数
	 * @throws Throwable
	 */
	private int getCount(Connection connection, String sql) throws Throwable {
		int result = 0;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			result = resultSet.getInt(1);
		}
		resultSet.close();
		statement.close();
		return result;
	}

	/***
	 * 获取分页参数
	 * 
	 * @param parameterObject
	 *            查询参数
	 * @return 分页参数实体
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	private PageModel<?> getPageModel(Object parameterObject) throws Throwable {
		PageModel<?> pageModel = null;
		if (parameterObject instanceof PageModel) {
			pageModel = (PageModel<?>) parameterObject;
		} else if (parameterObject instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) parameterObject;
			if (map.containsKey("pageModel")) {
				pageModel = (PageModel<?>) map.get("pageModel");
			}
		} else {
			Field pageField = this.getFileByName(parameterObject, "pageModel");
			if (null != pageField) {
				pageModel = (PageModel<?>) this.getField(parameterObject,
						"pageModel");
			}
		}
		return pageModel;

	}

	/***
	 * 拼接分页SQL
	 * 
	 * @param pageModel
	 *            分页实体
	 * @param sql
	 *            原SQL
	 * @return 分页SQL
	 */
	private String getPageSql(PageModel pageModel, String sql) {
		StringBuilder result = new StringBuilder(sql);
		result.append(" LIMIT ").append(pageModel.getStartRow()).append(" , ")
				.append(pageModel.getPageSize());
		return result.toString();
	}
}
