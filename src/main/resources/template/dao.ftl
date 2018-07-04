package ${daoPackageName};

import org.apache.ibatis.annotations.Mapper;
import com.mountain.springboot.common.BaseDao;
import ${poPackage}.${poClassName};

@Mapper
public interface ${daoClassName} extends BaseDao<${poClassName}, ${keyType}> {
	
}
