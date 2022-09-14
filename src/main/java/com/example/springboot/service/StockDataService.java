package com.example.springboot.service;

import java.io.IOException;
//import org.json.simple.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class StockDataService {

	private static String Yahoo_finance_API_URL = "https://yfapi.net/v6/finance/quote?region=IN&lang=en&symbols=AAPL";
	//https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/niftyStockWatch.json
	//private List<LocationStats> allStats = new ArrayList<>();
	
//	public List<LocationStats> getAllStats() {
//		return allStats;
//	}
	
	
	@PostConstruct
	//@Scheduled(cron = "* * 1 * * *")
	public void fetchStockData() throws IOException, InterruptedException {
		
		//List<LocationStats> newStats = new ArrayList<>();	
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(Yahoo_finance_API_URL))
				.header("x-api-key", "xt5IOlkFWI2Gx5kjKirvN4W7WyQWy4uH1I637GU6")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> httpResponse = HttpClient.newHttpClient()
				.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(httpResponse.body());
		
		//JSONObject myResponse = new JSONObject(httpResponse.toString());
		
		
		
	}
	
}
