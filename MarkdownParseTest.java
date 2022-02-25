import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        System.out.println("Hi");
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getSnippit1Links() throws IOException{
        List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
        Path fileName = Path.of("Snippit1.md");
	    String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    } 

    @Test
    public void getSnippit2Links() throws IOException{
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        Path fileName = Path.of("Snippit2.md");
	    String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    } 

    @Test
    public void getSnippit3Links() throws IOException{
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        Path fileName = Path.of("Snippit3.md");
	    String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}  