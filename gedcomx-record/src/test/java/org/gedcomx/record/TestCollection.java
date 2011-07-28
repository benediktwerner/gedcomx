package org.gedcomx.record;

import org.gedcomx.common.Extension;
import org.testng.annotations.Test;

import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Ryan Heaton
 */
@Test
public class TestCollection {

  /**
   * tests collection xml
   */
  public void testCollectionXml() throws Exception {
    RecordCollection collection = new RecordCollection();
    collection.setDescription("description");
    collection.setExtension(new Extension());
    collection.setId("id");
    collection.setParent(new RecordCollectionReference());
    collection.getParent().setHref(URI.create("urn:parent"));
    collection.setPublisher("publisher");
    collection.setTitle("title");
    collection = processThroughXml(collection);
    assertEquals("description", collection.getDescription());
    assertEquals("id", collection.getId());
    assertNotNull(collection.getExtension());
    assertEquals(URI.create("urn:parent"), collection.getParent().getHref());
    assertEquals("publisher", collection.getPublisher());
    assertEquals("title", collection.getTitle());
  }

  /**
   * tests collection json
   */
  public void testCollectionJson() throws Exception {
    RecordCollection collection = new RecordCollection();
    collection.setDescription("description");
    collection.setExtension(new Extension());
    collection.setId("id");
    collection.setParent(new RecordCollectionReference());
    collection.getParent().setHref(URI.create("urn:parent"));
    collection.setPublisher("publisher");
    collection.setTitle("title");
    collection = processThroughJson(collection);
    assertEquals("description", collection.getDescription());
    assertEquals("id", collection.getId());
    assertNotNull(collection.getExtension());
    assertEquals(URI.create("urn:parent"), collection.getParent().getHref());
    assertEquals("publisher", collection.getPublisher());
    assertEquals("title", collection.getTitle());
  }

}
