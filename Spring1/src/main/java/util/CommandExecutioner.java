package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutioner {
	
	String command = null,
		   directory = null;
	
	public CommandExecutioner() {}
	
	public CommandExecutioner(String command, String directory) {
		this.command = command;
		this.directory = directory;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	public String execute() {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(String.format("sh -c " + command + " %s", directory));
		} catch (IOException e) { e.printStackTrace(); System.err.println("Execution of command " + command + " failed!"); return null;}
		if(process == null) { System.err.println("Process is null!"); return null; }
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    	StringBuffer stringBuffer = new StringBuffer();
    	String line;
    	try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\n");
			}
		} catch (IOException e1) { e1.printStackTrace(); System.err.println("BufferedReader failed!"); return null;}
    	int exitCode;
    	try {
			exitCode = process.waitFor();
		} catch (InterruptedException e) { e.printStackTrace(); return "Process was interrupted!";}
    	assert exitCode == 0;
    	return stringBuffer.toString();
}	}
