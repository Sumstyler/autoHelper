package com.it.context.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.it.context.config.PropertyBean;
import com.it.dao.BaseDao;
import com.it.util.BeanUtil;
import com.it.util.FreemarkerUtil;

import freemarker.template.TemplateException;

public class GenteratorProcessor {

	public PropertyBean propertyBean;
	private BaseDao baseDao;

	public PropertyBean getPropertyBean() {
		return propertyBean;
	}

	public void setPropertyBean(PropertyBean propertyBean) {
		this.propertyBean = propertyBean;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<GeneratorBean> getGeneratorBean(Map<String, List<ColumnBean>> map) {
		List<GeneratorBean> result = new ArrayList<GeneratorBean>();
		for (String key : map.keySet()) {
			GeneratorBean generatorBean = new GeneratorBean(propertyBean.getPackageName(),
					BeanUtil.upperFirstChar(key));
			List<ColumnBean> columnBeanList = map.get(key);
			List<PropertiesBean> poProperties = new ArrayList<PropertiesBean>();
			for (int i = 0; i < columnBeanList.size(); i++) {
				PropertiesBean propertiesBean = new PropertiesBean(
						BeanUtil.strToCamel(columnBeanList.get(i).getColumnName()),
						BeanUtil.dbType2JavaType(columnBeanList.get(i).getColumnType()));
				poProperties.add(propertiesBean);
			}
			generatorBean.setPoProperties(poProperties);
			result.add(generatorBean);
		}
		return result;
	}

	public List<GeneratorBean> parse() {
		Map<String, List<ColumnBean>> map = baseDao.queryBatchTableDetail(propertyBean.getTables());
		List<GeneratorBean> list = getGeneratorBean(map);
		return list;
	}

	public void generatorFile() {
		List<GeneratorBean> list = parse();
		String userDir = System.getProperty("user.dir");
		String classPath = ClassLoader.getSystemResource("").getPath();
		String templatePath = classPath + "/" + propertyBean.getTemplatePath();
		String genDir = userDir + "/" + propertyBean.getGenDir();

		for (int i = 0; i < list.size(); i++) {
			GeneratorBean generatorBean = list.get(i);
			Map<String, Object> data = BeanUtil.transBean2Map(list.get(i));
			try {
				// 生成PO
				FreemarkerUtil.generatorFile(data, templatePath, propertyBean.getPoTemplateName(), genDir,
						generatorBean.getPoClassName() + ".java");
				// 生成DAO
				FreemarkerUtil.generatorFile(data, templatePath, propertyBean.getDaoTemplateName(), genDir,
						generatorBean.getDaoClassName() + ".java");
				// 生成Mapper
				/*FreemarkerUtil.generatorFile(data, templatePath, propertyBean.getMapperTemplateName(), genDir,
						generatorBean.getMapperName() + ".xml");*/
				// 生成service
				FreemarkerUtil.generatorFile(data, templatePath, propertyBean.getServiceTemplateName(), genDir,
						generatorBean.getServiceClassName() + ".java");
				// 生成service实现
				FreemarkerUtil.generatorFile(data, templatePath, propertyBean.getServiceImplTemplateName(), genDir,
						generatorBean.getServiceImplClassName() + ".java");
				// 生成controller
				FreemarkerUtil.generatorFile(data, templatePath, propertyBean.getControllerTemplateName(), genDir,
						generatorBean.getControllerClassName() + ".java");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}

	}
}
