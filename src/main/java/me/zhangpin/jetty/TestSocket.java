package me.zhangpin.jetty;

import java.io.IOException;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

public class TestSocket implements WebSocket, OnTextMessage {

	public void onClose(int arg0, String arg1) {
		System.out.println("On close");
	}

	public void onOpen(final Connection conn) {
		System.out.println("On open");
		new Thread() {
			@Override
			public void run() {
				try {
					conn.sendMessage("Start counting");
					int i = 0;
					while (true) {
						sleep(1000);
						conn.sendMessage("Count " + i++);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void onMessage(String data) {
		System.out.println("Receive:" + data);
	}

}
