/*******************************************************************************
 * Copyright (C) 2017 Create-Net / FBK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Create-Net / FBK - initial API and implementation
 ******************************************************************************/

package org.eclipse.agail;

import java.util.List;
import java.util.Map;

import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusSignal;
import org.freedesktop.dbus.Variant;
import org.freedesktop.dbus.exceptions.DBusException;

import org.eclipse.agail.object.DeviceDefinition;
import org.eclipse.agail.object.DeviceComponent;
import org.eclipse.agail.object.RecordObject;
import org.eclipse.agail.object.StatusType;

/**
 * @author dagi
 *
 * Agile Device Interface
 *
 */
public interface Device extends DBusInterface {

  static String AGILE_INTERFACE = "org.eclipse.agail.Device";

  /**
   *
   * @return The unique device id on the gateway
   */
  @org.freedesktop.DBus.Description("Unique device ID in the gateway")
  public String Id();

  /**
   *
   * @return The device name
   */
  @org.freedesktop.DBus.Description("Name of the device")
  public String Name();

  /**
   *
   * @return Current Device status
   */
  @org.freedesktop.DBus.Description("Current Device status")
  public StatusType Status();

  /**
  *
  * @return
  *  LastSeen
  */
 @org.freedesktop.DBus.Description("Last seen time")
 public long LastSeen();

  /**
   *
   * @return return User configuration storage (in terms of KeyValue)
   */
  @org.freedesktop.DBus.Description("returns User configuration storage (in terms of KeyValue)")
  public String Configuration();

  /**
   *
   * @return Profile is protocol specific information of the device
   *
   */
  @org.freedesktop.DBus.Description("returns the profile of the device")
  public List<DeviceComponent> Profile();

  /**
   *
   * @return Attributes of an object in as a DeviceDefinition
   *
   */
  @org.freedesktop.DBus.Description("returns the definition of the device")
  public DeviceDefinition Definition();

  /**
   *
   * @return A RecordObject with the last data update received from the component
   */
  @org.freedesktop.DBus.Description("returns the last data update received by the device")
  public RecordObject LastUpdate(String componentID);

  /**
   *
   * @return A list of RecordObjects with the last read value of all components
   */
  @org.freedesktop.DBus.Description("returns the last data updates received by the device")
  public List<RecordObject> LastUpdateAll();

  /**
   *
   * @return the most recent update of a sensor or data stream Received
   * asynchronously from subscribe all
   */
  @org.freedesktop.DBus.Description("returns the most recent update of a sensor")
  public RecordObject Data();

  /**
   *
   * @return Device specific communication protocol instance Available to access
   * protocol specific methods and properties
   */
  @org.freedesktop.DBus.Description("returns Device specific communication  protocol instance")
  public String Protocol();

  // Methods
  /**
   * Setup connection and initialize BLE connection for the given device
   *
   * TODO: Instead of deviceAddress this method should receive device profile,
   * and retrieve the id and other properties from it
   */
  @org.freedesktop.DBus.Description("Setup connection and initialize BLE connection for the given device")
  public void Connect()throws DBusException;

  /**
   *
   * Disconnect the BLE device
   *
   * TODO: Use device profile to disconnect the device
   *
   * @param deviceAddress
   */
  @org.freedesktop.DBus.Description("Safely disconnect the device from the BLE adapter")
  public void Disconnect() throws DBusException ;

  /**
   * Execute an operation on the device
   */
  @org.freedesktop.DBus.Description("Execute an operation on the device")
  public void Execute(String commandId) throws DBusException;

  /**
   * Read data from all components
   */
  @org.freedesktop.DBus.Description("Read data from all components")
  public List<RecordObject> ReadAll();

  /**
   * Read data from the device
   */
  @org.freedesktop.DBus.Description("Read data from the device")
  public RecordObject Read(String sensorName);

  /**
   * Write data on the device
     * @param componentName
     * @param payload
   */
  @org.freedesktop.DBus.Description("Write data on the device")
  public void Write(String componentName, String payload) throws DBusException;

  /**
   * Enable subscription
   */
  @org.freedesktop.DBus.Description("Enable subscription")
  public void Subscribe(String component) throws DBusException;

   /**
   * disable subscription
   */
  @org.freedesktop.DBus.Description("disable subscription")
  public void Unsubscribe(String component) throws DBusException;
  
  /**
   * Get list of all commands
     * @return 
     * @throws org.freedesktop.dbus.exceptions.DBusException
   */
  @org.freedesktop.DBus.Description("Get list of all commands")
  public List<String> Commands() throws DBusException;

  /**
   * Stop device gracefully
   */
 @org.freedesktop.DBus.Description("Stop device")
 public void Stop() throws DBusException;
	/**
	 * New data reading signal for subscribe methods
	 *
	 * @author dagi
	 *
	 */
	public class NewSubscribeValueSignal extends DBusSignal {
		public final RecordObject record;

		public NewSubscribeValueSignal(String path, RecordObject record) throws DBusException {
			super(path, record);
			this.record = record;
		}

	}
}
