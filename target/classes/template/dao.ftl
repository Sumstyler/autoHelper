package ${daoPackageName};

import org.springframework.stereotype.Repository;
import com.mountain.springboot.common.BaseDao;
import ${poPackage}.${poClassName};

@Repository
public interface ${daoClassName} extends BaseDao<${poClassName}> {
	
	
}
