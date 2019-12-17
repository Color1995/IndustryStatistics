package cn.com.trueway.idpjs.mapper;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import cn.com.trueway.idpjs.entity.ContinueZtd;

/**
 * 
 * @author King1995
 *
 */
public interface BasicTableMapepr {
	
	/**
	 * Map集合存放 表名，字段集合 
	 * @param paramMap
	 * @return 返回 List<Map<String,Object>>
	 */
	List<Map<String,Object>> toShow(Map<String, Object> paramMap);
	
	/**
	 * Map集合中存放 表名、字段集合、数据集合
	 * @param paramMap
	 * @return 受影响的行数
	 */
	Integer insertTables(Map<String, Object> paramMap);
	
	/**
	 * Map集合中存放 表名、字段集合、数据集合
	 * @param paramMap
	 * @return 受影响的行数
	 */
	Integer updateTables(Map<String, Object> paramMap);
	
	/**
	 * 特殊方式批量更新
	 * @param paramMap
	 * @return
	 */
	Integer updateTablesX(Map<String, Object> paramMap);
}
