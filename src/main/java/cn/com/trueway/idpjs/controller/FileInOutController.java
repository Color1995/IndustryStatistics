package cn.com.trueway.idpjs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.com.trueway.idpjs.util.UuidGenerator;
import cn.com.trueway.idpjs.entity.ContinueZtd;
import cn.com.trueway.sys.util.poi.ImportExcel;
import cn.com.trueway.sys.util.ResponseResult;

/**
 * 文件上传下载Controller
 * 调出相关页面
 * @author King1995
 * @date 2019年5月31日
 *
 */
@Controller
@RequestMapping("/file")
public class FileInOutController {
	
	@Autowired
	private BasicTableController basicTableController;
	
	/*调出file上传下载页面*/
	@RequestMapping("/show.do")
	public String showFileIO() {
		
		return "fileInOut";
	}
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleFileUp(@RequestParam(value = "file") MultipartFile multipartFile, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String year = (String) request.getAttribute("year");
		String belong = (String) request.getAttribute("belong");
		
		// 声明返回值
		ResponseResult<Void> rr = new ResponseResult<Void>();
		
		//处理第一Sheet页数据
		List<ArrayList<String>> newStartList = ImportExcel.analysisSheetTwo(multipartFile, 0);
		//处理第二Sheet页数据
		List<ArrayList<String>> continueZtdList = ImportExcel.analysisSheetTwo(multipartFile, 1);
		//处理第三Sheet页数据
		List<ArrayList<String>> industryFinList = ImportExcel.analysisSheetTwo(multipartFile, 2);
		//处理第四Sheet页数据
		List<ArrayList<String>> serviceFinList = ImportExcel.analysisSheetTwo(multipartFile, 3);
		//处理第五Sheet页数据
		List<ArrayList<String>> dataTechList = ImportExcel.analysisSheetTwo(multipartFile, 4);
		
		
		if (newStartList.size()>0) {
			basicTableController.insertTables(newStartList, year, belong, "new_start");
		}
		if (continueZtdList.size()>0) {
			basicTableController.insertTables(continueZtdList, year, belong, "continue_ztd");
		}
		if (industryFinList.size()>0) {
			basicTableController.insertTables(industryFinList, year, belong, "INDUSTRY_FIN");
		}
		if (serviceFinList.size()>0) {
			basicTableController.insertTables(serviceFinList, year, belong, "Service_Fin");
		}
		if (dataTechList.size()>0) {
			basicTableController.insertTables(dataTechList, year, belong, "DATA_TECH");
		}
		
		rr.setState(1);
		return rr;
	}
	
}
