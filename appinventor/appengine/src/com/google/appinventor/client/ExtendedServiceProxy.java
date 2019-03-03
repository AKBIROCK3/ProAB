// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2016-2020 AppyBuilder.com, All Rights Reserved - Info@AppyBuilder.com
// https://www.gnu.org/licenses/gpl-3.0.en.html

// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client;

import com.google.gwt.user.client.rpc.RemoteService;

import java.util.HashSet;
import java.util.Set;

/**
 * Extended interface that is implemented by all service proxies that are
 * generated by
 * {@link com.google.appinventor.rebind.ExtendedServiceProxyGenerator}. This
 * interface adds two features to service proxies:
 * <ol>
 * <li>Clients can be notified of all service calls by attaching
 * {@link RpcListener}s to the service proxy using the
 * {@link #addRpcListener(RpcListener)} method.
 * </ol>
 *
 * @param <T> the synchronous service interface
 */
public class ExtendedServiceProxy<T extends RemoteService> {
  // Listeners to be notified of RPC events
  private final Set<RpcListener> listeners = new HashSet<RpcListener>();

  /**
   * Adds a listener that is notified of RPC events.
   *
   * @param listener the listener
   */
  public void addRpcListener(RpcListener listener) {
    listeners.add(listener);
  }

  /**
   * Removes a listener that has been added using the
   * {@link #addRpcListener(RpcListener)} method before.
   *
   * @param listener the listener
   */
  public void removeRpcListener(RpcListener listener) {
    listeners.remove(listener);
  }

  /**
   * Calls the {@link RpcListener#onStart(String, Object...)} method for all
   * listeners.
   *
   * @param method the name of the RPC method that was called
   * @param params the params of the RPC method that was called
   */
  protected void fireStart(String method, Object... params) {
    for (RpcListener listener : listeners) {
      listener.onStart(method, params);
    }
  }

  /**
   * Calls the {@link RpcListener#onSuccess(String, Object)} method for all
   * listeners.
   *
   * @param method the name of the RPC method that was successfully completed
   * @param result the result of the RPC method
   */
  protected void fireSuccess(String method, Object result) {
    for (RpcListener listener : listeners) {
      listener.onSuccess(method, result);
    }
  }

  /**
   * Calls the {@link RpcListener#onFailure(String, Throwable)} method for all
   * listeners.
   *
   * @param method the name of the RPC method that threw an exception.
   * @param caught the thrown exception
   */
  protected void fireFailure(String method, Throwable caught) {
    for (RpcListener listener : listeners) {
      listener.onFailure(method, caught);
    }
  }
}
