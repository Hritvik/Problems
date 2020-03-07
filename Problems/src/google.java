import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class google {
	public static void main(String[] args) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			int C = Integer.parseInt(br.readLine());
			br.readLine();// blank line
			while (C-- > 0) {
				ArrayList<String> lines = new ArrayList<String>();
				String temp = null;
				while (!(temp = br.readLine()).trim().isEmpty()) {
					lines.add(temp);
				}
				solver(lines);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void solver(ArrayList<String> lines) {
		System.out.println("solver");
		HashMap<String, Integer> minPrice = new HashMap<String, Integer>();
		HashMap<String, Integer> avgPrice = new HashMap<String, Integer>();
		HashMap<String, Integer> maxPrice = new HashMap<String, Integer>();
		TreeMap<String, Integer> count = new TreeMap<String, Integer>();
		for (int i = 0; i < lines.size(); i++) {
			String testCase = lines.get(i);
			String[] temp = testCase.split(" ");
			String key = temp[0];
			int value = Integer.parseInt(temp[1]);
			if ((!minPrice.containsKey(key)) || (minPrice.containsKey(key) && minPrice.get(key) > value)) {
				minPrice.put(key, value);
			}
			if ((!maxPrice.containsKey(key)) || (maxPrice.containsKey(key) && maxPrice.get(key) < value)) {
				maxPrice.put(key, value);
			}
			if (!avgPrice.containsKey(key)) {
				avgPrice.put(key, value);
				count.put(key, 1);
			} else {
				avgPrice.put(key, (value + count.get(key) * avgPrice.get(key)) / (count.get(key) + 1));
				count.put(key, count.get(key) + 1);
			}
		}
		Set<String> keys = count.keySet();

		for (String key : keys) {
			System.out.println(
					key + " :: " + minPrice.get(key) + " :: " + avgPrice.get(key) + " :: " + maxPrice.get(key));
		}

	}

}
