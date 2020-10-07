package com.principledemo.jansi;

public abstract class Media {

	private String name;
	private String duration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public void writeTo(IWriter writer) {
		writer.saveTo(name);
	}
	
	abstract void printInfo() ;
	
	

}
