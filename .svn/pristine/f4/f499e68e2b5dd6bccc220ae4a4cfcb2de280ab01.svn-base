package com.it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import com.it.context.support.ColumnBean;
import com.it.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<ColumnBean> queryTableDetail(String tableName) {
		String sql = "SELECT * FROM " + tableName + " WHERE 1 =2";
		SqlRowSet rs = template.queryForRowSet(sql);
		SqlRowSetMetaData rsm = rs.getMetaData();

		int columnCount = rsm.getColumnCount();
		List<ColumnBean> columnList = new ArrayList<ColumnBean>();
		for (int i = 1; i < columnCount+1; i++) {
			ColumnBean colunmBean = new ColumnBean(rsm.getColumnName(i),rsm.getColumnType(i),rsm.getColumnTypeName(i));
			columnList.add(colunmBean);
		}
		return columnList;
	}

	public Map<String, List<ColumnBean>> queryBatchTableDetail(String tableNames) {
		String[] tables = tableNames.split(",");
		Map<String, List<ColumnBean>> result = new HashMap<String,List<ColumnBean>>();
		for(int i=0;i<tables.length;i++){
			result.put(tables[i], queryTableDetail(tables[i]));
		}
		return result;
	}
}
