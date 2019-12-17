package cn.com.trueway.idpjs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.trueway.idpjs.service.BasicTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.trueway.idpjs.util.UuidGenerator;
import cn.com.trueway.idpjs.service.BasicTableService;
import cn.com.trueway.zdcy.util.ReturnAbc;

/**
 * 续建重特大项目情况Controller
 * 
 * @author King1995
 * @date 2019年5月30日
 *
 */

@Controller
@RequestMapping("/baseTable")
public class BasicTableController {

	@Autowired
	private BasicTableService baseTableService;

	@RequestMapping(value = "/showZtd.do")
	public String showZtd(HttpServletRequest request, ModelMap modelMap) {
		String projectCode = request.getParameter("projectCode");
		String year = request.getParameter("year");
		String belong = request.getParameter("belong");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//放入表名
		paramMap.put("tableName", "continue_ztd");
		//默认查询所有
		paramMap.put("projectCode", projectCode);
		paramMap.put("year", year);
		paramMap.put("belong", belong);
		
		List<Map<String, Object>> resultList = baseTableService.toShow(paramMap);
		modelMap.addAttribute("resultMapList",resultList);
		
		return "base-table";
	}
	
	@RequestMapping(value = "/showNew.do")
	public String showNewStart(HttpServletRequest request, ModelMap modelMap) {
		String projectCode = request.getParameter("projectCode");
		String year = request.getParameter("year");
		String belong = request.getParameter("belong");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//放入表名
		paramMap.put("tableName", "new_start");
		//默认查询所有
		paramMap.put("projectCode", projectCode);
		paramMap.put("year", year);
		paramMap.put("belong", belong);
		
		List<Map<String, Object>> resultList = baseTableService.toShow(paramMap);
		modelMap.addAttribute("resultMapList",resultList);
		
		return "base-table";
	}
	
	@RequestMapping(value = "/industryFin.do")
	public String showIndustryFin(HttpServletRequest request, ModelMap modelMap) {
		String projectCode = request.getParameter("projectCode");
		String year = request.getParameter("year");
		String belong = request.getParameter("belong");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//放入表名
		paramMap.put("tableName", "INDUSTRY_FIN");
		//默认查询所有
		paramMap.put("projectCode", projectCode);
		paramMap.put("year", year);
		paramMap.put("belong", belong);
		// 
		List<Map<String, Object>> resultList = baseTableService.toShow(paramMap);
		modelMap.addAttribute("resultMapList",resultList);
		
		return "base-table";
	}
	
	@RequestMapping(value = "/serviceFinish.do")
	public String showServiceFinish(HttpServletRequest request, ModelMap modelMap) {
		String projectCode = request.getParameter("projectCode");
		String year = request.getParameter("year");
		String belong = request.getParameter("belong");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//放入表名
		paramMap.put("tableName", "Service_Fin");
		//默认查询所有
		paramMap.put("projectCode", projectCode);
		paramMap.put("year", year);
		paramMap.put("belong", belong);
		
		List<Map<String, Object>> resultList = baseTableService.toShow(paramMap);
		modelMap.addAttribute("resultMapList",resultList);
		
		return "base-table";
	}
	
	@RequestMapping(value = "/dataTech.do")
	public String showDataTech(HttpServletRequest request, ModelMap modelMap) {
		String projectCode = request.getParameter("projectCode");
		String year = request.getParameter("year");
		String belong = request.getParameter("belong");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//放入表名
		paramMap.put("tableName", "data_tech");
		//默认查询所有
		paramMap.put("projectCode", projectCode);
		paramMap.put("year", year);
		paramMap.put("belong", belong);
		
		List<Map<String, Object>> resultList = baseTableService.toShow(paramMap);
		modelMap.addAttribute("resultMapList",resultList);
		
		return "base-table";
	}
	
