package com.hzz.learn.http.ning;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.util.Base64;

public class AsyncHttpClientSslDemo {

	public static void main(String[] args) throws Exception {
		SSLContext ctx = SSLContext.getInstance("TLS");
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			@Override
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}
		};

		ctx.init(null, new TrustManager[] { tm }, new SecureRandom());
		AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
				.setSSLContext(ctx).build();
		AsyncHttpClient ahc = new AsyncHttpClient(config);

		String t = ahc
				.prepareGet("https://xxx.com")
				.addHeader("Authorization",
						"Basic " + Base64.encode("aa:bb".getBytes("UTF-8")))
				.execute().get().getResponseBody();
		System.out.println(t);
		ahc.close();
	}

}
