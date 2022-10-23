package com.example.Excel2Json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




import com.google.gson.Gson;

@RestController
public class ExcelController {

	@PostMapping("excel")
	public String getExcel(@RequestParam("data") MultipartFile data) {
		excel2Json3(data);
//		excel2Json4(data);
		return "Success";
	}

// public void excel2Json(MultipartFile data) {
//    try {
//       XSSFWorkbook workBook = new XSSFWorkbook(data.getInputStream());
//       XSSFSheet workSheet = workBook.getSheetAt(0);
//       List<JSONObject> dataList = new ArrayList<>();
//       XSSFRow header = workSheet.getRow(0);
//       System.out.println(header.getCell(0).toString());
//       for(int i=1;i<workSheet.getPhysicalNumberOfRows();i++) {
//          XSSFRow row = workSheet.getRow(i);
//          JSONObject rowJsonObject = new JSONObject();
////            HashMap<Object,Object> Details = new HashMap<Object,Object>();
//          for(int j=0; j<row.getPhysicalNumberOfCells();j++) {
//             String columnName = header.getCell(j).toString();
//             String columnValue = row.getCell(j).toString();
//             rowJsonObject.put(columnName, columnValue);
//          }
////            JSONObject rowJsonObject = new JSONObject(Details);
//          dataList.add(rowJsonObject);
//       }
//       System.out.println(dataList);
//       writeData2JsonFile(dataList);
//    } catch (IOException e) {
//       // TODO Auto-generated catch block
//       e.printStackTrace();
//    }
// }




// public void writeData2JsonFile(List<String> dataList) {
//    Gson gson = new Gson();
//    try {
//       FileWriter file = new FileWriter("/Users/manoj.kutala/Downloads/Excel2Json/src/main/resources/data.json");
//       file.write(gson.toJson(dataList));
//       file.close();
//       System.out.println("hii");
//    } catch (IOException e) {
//       // TODO Auto-generated catch block
//       e.printStackTrace();
//    }
//
// }



