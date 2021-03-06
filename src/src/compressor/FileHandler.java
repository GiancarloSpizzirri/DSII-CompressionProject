package compressor;

import java.io.*;
import java.util.List;

public class FileHandler {
	public static byte[] openFile(String filePath) {
		try {
			FileInputStream inputFile = new FileInputStream(filePath);
			byte[] fileData = inputFile.readAllBytes();
			inputFile.close();
			return fileData;	
		} catch (IOException e) {
			System.out.println(String.format("Failed to find or read file at: \"%s\". Exception: %s", filePath, e.getMessage()));
		}
		return null;

	}
	
	public static void saveFile(String filePath, List<Byte> fileData) {
		try {
			FileOutputStream outputFile = new FileOutputStream(filePath);
			byte[] fileDataArray = new byte[fileData.size()];
			
			// Convert List<Byte> to byte[] for output.
			for (int i = 0; i < fileDataArray.length; i++)
				fileDataArray[i] = fileData.get(i);
			
			outputFile.write(fileDataArray);
			outputFile.close();
		} catch (IOException e) {
			System.out.println(String.format("Failed to save file to: \"%s\". Exception: %s", filePath, e.getMessage()));
		}
	}
}
