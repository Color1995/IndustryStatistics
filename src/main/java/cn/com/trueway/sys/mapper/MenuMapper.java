package cn.com.trueway.sys.mapper;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    /**
     * @param menuId
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getMenuByUserId(String menuId) throws Exception;


    List<Map<String, Object>> getChildMenuByFid(String menuFaterId, String userId, String deptId) throws Exception;
}
