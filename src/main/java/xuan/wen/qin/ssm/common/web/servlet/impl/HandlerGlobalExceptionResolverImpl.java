package xuan.wen.qin.ssm.common.web.servlet.impl;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import xuan.wen.qin.ssm.common.exception.SsmVaildException;
import xuan.wen.qin.ssm.common.web.servlet.HandlerGlobalExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * HandlerGlobalExceptionResolverImpl<br>
 * 
 * @Remark 全局异常处理interface implements
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月25日下午5:57:29
 * @Version 1.0
 * @Address by siShangJie
 */
@Component(value = "handlerGlobalExceptionResolver")
public class HandlerGlobalExceptionResolverImpl implements
		HandlerGlobalExceptionResolver {
	private static final Logger logger = LoggerFactory
			.getLogger(HandlerGlobalExceptionResolverImpl.class);
	private static final ObjectMapper mapper = new ObjectMapper();

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		PrintWriter print = null;
		ModelAndView mav = new ModelAndView();
		/** 设置返回状态码 */
		response.setStatus(HttpStatus.OK.value());
		/** 设置返回ContentType */
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		/** 避免乱码 */
		response.setCharacterEncoding("UTF-8");
		/** 设置返回header */
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		Map<String, String> resutl = new HashMap<String, String>(2);
		resutl.put("code", "500");
		String message = "server data anomalies";
		try {
			print = response.getWriter();
			if (ex instanceof SsmVaildException) {
				message = ex.getLocalizedMessage();
				if (StringUtils.hasText(message)) {
					resutl.put("code", "400");
				}
			}
			resutl.put("message", message);
			String json = mapper.writeValueAsString(resutl);
			logger.error("全局异常处理信息 : {}", ex.getLocalizedMessage());
			print.write(json);
		} catch (Exception e) {
			logger.error("全局异常处理 失败: {}", e.getLocalizedMessage());
		} finally {
			if (null != print) {
				print.close();
			}
		}
		return mav;
	}

}
