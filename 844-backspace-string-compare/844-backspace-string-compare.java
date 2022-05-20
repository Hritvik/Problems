class Solution {
    public boolean backspaceCompare(String s, String t) {
        return text(s).equals(text(t));
    }
    private String text(String s){
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '#'){
                if(!stack.isEmpty()){
                    stack.pollFirst();
                }
            }else{
                stack.addFirst(c);
            }
        }
        StringBuilder output = new StringBuilder();
        for(char c : stack){
            output.append(c);
        }
        return output.toString();
    }
}