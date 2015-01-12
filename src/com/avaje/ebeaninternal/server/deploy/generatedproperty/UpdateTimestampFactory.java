package com.avaje.ebeaninternal.server.deploy.generatedproperty;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;

import com.avaje.ebeaninternal.api.ClassUtil;
import com.avaje.ebeaninternal.server.deploy.meta.DeployBeanProperty;

/**
 * Helper for creating Update timestamp GeneratedProperty objects.
 */
public class UpdateTimestampFactory {

	final GeneratedUpdateLong longTime = new GeneratedUpdateLong();

  Map<Class<?>, GeneratedProperty> map = new HashMap<Class<?>, GeneratedProperty>();

  public UpdateTimestampFactory() {
    map.put(Timestamp.class, new GeneratedUpdateTimestamp());
    map.put(java.util.Date.class, new GeneratedUpdateDate());
    map.put(Long.class, longTime);
    map.put(long.class, longTime);

    if (ClassUtil.isPresent("java.time.LocalDate", this.getClass())) {
      map.put(LocalDateTime.class, new GeneratedUpdateJavaTime.LocalDT());
      map.put(OffsetDateTime.class, new GeneratedUpdateJavaTime.OffsetDT());
      map.put(ZonedDateTime.class, new GeneratedUpdateJavaTime.ZonedDT());
    }
  }

	public void setUpdateTimestamp(DeployBeanProperty property) {

		property.setGeneratedProperty(createUpdateTimestamp(property));
	}
	
	/**
	 * Create the update GeneratedProperty depending on the property type.
	 */
	protected GeneratedProperty createUpdateTimestamp(DeployBeanProperty property) {

    Class<?> propType = property.getPropertyType();
    GeneratedProperty generatedProperty = map.get(propType);
    if (generatedProperty != null) {
      return generatedProperty;
    }

		throw new PersistenceException("Generated update Timestamp not supported on "+propType.getName());
	}
	
}
