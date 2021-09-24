package webservices;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class Check_ConvertController {

	@RequestMapping(value = "/checkFel", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public static void checkFel(HttpServletResponse response) {

		var csvFile = new ClassPathResource("sample.csv");

		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		try {
			StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
			String errorRows = checkCalc().toString();
			System.err.println("These rows arent correct!" + errorRows);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Integer> checkCalc() {
		ArrayList<Integer> rowErrors = new ArrayList<Integer>();

		for (int i = 1; i < readCSV.getWholeSheet().size(); i++) {
			ArrayList<String> row = readCSV.getWholeSheet().get(i);
			double units = (Double.parseDouble(row.get(6)));
			double unitCost = (Double.parseDouble(row.get(7)));
			double total = (Double.parseDouble(row.get(8)));

			if (Math.abs((units * unitCost) - total) > 0.01) {
				System.err.println(units + " * " + unitCost + " = " + total + ":" + (units * unitCost));
				rowErrors.add(i);
			} else
				System.out.println(units + " * " + unitCost + " = " + total + ":" + (units * unitCost));

		}

		return rowErrors;
	}

	@RequestMapping(value = "/convertToJSON", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public static void convertToJSON(HttpServletResponse response) {

		var csvFile = new ClassPathResource("sample.csv");
		System.out.println(List.of(response.getHeaderNames()));
		ArrayList<String> SimpleCsv = new ArrayList<String>();

		JSONArray list = new JSONArray();
		JSONObject obj = new JSONObject();

		JSONArray head = new JSONArray();

		head.addAll(readCSV.getWholeSheet().get(0));
		System.out.println(List.of(readCSV.getWholeSheet()).toString());
		for (ArrayList<String> row : readCSV.getWholeSheet()) {

			for (int i = 1; i < row.size(); i++) {

				obj.put(head.get(i), row.get(i));

			}
			System.out.println(obj.toString());
			list.add(obj.clone());
			obj.clear();
			System.out.println(row.toString());
			System.out.println(List.of(row));

		}
		try (FileWriter file = new FileWriter("test.json")) {
			System.out.println("file converted");
			file.write(list.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		try {
			StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
