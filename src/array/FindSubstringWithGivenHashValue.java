package array;

public class FindSubstringWithGivenHashValue {

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int[] val = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            val[i] = s.charAt(i) - 'a' + 1;
        }
        double base = calcBase(val, power, 0, k, modulo);
        if ((base % ((double) modulo)) == hashValue) {
            return s.substring(0, k);
        }
        for (int i = k; i < s.length(); i++) {
            // System.out.println("removing "+s.charAt(i-k)+" adding "+s.charAt(i));
            base = ((base - ((double) val[i - k])) / (double) power) + (((double) val[i]) * Math.pow(power, k - 1));
            // System.out.println((i-k+1)+"-"+(i+1)+" :: "+base);
            if ((base % ((double) modulo)) == hashValue) {
                return s.substring(i - k + 1, i + 1);
            }
        }
        return null;
    }

    private double calcBase(int[] val, int power, int start, int k, int modulo) {
        double base = 0;
        for (int i = start; i < start + k; i++) {
            base += (((double) val[i]) * Math.pow(power, i - start));
        }
        System.out.println(start + "-" + (start + k) + " :: base = " + base + " :: hash = " + (base % (double) modulo));
        return base;
    }
}
