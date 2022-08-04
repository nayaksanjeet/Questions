package questionaries;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Employee{
	Integer remitterID;
	String planID;
	Integer numberOfRecords;
	String fieldName;
	Double totalDollarAmount;
	String extractType;
	@Override
	public boolean equals(Object o) {

		// null check
		if (o == null) {
			return false;
		}
 
		// this instance check
		if (this == o) {
			return true;
		}
 
		// instanceof Check and actual value check
		if ((o instanceof Employee) && 
				(((Employee) o).getRemitterID() == this.getRemitterID()) &&
				(((Employee) o).getPlanID()!=null && ((Employee) o).getPlanID() .equals(this.getPlanID())) &&
				(((Employee) o).getNumberOfRecords()!=null && ((Employee) o).getNumberOfRecords().equals( this.getNumberOfRecords())) &&
				(((Employee) o).getFieldName()!=null && ((Employee) o).getFieldName().equals( this.getFieldName())) && 
				(((Employee) o).getTotalDollarAmount()!=null && ((Employee) o).getTotalDollarAmount().equals( this.getTotalDollarAmount())) &&
				(((Employee) o).getExtractType()!=null && ((Employee) o).getExtractType().equals( this.getExtractType()))
				) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	public Integer getRemitterID() {
		return remitterID;
	}
	public void setRemitterID(Integer remitterID) {
		this.remitterID = remitterID;
	}
	public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	public Integer getNumberOfRecords() {
		return numberOfRecords;
	}
	public void setNumberOfRecords(Integer numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Double getTotalDollarAmount() {
		return totalDollarAmount;
	}
	public void setTotalDollarAmount(Double totalDollarAmount) {
		this.totalDollarAmount = totalDollarAmount;
	}
	public String getExtractType() {
		return extractType;
	}
	public void setExtractType(String extractType) {
		this.extractType = extractType;
	}
	
	
}
public class DiffrenceCSVEmployee {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("D:\\workspace-sanjeet\\csvs\\input1.csv"));
		Scanner sc2 = new Scanner(new File("D:\\workspace-sanjeet\\csvs\\input2.csv"));
		Map<Integer,Employee> map1= new LinkedHashMap<>();
		Map<Integer,Employee> map2= new LinkedHashMap<>();
		List<Employee> employeeList = new ArrayList<>();
		String input = null;
		map1 =  readCSV(sc,input,map1);  
		map2 = readCSV(sc2,input,map2);
		
		for(Integer entry : map2.keySet()) {
			if(!map1.containsKey(entry)) {
				employeeList.add(map2.get(entry));
			}
			else {
				if(!map1.get(entry).equals(map2.get(entry))) {
					employeeList.add(map2.get(entry));
				}
			}
		}
		File csvFile = new File("D:\\workspace-sanjeet\\csvs\\result.csv");
		 FileWriter fileWriter = new FileWriter(csvFile);
		 StringBuilder line = new StringBuilder();
		 line.append("remitter_id,plan_id,number_of_records,field_name,total_dollar_amount,extract_type");
		 line.append("\n");
		for(Employee e: employeeList) {
			line.append(e.getRemitterID()!=null? e.getRemitterID(): "");
			line.append(",");
			line.append(e.getPlanID()!=null? e.getPlanID(): "");
			line.append(",");
			line.append(e.getNumberOfRecords()!=null ? e.getFieldName(): "");
			line.append(",");
			line.append(e.getFieldName()!=null ? e.getFieldName() : "");
			line.append(",");
			line.append(e.getTotalDollarAmount()!=null ? e.getTotalDollarAmount() : "");
			line.append(",");
			line.append(e.getExtractType()!=null ? e.getExtractType() :"");
			line.append("\n");
		}
		fileWriter.write(line.toString());
		
		fileWriter.close();
	}

	private static Map<Integer,Employee> readCSV(Scanner sc,String input,Map<Integer,Employee> map){
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		while (sc.hasNextLine())  //returns a boolean value  
		{ 
		input = sc.nextLine();
		System.out.println(input);
		
		//find and returns the next complete token from this scanner 
		String[] inputStr = input.split(",");
		Integer emitterId = null;
		
			 emitterId = inputStr[0].trim()!="" ?Integer.parseInt(inputStr[0]): null; 
			 Employee e = extractedEmployee(inputStr,emitterId);
		
			 map.put(emitterId, e);
		}   
		sc.close(); 
		return map;
	}
	private static Employee extractedEmployee(String[] inputStr,Integer emitterId) {
		Employee e = new Employee();
		 e.setRemitterID(emitterId);
		 e.setPlanID(inputStr[1]);
		 e.setNumberOfRecords(inputStr[2].trim()!="" ?Integer.parseInt(inputStr[2]): null);
		 e.setFieldName(inputStr[3]);
		 e.setTotalDollarAmount(inputStr[4].trim()!="" ?Double.parseDouble(inputStr[4]): null);
		 e.setExtractType(inputStr[5]);
		return e;
	}
 
}
     