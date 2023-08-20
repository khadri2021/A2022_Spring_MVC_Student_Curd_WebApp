package com.khadri.spring.mvc.form;

import org.springframework.stereotype.Component;

@Component
public class StudentForm {

	
	private Integer sId;
	private String sName;
	private String sAge;
	private String sBranch;
	private String sPhone;
	private String sAddress;
	private String sParentPhone;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAge() {
		return sAge;
	}

	public void setsAge(String sAge) {
		this.sAge = sAge;
	}

	public String getsBranch() {
		return sBranch;
	}

	public void setsBranch(String sBranch) {
		this.sBranch = sBranch;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsParentPhone() {
		return sParentPhone;
	}

	public void setsParentPhone(String sParentPhone) {
		this.sParentPhone = sParentPhone;
	}

}
