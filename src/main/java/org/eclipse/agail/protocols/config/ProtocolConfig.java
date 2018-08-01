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
	public String key;

	@Position(1)
	@JsonProperty("value")
	public String value;

	@Position(2)
	@JsonProperty("name")
	public String name;

	@Position(3)
	@JsonProperty("description")
	public String description;

	@Position(4)
	@JsonProperty("mandatory")
	public boolean mandatory;

	@JsonCreator
	public ProtocolConfig(@JsonProperty("key") String _key, @JsonProperty("value") String _value,
			@JsonProperty("name") String _name, @JsonProperty("description") String _description,
			@JsonProperty("mandatory") boolean _mandatory) {
		this.key = _key;
		this.value = _value;
		this.name = _name;
		this.description = _description;
		this.mandatory = _mandatory;
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

}
