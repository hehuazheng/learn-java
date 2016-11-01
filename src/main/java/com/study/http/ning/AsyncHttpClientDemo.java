package com.study.http.ning;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

public class AsyncHttpClientDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		AsyncHttpClient ahc = new AsyncHttpClient();
		Future<Response> f = ahc.prepareGet("http://www.baidu.com").execute();
		Response r = f.get();
		System.out.println(r.getResponseBody());
		ahc.close();
	}

}
