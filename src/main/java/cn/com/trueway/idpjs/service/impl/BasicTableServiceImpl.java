package cn.com.trueway.zdcy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.trueway.zdcy.mapper.BasicTableMapepr;
import cn.com.trueway.zdcy.service.BasicTableService;

/**
 * 续建重特大项目情况实现类
 * @author King1995
 * @date 2019年5月30日
 *
 */

@Service("baseTableService")
public class BasicTableServiceImpl implements BasicTableService {

	@Autowired
	private BasicTableMapepr baseTableMapepr;

	@Override
	public List<Map<String, Object>> toShow(Map<String, Object> paramMap) {
		List<Map<String, Object>> resultList = baseTableMapepr.toShow(paramMap);
		return resultList;
	}

	@Override
	public Integer insertTables(Map<String, Object> paramMap) {
		Integer affecteds =baseTableMapepr.insertTables(paramMap);
		return affecteds;
	}

	@Override
	public Integer updateTablesX(Map<String, Object> paramMap) {
		Integer affecteds =baseTableMapepr.updateTablesX(paramMap);
		return affecteds;
	}

}
