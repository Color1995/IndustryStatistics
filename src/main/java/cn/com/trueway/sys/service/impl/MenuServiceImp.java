package cn.com.trueway.sys.service.impl;

import cn.com.trueway.sys.mapper.MenuMapper;
import cn.com.trueway.sys.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Transactional
@Service("menuSrevice")
public class MenuServiceImp implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据用户id,部门id获取有权限的菜单
     *
     * @param userId
     *            用户名id
     * @return
     */
    @Override
    public Map<String, Object> getMenusById(String userId, String orgId) {

        /*
         * 先根据user_Id获取所有的菜单数据 org_menus
         * 再获取最高级的菜单id
         *
         */
        Map<String, Object> menus = new HashMap<>();
        String menuId = "";
        try {
            // 根据组织机构Id获取所有菜单合集
            // Map<String, Object> org_menus = menuMapper.getMenusByOrgId(orgId);
            // 获取所有一级菜单
            List<Map<String, Object>> parentMenu = menuMapper.getAllParentMenuByFid("");
            System.out.println(parentMenu.size());
            if (parentMenu != null && parentMenu.size() > 0) {

                Map<String, Object> menu = new HashMap<String, Object>();
                menus.put("title","常规管理");
                menus.put("icon","fa fa-address-book");
                menus.put("child", menu);
                // 将获得的菜单进行递归整理好
                for (int j = 0; j < parentMenu.size(); j++) {
                    Map<String, Object> childMap = parentMenu.get(j);

                    List<Map<String, Object>> childMenu = menuMapper.getMenus((String) childMap.get("MENUID"), orgId);
                    if (childMenu != null && childMenu.size() > 0) {
                        for (int i = 0; i < childMenu.size(); i++) {
                            childMap = childMenu.get(i);
                            menu.put("title", childMap.get("MENUNAME"));
                            menu.put("href", childMap.get("MENUURL"));
                            menu.put("target", "_self");
                            // 获取子集Menu
                            List<Map<String, Object>> childMenuSec = menuMapper.getMenus((String) childMap.get("MENUID"), orgId);
                            if (childMenuSec != null && childMenuSec.size() > 0) {
                                for (int z = 0; z < childMenu.size(); z++) {
                                    Map<String, Object> childMapSec = childMenu.get(i);
                                    Map<String, Object> menuSec = new HashMap<String, Object>();
                                    childMap.put("child", menuSec);
                                    menuSec.put("title", childMapSec.get("menuName"));
                                    menuSec.put("href", childMapSec.get("menuUrl"));
                                    menuSec.put("target", childMapSec.get("_self"));

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
                System.out.println(e);
            }
            System.out.println("根据用户id获取菜单出错，用户ID：" + userId + "；异常信息：" + e.getMessage());
        }
        return menus;
    }


}
