/*
第一轮：小哥说他是LA分部的，瞎聊了几句扯了点Project开始做题。
第一题是Moving Average, 每次输入一个数，调用double next_val(int val)，和现有的windows_size，输出当前平均数。 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
例如，win_size = 3，
next_val(1) = 1/3; 
next_val(10) = (1 + 10) / 2; 
next_val(3) = (1 + 10 + 3) / 3; 
next_val(5) = (10 + 3 + 5) / 3 （因为已经数的总数已经到达win_size）
……
这题还算直接，一个queue不断记录当前的win_size个数，一个sum不断记录当前和就行。. 1point3acres.com/bbs

*/
import java.util.*;

public class MovingAverage {

	private static Queue<Integer> queue = new LinkedList<Integer>();
	private static int size;
	private static int sum;
	public MovingAverage(int size) {
		this.size = size;
		this.sum = 0;
	}
	public static double next_val(int val) {
		sum += val;
		if (queue.size() >= size) {
			sum  -= queue.peek();
			queue.poll();
			
		} 
		queue.offer(val);
		

		return (double) sum / queue.size();

	}

	public static void main(String[] args) {
		MovingAverage obj = new MovingAverage(3);
		System.out.println(obj.next_val(1));
		System.out.println(obj.next_val(10));
		System.out.println(obj.next_val(3));
		System.out.println(obj.next_val(5));
	}
}