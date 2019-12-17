package cn.com.trueway.zdcy.controller;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.trueway.zdcy.entity.formul;
import cn.com.trueway.zdcy.mapper.FormulaMapper;
import cn.com.trueway.zdcy.service.FormulaService;
import cn.com.trueway.zdcy.util.Base64Encryption;
import cn.com.trueway.zdcy.util.Encryption;
import cn.com.trueway.zdcy.util.ResponseResult;
import cn.com.trueway.zdcy.util.ReturnAbcEntity;

@Controller
@RequestMapping("/formula")
public class FormulaController {
	
	@Autowired
	private FormulaService formulaService;
	
	@RequestMapping(value = "/show.do")
	public String showSummary(HttpServletRequest request, ModelMap modelMap) {
		
		List<String> list = ReturnAbcEntity.getColumnsList();
		modelMap.addAttribute("list",list);
		
		return "formula";
	}
	
	@RequestMapping(value="/xqExcute")
	@ResponseBody
	public ResponseResult<Void> xqBatchExc() {
		/*
		 * 先查询 公式表
		 * 县区，开发园区 下的各个区域 List<LikedHashMap<String, Object>>
		 * 获取Key Value
		 * 将Value值 拿出查询 获取值。 将值存放在汇总表中
		 *
		 */
		// 声明返回值
		ResponseResult<Void> responseResult = new ResponseResult<Void>();
		
		// 县区录入
		List<LinkedHashMap<String, Object>> listMap = new ArrayList<LinkedHashMap<String, Object>>();
		Map<String, Object> paramMap = new HashMap<>();
		List<String> columns = ReturnAbcEntity.getColumnsList();
		columns.add("DTBELONG");//获取每条数据具体属于
		paramMap.put("tableName", "FORMULA");		
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", "县区录入");
		listMap = formulaService.toShow(paramMap);
		//
		List<String> columnsList = ReturnAbcEntity.getColumnsList();
		for (LinkedHashMap<String, Object> linkedHashMap : listMap) {
			
			String DEBELONG = (String) linkedHashMap.get("DTBELONG");
			for (String column : columnsList) {
				String sqlValue = (String) linkedHashMap.get(column);
				// 判断公式是否为空
				if (sqlValue != null && sqlValue != "") {
					
					// 计算公式
					paramMap = new HashMap<String, Object>();
					String sql = new String(Base64Encryption.decodeBufferBase64(sqlValue));
					paramMap.put("formula", sql);
					Double result = formulaService.formulaCount(paramMap);
					String result02 = "";
					if (result != null) {
						result02 = String.format("%.2f", result);  
					}
					System.err.println("公式值：" + result02);
					//将所得结果放入汇总表
					paramMap = new HashMap<String, Object>();
					paramMap.put("tableName", "STATISTICS");
					paramMap.put("column", column);
					paramMap.put("value", result02);
					paramMap.put("belong", "县区录入");
					paramMap.put("dtbelong", DEBELONG);
					
					Integer affecteds = formulaService.updateTables(paramMap);
					
				}
			}
		}
		
		responseResult.setMessage("");
		return responseResult;
		
		/*
		 * Iterator<Entry<String, Object>> iterator =
		 * linkedHashMap.entrySet().iterator(); while (iterator.hasNext()) {
		 * Map.Entry<String, Object> entry = (Map.Entry<String,Object>) iterator.next();
		 * String key = entry.getKey(); String value = (String) entry.getValue();
		 * System.out.println("value:" + value); }
		 */
	}
	
