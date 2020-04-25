package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String kode;
	String vname;
	String vcity;
	String vdesignation;
	int vsalary;
	
	List<String> dataList = new ArrayList<>();
	
	List<Motor> objectList = new ArrayList<>();
	
	public Student() {
		super();
	}
		
	public Student(String vname, String vcity, String vdesignation, int vsalary, List<String> dataList,
			List<Motor> objectList) {
		super();
		this.vname = vname;
		this.vcity = vcity;
		this.vdesignation = vdesignation;
		this.vsalary = vsalary;
		this.dataList = dataList;
		this.objectList = objectList;
	}

	public final List<String> getDataList() {
		return dataList;
	}

	public final void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

	public final List<Motor> getobjectList() {
		return objectList;
	}

	public final void setobjectList(List<Motor> objectList) {
		this.objectList = objectList;
	}

//	public Student(String vname, String vcity, String vdesignation, int vsalary, List<String> dataList) {
//		super();
//		this.vname = vname;
//		this.vcity = vcity;
//		this.vdesignation = vdesignation;
//		this.vsalary = vsalary;
//		this.dataList = dataList;
//	}
//
//	public Student(String vname, String vcity, String vdesignation,
//			int vsalary) {
//		super();
//		this.vname = vname;
//		this.vcity = vcity;
//		this.vdesignation = vdesignation;
//		this.vsalary = vsalary;
//	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVcity() {
		return vcity;
	}
	public void setVcity(String vcity) {
		this.vcity = vcity;
	}
	public String getVdesignation() {
		return vdesignation;
	}
	public void setVdesignation(String vdesignation) {
		this.vdesignation = vdesignation;
	}
	public int getVsalary() {
		return vsalary;
	}
	public void setVsalary(int vsalary) {
		this.vsalary = vsalary;
	}

	public final String getKode() {
		return kode;
	}

	public final void setKode(String kode) {
		this.kode = kode;
	}

	public final List<String> getdataList() {
		return dataList;
	}

	public final void setdataList(List<String> dataList) {
		this.dataList = dataList;
	}
	
}
