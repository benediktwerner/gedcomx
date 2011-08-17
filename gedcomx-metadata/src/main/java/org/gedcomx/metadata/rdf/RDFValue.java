/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.metadata.rdf;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.AnyAttributeDeserializer;
import org.gedcomx.rt.AnyAttributeSerializer;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.Map;

/**
 * An element representing an RDF value. For more information, see <a href="http://www.w3.org/TR/rdf-schema/#ch_value">RDF Schema, Section 4.5.3</a>,
 * <a href="http://www.w3.org/TR/2004/REC-rdf-primer-20040210/#rdfvalue">RDF Primer, Section 4.4</a>
 * and <a href="http://dublincore.org/documents/profile-guidelines/#appc">Using RDF properties in profiles: a technical primer</a>.
 *
 * @link http://www.w3.org/TR/rdf-schema/#ch_value
 * @link http://www.w3.org/TR/2004/REC-rdf-primer-20040210/#rdfvalue
 * @author Ryan Heaton
 */
public final class RDFValue {

  private String lang;
  private String value;
  private URI valueRef;
  private Map<QName, String> otherAttributes;

  /**
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the value of the property.
   */
  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the value of the property.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * The value of the property, if it can be expressed as a string. If the value can't be expressed as a string, use {@link #getValueRef() the value ref}.
   *
   * @return The value of the property.
   */
  @XmlElement ( name = "value", namespace = TypesNamespaces.RDF_NAMESPACE )
  public String getValue() {
    return value;
  }

  /**
   * The value of the property, if it can be expressed as a string. If the value can't be expressed as a string, use {@link #getValueRef() the value ref}.
   *
   * @param value The value of the property.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * The URI reference to the value. To be used, for example, if the value is structured data.
   * If a {@link #getValue() value} is assigned as well as a value reference, the value is to
   * be treated as a string representation of the resource being referenced.
   *
   * @return The URI reference to the value. To be used, for example, if the value is structured data.
   */
  @XmlAttribute( name = "resource", namespace = TypesNamespaces.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getValueRef() {
    return valueRef;
  }

  /**
   * The URI reference to the value. To be used, for example, if the value is structured data.
   * If a {@link #getValue() value} is assigned as well as a value reference, the value is to
   * be treated as a string representation of the resource being referenced.
   *
   * @param valueRef The URI reference to the value. To be used, for example, if the value is structured data.
   */
  public void setValueRef(URI valueRef) {
    this.valueRef = valueRef;
  }

  /**
   * Attribute extensions to the property.
   *
   * @return Attribute extensions to the property.
   */
  @XmlAnyAttribute
  @JsonSerialize (using = AnyAttributeSerializer.class)
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  /**
   * Attribute extensions to the property.
   *
   * @param otherAttributes Attribute extensions to the property.
   */
  @JsonDeserialize (using = AnyAttributeDeserializer.class)
  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }
}
