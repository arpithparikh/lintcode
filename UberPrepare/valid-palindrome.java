c boolean isPalindrome(String s) {
        // Write your code here
        int front = 0;
        int end = s.length() - 1;
        while(front < end){
            //要注意这里是not valid
            while(front < s.length() && !isValid(s.charAt(front))){
                front++;
            }
            if(front == s.length()){
                return true;
            }
            //注意这里是not valid
            while(end > 0 && !isValid(s.charAt(end))){
                end--;
            }
            //注意要变成小写
            if(Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }else{
                front++;
                end--;
            }
        }
        return true;
    }
    
    public boolean isValid(char a){
        return(Character.isDigit(a) || Character.isLetter(a));
    }
}