	//  goutham
	public void excel2Json(MultipartFile data) {
		try {

			XSSFWorkbook workBook = new XSSFWorkbook(data.getInputStream());
			XSSFSheet workSheet = workBook.getSheetAt(0);
			List<Payload> matcheddataList = new ArrayList<>();
			List<Payload> unmatcheddataList = new ArrayList<>();
			XSSFRow header = workSheet.getRow(0);
			Payload payload;
			Gson gson = new Gson();
			for(int j=3;j<header.getPhysicalNumberOfCells();j++) {
//          String apiname = header.getCell(j);
				String fileName = "/Users/manoj.kutala/Downloads/Excel2Json/src/main/resources/"+header.getCell(j)+".json";
				FileWriter file = new FileWriter(fileName);
				JSONObject Details = new JSONObject();
				JSONObject unDetails = new JSONObject();
				for(int i=1;i<workSheet.getPhysicalNumberOfRows();i++) {
					XSSFRow row = workSheet.getRow(i);

					payload = new Payload(row);
					if(row.getCell(3).toString() != "") {
						matcheddataList.add(((payload)));
					}
					else {
						unmatcheddataList.add(((payload)));
					}
				}
				Details.put("API Name",header.getCell(j).toString());
				Details.put("matched", matcheddataList);
				Details.put("unmatched", unmatcheddataList);
				file.write(gson.toJson(Details));
				file.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	//nikhil
	//response
	public void excel2Json1(MultipartFile data) {
		try {

			XSSFWorkbook workBook = new XSSFWorkbook(data.getInputStream());
			XSSFSheet workSheet = workBook.getSheetAt(34);
			List<Payload> matcheddataList = new ArrayList<>();
			List<Payload> unmatcheddataList = new ArrayList<>();
			XSSFRow header = workSheet.getRow(0);
			String sheetname = workSheet.getSheetName();
			Map<String,JSONArray > datamap= new LinkedHashMap<>();
			Payload payload;
			Gson gson = new Gson();
			JSONObject Details = new JSONObject();
			String fileName = "/Users/manoj.kutala/Documents/Excel2Json/src/main/resources/APITouchPointsResponse/"+sheetname+".json";
			FileWriter file = new FileWriter(fileName);
			String temp = "meta-data";
			JSONArray temp_arr = new JSONArray();
			for(int i=27;i<28;i++) {
//          if()
//
//          for (int j = 2; j < 5; j++){
//             XSSFRow row = workSheet.getRow(j);
//             payload = new Payload(row);
//             matcheddataList.add(((payload));
//          }
//          Details.put(temp,matcheddataList);

				XSSFRow row = workSheet.getRow(i);
				payload = new Payload(row);

				//request
//				if( row.getCell(1).toString()!=temp){ // row.getCell(0)!=null &&
//					System.out.println(temp);
//					System.out.println(i);
//					datamap.put(temp,temp_arr);
//					temp = row.getCell(1).toString();
//					temp_arr = new JSONArray();
//				}
//				temp_arr.add(payload);


				//response

//          Details.put(temp,payload);

//				temp = row.getCell(1).toString();
//				temp_arr = new JSONArray();
				temp_arr.add(payload);
				datamap.put(temp,temp_arr);


			}
			datamap.put(temp,temp_arr);
			file.write(gson.toJson(datamap));
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}






	//request
	public void excel2Json2(MultipartFile data) {
		try {

			XSSFWorkbook workBook = new XSSFWorkbook(data.getInputStream());
			XSSFSheet workSheet = workBook.getSheetAt(35);
			XSSFRow header = workSheet.getRow(0);
			String sheetname = workSheet.getSheetName();
			Map<String,JSONArray > datamap= new LinkedHashMap<>();
			Payload payload;
			Gson gson = new Gson();
			JSONObject Details = new JSONObject();
			String fileName = "/Users/manoj.kutala/Documents/Excel2Json/src/main/resources/APITouchPoints/"+sheetname+".json";
			FileWriter file = new FileWriter(fileName);
			String temp = "meta-data";
			JSONArray temp_arr = new JSONArray();



			for(int i=1;i<9;i++) {

				XSSFRow row = workSheet.getRow(i);
				payload = new Payload(row);
				if(row.getCell(1)!=null && row.getCell(1).toString()!=temp){ //
					System.out.println(temp);
					System.out.println(i);
					if (datamap.containsKey(temp)) {
						datamap.get(temp).add(temp_arr);
					}
					else {
						datamap.put(temp,temp_arr);
					}
					temp = row.getCell(1).toString();
					temp_arr = new JSONArray();
				}
				temp_arr.add(payload);

			}
			datamap.put(temp,temp_arr);
			file.write(gson.toJson(datamap));
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}






	//request
	//mapping file creation
	public void excel2Json3(MultipartFile data) {
		try {

			XSSFWorkbook workBook = new XSSFWorkbook(data.getInputStream());
			XSSFSheet workSheet = workBook.getSheetAt(8);
			XSSFRow header = workSheet.getRow(0);
			String sheetname = workSheet.getSheetName();
			Map<String,JSONArray > datamap= new LinkedHashMap<>();
			Payload1 payload;
			Gson gson = new Gson();
			JSONObject Details = new JSONObject();
			String fileName = "/Users/manoj.kutala/Documents/Excel2Json/src/main/resources/mappingfilecreation/requestfields/"+sheetname+".json";
			FileWriter file = new FileWriter(fileName);
			String temp = "meta-data";
			JSONArray temp_arr = new JSONArray();


			for(int i=1;i<19;i++) {

				XSSFRow row = workSheet.getRow(i);
				payload = new Payload1(row);
				if(row.getCell(1)!=null && row.getCell(1).toString()!=temp){ //
					System.out.println(temp);
					System.out.println(i);
					if (datamap.containsKey(temp)) {
						datamap.get(temp).add(temp_arr);
					}
					else {
						datamap.put(temp,temp_arr);
					}
					temp = row.getCell(1).toString();
					temp_arr = new JSONArray();
				}
				temp_arr.add(payload);

			}
			datamap.put(temp,temp_arr);
			file.write(gson.toJson(datamap));
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//response
	// mappingfile creation
	public void excel2Json4(MultipartFile data) {
		try {

			XSSFWorkbook workBook = new XSSFWorkbook(data.getInputStream());
			XSSFSheet workSheet = workBook.getSheetAt(27);
			XSSFRow header = workSheet.getRow(0);
			String sheetname = workSheet.getSheetName();
			Map<String,JSONArray > datamap= new LinkedHashMap<>();
			Payload1 payload;
			Gson gson = new Gson();
			JSONObject Details = new JSONObject();
			String fileName = "/Users/manoj.kutala/Documents/Excel2Json/src/main/resources/mappingfilecreation/responsefields/"+sheetname+".json";
			FileWriter file = new FileWriter(fileName);
			String temp = "meta-data";
			JSONArray temp_arr = new JSONArray();
			for(int i=15;i<16;i++) {


				XSSFRow row = workSheet.getRow(i);
				payload = new Payload1(row);

				temp_arr.add(payload);
				datamap.put(temp,temp_arr);


			}
			datamap.put(temp,temp_arr);
			file.write(gson.toJson(datamap));
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}