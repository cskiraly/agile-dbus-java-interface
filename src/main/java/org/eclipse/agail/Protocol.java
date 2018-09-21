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
import org.freedesktop.dbus.exceptions.DBusException;

import org.eclipse.agail.object.DeviceOverview;
import org.eclipse.agail.object.StatusType;

/**
 * Agile BLE Protocol interface
 *
 * @author dagi
 *
 */
public interface Protocol extends DBusInterface {

	public static String AGILE_INTERFACE = "org.eclipse.agail.protocol";

	/**
	 * TODO: Return device status
	 */
	@org.freedesktop.DBus.Description("enquiry the device status")
	public String Status();

	/**
	 *
	 * @return Driver unique code name example:
	 */
	@org.freedesktop.DBus.Description("Returns the driver name")
	public String Driver();

	/**
	 *
	 * @return Driver name example bluetooth low energy
	 */
	@org.freedesktop.DBus.Description("Returns the protocol name")
	public String Name();

	/**
	 *
	 * @return the last record received by the read or subscribe operation
	 */
	@org.freedesktop.DBus.Description("Store the last record received by read or subscribe")
	public byte[] Data();

	/**
	 * List of all devices discovered by the BLE protocol
	 *
	 * This list is updated by discover method
	 *
	 * TODO: Return list of devices TODO: The implementing class for this
	 * interface should hold the list and return
	 *
	 * @see BLEDevice for sample device implementation
	 */
	@org.freedesktop.DBus.Description("Returns list discovered protocol devices")
	public List<DeviceOverview> Devices();

	/**
	 * Setup connection and initialize BLE connection for the given device
	 *
	 * TODO: Instead of deviceAddress this method should receive device profile,
	 * and retrieve the id and other properties from it
	 *
	 * @return true if successfully connected, or if it was already connected
	 */
	@org.freedesktop.DBus.Description("Setup connection and initialize protocol connection for the given device")
	public void Connect(String deviceAddress) throws DBusException;

	/**
	 *
	 * Disconnect the BLE device
	 *
	 * TODO: Use device profile to disconnect the device
	 *
	 * @param deviceAddress
	 */
	@org.freedesktop.DBus.Description("Safely disconnect the device from the protocol adapter")
	public void Disconnect(String deviceAddress) throws DBusException;

	/**
	 * Get discovery status
	 */
	@org.freedesktop.DBus.Description("Get discovery status")
	public String DiscoveryStatus() throws DBusException;

	/**
	 * List all discovered BLE devices
	 *
	 * TODO - return list of devices
	 */
	@org.freedesktop.DBus.Description("Start device discovery")
	public void StartDiscovery() throws DBusException;

	/**
	 * Stop device discovery
	 */
	@org.freedesktop.DBus.Description("Stop device discovery")
	public void StopDiscovery();

	/**
	 * Send data over the protocol to the device
	 *
	 * TODO: Detail of this method should be discussed
	 */
	public void Write(String deviceAddress, Map<String, String> profile, byte[] payload) throws DBusException;

	/**
	 * Read data over the Protocol, may be cached in the Data property depending
	 * on implementation to save resources
	 */
	public byte[] Read(String deviceAddress, Map<String, String> profile) throws DBusException;

	/**
	 * Notification based read using dbus signaling
	 * test method
	 * @param deviceAddress
	 * @param profile
	 * @throws DBusException
	 */
	public byte[] NotificationRead(String deviceAddress, Map<String, String> profile) throws DBusException;
	
	/* Subscribe to data update over the protocol
	 *
	 * @param subscribeParams
	 * @throws DBusException 
	 */
	public void Subscribe(String deviceAddress, Map<String, String> profile) throws DBusException;

	/**
	 * unsubscribe to data update over the protocol
	 *
	 * @param subscribeParams
	 */
	public void Unsubscribe(String deviceAddress, Map<String, String> profile)throws DBusException;

	/**
	 * Check the status of the device
	 *
	 * @param deviceAddress
	 */
	public StatusType DeviceStatus(String deviceAddress);
	/**
	 * New data reading signal for subscribe methods
	 * 
	 * @author dagi
	 *
	 */
	public class NewRecordSignal extends DBusSignal {
 		/**
 		 * The value that is read from the component
 		 */
		public final byte[] record;
		
		public final String address;
		
		public final Map<String, String> profile;
		
		public NewRecordSignal(String path, byte[] record,  String address, Map<String, String> profile) throws DBusException {
			super(path, record, address, profile);
 			this.record = record;
			this.address = address;
			this.profile = profile;
		}

	}
}
