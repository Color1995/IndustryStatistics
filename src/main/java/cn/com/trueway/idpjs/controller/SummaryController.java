package cn.com.trueway.idpjs.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.trueway.idpjs.util.UuidGenerator;
import cn.com.trueway.zdcy.service.SummaryService;
import cn.com.trueway.zdcy.util.ExportExcelUtil;
import cn.com.trueway.zdcy.util.ResponseResult;
import cn.com.trueway.zdcy.util.ReturnAbcEntity;
import cn.com.trueway.zdcy.util.TitlesUtil;

@Controller
@RequestMapping("/summary")
public class SummaryController {
	
	@Autowired
	private SummaryService summaryService;
	
	@RequestMapping(value = "/show.do")
	public String showSummary(HttpServletRequest request, ModelMap modelMap) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columns = new LinkedList<String>();
		columns.add("B");
		columns.add("C");
		paramMap.put("columns", columns);
		paramMap.put("tableName", "STATISTICS");
		
		
		List<LinkedHashMap<String, Object>> rusult = summaryService.toShow(paramMap);
		for (LinkedHashMap<String, Object> linkedHashMap : rusult) {
			for (Entry<String, Object> entry : linkedHashMap.entrySet()) {
				System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
				}
		}
		
		modelMap.addAttribute(rusult);
		
