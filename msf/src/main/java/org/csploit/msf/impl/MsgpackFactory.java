package org.csploit.msf.impl;

import org.csploit.msf.api.*;
import org.csploit.msf.api.Framework;

import java.io.IOException;

/**
 * A factory that create MSF stuff using a Messagepack connection
 */
public class MsgpackFactory {
  private final MsgpackClient client;

  /**
   * create a {@link MsgpackFactory} using the specified parameters
   * @param host to connect to
   * @param username username
   * @param password password
   * @param port port to connect to
   * @param ssl shall we connect using SSL ?
   */
  public MsgpackFactory(String host, String username, String password, int port, boolean ssl)
          throws IOException, MsfException {
    this.client = new MsgpackClient(host, username, password, port, ssl);
  }

  /**
   * create a {@link Framework}
   * @return
   */
  public Framework createFramework() {
    return MsgpackProxy.Factory.newFramework(client);
  }

  /**
   * create a {@link ConsoleManager}
   * @return
   */
  public ConsoleManager createConsoleManager() {
    return new MsgpackConsoleManager(client);
  }
}