package com.druggers.websockets;

public class DruglabDisplaySessionHandlerFactory {

	private static DruglabDisplaySessionHandler handler;
	
	public static DruglabDisplaySessionHandler getHandler() {
		if (handler == null) handler = new DruglabDisplaySessionHandler();
		return handler;
	}
}
