package br.com.senac.model;

public class ArquivoInfo {

	
	private String filename;
	private String url;
	
	public ArquivoInfo(String filename, String url) {
		this.filename = filename;
		this.url = url;
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
}