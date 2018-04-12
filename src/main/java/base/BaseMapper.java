package base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseMapper<T, ID extends Serializable> {

	T selectByPrimaryKey(ID id);

	@SuppressWarnings("rawtypes")
	List<T> selectByMap(Map map);

	@SuppressWarnings("rawtypes")
	long countByMap(Map map);

	int deleteByPrimaryKey(ID id);

	int insert(T record);

	int updateByPrimaryKeySelective(T record);

}