	@RequestMapping(value="/kfyqExcute")
	public void kfyqBatchExc() {
		/*
		 * 先查询 公式表
		 * 县区，开发园区 下的各个区域 List<LikedHashMap<String, Object>>
		 * 获取Key Value
		 * 将Value值 拿出查询 获取值。 将值存放在汇总表中
		 *
		 */
		// 开发园区录入
		List<LinkedHashMap<String, Object>> listMap = new ArrayList<LinkedHashMap<String, Object>>();
		Map<String, Object> paramMap = new HashMap<>();
		List<String> columns = ReturnAbcEntity.getColumnsList();
		columns.add("DTBELONG");//获取每条数据具体属于
		paramMap.put("tableName", "FORMULA");		
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", "开发园区录入");
		listMap = formulaService.toShow(paramMap);
		//
		List<String> columnsList = ReturnAbcEntity.getColumnsList();
		for (LinkedHashMap<String, Object> linkedHashMap : listMap) {
			
			String DEBELONG = (String) linkedHashMap.get("DTBELONG");
			for (String column : columnsList) {
				String sqlValue = (String) linkedHashMap.get(column);
				// 判断公式是否为空
				if (sqlValue != null && sqlValue != "") {
					
					// 计算公式
					paramMap = new HashMap<String, Object>();
					
					String sql = null;
					try {
						sql = new String(Base64Encryption.decodeBufferBase64(sqlValue),"UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					paramMap.put("formula", sql);
					Double result = formulaService.formulaCount(paramMap);
					String result02 = "";
					if (result != null) {
						result02 = String.format("%.2f", result);  
					}
					System.err.println("公式值：" + result02);
					//将所得结果放入汇总表
					paramMap = new HashMap<String, Object>();
					paramMap.put("tableName", "STATISTICS");
					paramMap.put("column", column);
					paramMap.put("value", result02);
					paramMap.put("belong", "开发园区录入");
					paramMap.put("dtbelong", DEBELONG);
					
					Integer affecteds = formulaService.updateTables(paramMap);
					
				}
			}
		}
				
		/*
		 * Iterator<Entry<String, Object>> iterator =
		 * linkedHashMap.entrySet().iterator(); while (iterator.hasNext()) {
		 * Map.Entry<String, Object> entry = (Map.Entry<String,Object>) iterator.next();
		 * String key = entry.getKey(); String value = (String) entry.getValue();
		 * System.out.println("value:" + value); }
		 */
	}
	
	
	@RequestMapping(value="/kfyqExcute2")
	public void kfyqBatchExc2() {
		/*
		 * 先查询 公式表
		 * 县区，开发园区 下的各个区域 List<LikedHashMap<String, Object>>
		 * 获取Key Value
		 * 将Value值 拿出查询 获取值。 将值存放在汇总表中
		 *
		 */
		// 开发园区录入
		List<LinkedHashMap<String, Object>> listMap = new ArrayList<LinkedHashMap<String, Object>>();
		Map<String, Object> paramMap = new HashMap<>();
		List<String> columns = ReturnAbcEntity.getColumnsList();
		columns.add("DTBELONG");//获取每条数据具体属于
		paramMap.put("tableName", "FORMULA");		
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", "县区录入");
		listMap = formulaService.toShow(paramMap);
		//
		List<String> columnsList = ReturnAbcEntity.getColumnsList();
		for (LinkedHashMap<String, Object> linkedHashMap : listMap) {
			
			String DEBELONG = (String) linkedHashMap.get("DTBELONG");
			for (String column : columnsList) {
				String sqlValue = (String) linkedHashMap.get(column);
				// 判断公式是否为空
				if (sqlValue != null && sqlValue != "") {
					
					// 计算公式
					paramMap = new HashMap<String, Object>();
					String sql = new String(Base64Encryption.decodeBufferBase64(sqlValue));
					paramMap.put("formula", sql);
					Double result = formulaService.formulaCount(paramMap);
					String result02 = "";
					if (result != null) {
						result02 = String.format("%.2f", result);  
					}
					System.err.println("公式值：" + result02);
					//将所得结果放入汇总表
					paramMap = new HashMap<String, Object>();
					paramMap.put("tableName", "STATISTICS");
					paramMap.put("column", column);
					paramMap.put("value", result02);
					paramMap.put("belong", "开发园区录入");
					paramMap.put("dtbelong", DEBELONG);
					
					Integer affecteds = formulaService.updateTables(paramMap);
					
				}
			}
		}
		
	}
	
	
	@RequestMapping(value = "/xqSqlShow.do")
	public String showXQSqlSummary(HttpServletRequest request, ModelMap modelMap) {
		String belong = request.getParameter("belong");
		String dtbelong = request.getParameter("dtbelong");
		if (belong==null) {
			belong = "县区录入";
		}
		System.out.println("belong:" + belong);
		// 存放三级地区名
		List<String> quyu = new ArrayList<String>();
		//获取地区 FORMULA表
		Map<String, Object> areaMap = new HashMap<String, Object>();		
	//	List<String> column = new ArrayList<String>();
		
		areaMap = new HashMap<String, Object>();
		areaMap.put("tableName", "FORMULA");
		areaMap.put("column", "dtbelong");
		areaMap.put("condition1", "belong");
		areaMap.put("value1", belong);
		areaMap.put("order", "order");
		List<LinkedHashMap<String, Object>> nameList = formulaService.toShow(areaMap);
		
		for (LinkedHashMap<String, Object> linkedHashMap : nameList) {
			quyu.add((String) linkedHashMap.get("DTBELONG"));
		}
		
		if (dtbelong==null) {
			dtbelong = quyu.get(0);
		}
		
		
		// 列名list
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columns = new LinkedList<String>();
		// 显示sql
		columns = ReturnAbcEntity.getColumnsList();
		columns.remove("A");
		
		// sql结果list	
		paramMap.put("tableName", "formula");
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", belong);
		paramMap.put("condition2", "dtbelong");
		paramMap.put("value2", dtbelong);
		paramMap.put("condition3", "");
		paramMap.put("value3", "");
		paramMap.put("condition4", "");
		paramMap.put("value4", "");
		paramMap.put("order", "order");
		List<LinkedHashMap<String, Object>> resultList = formulaService.toShow(paramMap);
		LinkedHashMap<String,Object> SqlMap= resultList.size() < 0 ? null : resultList.get(0);
		LinkedHashMap<String,Object> ResultSqlMap= new LinkedHashMap<String, Object>();
		for ( String column : columns) {
			if (column == null) {
				column = "";
			}
			String value = (String) SqlMap.get(column);
			value = new String(Base64Encryption.decodeBufferBase64(value));
			ResultSqlMap.put(column, value);
		}
		
		/*Encryption encryption = new Encryption();
		if (resultList.size()>0 && resultList != null) {
			Map<String,Object> map=resultList.get(0);
			for (Entry<String, Object> entry : map.entrySet()) {
				String value = (String) entry.getValue();
				if(value!=""&&value!=null) {					
				 	value = encryption.encryption(value);
				}
				SqlMap.put("Formula."+entry.getKey(), value);
			}
		}*/
		
		/*
		 * List<String> sqlList = new ArrayList<String>(); Map<String, Object> map = new
		 * HashMap<String, Object>(); for (int i = 0; i < resultList.size(); i++) { map
		 * = resultList.get(i); sqlList.add((String) map.get(columns.get(i))); }
		 */
		
		
		modelMap.addAttribute("dtbelong",dtbelong);
		modelMap.addAttribute("quyu",quyu);
		modelMap.addAttribute("sqlList",ResultSqlMap);
		
		return "xqSqlFormula";
	}
	
	@RequestMapping(value = "/kfyqSqlShow.do")
	public String showKFYQSql(HttpServletRequest request, ModelMap modelMap) {
		String belong = request.getParameter("belong");
		String dtbelong = request.getParameter("dtbelong");
		if (belong==null) {
			belong = "开发园区录入";
		}
		System.out.println("belong:" + belong);
		// 存放三级地区名
		List<String> quyu = new ArrayList<String>();
		//获取地区 FORMULA表
		Map<String, Object> areaMap = new HashMap<String, Object>();		
	//	List<String> column = new ArrayList<String>();
		
		areaMap = new HashMap<String, Object>();
		areaMap.put("tableName", "FORMULA");
		areaMap.put("column", "dtbelong");
		areaMap.put("condition1", "belong");
		areaMap.put("value1", belong);
		areaMap.put("order", "order");
		List<LinkedHashMap<String, Object>> nameList = formulaService.toShow(areaMap);
		
		for (LinkedHashMap<String, Object> linkedHashMap : nameList) {
			quyu.add((String) linkedHashMap.get("DTBELONG"));
		}
		
		if (dtbelong==null) {
			dtbelong = quyu.get(0);
		}
		
		// 显示sql
		ReturnAbcEntity abc = new ReturnAbcEntity();
		
		// 列名list
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columns = new LinkedList<String>();
		columns = abc.getColumnsList();
//		columns.add(0,"ID");
		columns.remove("A");
		columns.remove("B");
		
		// sql结果list	
		paramMap.put("tableName", "formula");
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", belong);
		paramMap.put("condition2", "dtbelong");
		paramMap.put("value2", dtbelong);
		paramMap.put("condition3", "");
		paramMap.put("value3", "");
		paramMap.put("condition4", "");
		paramMap.put("value4", "");
		List<LinkedHashMap<String, Object>> resultList = formulaService.toShow(paramMap);
		LinkedHashMap<String,Object> SqlMap= resultList.size() < 0 ? null : resultList.get(0);
		
		/*Encryption encryption = new Encryption();
		if (resultList.size()>0 && resultList != null) {
			Map<String,Object> map=resultList.get(0);
			for (Entry<String, Object> entry : map.entrySet()) {
				String value = (String) entry.getValue();
				value = encryption.encryption(value);
				SqlMap.put("Formula."+entry.getKey(), value);
			}
		}*/
		
		
		
		/*
		 * List<String> sqlList = new ArrayList<String>(); Map<String, Object> map = new
		 * HashMap<String, Object>(); for (int i = 0; i < resultList.size(); i++) { map
		 * = resultList.get(i); sqlList.add((String) map.get(columns.get(i))); }
		 */
		modelMap.addAttribute("dtbelong",dtbelong);
		modelMap.addAttribute("quyu",quyu);
		modelMap.addAttribute("sqlList",SqlMap);
		
		return "kfqSqlFormula";
	}
	
	@RequestMapping(value = "/sqlInsert.do",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> sqlInsert(HttpServletRequest request, ModelMap modelMap) {
		// 声明返回值
		ResponseResult<Void> result = new ResponseResult<Void>();
		// 列名
		String column = request.getParameter("column");
		// 参数值
		String sqlValue = request.getParameter("sqlValue");
		String belong = request.getParameter("belong");
		String dtbelong = request.getParameter("dtbelong");
	//	String column = columnA.split("\\.")[1];
		
		// 将sql语句写入 formula
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 前台传来的SQL 加密
	//	String value = Base64Encryption.encodeBufferBase64(sqlValue.getBytes());
		paramMap.put("tableName", "formula");
		paramMap.put("column", column);
		paramMap.put("value", sqlValue);
		paramMap.put("belong", belong);
		paramMap.put("dtbelong", dtbelong);	
		Integer affecteds = formulaService.updateTables(paramMap);
		
		/*
		// 查询公式值
		paramMap = new HashMap<String, Object>();
		paramMap.put("formula", sqlValue);
		Integer formula = null;
		try {
			formula = formulaService.formulaCount(paramMap);
			
		} catch (Exception e) {
			result.setMessage("false");
		}
		//  将计算结果录入STATISTICS
		paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", "STATISTICS");
		paramMap.put("column", column);
		paramMap.put("value", formula);
		paramMap.put("belong", belong);
		paramMap.put("dtbelong", dtbelong);
		Integer affectedsX = null;
		try {
			affectedsX = formulaService.updateTables(paramMap);
		} catch (Exception e) {
			result.setMessage("false");
		}
		System.out.println("formula:" + affectedsX);
		
		*/
		 // 录入公式 
		paramMap = new HashMap<String, Object>();
		paramMap.put("value", sqlValue);
		Integer affecteds2 = null;
		try {
			affecteds2 = formulaService.insertTable(paramMap);
		} catch (Exception e) {
			result.setMessage("false");
		}
		 
	//	System.out.println("formula:" + formula);
		
		System.out.println("affecteds" + affecteds);
		
		result.setMessage("true");
		return result; 
	}
	@RequestMapping(value = "/list.do")
	public void resultlist() {
		
		Map<String, Object> listmap = new HashMap<String, Object>();		
		listmap =formulaService.formulaalllist();
		for(Map.Entry<String, Object> e :listmap.entrySet()){
			String mapkey=e.getKey();
			String mapvalue=(String)e.getValue();
			if(mapvalue.equals("")) {
				mapvalue=" ";
			}
			System.out.println(mapkey+"+"+mapvalue);
			}
	}
	
	
}
