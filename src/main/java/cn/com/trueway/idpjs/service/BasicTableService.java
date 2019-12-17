package cn.com.trueway.idpjs.service;

import java.util.List;
import java.util.Map;

import cn.com.trueway.zdcy.entity.ContinueZtd;

/**
 * 续建重特大项目情况
 * @author King1995
 * @date 2019年5月30日
 *
 */
public interface BasicTableService {
	
	/**
	 * 查询所有数据或某条数据
	 * Map集合存放 表名，字段集合 
	 * @param paramMap
	 * @return
	 */
	List<Map<String,Object>> toShow(Map<String, Object> paramMap);
	
	/**
	 * Map集合中存放 表名、字段集合、数据集合
	 * @param paramMap
	 * @return 受影响的行数
	 */
	Integer insertTables(Map<String, Object> paramMap);
	
	/**
	 * 特殊方式批量更新
	 * @param paramMap
	 * @return
	 */
	Integer updateTablesX(Map<String, Object> paramMap);
}
