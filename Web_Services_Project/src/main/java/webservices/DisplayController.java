package webservices;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


public final class DisplayController {
	
	@RequestMapping(value = "/showCSV", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public static void showCSV(HttpServletResponse response)  {

		var csvFile = new ClassPathResource("sample.csv");

		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		
		try {
			StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping
	(value = "/showCSVList", method = RequestMethod.GET)
	public static ArrayList<String> showCSVList() {

		

		ArrayList<String> SimpleCsv= new ArrayList<String>();
		
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
		
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}
	
}