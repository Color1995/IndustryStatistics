package cn.com.trueway.sys.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuMapper {

    /**
     * 根据组织机构Id获取所有菜单合集
     * SYS_ORG_MENU
     * @param orgId
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getMenusByOrgId(String orgId) throws Exception;


    /**
     * 根据menuId, orgId
     * @param menuId
     * @param orgId
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getMenus(String menuId, String orgId) throws Exception;

    /**
     * 从SYS_MENU中取所有父级数据
     * @param parentId
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getAllParentMenuByFid(String parentId) throws Exception;

    /**
     * 从SYS_MENU中取子级数据
     * @param menuId
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getChildMenuByFid(String menuId) throws Exception;
}
