
public class excelColumnNo_Solved {
	public static void main(String[] args) {
		String a = "AEB";
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			int j = a.length() - i;
			char c = a.charAt(i);
			int x = c - 64;// ASCII
			count += x * Math.pow(26, j - 1);
		}
		System.out.println(count);
	}
}
