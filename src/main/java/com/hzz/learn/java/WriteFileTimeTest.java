package com.hzz.learn.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WriteFileTimeTest {

	public static void main(String[] args) throws Exception {
		long s = System.currentTimeMillis();
		File f = new File("t.log");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		bw.write("10003");
		bw.flush();
		bw.close();
		long end = System.currentTimeMillis();
		f.delete();
		System.out.println("time: " + (end-s));
	}

}
