package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ColourWriter {

	private String filePath;
	private String colour;

	public ColourWriter(String filePath, String colour) {
		this.filePath = filePath;
		this.colour = colour;
	}

	public void write() {

		PrintWriter pw = null;
		FileReader fr = null;
		String pin = null;
		try {
			fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			pin = br.readLine();
			br.close();
		} catch (FileNotFoundException e1) {
			System.out.println("FileNotFoundException in ColourWriter; "
					+ filePath);
		} catch (IOException e) {
			System.out.println("IOException in ColourWriter");
		}

		try {
			pw = new PrintWriter(new FileWriter(filePath));
		} catch (IOException e) {
			System.out
					.println("IOException in ColourWriter; error writing to: "
							+ filePath);
		}

		System.out.println("ColourWriter; printing colour to file");
		pw.println(pin);
		pw.println(colour);

		pw.flush();
		pw.close();
	}
}