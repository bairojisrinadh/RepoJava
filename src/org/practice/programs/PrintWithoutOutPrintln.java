package org.practice.programs;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintWithoutOutPrintln {

	public static void main(String[] args) throws IOException {
		System.err.print("Printed with err \n");
		System.out.format("%s", "using format \n");
		System.out.write("Using System.out.write \n".getBytes());
		PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));
		ps.print("using PrintStream \n");
		//System.console().writer().println("Using System.console().writer().println()");
	}

}
