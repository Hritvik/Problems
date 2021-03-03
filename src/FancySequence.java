import java.util.ArrayList;
import java.util.List;

class FancySequence {
	List<Long> sequence;

	public FancySequence() {
		sequence = new ArrayList<>();
	}

	public void append(int val) {
		sequence.add((long) val);
	}

	public void addAll(int inc) {
		for (int i = 0; i < sequence.size(); i++) {
			sequence.set(i, sequence.get(i) + inc);
		}
	}

	public void multAll(int m) {
		for (int i = 0; i < sequence.size(); i++) {
			sequence.set(i, sequence.get(i) * m);
		}
	}

	public int getIndex(int idx) {
		long answer = ((idx < sequence.size()) ? (sequence.get(idx) % 1000000007) : -1);
		// System.out.println(answer);
		return (int) answer;
	}
}

/**
 * Your Fancy object will be instantiated and called as such: Fancy obj = new
 * Fancy(); obj.append(val); obj.addAll(inc); obj.multAll(m); int param_4 =
 * obj.getIndex(idx);
 */