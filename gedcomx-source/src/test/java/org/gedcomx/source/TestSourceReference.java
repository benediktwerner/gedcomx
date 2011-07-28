package org.gedcomx.source;

import org.gedcomx.types.SourceReferenceType;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestSourceReference {

  /**
   * tests source reference xml
   */
  public void testSourceReferenceXml() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceReferenceType.source);
    reference.setId("refid");
    reference.setQualifiers(new ArrayList<SourceQualifier>());
    SourceQualifier q = new SourceQualifier();
    q.setProperty(SourceQualifierProperty.height_pixels, "1234");
    reference.getQualifiers().add(q);
    reference = processThroughXml(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceReferenceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals("1234", reference.getQualifiers().get(0).getProperty(SourceQualifierProperty.height_pixels));
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceReferenceType.source);
    reference.setId("refid");
    reference.setQualifiers(new ArrayList<SourceQualifier>());
    SourceQualifier q = new SourceQualifier();
    q.setProperty(SourceQualifierProperty.height_pixels, "1234");
    reference.getQualifiers().add(q);
    reference = processThroughJson(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceReferenceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals("1234", reference.getQualifiers().get(0).getProperty(SourceQualifierProperty.height_pixels));
  }

}
