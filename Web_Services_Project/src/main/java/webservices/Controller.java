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

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String Search(@RequestParam String column) {

		String searchString = column;
		System.out.println(searchString);
		ArrayList<String> head = new ArrayList<String>();
		head.addAll(readCSV.getWholeSheet().get(0));
		head.remove(0);
		int index = 0;
		for (int i = 0; i < 8; i++) {
			System.out.println(head.get(i).toLowerCase() + ":" + searchString.toLowerCase());
			if (head.get(i).toLowerCase().equals(searchString.toLowerCase())) {
				index = i;
				break;
			}

		}
		String results = "";
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
			results += row.get(index + 1) + "\n";
		}
		return results;
	}

	@RequestMapping(value = "/showCSV", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public static void showCSV(HttpServletResponse response) {
		DisplayController.showCSV(response);
	}

	@RequestMapping(value = "/showCSVList", method = RequestMethod.GET)
	public static ArrayList<String> showCSVList() {
		return DisplayController.showCSVList();
	}

	@RequestMapping(value = "/checkFel", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public static void checkFel(HttpServletResponse response) {
		Check_ConvertController.checkFel(response);
	}

	@RequestMapping(value = "/convertToJSON", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public static void convertToJSON(HttpServletResponse response) {
		Check_ConvertController.convertToJSON(response);
	}
}