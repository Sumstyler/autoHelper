package base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T, ID extends Serializable> {
	void setBaseMapper();

	T selectByPrimaryKey(ID id);

	@SuppressWarnings("rawtypes")
	List<T> selectByMap(Map map);

	@SuppressWarnings("rawtypes")
	PageBean selectPageByMap(Map map, PageBean pb);

	int deleteByPrimaryKey(ID id);

	int insert(T record);

	int updateByPrimaryKeySelective(T record);
}
