package org.erdtman.jcs;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by erdtman on 2018-06-12.
 */

public class CanonicalizationTests
{
  private static String INPUT_DIR = "src/test/resources/input/";
  private static String OUTPUT_DIR = "src/test/resources/output/";

  private static byte[] readFile(String filename) throws IOException {
    FileInputStream in = new FileInputStream(new File(filename));
    ByteArrayOutputStream out = new ByteArrayOutputStream(10000);

    byte[] buffer = new byte[10000];
    int bytes;
    while ((bytes = in.read(buffer)) != -1) {
      out.write(buffer, 0, bytes);
    }
    in.close();
    return out.toByteArray();
  }

  private static void test(String filename) throws IOException {
    byte[] rawInput = readFile(INPUT_DIR + filename);
    byte[] expected = readFile(OUTPUT_DIR + filename);
    byte[] actual = new JsonCanonicalizer(rawInput).getEncodedUTF8();
    Assert.assertArrayEquals(expected, actual);
  }

  @Test
  public void arrays() throws IOException {
    test("arrays.json");
  }

  @Test
  public void french() throws IOException {
    test("french.json");
  }

  @Test
  public void structures() throws IOException {
    test("structures.json");
  }

  @Test
  public void values() throws IOException {
    test("values.json");
  }

  @Test
  public void weird() throws IOException {
    test("weird.json");
  }
}
