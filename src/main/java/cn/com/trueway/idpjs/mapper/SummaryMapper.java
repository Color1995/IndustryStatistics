package cn.com.trueway.idpjs.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface SummaryMapper {
	
	/**
	 * Map集合存放 表名，字段集合 
	 * @param paramMap
	 * @return 返回 List<Map<String,Object>>
	 */
	List<LinkedHashMap<String,Object>> toShow(Map<String, Object> paramMap);
	
	/**
	 * Map集合中存放 表名、字段集合、数据集合
	 * @param paramMap
	 * @return 受影响的行数
	 */
	Integer insertTables(Map<String, Object> paramMap);
}
