package cn.com.trueway.sys.service.impl;

import cn.com.trueway.sys.mapper.MenuMapper;
import cn.com.trueway.sys.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Slf4j
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据用户id获取有权限的菜单
     *
     * @param userId
     *            用户名id
     * @return
     */
    @Override
    public Map<String, Object> getMenuByUserId(String menuId, String userId, String detpId) {

        Map<String, Object> menus = null;
        try {
            // 获取该用户的角色
            List<Map<String, Object>> menuss = menuMapper.getMenuByUserId(menuId);
            if (menuss != null && menuss.size() > 0) {
                // 将获得的菜单进行递归整理好
                menus = menuss.get(0);
                // 获取该用户的角色
                List<Map<String, Object>> childMenu = menuMapper.getChildMenuByFid((String) menus.get("menuid"), userId,detpId);
                if (childMenu != null && childMenu.size() > 0) {
                    menus.put("child", childMenu);
                    // 将获得的菜单进行递归整理好
                    for (int j = 0; j < childMenu.size(); j++) {
                        Map<String, Object> childMap = childMenu.get(j);
                        // 获取该用户的角色
                        List<Map<String, Object>> childMenus = menuMapper.getChildMenuByFid((String) childMap.get("menuid"), userId, detpId);
                        if (childMenus != null && childMenus.size() > 0) {
                            childMap.put("child", childMenus);
                            for (int z = 0; z < childMenus.size(); z++) {
                                Map<String, Object> childsMap = childMenus.get(z);
                                // 获取该用户的角色
                                List<Map<String, Object>> childsMenus = menuMapper.getChildMenuByFid((String) childsMap.get("menuid"), userId, detpId);
                                if (childsMenus != null && childsMenus.size() > 0) {
                                    childsMap.put("child", childsMenus);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            try {
            //    sysErrorLogDao.saveErrorLog("SysMenuServiceImpl", e.getMessage(), "getMenuByUserId", e);
            } catch (Exception e1) {
            }
            log.error("根据用户id获取菜单出错，用户ID：" + userId + "；异常信息：" + e.getMessage());
        }
        return menus;
    }


}