	/**
	 * 批量插入
	 * @param valuesList
	 * @param year
	 * @param belong
	 * @param tableName
	 */
	@RequestMapping(value = "/insert.do")
	public void insertTables(List<ArrayList<String>> valuesList, String year, String belong, String tableName) {
		Map<String, Object> paramMap = null;
		// 接收excel值集合
		List<ArrayList<String>> valuesListX = new ArrayList<ArrayList<String>>();
		// 重复数据
		List<ArrayList<String>> updateValuesList = new ArrayList<ArrayList<String>>();
		// 获取列名
		List<String> columnsList = new ReturnAbc().columnsList();		
		
		//获取所有已存在的项目编码，查询是否有重复值
		Map<String, Object> checkParamMap = new HashMap<String, Object>();
		List<String> columns = new ArrayList<String>();
		columns.add("B");
		columns.add("C");
		checkParamMap.put("columns", columns);//放入列名
		checkParamMap.put("tableName", tableName); // 放入表名
		List<Map<String, Object>> projectCodeNames = baseTableService.toShow(checkParamMap);
		
		/*
		 * List<String> Codes = new ArrayList<String>(); List<String> Names = new
		 * ArrayList<String>(); for (Map<String, Object> map : projectCodes) { String
		 * code = (String) map.get("B") ==null ? "":(String) map.get("B"); String name =
		 * (String) map.get("C") ==null ? "":(String) map.get("C"); Codes.add(code);
		 * Names.add(name); }
		 */
		
		//获取所有项目代码合集，进行区分
		/*
		 * for (int i = 0; i < valuesListX.size(); i++) { ArrayList<String> ArrayList =
		 * valuesListX.get(i); String projectCode = ArrayList.get(1); String projectName
		 * = ArrayList.get(2);
		 * 
		 * }
		 */
		
		String projectCode = "";
		String projectName = "";
		String code = "";
		String name = "";
		for (ArrayList<String> ArrayList : valuesList) {
			boolean flag = false;
			projectCode = ArrayList.get(1);
			projectName = ArrayList.get(2);
			for (Map<String, Object> map : projectCodeNames) {
				code = (String) map.get("B") ==null ? "":(String) map.get("B");
				name = (String) map.get("C") ==null ? "":(String) map.get("C");
				if (projectCode.equals(code) && projectName.equals(name)) {
					flag = true;			
				}
			}
			if(flag) {				
				updateValuesList.add(ArrayList); //添加
			}else {				
				valuesListX.add(ArrayList); //添加	
			}
		}
		
		
		// 不重复数据添加ID
		for (int i = 0; i < valuesListX.size(); i++) {
			valuesListX.get(i).add(0, UuidGenerator.generate36UUID());
			valuesListX.get(i).add(year);
			valuesListX.get(i).add(belong);
		}

		paramMap = new HashMap<String, Object>();
		paramMap.put("columnsList", columnsList);
		paramMap.put("valuesList", valuesListX);
		paramMap.put("tableName", tableName);
//		System.out.println("__________" + valuesListX.get(2).size() + "______________");
		if (valuesListX.size()>0) {			
			Integer affecteds = baseTableService.insertTables(paramMap);
			System.out.println("表 " + tableName + " 插入行数 :" + affecteds);
		}
		/*---------------------------------------------------*/
		
		if(updateValuesList .size()>0) {
			List<String> columnsListX = columnsList;
			columnsListX.remove("ID");
			columnsListX.remove("YEAR");
			columnsListX.remove("BELONG");
			//重复数据 
			List<String> updataValues = new ArrayList<String>();
			StringBuilder stringBuilder = null;
			for (ArrayList<String> updataList : updateValuesList) {
				stringBuilder = new StringBuilder();
				stringBuilder.append("set ");
				for (int i = 0; i < updataList.size(); i++) {
					
					stringBuilder.append(columnsListX.get(i) + "='"+ updataList.get(i) +"'");
					if(i != updataList.size()-1) {
						stringBuilder.append(", ");
					}
				}
				stringBuilder.append(" where t.B = '" + updataList.get(1) + "'");
				updataValues.add(stringBuilder.toString());
			}
			paramMap = new HashMap<String, Object>();
			paramMap.put("updataValues", updataValues);
			paramMap.put("tableName", tableName);
			if (updataValues.size()>0) {
				Integer affectedsX = updateTablesX(paramMap);
				System.out.println("表 " + tableName + " 更新行数 :" + affectedsX);
			}
		
		}
	}

	/**
	 * 批量更新
	 * @param paramMap
	 * @return
	 */
	public Integer updateTablesX(Map<String, Object> paramMap) {
		
		Integer affecteds = baseTableService.updateTablesX(paramMap);
		
		return affecteds;
	}
	
}
