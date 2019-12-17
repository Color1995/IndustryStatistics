package cn.com.trueway.zdcy.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.trueway.zdcy.mapper.SummaryMapper;
import cn.com.trueway.zdcy.service.SummaryService;


@Service("mainService")
public class SummaryServiceImpl implements SummaryService {
	
	@Autowired
	private SummaryMapper summaryMapper;
	
	@Override
	public List<LinkedHashMap<String, Object>> toShow(Map<String, Object> paramMap) {
//		System.out.println("--------" + paramMap.get("tableName"));
		List<LinkedHashMap<String, Object>> ruslt = summaryMapper.toShow(paramMap);
		return ruslt;
	}

	@Override
	public Integer insertTables(Map<String, Object> paramMap) {
		
	Integer	affecteds = summaryMapper.insertTables(paramMap);
		
	return affecteds;
	}

}
