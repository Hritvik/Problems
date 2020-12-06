import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

public class LRU_Solved {
	int capacity = 0;
	int time = 0;
	PriorityQueue<Element> q = null;
	static HashMap<Integer, Integer> valueMap = null;
	static HashMap<Integer, Integer> timeMap = null;
	Comparator<Element> c = new Comparator<Element>() {
		@Override
		public int compare(Element o1, Element o2) {
			return timeMap.get(o1.key) - timeMap.get(o2.key);
		}
	};

	public static Predicate<Element> matchElement(Integer key) {
		return p -> p.key == key;
	}

	public static void main(String[] args) {
//		String input = "6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2"; // -1 3
		String input = "32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3";
//		  1 -1 -1 -1 -1 3 12 5 14 12 -1 3 -1 -1 -1 -1
		String[] temp = input.split(" ");
		int capacity = Integer.parseInt(temp[1]);
		LRU_Solved cache = new LRU_Solved(capacity);
		int i = 2;
		String res = "";
		while (i < temp.length) {
			String element = temp[i++];
			if (element.equals("S")) {
				int key = Integer.parseInt(temp[i++]);
				int value = Integer.parseInt(temp[i++]);
				System.out.println("inserting :: " + key + "[" + value + "]");
				cache.set(key, value);
			} else if (element.equals("G")) {
				int key = Integer.parseInt(temp[i++]);
				int result = cache.get(key);
				System.out.println("fetched :: " + key + "[" + result + "]");
				res += result + " ";
			}
			Iterator<Element> itr = cache.q.iterator();
			System.out.print("cache = ");
			while (itr.hasNext()) {
				System.out.print(itr.next().key + " ");
			}
			System.out.println();
			System.out.println("memory = " + valueMap);
			System.out.println("time = " + timeMap + " :: min = " + cache.q.peek().key);
		}
		System.out.println(res.trim());
	}

	public LRU_Solved(int capacity) {
		this.capacity = capacity;
		q = new PriorityQueue<Element>(capacity, c);
		valueMap = new HashMap<>();
		timeMap = new HashMap<Integer, Integer>();
	}

	public int get(int key) {
		if (valueMap.containsKey(key)) {
			timeMap.put(key, time++);
			rebuildQ(key);
			return valueMap.get(key);
		} else {
			time++;
			return -1;
		}

	}

	private void rebuildQ(int key) {
		q.removeIf(matchElement(key));
		q.add(new Element(key));
	}

	public void set(int key, int value) {

		if (!valueMap.containsKey(key)) {
			Element temp = new Element(key);
			if (q.size() == capacity) {
				Element removedElement = q.poll();
//				System.out.println("remove :: " + removedElement.key + "[" + timeMap.get(removedElement.key) + "]");
				valueMap.remove(removedElement.key);
				timeMap.remove(removedElement.key);
			}
			timeMap.put(key, time++);
			q.add(temp);
		} else {
			timeMap.put(key, time++);
			rebuildQ(key);
		}
		valueMap.put(key, value);
	}

	class Element {
		int key = 0;

		Element(int key) {
			this.key = key;
		}
	}

}
