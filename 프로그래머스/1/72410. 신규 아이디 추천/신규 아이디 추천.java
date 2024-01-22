class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<new_id.length(); i++){
            char c = new_id.charAt(i);
            if((c>='a'&&c<='z') ||(c>='0'&&c<='9') || c=='.'
               || c=='-' || c=='_'){
                sb.append(c);
            }
        }
        
        String sbStr = sb.toString().replace("..", ".");
        while(sbStr.contains("..")){
        sbStr = sbStr.replace("..",".");
        }
        
        if(!sbStr.isEmpty() && sbStr.charAt(0) == '.') {
           sbStr = sbStr.substring(1);
        } 
        if(!sbStr.isEmpty() && sbStr.charAt(sbStr.length()-1) == '.') {
           sbStr = sbStr.substring(0,sbStr.length()-1);
        } 
        if(sbStr.isEmpty()){
            sbStr = "a";
        }
                    
        if(sbStr.length()>=16){
           sbStr = sbStr.substring(0,15);
        }
        if(sbStr.charAt(sbStr.length()-1) == '.'){
           sbStr = sbStr.substring(0,sbStr.length()-1);
        }
        
        StringBuilder newSb = new StringBuilder(sbStr);
        if(newSb.length()<=2){
            char c = newSb.charAt(sbStr.length()-1);
           while(newSb.length() < 3){
            newSb.append(c);
           }
        }
        return newSb.toString();
    }
}