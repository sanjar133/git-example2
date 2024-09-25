package leetcode.first;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "qwertyuiop";
        int k = 1;
        int result = solution.longestIdealString(s, k);
        System.out.println("Uzunlik: " + result);
    }
}
