package com.it.context.support;

public class PropertiesBean {
	private String name;
	private String type;
	private String columnName;

	public PropertiesBean() {
	};

	public PropertiesBean(String name, String type, String columnName) {
		this.name = name;
		this.type = type;
		this.columnName = columnName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
