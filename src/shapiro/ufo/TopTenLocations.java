package shapiro.ufo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;

public class TopTenLocations {

	public static void main(String[] args) {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("./ufo_awesome.json"));
			Gson gson = new Gson();

			UFOSightingList list = gson.fromJson(in, UFOSightingList.class);
			in.close();
			HashMap<String, Integer> locations = new HashMap<String, Integer>();
			for (UFOSighting ufoSighting : list) {
				String location = ufoSighting.getLocation();
				if (locations.containsKey(location)) {
					locations.put(location, locations.get(location) + 1);
				} else {
					locations.put(location, 1);
				}
			}

			Set<Entry<String, Integer>> set = locations.entrySet();
			List<Entry<String, Integer>> entryList = new ArrayList<>(set);
			Collections.sort(entryList,
					new Comparator<Entry<String, Integer>>() {
						@Override
						public int compare(Entry<String, Integer> a,
								Entry<String, Integer> b) {
							return b.getValue().compareTo(a.getValue());
						}
					});

			for (int i = 0; i < 10; i++) {
				Entry<String, Integer> entry = entryList.get(i);
				System.out.println(entry.getKey() + ": " + entry.getValue()
						+ " sightings.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Could not process data.");
		} catch (IOException e) {
			System.out.println("IO Exception.");
		}
	}
}
