package ${serviceImplPackage};

import org.springframework.stereotype.Service;

import ${packageName}.common.BaseDao;
import ${poPackage}.${poClassName};

@Service
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
