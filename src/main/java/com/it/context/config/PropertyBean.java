package com.it.context.config;

public class PropertyBean {
	// 表名
	private String tables;
	// 生成包名
	private String packageName;
	// 生成目录
	private String genDir;
	// 模板路径
	private String templatePath = "template";

	private String poTemplateName = "po.ftl";
	private String daoTemplateName = "dao.ftl";
	private String mapperTemplateName = "mapper.ftl";
	private String serviceTemplateName = "service.ftl";
	private String serviceImplTemplateName = "impl.ftl";
	private String controllerTemplateName = "controller.ftl";

	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getGenDir() {
		return genDir;
	}

	public void setGenDir(String genDir) {
		this.genDir = genDir;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getPoTemplateName() {
		return poTemplateName;
	}

	public void setPoTemplateName(String poTemplateName) {
		this.poTemplateName = poTemplateName;
	}

	public String getDaoTemplateName() {
		return daoTemplateName;
	}

	public void setDaoTemplateName(String daoTemplateName) {
		this.daoTemplateName = daoTemplateName;
	}

	public String getMapperTemplateName() {
		return mapperTemplateName;
	}

	public void setMapperTemplateName(String mapperTemplateName) {
		this.mapperTemplateName = mapperTemplateName;
	}

	public String getServiceTemplateName() {
		return serviceTemplateName;
	}

	public void setServiceTemplateName(String serviceTemplateName) {
		this.serviceTemplateName = serviceTemplateName;
	}

	public String getServiceImplTemplateName() {
		return serviceImplTemplateName;
	}

	public void setServiceImplTemplateName(String serviceImplTemplateName) {
		this.serviceImplTemplateName = serviceImplTemplateName;
	}

	public String getControllerTemplateName() {
		return controllerTemplateName;
	}

	public void setControllerTemplateName(String controllerTemplateName) {
		this.controllerTemplateName = controllerTemplateName;
	}

}
