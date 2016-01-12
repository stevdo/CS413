package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterToo {

	private String filePath;
	private String pin;

	public FileWriterToo(String filePath, String pin) {
		this.filePath = filePath;
		this.pin = pin;
	}

	public void write() {

		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileWriter(filePath));
		} catch (IOException e) {
			System.out.println("IOException in PinWriter; error writing to: "
					+ filePath);
		}

		System.out.println("FileWriterToo; printing pin to file");
		pw.println(pin);

		pw.flush();
		pw.close();
	}
}