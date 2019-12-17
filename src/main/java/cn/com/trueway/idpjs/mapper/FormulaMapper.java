package cn.com.trueway.idpjs.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.com.trueway.idpjs.entity.formul;

public interface FormulaMapper {
	
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
	Integer updateTables(Map<String, Object> paramMap);
	
	/**
	 * Map集合中存放 表名、字段集合、数据集合
	 * @param paramMap
	 * @return 受影响的行数
	 */
	Integer insertAllTables(Map<String, Object> paramMap);

	
	Integer insertTable(Map<String, Object> paramMap);
	
	Double formulaCount(Map<String, Object> paramMap);
	//用于将县市区的公式变成字节形式
	Map<String,Object> formulaalllist();
}
