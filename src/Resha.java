import java.util.ArrayList;
import java.util.List;

public class Resha {
//    itemId, phone, bidprice
//          40001, 9914242425,202
//        40002, 9914242426,205
//        40001, 9914242325,210
//        40001, 9914242625,210
//        40003, 8914242625,375
//        40003, 9914242625,210

    class Bid{
        String id;
        String phone;
        int bidPrice;
        Bid(String id, String phone, int bidPrice){
            this.id = id;
            this.phone = phone;
            this.bidPrice = bidPrice;
        }
    }
    public static void main(String[] args) {
        String[] inputs = new String[10];
        Resha resha = new Resha();
        resha.insertBids(inputs);

    }

    private List<Bid> insertBids(String[] inputs){
        List<Bid> bids = new ArrayList<>();
        for(String input : inputs){
            String[] split = input.split(",");
            Bid bid = new Bid(split[0], split[1], Integer.parseInt(split[2]));
            bids.add(bid);
        }
        return bids;
    }
}
