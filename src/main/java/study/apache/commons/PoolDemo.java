package study.apache.commons;

import java.util.Date;

import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import com.hhz.util.DateUtils;

public class PoolDemo {
	
	public static void main(String[] args) throws Exception {
//		KeyedPoolableObjectFactory<String , Connection> fact = new MyKeyedPoolableObjectFactory<String, Connection>();
//		GenericKeyedObjectPool<String, Connection> pool = new GenericKeyedObjectPool<String, Connection>(fact, 100, GenericObjectPool.WHEN_EXHAUSTED_BLOCK, 100, true, true);
		PoolableObjectFactory<Connection> fact2 = new MyPoolableObjectFactory();
		GenericObjectPool<Connection> pool2 = new GenericObjectPool<Connection>(fact2, 3, GenericObjectPool.WHEN_EXHAUSTED_BLOCK, 4100, true, true);

		int cnt = 5;
		for(int i = 0; i < cnt; i++) {
			new MyThread("name:" + i, pool2).start();
		}
//		Thread.yield();
		Thread.sleep(10000L);
		pool2.close();
//		System.out.println("idle: " + pool2.getNumIdle());
//		Connection con = pool2.borrowObject();
//		System.out.println("idle: " + pool2.getNumIdle());
//		con.show("a");
//		pool2.returnObject(con);
//		
//		System.out.println("idle: " + pool2.getNumIdle());
//		System.out.println("a");
	}
}

class MyThread extends Thread {
	private GenericObjectPool<Connection> pool;
	private String name;
	
	public MyThread(String name, GenericObjectPool<Connection> pool) {
		this.name = name;
		this.pool = pool;
	}
	
	@Override
	public void run() {
		Connection conn  = null;
		try {
			conn = pool.borrowObject();
			Thread.sleep(3000L);
			conn.show(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class MyPoolableObjectFactory implements PoolableObjectFactory<Connection> {

	@Override
	public Connection makeObject() throws Exception {
		System.out.println("makeObject");
		return new Connection();
	}

	@Override
	public void destroyObject(Connection obj) throws Exception {
		System.out.println("destroyObject");
	}

	@Override
	public boolean validateObject(Connection obj) {
		System.out.println("validateObject");
		return true;
	}

	@Override
	public void activateObject(Connection obj) throws Exception {
		System.out.println("activateObject");
	}

	@Override
	public void passivateObject(Connection obj) throws Exception {
		System.out.println("passivateObject");
	}
	
}


class MyKeyedPoolableObjectFactory implements KeyedPoolableObjectFactory<String, Connection> {

	@Override
	public Connection makeObject(String key) throws Exception {
		return null;
	}

	@Override
	public void destroyObject(String key, Connection obj) throws Exception {
		
	}

	@Override
	public boolean validateObject(String key, Connection obj) {
		return false;
	}

	@Override
	public void activateObject(String key, Connection obj) throws Exception {
		
	}

	@Override
	public void passivateObject(String key, Connection obj) throws Exception {
		
	}

}

class Connection {
	public void show(String val) {
		System.out.println(DateUtils.toLongFormat(new Date()) + " value: " + val);
	}
}