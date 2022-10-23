package com.example.Excel2Json;

import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class Payload {

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

	private String yubi_standard_field_id;
	private String yubi_staindard_field_name;
	private boolean isMandatory;
	private String dataType;

	private String description;


	
	
	public Payload(XSSFRow row) {
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

		this.yubi_standard_field_id = row.getCell(0).toString();
		this.yubi_staindard_field_name = row.getCell(2).toString();
		this.isMandatory = ((row.getCell(4).toString()).equals("Mandatory"));
		this.dataType = row.getCell(3).toString();
		if(row.getCell(5) == null){
			this.description = "";
		}
		else{
			this.description = row.getCell(5).toString();
		}

//		this.fieldID = row.getCell(0).toString();
	}
	
	
	
	
}
