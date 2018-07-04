package com.it.context.support;

import java.util.List;

import com.it.util.BeanUtil;

public class GeneratorBean {

	// 主键类型
	private String keyType;
	private String packageName;
	private String tableName;
	private String poClassName;
	private String poPackage;
	private String paramPoClassName;
	private String daoClassName;
	private String paramDaoClassName;
	private String daoPackageName;
	private String servicePackage;
	private String serviceClassName;
	private String paramServiceClassName;
	private String serviceImplPackage;
	private String serviceImplClassName;
	private String mapperName;
	private String controllerClassName;
	private String paramControllerClassName;
	private String controllerPackageName;

	private List<PropertiesBean> poProperties;

	public GeneratorBean() {
	};

	public GeneratorBean(String packageName, String tableName) {
		String className = BeanUtil.upperFirstChar(tableName);
		this.packageName = packageName;
		this.tableName = tableName;
		this.poPackage = packageName + ".po";
		this.poClassName = className;
		this.paramPoClassName = new StringBuilder().append(Character.toLowerCase(poClassName.charAt(0)))
				.append(poClassName.substring(1)).toString();
		this.daoPackageName = packageName + ".dao";
		this.daoClassName = className + "Dao";
		this.paramDaoClassName = new StringBuilder().append(Character.toLowerCase(daoClassName.charAt(0)))
				.append(daoClassName.substring(1)).toString();
		this.serviceClassName = "I" + className + "Service";
		this.paramServiceClassName = new StringBuilder().append(Character.toLowerCase(serviceClassName.charAt(1)))
				.append(serviceClassName.substring(2)).toString();
		this.servicePackage = packageName + ".service";
		this.serviceImplClassName = className + "Service";
		this.serviceImplPackage = packageName + ".service.impl";
		this.mapperName = className + "Dao";
		this.controllerClassName = className + "Controller";
		this.controllerPackageName = packageName + ".controller";
		this.paramControllerClassName = new StringBuilder().append(Character.toLowerCase(controllerClassName.charAt(0)))
				.append(controllerClassName.substring(1)).toString();
		this.keyType = "Long";
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPoClassName() {
		return poClassName;
	}

	public void setPoClassName(String poClassName) {
		this.poClassName = poClassName;
	}

	public String getPoPackage() {
		return poPackage;
	}

	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}

	public String getDaoClassName() {
		return daoClassName;
	}

	public void setDaoClassName(String daoClassName) {
		this.daoClassName = daoClassName;
	}

	public String getDaoPackageName() {
		return daoPackageName;
	}

	public void setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
	}

	public String getServiceClassName() {
		return serviceClassName;
	}

	public void setServiceClassName(String serviceClassName) {
		this.serviceClassName = serviceClassName;
	}

	public String getServiceImplClassName() {
		return serviceImplClassName;
	}

	public void setServiceImplClassName(String serviceImplClassName) {
		this.serviceImplClassName = serviceImplClassName;
	}

	public String getMapperName() {
		return mapperName;
	}

	public void setMapperName(String mapperName) {
		this.mapperName = mapperName;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getServiceImplPackage() {
		return serviceImplPackage;
	}

	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}

	public List<PropertiesBean> getPoProperties() {
		return poProperties;
	}

	public void setPoProperties(List<PropertiesBean> poProperties) {
		this.poProperties = poProperties;
	}

	public String getParamDaoClassName() {
		return paramDaoClassName;
	}

	public void setParamDaoClassName(String paramDaoClassName) {
		this.paramDaoClassName = paramDaoClassName;
	}

	public String getParamServiceClassName() {
		return paramServiceClassName;
	}

	public void setParamServiceClassName(String paramServiceClassName) {
		this.paramServiceClassName = paramServiceClassName;
	}

	public String getParamPoClassName() {
		return paramPoClassName;
	}

	public void setParamPoClassName(String paramPoClassName) {
		this.paramPoClassName = paramPoClassName;
	}

	public String getControllerClassName() {
		return controllerClassName;
	}

	public void setControllerClassName(String controllerClassName) {
		this.controllerClassName = controllerClassName;
	}

	public String getParamControllerClassName() {
		return paramControllerClassName;
	}

	public void setParamControllerClassName(String paramControllerClassName) {
		this.paramControllerClassName = paramControllerClassName;
	}

	public String getControllerPackageName() {
		return controllerPackageName;
	}

	public void setControllerPackageName(String controllerPackageName) {
		this.controllerPackageName = controllerPackageName;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
}