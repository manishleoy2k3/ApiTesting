package com.api.interfaces;

import java.util.HashMap;

public interface IAddHeadersParameters {

	IAddParameter addParameter(String parameter);
	
	void addParameterMap(HashMap<String, String> headerParametersHashMap);
}
