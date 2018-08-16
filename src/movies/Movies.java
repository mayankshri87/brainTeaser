package movies;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import com.google.gson.Gson;

import java.net.*;

public class Movies {

	public class Response {
		private String total;

		private String per_page;

		private String page;

		private Data[] data;

		private String total_pages;

		public String getTotal() {
			return total;
		}

		public void setTotal(String total) {
			this.total = total;
		}

		public String getPer_page() {
			return per_page;
		}

		public void setPer_page(String per_page) {
			this.per_page = per_page;
		}

		public String getPage() {
			return page;
		}

		public void setPage(String page) {
			this.page = page;
		}

		public Data[] getData() {
			return data;
		}

		public void setData(Data[] data) {
			this.data = data;
		}

		public String getTotal_pages() {
			return total_pages;
		}

		public void setTotal_pages(String total_pages) {
			this.total_pages = total_pages;
		}

		@Override
		public String toString() {
			return "ClassPojo [total = " + total + ", per_page = " + per_page + ", page = " + page + ", data = " + data
					+ ", total_pages = " + total_pages + "]";
		}
	}

	public class Data {
		private String Year;

		private String Type;

		private String Poster;

		private String imdbID;

		private String Title;

		public String getYear() {
			return Year;
		}

		public void setYear(String Year) {
			this.Year = Year;
		}

		public String getType() {
			return Type;
		}

		public void setType(String Type) {
			this.Type = Type;
		}

		public String getPoster() {
			return Poster;
		}

		public void setPoster(String Poster) {
			this.Poster = Poster;
		}

		public String getImdbID() {
			return imdbID;
		}

		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String Title) {
			this.Title = Title;
		}

		@Override
		public String toString() {
			return "ClassPojo [Year = " + Year + ", Type = " + Type + ", Poster = " + Poster + ", imdbID = " + imdbID
					+ ", Title = " + Title + "]";
		}
	}

	static String[] getMovieTitles(String substr) {
		HttpURLConnection conn = null;
		String str = substr.trim();

		try {

			String customizedURL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman";
			URL url = new URL(customizedURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			Gson gson = new Gson();
			Response response = gson.fromJson(br, Response.class);
			int totalMovies = 0;
			int pageNumbers = 0;
			if (response != null) {
				totalMovies = Integer.parseInt(response.getTotal());
				pageNumbers = Integer.parseInt(response.getTotal_pages());
			}
			String[] titles = new String[totalMovies];
			if (response != null) {
				int i = 0;
				System.out.println(pageNumbers);
				if (pageNumbers > 0) {
					HttpURLConnection conn1 = null;
					for (int k = 1; k <= pageNumbers; k++) {

						String pageUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=" + k;
						URL page = new URL(pageUrl);
						conn1 = (HttpURLConnection) page.openConnection();
						// conn1.setDoOutput(true);
						conn1.setRequestMethod("GET");
						conn1.setRequestProperty("Accept", "application/json");
						BufferedReader br1 = new BufferedReader(new InputStreamReader((conn1.getInputStream())));
						Gson gson1 = new Gson();
						Response response1 = gson1.fromJson(br1, Response.class);
						if (response1 != null) {
							for (Data data : response1.getData()) {
								titles[i] = data.getTitle();
								i++;
							}

						}
					}
					conn1.disconnect();
				}
			}

			conn.disconnect();
			Arrays.sort(titles);
			return titles;

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res[];
		/*
		 * String _substr; try { _substr = in.nextLine(); } catch (Exception e)
		 * { _substr = null; }
		 */

		res = getMovieTitles("abc");

		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println((String.valueOf(res[res_i])));
		}

		// bw.close();
	}
}
