package com.demo.springboot.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.demo.springboot.model.CurrentStock;


@Service
public class CurrentStockService {

	private Logger logger = LoggerFactory.getLogger(CurrentStockService.class);

	// returns arraylist(current stock object) of real-time stock data of companies using API
	public ArrayList<CurrentStock> fetchStockData() throws IOException, InterruptedException, JSONException {

		ArrayList<String> company = new ArrayList<String>(
				Arrays.asList("TCS","INFY","ACC","AMBUJACEM","ASIANPAINT","AXISBANK","BPCL","CIPLA"));
						/*
						,"HDFC","ITC"));
						
						"ICICIBANK","IDEA","KOTAKBANK","M&M","PNB",
						"RELIANCE","SBIN","TATAMOTORS","TATAPOWER","TECHM",
						"ULTRACEMCO","VEDL","WIPRO","YESBANK","ZEEL",
						"SUNPHARMA","TATASTEEL","ONGC","LUPIN","HINDUNILVR"));*/
		/*
		 * TCS - TCS
		 * Infosys - INFY
		 * Reliance - RELI
		 */

		ArrayList<CurrentStock> stocksDetails = new ArrayList<CurrentStock>();
		String exchange = ".BO";


		for(int i = 0; i < company.size(); i++) {

			CurrentStock cs = new CurrentStock();

			//for BSE
			exchange = ".BO";
			JSONArray array = fetch(company.get(i),exchange);
			JSONObject[] values = new JSONObject[array.size()];
			values[0] = (JSONObject) array.get(0);

			String name = (String) String.valueOf(values[0].get("longName"));
			cs.setCompanyName(name);
			Double bse = Double.parseDouble(values[0].get("regularMarketPrice").toString());
			//logger.info(bse.toString());
			cs.setBsePrice(bse);

			//for NSE
			exchange = ".NS";
			JSONArray array1 = fetch(company.get(i),exchange);
			JSONObject[] values1 = new JSONObject[array1.size()];
			values1[0] = (JSONObject) array1.get(0);

			Double nse = Double.parseDouble(values1[0].get("regularMarketPrice").toString());
			//logger.info(nse.toString());
			cs.setNsePrice(nse);
			stocksDetails.add(cs);
		}

		//logger.info(String.valueOf(stocksDetails.size()));
		return stocksDetails;
	}

	public JSONArray fetch(String name, String exchange) throws IOException, InterruptedException {

		String Yahoo_finance_API_URL = "https://yfapi.net/v6/finance/quote?region=IN&lang=en&symbols="+name+ exchange;
		//.NO //.BO
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(Yahoo_finance_API_URL))
				.header("x-api-key", "yAr1FkULkd6EAdr3FwjRJ6gYxayUFB1V7S3Fb9iU")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		//yAr1FkULkd6EAdr3FwjRJ6gYxayUFB1V7S3Fb9iU
		//JXhBaYR2Dq6sV0ATURzbm2iHVZIGThmu3X79Hmsq
		//4sbstDEPau6pkr8FbI7PG2rRiUVOxArY7OHsLrf9
		//L1hLENIvMG4CVK10CIj7ztv1CDxRjksam5rVjhU2
		//xt5IOlkFWI2Gx5kjKirvN4W7WyQWy4uH1I637GU6

		HttpResponse<String> httpResponse = HttpClient.newHttpClient()
				.send(request, HttpResponse.BodyHandlers.ofString());

		//System.out.println(httpResponse.body());
		//logger.info(httpResponse.body());


		JSONObject jsonObject = null;

		try {
			jsonObject = (JSONObject) new JSONParser().parse(httpResponse.body());
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject response_obj = (JSONObject) jsonObject.get("quoteResponse");
		JSONArray array = (JSONArray) response_obj.get("result");


		return array;
	}

	public ArrayList<CurrentStock> getRecommendations() throws IOException, InterruptedException, JSONException {

		ArrayList<CurrentStock> stocksDetails = fetchStockData();

		ArrayList<CurrentStock> savedStocks = new ArrayList<>();
		
		//HashMap<String, Double> map = new HashMap<>(); 

		for(int i = 0; i < stocksDetails.size(); i++) {

			CurrentStock cso = stocksDetails.get(i);

			double profit;

			if(cso.getBsePrice() == 0.0)
			{
				double d = (Math.random() * ((5) + 1)) + cso.getNsePrice();
				int r = (int)(d * 100);
				double f = r / 100.0;
				cso.setBsePrice(f);
			}

			profit = Math.abs(cso.getBsePrice() - cso.getNsePrice()) / Math.max(cso.getBsePrice(), cso.getNsePrice());
			profit = profit*100;

			int r = (int)(profit * 100);
			double p = r / 100.0;

			//logger.info(String.valueOf(cso.getBsePrice()));
			//logger.info(String.valueOf(cso.getNsePrice()));
			//logger.info(String.valueOf(p));
			cso.setProfit(p);

			//set recommendation
			if(cso.getNsePrice() > cso.getBsePrice())
				cso.setRecommendation("Buy from BSE, sell in NSE");
			else
				cso.setRecommendation("Buy from NSE, sell in BSE");

			
			savedStocks.add(cso);
			
			//map.put(cso.getCompanyName(),cso.getProfit());

			Collections.sort(savedStocks, new StockComparator());

		}

		return savedStocks;
	}

}

class StockComparator implements Comparator<CurrentStock> {

	// override the compare() method
	public int compare(CurrentStock s1, CurrentStock s2)
	{
		if (s1.getProfit() == s2.getProfit())
			return 0;
		else if (s1.getProfit() < s2.getProfit())
			return 1;
		else
			return -1;
	}
}
