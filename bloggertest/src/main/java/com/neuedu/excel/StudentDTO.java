package com.neuedu.excel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class StudentDTO extends BaseRowModel {
	 @ExcelProperty(index = 0 , value ="姓名")
	 private String name;
	 
	 @ExcelProperty(index = 1 , value = "手机")
	 private String tel;
	 
	 public StudentDTO() {
		 super();
	 }

	public StudentDTO(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
