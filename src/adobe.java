public class adobe {
    public static void main(String[] args) {
        System.out.println(findDuplicates("abbaca"));
    }
    public static String findDuplicates(String s){
        int removals = 1;
        while(removals>0){
            removals = 0;
            char p = ' ';
            String res = "";
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c==p){
                    count++;
                }else{// c!=p
                    if(p==' '){
                        // do nothing.
                    }else{
                        if(count == 1){
                            res+=p;
                        }else{
                            // we drop the char
                            removals++;
                        }
                    }
                    count = 1;
                    p = c;
                }
            }
            s = res;
        }
        return s;
    }

}
