package com.api.interfaces;

public interface IStatusLine {

	void isEqualTo(boolean compareType, Object expectedStatusLine);
	void contains(String statusLine);
}
