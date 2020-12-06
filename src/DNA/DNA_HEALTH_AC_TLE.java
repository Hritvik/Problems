package DNA;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//TEST CASE 0 :: 0 19
//TEST CASE 1 :: 3218660 11137051
//TEST CASE 2 :: 15806635 20688978289
//TEST CASE 33:: 11674463 11674463
public class DNA_HEALTH_AC_TLE {
	private static Scanner scanner = null;

	public static void main(String[] args) {
		try {
			Node root = new Node('@', null);
			InputStream is = null;
			long startTime = System.currentTimeMillis();
			is = new FileInputStream("DNA/2.txt");
//			is = System.in;
			scanner = new Scanner(is);
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String[] genes = new String[n];

			String[] genesItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				String genesItem = genesItems[i];
				genes[i] = genesItem;
			}

			int[] health = new int[n];

			String[] healthItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			Node tempNode = root;
			for (int i = 0; i < n; i++) {
				int healthItem = Integer.parseInt(healthItems[i]);
				health[i] = healthItem;
				addToTrie(root, genes[i]);
			}
			suffixLinks3(tempNode);
			printSuffix(root);
			System.out.println("automaton created!");
			int s = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("s = " + s);
			long max = 0;
			long min = 999999999;
			for (int sItr = 0; sItr < s; sItr++) {
				String[] firstLastd = scanner.nextLine().split(" ");

				int first = Integer.parseInt(firstLastd[0]);

				int last = Integer.parseInt(firstLastd[1]);

				String d = firstLastd[2];
				long temp = solver(root, genes, health, first, last, d);
				if (temp > max) {
					max = temp;
				}
				if (temp < min) {
					min = temp;
				}
			}
			System.out.println(min + " " + max);
			long endTime = System.currentTimeMillis();
			long duration = (endTime - startTime);
			System.out.println("duration = " + duration);
			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long solver(Node root, String[] genes, int[] health, int first, int last, String d) {
		long score = 0;
//		Node root = new Node('@', null);
		HashMap<String, Long> scoreMap = new HashMap<String, Long>();
		HashMap<String, Integer> healthMap = new HashMap<String, Integer>();
		for (int i = first; i <= last; i++) {
			scoreMap.put(genes[i], (long) 0);
			if (healthMap.containsKey(genes[i])) {
				healthMap.put(genes[i], healthMap.get(genes[i]) + health[i]);
			} else {
				healthMap.put(genes[i], health[i]);
			}
		}
		slogger("pattern to match :: " + d);
		score(root, genes, health, d, scoreMap, healthMap);
		slogger("score calculated!");

		Set<String> set = scoreMap.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			score += scoreMap.get(key);
		}

		return score;
	}

	private static void addToTrie(Node root, String gene) {

		Node index = root;
		for (int i = 0; i < gene.length(); i++) {
			char v = gene.charAt(i);
			logger("" + v);
			if (index.next.containsKey(v)) {
				index = index.next.get(v);
				if (i == gene.length() - 1) {
					slogger(";");
					index.isLeaf = true;
				}
			} else {
				Node temp = new Node(v, index);
				index.next.put(v, temp);
				index = temp;
				if (i == gene.length() - 1) {
					slogger(";");
					temp.isLeaf = true;
				}
			}
		}
	}

