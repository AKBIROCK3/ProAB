// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2016-2020 AppyBuilder.com, All Rights Reserved - Info@AppyBuilder.com
// https://www.gnu.org/licenses/gpl-3.0.en.html

// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.shared.rpc.user;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Interface for the service providing user related information. All
 * declarations in this interface are mirrored in {@link UserInfoService}.
 * For further information see {@link UserInfoService}.
 *
 */
public interface UserInfoServiceAsync {

  /**
   * @see UserInfoService#getSystemConfig()
   */
  void getSystemConfig(String sessionId, AsyncCallback<Config> callback);

  /**
   * @see UserInfoService#getUserBackpack()
   */
  void getUserBackpack(AsyncCallback<String> callback);

  /**
   * @see UserInfoService#getUserInformation()
   */
  void getUserInformation(String sessionId, AsyncCallback<User> callback);

  /**
   * @see UserInfoService#getUserInformationByUserId(String)
   */
  void getUserInformationByUserId(String userId, AsyncCallback<User> callback);

  /**
   * @see UserInfoService#loadUserSettings()
   */
  void loadUserSettings(AsyncCallback<String> callback);

  /**
   * @see UserInfoService#storeUserBackpack(String)
   */
  void storeUserBackpack(String backpack, AsyncCallback<Void> callback);

  /**
   * @see UserInfoService#storeUserSettings(String)
   */
  void storeUserSettings(String settings, AsyncCallback<Void> callback);

  /**
   * @see UserInfoService#storeNameSettings(String)
   */
  void storeUserName(String name, AsyncCallback<Void> callback);

  /**
   * @see UserInfoService#storeNameLink(String)
   */
  void storeUserLink(String link, AsyncCallback<Void> callback);

  /**
   * @see UserInfoService#storeUserEmailFrequency(int)
   */
  void storeUserEmailFrequency(int emailFrequency, AsyncCallback<Void> callback);

  /**
   * @see UserInfoService#hasUserFile(String)
   */
  void hasUserFile(String fileName, AsyncCallback<Boolean> callback);

  /**
   * @see UserInfoService#deleteUserFile(String)
   */
  void deleteUserFile(String fileName, AsyncCallback<Void> callback);

  /**
   * @see UserInfoService#noop(String)
   */
  void noop(AsyncCallback<Void> callback);

}
