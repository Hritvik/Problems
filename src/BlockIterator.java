import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BlockIterator implements Iterator<List<String>> {
    Iterator<String> inputIterator;
    Pattern startOfBlock;
    String startValue = null;

    public BlockIterator(Iterator<String> inputIterator, Pattern startOfBlock) {
        this.inputIterator = inputIterator;
        while (inputIterator.hasNext()) {
            String s = inputIterator.next();
            if (startOfBlock.matcher(s).matches()) {
                startValue = s;
                break;
            }
        }
        this.startOfBlock = startOfBlock;
    }

    public static void main(String[] args) {
        String[] sample = {"123", "start", "data1", "data2", "start", "data3", "start"};
        List<String> sampleList = Arrays.stream(sample).collect(Collectors.toList());
        Pattern startOfBlock = Pattern.compile("start");
        BlockIterator bi = new BlockIterator(sampleList.listIterator(), startOfBlock);
        while (bi.hasNext()) {
            System.out.println(bi.next());
        }
    }

    /**
     * If this iterator has more elements in it, return true without advancing
     * the internal iterator pointer.
     * Otherwise return false.
     */
    @Override
    public boolean hasNext() {
        if (startValue == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Return the next block. If no more block exists, throw
     * {@link java.util.NoSuchElementException}.
     */
    @Override
    public List<String> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        List<String> res = new ArrayList<>();
        res.add(startValue);
        while (inputIterator.hasNext()) {
            String s = inputIterator.next();
            if (startOfBlock.matcher(s).matches()) {
                startValue = s;
                return res;
            } else {
                res.add(s);
            }
        }
        startValue = null;
        return res;
    }
}
