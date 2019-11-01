package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {
	
	public static void readFromFile() {
		String fileName = "easywordslist.txt";
		Path path = Paths.get("resources", fileName);
		File file = path.toFile();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e) {

			System.out.println("Something went wrong with your file...");
		} catch (IOException e) {

			System.out.println("Something went wrong while reading from the file...");
		}

	}

	public static void writeToFile() {
		String fileName = "write_stuff.txt";

		Path path = Paths.get("resources", fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			output.println();
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("Hey, contact customer service!");
		} finally {
			output.close();
		}
	}

	public static void createOurFile() {
		String fileName = "write_stuff.txt";

		Path path = Paths.get("resources", fileName);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("The files were created successfully.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Something went terribly wrong!");
			}
		} else {
			System.out.println("The file already exists!");
		}

	}

	// This method will create a folder called resources and will check if it is
	// there
	// if it is there it wont make on for you, you only need to run this once
	public static void createDir() {
		// Create a string representing the name of the folder
		// that we want to create or verify that it already exists
		String dirPath = "resources";

		// This next line will turn the string reference above
		// into a path to use with the other file methods
		Path folder = Paths.get(dirPath);

		// This Files.notExists() method is checking to make sure that
		// the folder is not already there, otherwise it will create a new folder
		if (Files.notExists(folder)) {
			try {
				Files.createDirectories(folder);
				System.out.println("The file was created successfully!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Somethig went wrong with the folder creation");
			}
		} else {
			System.out.println("The folder already exists");
		}
	}


}
