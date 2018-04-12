package base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<T, ID extends Serializable> implements
		BaseService<T, ID> {
	private BaseMapper<T, ID> baseMapper;

	public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
		this.baseMapper = baseMapper;
	}

	public T selectByPrimaryKey(ID id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@SuppressWarnings("rawtypes")
	public List<T> selectByMap(Map map) {
		return baseMapper.selectByMap(map);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean<T> selectPageByMap(Map map, PageBean pb) {

		map.put(PageConstant.PAGE_SIZE, pb.getPageSize());
		map.put(PageConstant.START_INDEX, pb.getStart());

		long pageCount = baseMapper.countByMap(map);
		if (pageCount == 0) {
			return pb;
		}
		pb.setPageCount(pageCount);
		List<T> rows = baseMapper.selectByMap(map);

		pb.setRows(rows);
		return pb;

	}

	@Transactional
	public int deleteByPrimaryKey(ID id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	public int insert(T record) {
		return baseMapper.insert(record);
	}

	@Transactional
	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

}
