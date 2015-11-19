package config;

import java.util.ResourceBundle;
import resourcemanager.ResourceManager;

public class Config {
	private static final String CONFIG_FILE = "properties/config";
	private static final Config config = new Config();
	private ResourceBundle stateGroupsBundle;
	
	private Config() {
		stateGroupsBundle = ResourceManager.getResourceManager().getPm().getResourceMap().get(config);
	}

	public static Integer getInt(String s) {
		return getInt(s, 0);
	}

	public static Integer getInt(String s, int n) {
		String value = config.stateGroupsBundle.getString(s);
		return value != null ? Integer.parseInt(value) : n;
	}

	public static Double getDouble(String s) {
		return getDouble(s, 0.0);
	}
	
	public static Double getDouble(String s, Double d) {
		String value = config.stateGroupsBundle.getString(s);
		return value != null ? Double.parseDouble(value) : d;
	}
	
	public static String[] getStringArray(String s) {
		String temp = config.stateGroupsBundle.getString(s);
		String[] ret = temp.split(",");
		return ret;
	}
	
	public static <T> T getObject(String s) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getObject(clazz, s);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObject(Class<?> T, String s) {
		T ret = null;
		try {
			ret = (T) T.getClassLoader().loadClass(s).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}

