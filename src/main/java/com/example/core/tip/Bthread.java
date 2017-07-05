package com.example.core.tip;


public class Bthread extends Thread {
		public void run() {
			synchronized (ThreadSynObject.object) {
				try {
					System.out.println("B");
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
