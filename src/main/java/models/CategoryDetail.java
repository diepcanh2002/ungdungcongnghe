package models;

public class CategoryDetail {
	private String categorycode;
	private String frame;
	private String brake;
	private String gearset;
	private String discset;
	private String typeofhandle;
	private String pork;
	private String tires;
	private String dvolume;
	private String brand;
	public CategoryDetail(String categorycode, String frame, String brake, String gearset, String discset,
			String typeofhandle, String pork, String tires, String dvolume, String brand) {
		super();
		this.categorycode = categorycode;
		this.frame = frame;
		this.brake = brake;
		this.gearset = gearset;
		this.discset = discset;
		this.typeofhandle = typeofhandle;
		this.pork = pork;
		this.tires = tires;
		this.dvolume = dvolume;
		this.brand = brand;
	}
	public String getCategorycode() {
		return categorycode;
	}
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
	public String getFrame() {
		return frame;
	}
	public void setFrame(String frame) {
		this.frame = frame;
	}
	public String getBrake() {
		return brake;
	}
	public void setBrake(String brake) {
		this.brake = brake;
	}
	public String getGearset() {
		return gearset;
	}
	public void setGearset(String gearset) {
		this.gearset = gearset;
	}
	public String getDiscset() {
		return discset;
	}
	public void setDiscset(String discset) {
		this.discset = discset;
	}
	public String getTypeofhandle() {
		return typeofhandle;
	}
	public void setTypeofhandle(String typeofhandle) {
		this.typeofhandle = typeofhandle;
	}
	public String getPork() {
		return pork;
	}
	public void setPork(String pork) {
		this.pork = pork;
	}
	public String getTires() {
		return tires;
	}
	public void setTires(String tires) {
		this.tires = tires;
	}
	public String getDvolume() {
		return dvolume;
	}
	public void setDvolume(String dvolume) {
		this.dvolume = dvolume;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
