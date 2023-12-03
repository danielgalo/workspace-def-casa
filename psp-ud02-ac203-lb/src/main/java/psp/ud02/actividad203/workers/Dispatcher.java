package psp.ud02.actividad203.workers;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import psp.ud02.actividad203.utils.PropertiesProcesser;

public class Dispatcher extends Thread {

	/** Properties file */
	private String propertiesFile;

	/**
	 * Constructor
	 * 
	 * @param propertiesFile
	 */
	public Dispatcher(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}

	@Override
	public void run() {

		// Obtain the properties to work with
		PropertiesProcesser properties = new PropertiesProcesser(propertiesFile);

		int maxWidth = properties.getMaxWidth();
		int maxHeight = properties.getMaxHeigth();

		String inputFolder = properties.getInputFolder();
		String outputFolder = properties.getOutputFolder();

		if (!folderExists(inputFolder)) {
			// If the folder does not exists, use the workspace folder
			inputFolder = "";
		}
		// Monitor the input folder specified in the properties
		monitorFolder(inputFolder, outputFolder, maxWidth, maxHeight);
	}

	/**
	 * Monitors a folder, watches for an entry event. Creates as many threads as new
	 * files entries. These threads process the file.
	 * 
	 * @param monitoredFolder
	 */
	private void monitorFolder(String monitoredFolder, String outputFolder, int maxWidth, int maxHeight) {

		// Create a WatchService
		try (WatchService watchService = FileSystems.getDefault().newWatchService()) {

			// Register the folder for ENTRY_CREATE events
			Path folder = Paths.get(monitoredFolder);
			folder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			// Infinite loop to watch for events
			while (true) {
				WatchKey key = watchService.take(); // Wait for events

				// Process events
				for (WatchEvent<?> event : key.pollEvents()) {
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						// A new file is created
						Path filePath = (Path) event.context();
						String newFilePath = folder.resolve(filePath).toString();

						// Create a worker that processes the file
						Worker worker = new Worker(newFilePath, outputFolder, maxWidth, maxHeight);
						worker.start();
					}
				}

				// Reset the key
				if (!key.reset()) {
					break;
				}
			}

		} catch (IOException | InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param folderPath
	 * @return
	 */
	public static boolean folderExists(String folderPath) {
		Path path = Paths.get(folderPath);

		// Check if the path points to an existing directory
		return Files.exists(path) && Files.isDirectory(path);
	}

}
