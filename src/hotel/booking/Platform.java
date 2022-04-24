package hotel.booking;

public class Platform {
    public static void main(String[] args){
        int[] arrivals = {1,3,5};
        int[] departures = {2, 6, 8};
        boolean status = bookRooms(arrivals, departures, 1);
        System.out.println("status = "+status);
    }

    public static boolean bookRooms(int[] arrivals, int[] departures, int rooms){
        int[] day_capacity = new int[30];

        for(int i =  0; i < arrivals.length; i++){
            int a = arrivals[i];
            int d = departures[i];
            for(int j = a ; j <= d; j++){
                if(day_capacity[j-1] == rooms){
                    return false;
                }else{
                    day_capacity[j-1]++;
                }
            }
        }
        return true;
    }
}
