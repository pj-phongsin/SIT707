package task9_1P;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileValidatorTest {
	
	@Test
    public void testValidPDFFile() {
        assertTrue(FileValidator.isValidFileType("assignment.pdf"));
    }

    @Test
    public void testValidDOCXFile() {
        assertTrue(FileValidator.isValidFileType("report.docx"));
    }

    @Test
    public void testInvalidTXTFile() {
        assertFalse(FileValidator.isValidFileType("notes.txt"));
    }

    @Test
    public void testInvalidFileWithoutExtension() {
        assertFalse(FileValidator.isValidFileType("README"));
    }

    @Test
    public void testEmptyFileName() {
        assertFalse(FileValidator.isValidFileType(""));
    }

}