		return "";
	}
	
	
	@RequestMapping(value = "/insert.do")
	public void insertTables() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columnsList = new LinkedList<String>();
		List<List<String>> valuesList = new ArrayList<List<String>>();;
		List<String> values = new LinkedList<String>();
		List<String> values2 = new LinkedList<String>();
		paramMap.put("tableName", "STATISTICS");
		columnsList.add("ID");
		columnsList.add("A");
		columnsList.add("B");
		values.add(UuidGenerator.generate36UUID());
		values.add("1");
		values.add("1111111111111");
		values2.add(UuidGenerator.generate36UUID());
		values2.add("2");
		values2.add("222222222222");
		valuesList.add(values);
		valuesList.add(values2);
		paramMap.put("columnsList", columnsList);
		paramMap.put("valuesList", valuesList);
		Integer affecteds = summaryService.insertTables(paramMap);
		System.out.println("affecteds" + affecteds);
		
	}
	
	@RequestMapping(value = "/xqShow.do")
	public String showXQSummary(HttpServletRequest request, ModelMap modelMap) {
		String belong = "县区录入";
		
		// 参数实体
		//ReturnAbcEntity abcEntity = new ReturnAbcEntity();
		
		// 列名list
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columns = new ArrayList<String>();
		columns = ReturnAbcEntity .getColumnsList();
		columns.remove("A");
		columns.add("quarter");
		columns.add(0,"dtbelong");
		columns.remove("AV");
		columns.remove("AW");
		columns.remove("AX");
		columns.remove("AY");
		columns.remove("AZ");
		columns.add("year");
		columns.add("belong");
		
		// sql结果list	
		paramMap.put("tableName", "STATISTICS");
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", belong);
		paramMap.put("condition2", "");
		paramMap.put("value2", "");
		paramMap.put("condition3", "");
		paramMap.put("value3", "");
		paramMap.put("condition4", "");
		paramMap.put("value4", "");
		paramMap.put("order", "order");
		
		List<LinkedHashMap<String, Object>> resultListMap = summaryService.toShow(paramMap);
		
		/*
		 * List<LinkedHashMap<String, Object>> resultListAll = new
		 * ArrayList<LinkedHashMap<String,Object>>(); Map<String,Object> SqlMap=new
		 * LinkedHashMap<String, Object>(); if (resultList.size()>0 && resultList !=
		 * null) { for (LinkedHashMap<String, Object> LinkedHashMap : resultList) { for
		 * (Entry<String, Object> entry : LinkedHashMap.entrySet()) { String value =
		 * (String) entry.getValue(); SqlMap.put("Formula."+entry.getKey(), value); }
		 * resultListAll.add((java.util.LinkedHashMap<String, Object>) SqlMap); }
		 * 
		 * }
		 */
		
		/*
		 * List<String> sqlList = new ArrayList<String>(); Map<String, Object> map = new
		 * HashMap<String, Object>(); for (int i = 0; i < resultList.size(); i++) { map
		 * = resultList.get(i); sqlList.add((String) map.get(columns.get(i))); }
		 */
		modelMap.addAttribute("resultListMap",resultListMap);
		
		return "county-statistics";
	}
	
	@RequestMapping(value = "/xqExport.do")
	public void XQExport(HttpServletRequest request, HttpServletResponse response) {
		String quarter = request.getParameter("quarter");
		String belong = "县区录入";
		
		// 参数实体
		//ReturnAbcEntity abcEntity = new ReturnAbcEntity();
		
		// 列名list
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columns = new ArrayList<String>();
		columns = ReturnAbcEntity.getColumnsList();
		columns.remove(0); // 去掉ID
		columns.add(0, "DTBELONG");; // 去掉ID
		
		// sql结果list	
		paramMap.put("tableName", "STATISTICS");
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", belong);
		paramMap.put("condition2", "");
		paramMap.put("value2", "");
		paramMap.put("condition3", "");
		paramMap.put("value3", "");
		paramMap.put("condition4", "");
		paramMap.put("value4", "");
		
		//获取数据
		List<LinkedHashMap<String, Object>> resultListMap = summaryService.toShow(paramMap);
		
		// List 转 数组
 		String[] columnsX = new String[columns.size()];
		for (int i = 0; i < columns.size(); i++) {
			columnsX[i] = columns.get(i);
		}
		
		TitlesUtil titles = new TitlesUtil();
		// excel标题
		String[] names = titles.xqTitle();
		
		// 导出EXcel
		// 创建HSSFWorkbook
		ExportExcelUtil exportExcelUtil = new ExportExcelUtil();
		// 新建工作簿
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFWorkbook wb = exportExcelUtil.OutExcelUtilLinkedHashMap(workBook,names, columnsX, resultListMap,0,"sheet0");
		
		//excel文件名
		String fileName = "县区汇总表"+System.currentTimeMillis()+".xls";
		
		//响应到客户端
		try {
			exportExcelUtil.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
		    wb.write(os);
		    os.flush();
		    os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value = "/kfyqShow.do")
	public String showKFYQSummary(HttpServletRequest request, ModelMap modelMap) {
		String belong = "开发园区录入";
		
		// 参数实体
		//ReturnAbcEntity abcEntity = new ReturnAbcEntity();
		
		// 列名list
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columns = new ArrayList<String>();
		columns = ReturnAbcEntity.getColumnsList();
		columns.remove("A");
		columns.remove("B");
		columns.add("quarter");
		columns.add(0,"dtbelong");
		columns.add("year");
		columns.add("belong");
		
		// sql结果list	
		paramMap.put("tableName", "STATISTICS");
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", belong);
		paramMap.put("condition2", "");
		paramMap.put("value2", "");
		paramMap.put("condition3", "");
		paramMap.put("value3", "");
		paramMap.put("condition4", "");
		paramMap.put("value4", "");
		
		List<LinkedHashMap<String, Object>> resultListMap = summaryService.toShow(paramMap);
		
		modelMap.addAttribute("resultListMap",resultListMap);
		
		return "development-statistics";
	}
	
//	@RequestMapping(value = "/kfyqShow.do")
	public String showKFYQSummaryFalse2(HttpServletRequest request, ModelMap modelMap) {
		
		// 二级被选中的Name
		String checkedSecID = request.getParameter("checkedSecID");
		String checkedSecName = request.getParameter("checkedSecName");
		
		// 所需参数
		Map<String, Object> paraMap = new HashMap<String, Object>();
		List<String> colums = new ArrayList<String>();
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>(); 
		
		// 参数实体
		ReturnAbcEntity abcEntity = new ReturnAbcEntity();
		
		// 获取开发园区的ID
		String name = "开发园区录入";
		
		// 获取开发园区的superID
		colums.clear();
		colums.add("id");
		paraMap.clear();
		paraMap.put("colums", colums);
		paraMap.put("name", name);
		paraMap.put("tableName", "DIVISION");
		//
		List<LinkedHashMap<String, Object>> FirResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
		FirResultListMap = summaryService.toShow(paraMap);
		
		String super_id = "";
		if (FirResultListMap.size()>0) {
			resultMap = FirResultListMap.get(0);
			super_id = (String) resultMap.get("ID");
		}
		
		// 获取开发园区二级菜单
		colums.clear();
		colums.add("id");
		colums.add("name");
		paraMap.clear();
		paraMap.put("colums", colums);
		paraMap.put("super_id", super_id);
		paraMap.put("tableName", "DIVISION");
		//
		List<LinkedHashMap<String, Object>> SecResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
		SecResultListMap = summaryService.toShow(paraMap);
		
		// 发送到前台(二级菜单)
		modelMap.addAttribute("secList", SecResultListMap);
		
		if(checkedSecID == null) {
			if (SecResultListMap.size()>0) {
			// 获取某一细则
			resultMap.clear();
			checkedSecID = (String) SecResultListMap.get(0).get("ID");
			checkedSecName = (String) SecResultListMap.get(0).get("NAME");
			modelMap.addAttribute("checkedSecID", checkedSecID);
			modelMap.addAttribute("checkedSecName", checkedSecName);
			
			paraMap.clear();
			paraMap.put("colums", abcEntity);
			paraMap.put("belong", checkedSecName);
			paraMap.put("tableName", "STATISTICS");
			
			//结果
			List<LinkedHashMap<String, Object>> ResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
			ResultListMap = summaryService.toShow(paraMap);
			
			modelMap.addAttribute("kfyqList", ResultListMap);
			}
			
		}else {
			
			paraMap.clear();
			paraMap.put("colums", abcEntity);
			paraMap.put("belong", checkedSecName);
			paraMap.put("tableName", "STATISTICS");
			
			//结果
			List<LinkedHashMap<String, Object>> resultListMap = new ArrayList<LinkedHashMap<String, Object>>();
			resultListMap = summaryService.toShow(paraMap);
			modelMap.addAttribute("checkedSecID", checkedSecID);
			modelMap.addAttribute("checkedSecName", checkedSecName);
			modelMap.addAttribute("kfyqList", resultListMap);
		}
		
		return "development-statistics";
		
		
	}
	
//	@RequestMapping(value = "/kfyqShow.do")
	public String showKFQSummaryFalse(HttpServletRequest request, ModelMap modelMap) {
		// 二级被选中的Name
		String checkedSecID = request.getParameter("checkedSecID");
		String checkedSecName = request.getParameter("checkedSecName");
		// 三级被选中的Name
		String checkedThrID = request.getParameter("checkedThrID");
		String checkedThrName = request.getParameter("checkedThrName");
		
		// 所需参数
		Map<String, Object> paraMap = new HashMap<String, Object>();
		List<String> colums = new ArrayList<String>();
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>(); 
		
		// 参数实体
		ReturnAbcEntity abcEntity = new ReturnAbcEntity();
		
		// 获取开发园区的ID
		String name = "开发园区录入";
		
		// 获取开发园区的superID
		colums.clear();
		colums.add("id");
		paraMap.clear();
		paraMap.put("colums", colums);
		paraMap.put("name", name);
		paraMap.put("tableName", "DIVISION");
		//
		List<LinkedHashMap<String, Object>> FirResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
		FirResultListMap = summaryService.toShow(paraMap);
		
		String super_id = "";
		if (FirResultListMap.size()>0) {
			resultMap = FirResultListMap.get(0);
			super_id = (String) resultMap.get("ID");
		}
		
		// 获取开发园区二级菜单
		colums.clear();
		colums.add("id");
		colums.add("name");
		paraMap.clear();
		paraMap.put("colums", colums);
		paraMap.put("super_id", super_id);
		paraMap.put("tableName", "DIVISION");
		//
		List<LinkedHashMap<String, Object>> SecResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
		SecResultListMap = summaryService.toShow(paraMap);
		
		// 发送到前台(二级菜单)
		modelMap.addAttribute("secList", SecResultListMap);
		
		if(checkedSecID == null) {
			
			// 获取三级菜单
			if(SecResultListMap.size()>0) {
				resultMap.clear();
				checkedSecID = (String) SecResultListMap.get(0).get("ID");
				checkedSecName = (String) SecResultListMap.get(0).get("NAME");
				modelMap.addAttribute("checkedSecID", checkedSecID);
				modelMap.addAttribute("checkedSecName", checkedSecName);
				
				colums.clear();
				colums.add("id");
				colums.add("name");
				paraMap.clear();
				paraMap.put("colums", colums);
				paraMap.put("super_id", checkedSecID);
				paraMap.put("tableName", "DIVISION");
				
				//
				
				List<LinkedHashMap<String, Object>> thrResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
				thrResultListMap = summaryService.toShow(paraMap);
				// 发送到前台(三级菜单)
				modelMap.addAttribute("thrList", thrResultListMap);
				
				if (thrResultListMap.size()>0) {
					// 获取某一细则
					checkedThrID = (String)thrResultListMap.get(0).get("ID"); 
					checkedThrName = (String)thrResultListMap.get(0).get("NAME"); 
					modelMap.addAttribute("checkedThrID", checkedThrID);
					modelMap.addAttribute("checkedThrName", checkedThrName);
					
					paraMap.clear();
					paraMap.put("colums", abcEntity);
					paraMap.put("belong", checkedSecName);
					paraMap.put("dtbelong", checkedThrName);
					paraMap.put("tableName", "STATISTICS");
					
					//结果
					List<LinkedHashMap<String, Object>> ResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
					ResultListMap = summaryService.toShow(paraMap);
					
					modelMap.addAttribute("kfyqList", ResultListMap);
				}
			}
			
		}else {
			if (checkedThrID == null) {
				modelMap.addAttribute("checkedSecID", checkedSecID);
				modelMap.addAttribute("checkedSecName", checkedSecName);
				// 获取三级菜单
				colums.clear();
				colums.add("id");
				colums.add("name");
				paraMap.clear();
				paraMap.put("colums", colums);
				paraMap.put("super_id", checkedSecID);
				paraMap.put("tableName", "DIVISION");
				
				List<LinkedHashMap<String, Object>> thrResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
				thrResultListMap = summaryService.toShow(paraMap);
				// 发送到前台(三级菜单)
				modelMap.addAttribute("thrList", thrResultListMap);
				
				if (thrResultListMap.size()>0) {
					// 获取某一细则
					checkedThrID = (String)thrResultListMap.get(0).get("ID"); 
					checkedThrName = (String)thrResultListMap.get(0).get("NAME"); 
					modelMap.addAttribute("checkedThrID", checkedThrID);
					modelMap.addAttribute("checkedThrName", checkedThrName);
					
					paraMap.clear();
					paraMap.put("colums", abcEntity);
					paraMap.put("belong", checkedSecName);
					paraMap.put("dtbelong", checkedThrName);
					paraMap.put("tableName", "STATISTICS");
					
					//结果
					List<LinkedHashMap<String, Object>> ResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
					ResultListMap = summaryService.toShow(paraMap);
					
					modelMap.addAttribute("kfyqList", ResultListMap);
				}
				
			}
			
			// 获取三级菜单
			modelMap.addAttribute("checkedSecID", checkedSecID);
			modelMap.addAttribute("checkedSecName", checkedSecName);
			modelMap.addAttribute("checkedThrID", checkedThrID);
			modelMap.addAttribute("checkedThrName", checkedThrName);
			
			colums.clear();
			colums.add("id");
			colums.add("name");
			paraMap.clear();
			paraMap.put("colums", colums);
			paraMap.put("super_id", checkedSecID);
			paraMap.put("tableName", "DIVISION");
			
			List<LinkedHashMap<String, Object>> thrResultListMap = new ArrayList<LinkedHashMap<String, Object>>();
			thrResultListMap = summaryService.toShow(paraMap);
			// 发送到前台(三级菜单)
			modelMap.addAttribute("thrList", thrResultListMap);
			
			paraMap.clear();
			paraMap.put("colums", abcEntity);
			paraMap.put("belong", checkedSecName);
			paraMap.put("dtbelong", checkedThrName);
			paraMap.put("tableName", "STATISTICS");
			
			//结果
			List<LinkedHashMap<String, Object>> resultListMap = new ArrayList<LinkedHashMap<String, Object>>();
			resultListMap = summaryService.toShow(paraMap);
			
			modelMap.addAttribute("kfyqList", resultListMap);
		}
		
		return "kfyqSummary";
	}
	
	@RequestMapping(value = "/kfyqExport.do")
	public void KFYQExport(HttpServletRequest request, HttpServletResponse response) {
	//	String quarter = request.getParameter("quarter");
		String belong = "开发园区录入";
		
		// 参数实体
		//ReturnAbcEntity abcEntity = new ReturnAbcEntity();
		
		// 列名list
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> columns = new ArrayList<String>();
		columns = ReturnAbcEntity.getColumnsList();
		columns.remove(0); // 去掉ID
		columns.add(0, "DTBELONG");; // 去掉ID
		
		// sql结果list	
		paramMap.put("tableName", "STATISTICS");
		paramMap.put("columns", columns);
		paramMap.put("condition1", "belong");
		paramMap.put("value1", belong);
		paramMap.put("condition2", "");
		paramMap.put("value2", "");
		paramMap.put("condition3", "");
		paramMap.put("value3", "");
		paramMap.put("condition4", "");
		paramMap.put("value4", "");
		
		//获取数据
		List<LinkedHashMap<String, Object>> resultListMap = summaryService.toShow(paramMap);
		
		// List 转 数组
 		String[] columnsX = new String[columns.size()];
		for (int i = 0; i < columns.size(); i++) {
			columnsX[i] = columns.get(i);
		}
		
		TitlesUtil titles = new TitlesUtil();
		// excel标题
		String[] names = titles.xqTitle();
		
		// 导出EXcel
		// 创建HSSFWorkbook
		ExportExcelUtil exportExcelUtil = new ExportExcelUtil();
		// 新建工作簿
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFWorkbook wb = exportExcelUtil.OutExcelUtilLinkedHashMap(workBook,names, columnsX, resultListMap,0,"sheet0");
		
		//excel文件名
		String fileName = "开发园区汇总表"+System.currentTimeMillis()+".xls";
		
		//响应到客户端
		try {
			exportExcelUtil.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
		    wb.write(os);
		    os.flush();
		    os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="/getThrList.do", method = RequestMethod.POST)
	public ResponseResult<Void> getThrList(HttpServletRequest request, ModelMap modelMap){
		// 返回值
		ResponseResult<Void> result = new ResponseResult<Void>();
		
		return result;
	}
}
