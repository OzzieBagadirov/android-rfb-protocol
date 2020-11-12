package com.adigium.androidrfb.RFB.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 'The RFB Protocol' documentation, page 16,
 * by Tristan Richardson, RealVNC Ltd.
 * <p>
 * Version 3.8, Last updated 26 November 2010
 */
public class ClientInit {

	public final boolean sharedDesktop;
	
	/**
	 * Shared-flag is non-zero (true) if the server should try to share the desktop by leaving
	 * other clients connected, zero (false) if it should give exclusive access to this client by
	 * disconnecting all other clients.
	 * <p>
	 * 
	 * @param sharedDesktop
	 */
	public ClientInit(final boolean sharedDesktop) {
		
		this.sharedDesktop = sharedDesktop;
	}

	public static ClientInit readClientInit(final InputStream in) throws IOException {
		
		int sharedDesktop = in.read();
		
		return new ClientInit(sharedDesktop > 0);
	}
}