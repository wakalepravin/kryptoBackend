package com.kryptominds.dtos;
import java.util.LinkedHashMap;
import java.util.Map;


public final class ResponseBean {

	private final Map<String, Object> response;

	public static ResponseBean instance() {
		return new ResponseBean();
	}
	
	public ResponseBean() {
		response = new LinkedHashMap<>();
	}

	public <O> ResponseBean add(String key, O value) {
		response.put(key, value);
		return this;
	}
	
	public Map<String, Object> getResponse() {
		return response;
	}

	@Override
	public String toString() {
		return "ResponseBean [response=" + response + "]";
	}
}
