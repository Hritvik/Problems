package hotel.booking;

//public class LRU {
//    int capacity = 10;
//    PriorityQueue<Node> pq = null;
//    Map<Integer, Node> map = null;
//    Comparator<Node> c = new Comparator<Node>() {
//        @Override
//        public int compare(Node a, Node b) {
//            if (a.time < b.time) {
//                return -1;
//            } else {
//                return 1;
//            }
//        }
//    };
//    int currTime = 0;
//
//    LRU(int capacity) {
//        this.capacity = capacity;
//        pq = new PriorityQueue<Node>(capacity, c);
//        map = new HashMap<>(capacity);
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//    int fetch(int key) {
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            node.time = currTime;
//            return node.val;
//        } else {
//            Node n = new Node(key, 0, currTime);//DB call
//            if(map.size() == capacity){
//                Node r = pq.poll();
//                map.remove(r.key);
//            }else{
//                map.put(key, n);
//                pq.add(n);
//            }
//        }
//        currTime++;
//
//
//    }
//
//    class Node {
//        int key;
//        int val;
//        int time;
//
//        Node(int key, int val, int time) {
//            this.key = key;
//            this.val = val;
//            this.time = time;
//        }
//    }
//}
