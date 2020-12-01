package biblemulticonverter.format.paratext.utilities;

import biblemulticonverter.format.paratext.ParatextBook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LocationParserTest {

    private final LocationParser parser = new LocationParser(false);

    @Test
    public void test_book_format() {
        assertTrue(parser.parse("MAT"));
        assertEquals(LocationParser.Format.BOOK, parser.getFormat());
        assertEquals(ParatextBook.ParatextID.ID_MAT, parser.getStartBook());
        assertNull(parser.getEndBook());
        assertEquals(-1, parser.getStartChapter());
        assertEquals(-1, parser.getEndChapter());
        assertNull(parser.getStartVerse());
        assertNull(parser.getEndVerse());
    }

    @Test
    public void test_book_range_format() {
        assertTrue(parser.parse("MAT-LUK"));
        assertEquals(LocationParser.Format.BOOK_RANGE, parser.getFormat());
        assertEquals(ParatextBook.ParatextID.ID_MAT, parser.getStartBook());
        assertEquals(ParatextBook.ParatextID.ID_LUK, parser.getEndBook());
        assertEquals(-1, parser.getStartChapter());
        assertEquals(-1, parser.getEndChapter());
        assertNull(parser.getStartVerse());
        assertNull(parser.getEndVerse());
    }

    @Test
    public void test_chapter_format() {
        assertTrue(parser.parse("MAT 10"));
        assertEquals(LocationParser.Format.CHAPTER, parser.getFormat());
        assertEquals(ParatextBook.ParatextID.ID_MAT, parser.getStartBook());
        assertNull(parser.getEndBook());
        assertEquals(10, parser.getStartChapter());
        assertEquals(-1, parser.getEndChapter());
        assertNull(parser.getStartVerse());
        assertNull(parser.getEndVerse());
    }

    @Test
    public void test_chapter_range_format() {
        assertTrue(parser.parse("MAT 10-12"));
        assertEquals(LocationParser.Format.CHAPTER_RANGE, parser.getFormat());
        assertEquals(ParatextBook.ParatextID.ID_MAT, parser.getStartBook());
        assertNull(parser.getEndBook());
        assertEquals(10, parser.getStartChapter());
        assertEquals(12, parser.getEndChapter());
        assertNull(parser.getStartVerse());
        assertNull(parser.getEndVerse());
    }

    @Test
    public void test_verse_format() {
        assertTrue(parser.parse("MAT 10:2"));
        assertEquals(LocationParser.Format.VERSE, parser.getFormat());
        assertEquals(ParatextBook.ParatextID.ID_MAT, parser.getStartBook());
        assertNull(parser.getEndBook());
        assertEquals(10, parser.getStartChapter());
        assertEquals(-1, parser.getEndChapter());
        assertEquals("2", parser.getStartVerse());
        assertNull(parser.getEndVerse());
    }

    @Test
    public void test_verse_range_format() {
        assertTrue(parser.parse("MAT 10:2-11:3"));
        assertEquals(LocationParser.Format.VERSE_RANGE, parser.getFormat());
        assertEquals(ParatextBook.ParatextID.ID_MAT, parser.getStartBook());
        assertNull(parser.getEndBook());
        assertEquals(10, parser.getStartChapter());
        assertEquals(11, parser.getEndChapter());
        assertEquals("2", parser.getStartVerse());
        assertEquals("3", parser.getEndVerse());
    }

    @Test
    public void test_invalid_verse_range_format() {
        assertFalse(parser.parse("MAT 10:2-11"));
        assertNull(parser.getFormat());
        assertNull(parser.getStartBook());
        assertNull(parser.getEndBook());
        assertEquals(-1, parser.getStartChapter());
        assertEquals(-1, parser.getEndChapter());
        assertNull(parser.getStartVerse());
        assertNull(parser.getEndVerse());
    }
}
