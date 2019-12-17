package cn.com.trueway.zdcy.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.trueway.zdcy.entity.formul;
import cn.com.trueway.zdcy.mapper.FormulaMapper;
import cn.com.trueway.zdcy.service.FormulaService;


@Service("formulaService")
public class FormulaServiceImpl implements FormulaService {
	
	@Autowired
	private FormulaMapper formulaMapper;
	
	@Override
	public List<LinkedHashMap<String, Object>> toShow(Map<String, Object> paramMap) {
//		System.out.println("--------" + paramMap.get("tableName"));
		List<LinkedHashMap<String, Object>> ruslt = formulaMapper.toShow(paramMap);
		return ruslt;
	}

	@Override
	public Integer updateTables(Map<String, Object> paramMap) {
		
	Integer	affecteds = formulaMapper.updateTables(paramMap);
		
	return affecteds;
	}

	@Override
	public Double formulaCount(Map<String, Object> paramMap) {
		Double	affecteds = formulaMapper.formulaCount(paramMap);
		return affecteds;
	}

	@Override
	public Integer insertTable(Map<String, Object> paramMap) {
		Integer	affecteds = formulaMapper.insertTable(paramMap);
		
		return affecteds;
	}
	public Map<String,Object> formulaalllist(){
		//Map<String,Object> map =formulaMapper.formulaalllist();
		return formulaMapper.formulaalllist();
	}
	

}
