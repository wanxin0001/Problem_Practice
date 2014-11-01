import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/wanxin/Downloads/sum.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/wanxin/Downloads/sum.out"));

		int numCases = Integer.parseInt(br.readLine());
		for (int caseNum = 1; caseNum <= numCases; caseNum++) {
			String[] items = br.readLine().split(" ");
			int x = Integer.parseInt(items[0]);
			int y = Integer.parseInt(items[1]);
			int sum = x + y;

			bw.write("Case #" + caseNum + "\n");
			bw.write(sum + "\n");
		}

		bw.close();
		br.close();
	}


}