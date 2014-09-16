/*
Date: Sep, 16, 2014
Author: Xin Wan
Topic: Generate the random number int [min, max]
*/
import java.util.*;

public Class Random_Num_in_A_Range {
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}