	private static void suffixLinks3(Node node) {
		if (node.suffix != null) {
			return;
		} else {
			slogger("case :: " + printStr(node));
			if (node.v == '@') {// node is root
				node.suffix = node;
				slogger("root " + node.v + " :: suffix " + node.suffix.v);
			} else {
				if (node.p.v == '@') {// first children
					node.suffix = node.p;
					if (node.v == 'k') {
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					slogger("link set " + node.v + " :: " + node.suffix.v + " (level 1 child)");
				} else {
					Node curr = node;
					if (curr.v == curr.p.v) {// repeated chars
						node.suffix = node.p;
						slogger("link set " + printStr(node) + " :: " + printStr(node.suffix) + " (repeat)");
					} else {
						boolean suffixFlag = false;
						curr = curr.p;
						if (curr.suffix == null) {
							suffixLinks3(curr);
						}
						curr = curr.suffix;
						while ((curr.v != '@')) {
//							System.out.println("trying node " + curr.v + " of " + printStr(curr));
							if (curr.next.containsKey(node.v)) {
//								System.out.println(curr.v + " has required child :: " + node.v);
								node.suffix = curr.next.get(node.v);
								slogger("link set " + printStr(node) + " :: " + printStr(node.suffix));
								suffixFlag = true;
								break;
							}
							if (curr.suffix == null) {
								suffixLinks3(curr);
							}
							curr = curr.suffix;
						}
						if (!suffixFlag) {
							if (curr.v == '@') {// root
								node.suffix = curr;
								slogger("link set " + printStr(node) + " :: " + node.suffix.v
										+ " (no lateral move possible)");
							} else {
//								System.out.println("xxxxxxxxxxxxxxxxx");
//								System.out.println(curr.v);
							}
						}
					}

				}
			}

			Set<Character> children = node.next.keySet();
			if (children.size() == 0) {
				slogger("---------------------------------------");
			} else {
				for (Iterator<Character> iterator = children.iterator(); iterator.hasNext();) {
					Character child = iterator.next();
					Node childNode = node.next.get(child);
					suffixLinks3(childNode);
				}
			}

		}
	}

	private static void suffixLinks1(Node node) {
		if (node.p == null) {// node is root
			node.suffix = node;
		} else {
			if (node.p.p == null) {// first children
				node.suffix = node.p;
			} else {
				Node curr = node;
				boolean suffixFlag = false;
				while (curr.p != null) {
					curr = curr.p;
					while (curr.suffix != null) {
						curr = curr.suffix;
						if (curr.next.containsKey(node.v)) {
							node.suffix = curr.next.get(node.v);
							suffixFlag = true;
							break;
						}
						if (curr == curr.suffix) {// root
							node.suffix = curr;
							suffixFlag = true;
							break;
						}
					}
					if (suffixFlag) {
						break;
					}
				}
				if (!suffixFlag) {
					errlogger("no suffix found for " + node.v + " :: isLeaf? " + node.isLeaf);
				}

			}
		}

		Set<Character> children = node.next.keySet();
		for (Iterator<Character> iterator = children.iterator(); iterator.hasNext();) {
			Character child = iterator.next();
			Node childNode = node.next.get(child);
			suffixLinks1(childNode);
		}
	}

	private static void suffixLinks2(Node node) {
		if (node.p == null) {// node is root
			node.suffix = node;
		} else {
			if (node.p.p == null) {// first children
				node.suffix = node.p;
			} else {
				boolean suffixFlag = false;
				Node currParent = null;
				currParent = node.p;
				while (currParent.p != null) {// not root
					Node currSuffix = null;
					currSuffix = currParent.suffix;
					while (currSuffix.suffix != currSuffix) {// not root
						if (currSuffix.next.containsKey(node.v)) {
							node.suffix = currSuffix.next.get(node.v);
							suffixFlag = true;
							break;
						}
						currSuffix.suffix = currSuffix;
					}
					if (suffixFlag) {
						break;
					}
					currParent = currParent.p;
				}
				if (!suffixFlag) {
					node.suffix = currParent;
				}
			}

		}

		Set<Character> children = node.next.keySet();
		for (Iterator<Character> iterator = children.iterator(); iterator.hasNext();) {
			Character child = iterator.next();
			Node childNode = node.next.get(child);
			suffixLinks2(childNode);
		}
	}

	private static void score(Node root, String[] genes, int[] health, String d, HashMap<String, Long> scoreMap,
			HashMap<String, Integer> healthMap) {
		Node index = root;
		int i = 0;
		while (i < d.length()) {
			char v = d.charAt(i);
			slogger("input[" + i + "] = " + v);
			if (index.next.containsKey(v)) {
				index = index.next.get(v);
				i++;
			} else {
				if (index.suffix == index) {// root
					slogger("No matches found");
//					break;
					i++;
				} else {
					index = index.suffix;
					slogger("lateral movement to " + index.v);
				}
			}
			if (index.isLeaf) {
				ArrayList<String> matchList = printString(index);
//				System.out.println("*" + index.str);
//				String match = index.str;

				for (int j = 0; j < matchList.size(); j++) {
					String match = matchList.get(j);
//					slogger("xxfound ::" + match);
					if (scoreMap.containsKey(match)) {
						scoreMap.put(match, scoreMap.get(match) + healthMap.get(match));
//						System.out.println("found ::" + match);
//						System.out.println(scoreMap);
					} else {
						errlogger("matched redundent gene :: " + match);
					}
				}
			} else {
				slogger("reached ::" + index.v);
			}
		}
	}

	private static void search(Node root, String d) {
		Node index = root;
		int i = 0;
		while (i < d.length()) {
			char v = d.charAt(i);
//			logger1("input[" + i + "] = " + v);
			if (index.next.containsKey(v)) {
				index = index.next.get(v);
				i++;
			} else {
				if (index.suffix == index) {// root
//					logger1("reached root");
					i++;
				} else {
					index = index.suffix;
//					logger1("lateral movement to " + index.v);
				}
			}
			if (index.isLeaf) {
				logger("found ::");
				printString(index);
			} else {
//				logger1("reached ::" + index.v);
			}
		}
	}

	public static ArrayList<String> printString(Node node) {
		ArrayList<String> resultList = new ArrayList<String>();
		while (node.p != null) {
			if (node.isLeaf) {
				resultList.add("");
			}
			for (int i = 0; i < resultList.size(); i++) {
				String s = resultList.get(i);
				String temp = node.v + s;
				resultList.remove(i);
				resultList.add(i, temp);
			}
			node = node.p;
		}

		return resultList;
	}

	public static String printStr(Node node) {
		String s = "";
		while (node.p != null) {
			s = node.v + s;
			node = node.p;
		}

		return s;
	}

	private static void printSuffix(Node root) {
		if (root.suffix != null) {
			slogger(root.v + " :: " + root.suffix.v);
		} else {
			slogger("suffix null");
		}
		if (root.next != null && (!root.next.keySet().isEmpty())) {
			Set<Character> children = root.next.keySet();
			for (Iterator<Character> iter = children.iterator(); iter.hasNext();) {
				char v = iter.next();
				printSuffix(root.next.get(v));
			}

		} else {
			slogger("end node " + root.v);
		}

	}

	private static void printTrie(Node root) {
		if (root.next != null && (!root.next.keySet().isEmpty())) {
			Set<Character> children = root.next.keySet();
			for (Iterator<Character> iter = children.iterator(); iter.hasNext();) {
				char v = iter.next();
				logger(v + " ");
			}
			slogger("|");
			for (Iterator<Character> iter = children.iterator(); iter.hasNext();) {
				char v = iter.next();
				printTrie(root.next.get(v));
			}

		}
	}

	public static void main2(String[] args) {
		Node root = new Node('@', null);

		addToTrie(root, "a");
		addToTrie(root, "b");
		addToTrie(root, "ab");
		addToTrie(root, "bab");
		addToTrie(root, "bc");
		addToTrie(root, "bca");
		addToTrie(root, "c");
		addToTrie(root, "caa");
//		printTrie(root);
		Node temp = root;
		suffixLinks1(temp);
		temp = root;
//		printSuffix(temp);
		String d = "abccab";
		slogger("input = " + d);
		search(root, d);
	}

	public static void logger(String s) {
//		System.out.print(s);
	}

	public static void slogger(String s) {
//		System.out.println(s);
	}

	public static void errlogger(String s) {
//		System.out.println(s);
	}
}

class Node {
	public Node(char v, Node p) {
		this.v = v;
		this.p = p;
	}

	Node p = null;
	Node suffix = null;
	char v;
	HashMap<Character, Node> next = new HashMap<Character, Node>();
	boolean isLeaf = false;
}
