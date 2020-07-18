package com.come2niks.models;

/**
 * 
 * @author come2niks
 * Model class.
 *
 */
public class LanguageModel {

	private int srNo;
	private String language;
	private String version;
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public LanguageModel(int srNo, String language, String version) {
		super();
		this.srNo = srNo;
		this.language = language;
		this.version = version;
	}

	
	


}
