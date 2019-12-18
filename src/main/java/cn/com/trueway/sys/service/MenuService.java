package cn.com.trueway.sys.service;

import java.util.Map;

public interface MenuService {

    public Map<String, Object> getMenuByUserId(String menuId, String userId, String detpId);


}
