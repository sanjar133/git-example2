
class world {
    public static void main(String[] args) {

        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.substring(i, i + 1).equals("e")){
                sum++;
            }
        }
        if(sum == 1 || sum == 3){
            System.out.println(true);
        }
        else{
            return false;
        }

    }
}