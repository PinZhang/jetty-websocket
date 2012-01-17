package me.zhangpin.jetty;

import javax.servlet.http.HttpServletRequest;


import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class TestWebSocketServlet extends WebSocketServlet {

	private static final long serialVersionUID = 3149140241517553248L;

	public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
		return new TestSocket();
	}

}
