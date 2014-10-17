/*
数一个区间内的平方数  O（log（n））

*/

public class SquareNum1 {
    public static void main(String[] args) {
        SquareNum1 obj = new SquareNum1();
        System.out.println(obj.squareNum(0, 10));
        System.out.println(obj.squareNum(5, 5));
       System.out.println(obj.squareNum(16, 16));
        
        //System.out.println();
        System.out.println(obj.squareNum(12, 20));
        System.out.println(obj.squareNum(4, 25));

        
    }

    public int squareNum(int left, int right) {
        
       if (right < 0 || right < left ) {
            return -1;
       }
       int start = 0;
       if (left <= 0) {
            start = 0;
       } else {
            start = searchLeft(left);
       }

       int end = searchRight(left, right);
       
       
       if (start > end) {
            return 0;
       } else {
            return end - start + 1;
       }
    }

    private int searchLeft(int goal) {
        int left = 1;
        int right = goal;
        while (left <= right ) {
            int mid = (right - left) / 2 + left;
            if (mid * mid == goal) {
                return mid;
            } else if (mid * mid < goal){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left * left == goal) {
            return left;
        } else {
            return left + 1;
        }
       

    }

    private int searchRight(int left, int goal) {
        
        int right = goal;
        while (left <= right ) {
            int mid = (right - left) / 2 + left;
            if (mid * mid == goal) {
                return mid;
            } else if (mid * mid < goal){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right * right == goal) {
            return right;
        } else {
            return right - 1;
        }
       

    }
}