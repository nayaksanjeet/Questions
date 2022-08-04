package questionaries;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DiffrenceCSV {
 public static void main(String[] args) throws IOException {
	 
	Map<String,String> map1= new LinkedHashMap<>();
	Map<String,String> map2 = new LinkedHashMap<>();
	Scanner sc = new Scanner(new File("D:\\workspace-sanjeet\\csvs\\input1.csv"));
	Scanner sc2 = new Scanner(new File("D:\\workspace-sanjeet\\csvs\\input2.csv"));
	List<String> array = new ArrayList<>() ;
	sc.useDelimiter(",");
	sc2.useDelimiter(",");
	while (sc.hasNext())  //returns a boolean value  
	{  
	map1.put(sc.next(), null);  //find and returns the next complete token from this scanner  
	}   
	sc.close();  //closes the scanner  
	while (sc2.hasNext())  //returns a boolean value  
	{  
	map2.put(sc2.next(), null);  //find and returns the next complete token from this scanner  
	}   
	sc2.close();  //closes the scanner  
	
	for(String input : map2.keySet()) {
		if(!map1.containsKey(input)) {
			array.add(input);
		}
	}
	System.out.println(array.toString());
 File csvFile = new File("D:\\workspace-sanjeet\\csvs\\result.csv");
 FileWriter fileWriter = new FileWriter(csvFile);
 int i=0;
 StringBuilder line = new StringBuilder();
 for (String data : array) {
	 
	   
	    
        line.append(data);
        
        if (i != array.size()-1) {
            line.append(',');
        }
        i++;
    }
	    fileWriter.write(line.toString());
	
	fileWriter.close();
	
}
}
