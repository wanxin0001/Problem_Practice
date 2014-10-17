/*
数一个区间内的平方数，根号N
others' solutions:
public int countSquare(int left, int right){
                if(right < left)
                        return -1; //Means error
                int start = 1, end = 1;
                while(start * start < left)
                        start++;
                end = start;. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
                while(end * end <= right)
                        end++;. from: 1point3acres.com/bbs 
                return end - start;
}

end * end小心溢出
假设右边界right 在Integer.MAX_VALUE附近 很有可能的情况是 (end- 1)*(end - 1)时没有溢出 然后 end * end溢出了 变成一个极小的复数 这时候必然小于right 然后可能会造成一些不期望的结果吧。

 public int countSquare(int left, int right) {
        if (left < 0 || right < left) {
            return -1; 
        }
        
        int st = 1; 
        while (st < left / st) {
            ++st; 
        }
        
        int ed = st + 1; 
        while (ed <= right / ed) {
            ++ed; 
        }
        
        return ed - st; 
    }
*/

public class SquareNum {
    public static void main(String[] args) {
        SquareNum obj = new SquareNum();
        System.out.println(obj.squareNum(0, 10));
        System.out.println(obj.squareNum(5, 5));
        System.out.println(obj.squareNum(16, 16));
        System.out.println(obj.squareNum(12, 20));
        System.out.println(obj.squareNum(4, 25));
        
    }

    public int squareNum(int left, int right) {
        if (right < 0 || right < left) {
            return -1;
        }

    

        long start = 0;
        while (start * start < left) {
            start++;
        }
        

        long end = start;
        while (end * end <= right) {
            end++;
        }
        end = end - 1;

        if ((end - start) > 0) {
            return (int) (end - start + 1);
        } else {
            if (start * start <= right) {
                return 1;
            } else {
                return 0;
            }
        }
        

    }
}