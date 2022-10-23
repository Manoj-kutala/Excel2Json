package com.example.Excel2Json;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class Payload1 {

//	private String fieldName;
//	private boolean isMandatory;
//	private String valueType;
//	private String category;
//	private String yubiStandardFieldId;
//	private String yubiFieldName;
//	private String yubiModelName;
//	private String description;
//	private String createdBy;
//	private Date createdAt;
//	private Date updatedAt;
	//
	//



	private boolean isMandatory;
	private String yubiFieldName;
	private String originatorFieldName;
	private String datatype;





	public Payload1(XSSFRow row) {
//		this.fieldName = row.getCell(3).toString();
//		this.isMandatory = true;
//		this.valueType = "Yubi Standard Fields";
//		this.category = "";
//		this.yubiStandardFieldId = "";
//		this.yubiFieldName = row.getCell(0).toString();
//		this.yubiModelName = row.getCell(1).toString();
//		this.description = row.getCell(2).toString();
//		this.createdBy = "";
//		this.createdAt = new Date();
//		this.updatedAt = new Date();

		this.isMandatory = ((row.getCell(5).toString()).equals("Mandatory"));
		this.yubiFieldName = row.getCell(2).toString();
		this.originatorFieldName = row.getCell(3).toString();

//		this.datatype = row.getCell(4).toString();
		if(row.getCell(4) == null){
			this.datatype = "String";
		}
		else{
			this.datatype = row.getCell(4).toString();
		}

//		this.fieldID = row.getCell(0).toString();
	}
	
	
	
	
}
