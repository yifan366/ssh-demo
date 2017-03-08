package com.ztzf.utils.internationalization;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 国际化的工具类，读取资源文件中的，不同语言的properties文件
 * modified by：Rain  2014-3-5
 */
public class ResourcesUtil {
	public static final Map<String, String> ZH_CN = ResourcesUtil.getResources("messages_zh_CN");
	public static final Map<String, String> EN_US = ResourcesUtil.getResources("messages_en_US");
	public static final Map<String, String> systemInitial = ResourcesUtil.getResources("systemInitial");
						
	/**
	 * 获取资源文件的方法。
	 * modified by：Rain  2014-3-5
	 */
	public static Map<String, String> getResources(String resourcesName){
		Map<String, String> resources = new HashMap<String, String>();
		ResourceBundle resource = ResourceBundle.getBundle(resourcesName);
		for (String key:resource.keySet()){
			resources.put(key, resource.getString(key));
		}
		return resources;
	}
}
