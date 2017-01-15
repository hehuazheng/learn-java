package com.hzz.learn.java.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestMarkOnStream {

	public static void main(String[] args) throws IOException {
		String text = "i'm a test text";
		ByteArrayInputStream bais = new ByteArrayInputStream(text.getBytes());
		int c = -1;
		while((c = bais.read()) != -1) {
			if((char)c == ' ') {
				System.out.println(bais.available());
				bais.mark(bais.available());
				break;
			}
			System.out.println((char)c);
		}
		
		while((c = bais.read()) != -1) {
			System.out.println((char)c);
		}
		
		bais.reset();
		System.out.println("restart read");
		System.out.println((char)bais.read());
		bais.close();
	}

}
