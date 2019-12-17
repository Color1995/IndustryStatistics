package cn.com.trueway.zdcy.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.com.trueway.zdcy.entity.formul;

public interface FormulaService {
	
	/**
	 * 查询所有数据或某条数据
	 * Map集合存放 表名，字段集合 
	 * @param paramMap
	 * @return
	 */
	List<LinkedHashMap<String,Object>> toShow(Map<String, Object> paramMap);
	
	/**
	 * Map集合中存放 表名、字段集合、数据集合
	 * @param paramMap
	 * @return 受影响的行数
	 */
	Integer updateTables(Map<String, Object> paramMap);

	/**
	 * 计算的方法
	 * @param paramMap
	 * @return
	 */
	Double formulaCount(Map<String, Object> paramMap);
	
	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	Integer insertTable(Map<String, Object> paramMap);
	//用于将县市区的公式变成字节形式
	Map<String, Object> formulaalllist();
}
