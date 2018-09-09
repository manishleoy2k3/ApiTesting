package com.api.interfaces;

import java.util.HashMap;

public interface IAddQueryParameters {

	IAddParameter addParameter(String parameter);
	void addParameterMap(HashMap<String, String> queryParametersHashMap);
}
