package com.hzz.learn.nio;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

	public static void main(String[] args) throws Exception {
		ByteBuffer bb = ByteBuffer.allocate(256);
		bb.putInt(3);
		bb.putInt(4);
		bb.flip();

		int a = bb.getInt();
		System.out.println(a);
		bb.clear();
		int b = bb.getInt();
		System.out.println(b);
		 b = bb.getInt();
			System.out.println(b);
	}

}
