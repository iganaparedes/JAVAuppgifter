package webservices;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@RestController
public class Controller {
	
	@RequestMapping(value = "/search", method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
	public String Search(@RequestParam String search) {

		String searchString = search;
		System.out.println(searchString);
		ArrayList<String> head= new ArrayList<String>();
		head.addAll(readCSV.getWholeSheet().get(0));
		head.remove(0);
		int index = 0;
		for(int i=0; i< 8 ; i++) {
			System.out.println(head.get(i).toLowerCase() +":"+searchString.toLowerCase());
			if(head.get(i).toLowerCase().equals(searchString.toLowerCase())){
				index = i;
				break;
			}
			
		}
		String results="";
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
			results+=row.get(index+1)+"\n";
		}
		return results;
		//return String.valueOf(index);
		
	}
	
	@RequestMapping(value = "/checkFel", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public void checkFel(HttpServletResponse response) throws IOException {

		var csvFile = new ClassPathResource("sample.csv");
		
		System.out.println("These rows arent correct!"+checkCalc().toString());
	

		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());

	}

	
	public ArrayList<Integer>  checkCalc() {
		ArrayList<Integer> rowErrors = new ArrayList<Integer>();
		//for(ArrayList<String> row : readCSV.getWholeSheet()) {
			
			//for(int i = 0; i < row.size(); i++) {
		
		for( int i = 1; i < readCSV.getWholeSheet().size() ; i++) {
			ArrayList<String> row=readCSV.getWholeSheet().get(i);
			//System.out.println( row+" ,\n");
				double units = (Double.parseDouble(row.get(6)));
				double unitCost = (Double.parseDouble(row.get(7)));
				double total = (Double.parseDouble(row.get(8)));

				if( Math.abs((units *unitCost) - total) > 0.01) {
					System.err.println( units+" * "+ unitCost + " = "+ total +":" + (units*unitCost));
					rowErrors.add(i);
				}else System.out.println( units+" * "+ unitCost + " = "+ total +":" + (units*unitCost));

			}
		
		
		
		return rowErrors;
	}
	
	
	@RequestMapping(value = "/showCSV", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public void showCSV(HttpServletResponse response) throws IOException {

		var csvFile = new ClassPathResource("sample.csv");

		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());

	}
	
	@RequestMapping(value = "/convertToJSON", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public void convertToJSON(HttpServletResponse response) throws IOException {

		var csvFile = new ClassPathResource("sample.csv");
		System.out.println(List.of(response.getHeaderNames()));
		ArrayList<String> SimpleCsv= new ArrayList<String>();
		//JSONObject[] obj = new JSONObject[8];
		
		JSONArray list = new JSONArray();
		JSONObject obj = new JSONObject();

		JSONArray head = new JSONArray();
		
		head.addAll(readCSV.getWholeSheet().get(0));
		System.out.println(List.of(readCSV.getWholeSheet()).toString() );
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
		
			//list.add(row);
			
			for(int i =1; i<row.size(); i++) {
				
		
				obj.put(head.get(i), row.get(i));
			
			}
			System.out.println(obj.toString());
			list.add(obj.clone());
			obj.clear();
			System.out.println(row.toString());
			//SimpleCsv.addAll(row);
			System.out.println( List.of(row) );
		
		}
		try (FileWriter file = new FileWriter ("test.json")) {
			System.out.println("file converted");
			file.write(list.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());

	}
	
	
	

	@RequestMapping
	/*public String index () {
		
		System.out.println(Arrays.toString(showCSVList().toArray()));
		System.out.println( readCSV.getWholeSheet().get(0).get(0));
		return "hehe";
	}*/
	
	(value = "/showCSVList", method = RequestMethod.GET)
	public ArrayList<String> showCSVList() {

		

		ArrayList<String> SimpleCsv= new ArrayList<String>();
		
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
		
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}
	/*@RequestMapping(value = "/showCSVListJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> showCSVListJSON() {

		
		ArrayList<String> SimpleCsv= new ArrayList<String>();
		
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}*/

}