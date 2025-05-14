package task9_1P;

public class FileValidator {
	
	public static boolean isValidFileType(String fileName) {
        return fileName.endsWith(".pdf") || fileName.endsWith(".docx");
    }

}
