package com.example.core.tip;


public class Athread extends Thread {
		public void run() {
			synchronized (ThreadSynObject.object) {
				try {
					System.out.println("A");
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
