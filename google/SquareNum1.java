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
        if (right < 0 || right < left) {
            return -1;
        }
        if (left < 0) {
            left = 0;
        }

        long leftSqrt = sqrt(left);
        long rightSqrt = sqrt(right);

        if (leftSqrt * leftSqrt < left) {
            leftSqrt++;
        }
        //System.out.println(leftSqrt + " " + rightSqrt);
        if (leftSqrt > rightSqrt) {
            return 0;
        } else {
            return (int)(rightSqrt - leftSqrt + 1);
        }
       

    }

    private long sqrt(int num) {
        if (num == 1) {
            return 1;
        }

        int low = 0;
        int high = 1 + (num / 2);
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            long square = mid * mid;
            if (square == num) {
                return mid;
            } else if ( square < num ){
                low = mid;
            } else {
                high = mid;
            }
        }

        return (long) low;
    }
}