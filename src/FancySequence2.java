import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FancySequence2 {
	public static void main(String[] args) {
		String[] commands = { "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll",
				"getIndex", "getIndex", "getIndex" };
		int[] values = { 2, 3, 7, 2, 0, 3, 10, 2, 0, 1, 2 };
		FancySequence2 fancy = new FancySequence2();
		for (int i = 0; i < commands.length; i++) {
			switch (commands[i]) {
			case "append": {
				fancy.append(values[i]);
			}
				break;
			case "addAll": {
				fancy.addAll(values[i]);
			}
				break;
			case "multAll": {
				fancy.multAll(values[i]);
			}
				break;
			case "getIndex": {
				System.out.println(fancy.getIndex(values[i]));
			}
				break;
			default:
				break;
			}
		}
	}

	List<BigInteger> sequence;
	int toBeAdded;
	int toBeMultiplied;

	FancySequence2() {
		sequence = new ArrayList<>();
		toBeAdded = 0;
		toBeMultiplied = -1;
	}

	public void append(int val) {
		operate();
		sequence.add(BigInteger.valueOf(val));
	}

	public void addAll(int inc) {
		toBeAdded += inc;
	}

	public void multAll(int m) {
		if (toBeMultiplied == -1) {
			toBeMultiplied = m;
		} else {
			toBeMultiplied *= m;
		}
	}

	public int getIndex(int idx) {
		operate();
		if (idx >= sequence.size()) {
			return -1;
		} else {
			BigInteger answer = sequence.get(idx);
			// System.out.println(answer);
			return answer.remainder(BigInteger.valueOf(1000000007)).intValue();
		}
	}

	private void operate() {
		if (toBeAdded != 0) {
			for (int i = 0; i < sequence.size(); i++) {
				sequence.set(i, sequence.get(i).add(BigInteger.valueOf(toBeAdded)));
			}
		}
		if (toBeMultiplied != 1) {
			for (int i = 0; i < sequence.size(); i++) {
				sequence.set(i, sequence.get(i).multiply(BigInteger.valueOf(toBeMultiplied)));
			}
		}
		toBeAdded = 0;
		toBeMultiplied = -1;

	}
}
