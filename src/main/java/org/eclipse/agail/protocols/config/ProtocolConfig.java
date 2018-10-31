package org.eclipse.agail.protocols.config;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"parameters"})
public class ProtocolConfig extends Struct {

	@Position(0)
	@JsonProperty("key")
	public String key = "";
	
	@Position(1)
	@JsonProperty("type")
	public String type = "";

	@Position(2)
	@JsonProperty("value")
	public String value = "";
	
	@Position(3)
	@JsonProperty("default_value")
	public String default_value = "";

	@Position(4)
	@JsonProperty("name")
	public String name = "";

	@Position(5)
	@JsonProperty("description")
	public String description = "";

	@Position(6)
	@JsonProperty("mandatory")
	public boolean mandatory = false;
	
	@Position(7)
	@JsonProperty("valid_values")
	public String valid_values = "";

	@JsonCreator
	public ProtocolConfig(@JsonProperty("key") String _key, @JsonProperty("type") String _type, @JsonProperty("value") String _value,
			@JsonProperty("default_value") String _default_value, @JsonProperty("name") String _name, 
			@JsonProperty("description") String _description, @JsonProperty("mandatory") boolean _mandatory,
			@JsonProperty("valid_vlaues") String _valid_vlaues) {
		this.key = _key;
		this.value = _value;
		this.name = _name;
		this.description = _description;
		this.mandatory = _mandatory;
		this.default_value = _default_value;
		this.type = _type;
		this.valid_values = _valid_vlaues;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the mandatory
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * @param mandatory the mandatory to set
	 */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param mandatory the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the default_value
	 */
	public String getDefault_value() {
		return default_value;
	}

	/**
	 * @param mandatory the default_value to set
	 */
	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}

	/**
	 * @return the valid_values
	 */
	public String getValid_values() {
		return valid_values;
	}

	/**
	 * @param mandatory the valid_values to set
	 */
	public void setValid_values(String valid_values) {
		this.valid_values = valid_values;
	}
	
	public String toStringObj() {
		return "Key: " + key + " Type: " + type + " Value: " + value + " Mandatory: " + mandatory + 
				" ValidValues: " + valid_values + " DefaultValue: " + default_value + " Name: " + name + " Description: " + description;
	}

}
