package edu.necklaceservice.util;

import edu.necklaceservice.model.Necklace;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInitializer {
	public static void init(Necklace necklace, String path) {
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
