package org.eclipse.agail.protocols;

import java.util.List;
import java.util.Map;

import org.eclipse.agail.Protocol;
import org.freedesktop.dbus.exceptions.DBusException;

public interface BLEProtocol extends Protocol {
	
//	public static String AGILE_INTERFACE = "org.eclipse.agail.protocols.bleprotocol";
	
	/**
	 * Get the list of Services / sensors
	 *
	 * @param deviceAddress
	 */
	@org.freedesktop.DBus.Description("Return the list of BLE device sensors/services with charateristics")
	public Map<String, List<String>> GetSensors(String deviceAddress) throws DBusException;

}
