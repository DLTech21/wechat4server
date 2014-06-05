package com.wc.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleJSONObject {

	private List<String> keys;
	private List<Object> values;

	public SimpleJSONObject() {

		keys = new ArrayList<String>();
		values = new ArrayList<Object>();
	}

	public void add(String prop, Object value) {
		keys.add(prop);
		values.add(value);
	}

	public String toString() {

		StringBuffer json = new StringBuffer();
		json.append("{");
		for (int size = keys.size(), i = 0; i < size; i++) {
			json.append("\""+keys.get(i)+"\"");
			json.append(":");
			json.append(objectToJSON(values.get(i)) + ",");
		}

		if (json.length() > 1) {
			json.deleteCharAt(json.length() - 1);
		}
		json.append("}");
		return json.toString();
	}

	public static String objectToJSON(Object object) {
		if (object == null) {
			return "null";
		} else if (object instanceof String) {
			return "\"" + object.toString() + "\"";
		} else if (object instanceof Integer) {
			return String.valueOf(object);
		} else if (object instanceof Long) {
			return String.valueOf(object);
		} else if (object instanceof Float) {
			return String.valueOf(object);
		} else if (object instanceof Double) {
			return String.valueOf(object);
		} else if (object instanceof Boolean) {
			return ((Boolean)(object))?"1":"0";
		} else if (object instanceof SimpleJSONObject) {
			return object.toString();
		} else if (object instanceof SimpleJSONArray) {
			return object.toString();
		} else {
			return "\"" + object.toString() + "\"";
		}
	}

	public static SimpleJSONObject parseJSON(String string) {
		SimpleJSONObject json = new SimpleJSONObject();
		string = string.trim();
		try {
			Map<Integer, SimpleJSONObject> map = new HashMap<Integer, SimpleJSONObject>();
			int len = string.length();
			int dep = 0;
			for (int i = 0; i < len; i++) {
				Character c = string.charAt(i);
				switch (c) {
				case ':':
					String key = new String();
					String value = new String();
					int s = -1;
					int e = -1;
					boolean fs = false;
					boolean fe = false;
					for (int j = i; j >= 0; j--) {
						char v = string.charAt(j);
						switch (v) {
						case '{':
						case ',':
							s = j + 1;
							fs = true;
							break;
						}
						if (fs) {
							break;
						}
					}
					for (int j = i; j < len; j++) {
						char v = string.charAt(j);
						switch (v) {
						case '}':
						case ',':
							e = j;
							fe = true;
							break;
						}
						if (fe) {
							break;
						}
					}

					if (s == -1 || e == -1) {
						throw new JSONException();
					} else {
						key = string.substring(s, i);
						value = string.substring(i + 1, e);
					}
					System.out.println(key + "=" + value);
					System.out.println("sss");
					break;
				case '{':
					++dep;
					SimpleJSONObject js = map.get(dep);
					if (js == null) {
						js = new SimpleJSONObject();
						map.put(dep, js);
					}
					break;
				case '}':
					--dep;
					break;
				case '[':
					break;
				case ']':
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	private Object parseJSONValue(String value) {
		return null;
	}

	public static void main(String[] args) {

		String str = "{result: 'success', error_info: '',routes: [{userId: 1101083, startRouteProvince: '������',startRouteCity: '�ϰ���',} ] }";

		parseJSON(str);

	}
}
