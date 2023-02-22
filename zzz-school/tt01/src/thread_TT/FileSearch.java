package thread_TT;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileSearch implements Runnable {
	private String FileName;
	private String Directory;

	private PrintWriter pw = null;

	@Override
	public void run() {
		try {
			processDir(new File(Directory));
		} catch (InterruptedException e) {
			System.out.printf("%s : The search has been interrupted\n", Thread.currentThread().getName());
			System.out.println("Reason: " + e.getMessage());

		}
	}

	public FileSearch(String file, String dir, OutputStreamWriter out) {
		this.FileName = file;
		this.Directory = dir;
		pw = new PrintWriter(out);
	}

	private void prcessFile(File file) throws InterruptedException {
		System.out.println("File: " + file);
		pw.write("File: " + file + "\n");
		if (file.isFile()) {
			if (file.getName().equals(FileName)) {
				System.out.println("----------FOUND-------------");
				System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
				throw new InterruptedException("HAS FOUND");
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}

	}

	private void processDir(File dir) throws InterruptedException {
		System.out.println("Dir: " + dir);
		pw.write("Dir: " + dir + "\n");
		File[] files = dir.listFiles();
		if (files != null && files.length != 0) {
			for (File file2 : files) {
				if (file2.isDirectory()) {
					processDir(file2);
				} else {
					prcessFile(file2);
				}
			}
		}
		if (Thread.interrupted()) {
			new InterruptedException();
		}

	}

	public static void main(String[] args) throws IOException {
		FileSearch searcher = new FileSearch("gradle.properties", "G:/", new FileWriter("logs/FileSearchLog.txt"));
		Thread thread = new Thread(searcher);
		thread.start();
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
