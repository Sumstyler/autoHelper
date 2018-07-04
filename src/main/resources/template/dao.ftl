package ${daoPackageName};

import org.apache.ibatis.annotations.Mapper;
import ${packageName}.common.BaseMapper;
import ${poPackage}.${poClassName};

@Mapper
public interface ${daoClassName} extends BaseMapper<${poClassName}, ${keyType}> {
	
}
