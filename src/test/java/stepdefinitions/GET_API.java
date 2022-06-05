package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import runner.Runner;
import utility.WriteToExcel;

public class GET_API {
	Logger log = LogManager.getLogger(Runner.class.getName());


	@Test
	@Given("user takes the GetApi")
	public void user_takes_the_get_api(DataTable dataTable) throws IOException {
		log.info(" <------------------------------ GET Request API Details ------------------------------>");
		WriteToExcel ex = new WriteToExcel();

		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapdata : listdata) {
			Response response = null;

			try {
				response = RestAssured.given().header("X-ART-API-KEY", "koPKTXm5v9PPSGHpuqifHeaTh2b8mAA7")
						.get(mapdata.get("baseURI"));

			} catch (Exception e) {
				e.printStackTrace();
			}
			int statuscode = response.getStatusCode();
			String responsetime = response.getTime() + " ms";

			ex.writetoexcel(mapdata.get("baseURI"), statuscode, responsetime);

			log.info(mapdata.get("baseURI") + " Status Code : " + statuscode);
			log.info(mapdata.get("baseURI") + " Response Time : " + responsetime);
		}

	}
	
	
}
