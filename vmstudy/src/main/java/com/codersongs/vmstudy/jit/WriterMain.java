package com.codersongs.vmstudy.jit;

/**
 * -XX:+PrintCompilation -client -Xcomp
 * -XX:+PrintCompilation -server -Xcomp �鿴����ĺ���
 * -XX:+PrintCompilation -server -Xcomp  -XX:+TieredCompilation ���뼶�����
 * -XX:+PrintCompilation -server -Xcomp -XX:+TieredCompilation -XX:NmethodSweepFraction=1 ����������zombie
 * 
 * @author Administrator
 *
 */
public class WriterMain {
	public static void main(String[] args) throws InterruptedException {
		long b=System.currentTimeMillis();
		WriterService ws=new WriterService();
		for(int i=0;i<20000000;i++){
			ws.service();
		}
		long e=System.currentTimeMillis();
		System.out.println("spend:"+(e-b));
		ws=null;
		System.gc();
		Thread.sleep(5000);
	}
}
