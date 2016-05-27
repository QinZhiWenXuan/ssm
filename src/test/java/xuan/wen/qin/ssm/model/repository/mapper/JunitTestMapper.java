package xuan.wen.qin.ssm.model.repository.mapper;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xuan.wen.qin.ssm.common.web.servlet.PageModel;
import xuan.wen.qin.ssm.model.entity.form.TestEditForm;
import xuan.wen.qin.ssm.model.entity.form.TestSaveForm;
import xuan.wen.qin.ssm.model.entity.vo.TestVO;

/**
 * JunitTestMapper<br>
 * 
 * @Remark
 * @Author xuan
 * @Email qinzhiwenxuan@gmail.com
 * @Date 2016年5月26日下午2:47:02
 * @Version 1.0
 * @Address by siShangJie
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:*-test.xml" })
public class JunitTestMapper {
	private static final Logger logger = LoggerFactory
			.getLogger(JunitTestMapper.class);
	@Autowired(required = true)
	@Qualifier(value = "testMapper")
	private TestMapper testMapper;
	private static final int ID = 2;

	@Test
	public void save() {
		TestSaveForm form = new TestSaveForm();
		form.setRemark("瞧瞧你们这群咸鱼");
		form.setDescription("这是备注。。。");
		testMapper.save(form);
		logger.debug("save : {}", form.toString());
	}

	@Test
	public void query() {
		List<Map<String, ?>> infoColl = testMapper.query();
		for (Map<String, ?> info : infoColl) {
			logger.debug("query : {}", info.toString());
		}
	}

	@Test
	public void queryForVO() {
		List<TestVO> listColl = testMapper.queryForVO();
		for (TestVO vo : listColl) {
			logger.debug("queryForVO : {}", vo.toString());
		}
	}

	@Test
	public void queryById() {
		Map<String, ?> info = testMapper.queryById(ID);
		logger.debug("queryById : {}", info.toString());
	}

	@Test
	public void deleteById() {
		testMapper.deleteById(ID);
	}

	@Test
	public void removeById() {
		testMapper.removeById(ID);
	}

	@Test
	public void update() {
		TestEditForm form = new TestEditForm();
		form.setId(ID);
		form.setRemark("瞧瞧你们这群咸鱼。--来这远方的猫");
		form.setDescription("This is description ...");
		testMapper.update(form);
	}

	@Test
	public void queryByPage() {
		PageModel<Map<String, ?>> pageModel = new PageModel<Map<String, ?>>();
		pageModel.setPageIndex(2);
		pageModel.setPageSize(2);
		List<Map<String, ?>> listColl = testMapper.queryByPage(pageModel);
		pageModel.setDataColl(listColl);
		logger.debug("queryByPage : {}", listColl.toString());
		logger.debug("pageModel : {}", pageModel.toString());
	}
}
