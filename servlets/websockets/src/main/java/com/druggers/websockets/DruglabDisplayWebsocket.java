package com.druggers.websockets;

import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;
import com.druggers.domain.Order;
import org.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/druglabManagement")
public class DruglabDisplayWebsocket {

	@OnOpen
	public void open(Session session) {
		DruglabDisplaySessionHandler handler = DruglabDisplaySessionHandlerFactory.getHandler();
		handler.addSession(session);
	}
	
	@OnClose
	public void close(Session session) {
		DruglabDisplaySessionHandler handler = DruglabDisplaySessionHandlerFactory.getHandler();
		handler.removeSession(session);
	}
	
	@OnError
	public void onError (Throwable error) {
		throw new RuntimeException(error);
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
		JSONObject json = new JSONObject(message);
		Long id = json.getLong("id");
		String status = json.getString("status");

		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		menuDao.updateOrderStatus(id,status);

		Order order = menuDao.getOrder(id);
		DruglabDisplaySessionHandler handler = DruglabDisplaySessionHandlerFactory.getHandler();
		handler.amendOrder(order);
	}
}
