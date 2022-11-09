import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static final String BASE_URL = "http://api.geonames.org/earthquakesJSON?";

	public static final double NORTH = 44.1;
	public static final double SOUTH = 9.9;
	public static final double EAST = -22.4;
	public static final double WEST = 55.2;
	public static final String USERNAME = "amnunez";
	public static final int MAX_ROWS = 50;

	static ArrayList<Earthquake> earthquakesList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		System.out.println(getDate());
		String url = BASE_URL + "north=" + NORTH + "&south=" + SOUTH + "&east=" + EAST + "&west=" + WEST + "&username="
				+ USERNAME + "&maxRows=" + MAX_ROWS +"&date=" + getDate();
		System.out.println(url);
		CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpResponse response = client.execute(new HttpGet(url));
		HttpEntity entity1 = response.getEntity();
		InputStream iStream = entity1.getContent();

		int a;
		String content = "";
		while ((a = iStream.read()) != -1) {
			content += (char) a;
		}
		JSONObject earthObject = new JSONObject(content);
		JSONArray jsonArray = earthObject.getJSONArray("earthquakes");

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			Earthquake earthquake = new Earthquake(object.getString("datetime"), object.getDouble("depth"),
					object.getDouble("lng"), object.getString("src"), object.getString("eqid"),
					object.getDouble("magnitude"), object.getDouble("lat"));
			earthquakesList.add(earthquake);
		}

		RadixSort.radixsort(earthquakesList, earthquakesList.size());

		System.out.println("After sorting by depth ascendingly");
		for (Earthquake earthquake : earthquakesList) {
			System.out.println(earthquake);
		}
	}

	public static String getDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ (calendar.get(Calendar.DAY_OF_MONTH) - 1);
	}

}
