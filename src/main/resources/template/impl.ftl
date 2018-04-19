package ${serviceImplPackage};

import org.springframework.stereotype.Repository;
import com.mountain.springboot.common.BaseDao;
import ${poPackage}.${poClassName};

@Repository
public class ${serviceImplClassName} extends AbstractService<${poClassName}, Long> implements
		${serviceClassName} {
	
	@Autowired
	private ${daoClassName} ${paramDaoClassName};
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(${paramDaoClassName});
	}
}
