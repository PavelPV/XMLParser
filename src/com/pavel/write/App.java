package com.pavel.write;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that contain all logic for working with randomAccessFile
 * Writing in file
 * @author Pavel
 * Date 04-12-2015
 */
public class App {
	
	private String fileName = "";
	
	private RandomAccessFile raFile ;
	
	public App() {}
	
	public App(String file) throws FileNotFoundException {
		this.fileName = file;		
		this.raFile = new RandomAccessFile(file, "rw");
	}
	
	/**
	 * Method that makes changes in all cases that will be found
	 * it has 3 modes:
	 * 0 - add new value before marker
	 * 1 - replace marker with new value
	 * 2 = add new value after marker 
	 * Also it change length of the file if it necessary(replace mode)
	 * @param marker - old string that keeps in file
	 * @param newText - new string that we want to insert 
	 * @param mode - mode of writing
	 * @throws IOException
	 */
	public void run(String marker, String newText, int mode) throws IOException {
		List<Integer> listOfIndex = this.getAllIndexOf(marker);
		switch (mode) {
		case 0 :
			for(int i = listOfIndex.size()-1; i >= 0; --i) {
				int index = listOfIndex.get(i);
				String t = this.readFrom(index);
				this.writeInto(index, t, newText + " ");
			}
			break;
		case 1 :
			for(int i = listOfIndex.size()-1; i >= 0; --i) {
				int index = listOfIndex.get(i);
				String t = this.readFrom(index + marker.length());
				this.writeInto(index, t, newText);
				if (newText.length() < marker.length()) {
					raFile.setLength(raFile.length() - (marker.length() - newText.length()));
				}
			}
			break;
		case 2 :
			for(int i = listOfIndex.size()-1; i >= 0; --i) {
				int index = listOfIndex.get(i);
				String t = this.readFrom(index + marker.length());
				this.writeInto(index + marker.length(), t, " " + newText);
			}
			break;
		default :
			return;
		}		
				
	}
	
	/**
	 * Method that makes changes only in specified index if it exist
	 * it has 3 modes:
	 * 0 - add new value before marker
	 * 1 - replace marker with new value
	 * 2 = add new value after marker 
	 * Also it change length of the file if it necessary(replace mode)
	 * @param marker - old string that keeps in file
	 * @param newText - new string that we want to insert 
	 * @param index - index of possible location marker
	 * @param mode - mode of writing
	 * @throws IOException
	 */
	public void run(String marker, String newText, int index, int mode) throws IOException {
		List<Integer> listOfIndex = this.getAllIndexOf(marker);
		if (!listOfIndex.contains(index)) {
			return;
		}
		String t;
		switch (mode) {
		case 0 : 
			t = this.readFrom(index);
			this.writeInto(index, t, newText + " ");
			break;
		case 1 : 
			t = this.readFrom(index + marker.length());
			this.writeInto(index, t, newText);
			if (newText.length() < marker.length()) {
				raFile.setLength(raFile.length() - (marker.length() - newText.length()));
			}
			break;
		case 2 :
			t = this.readFrom(index + marker.length());
			this.writeInto(index + marker.length(), t, " " + newText);
			break;
		default : 
			return;
		}
	}
	
	/**
	 * Method that read all file from specified index and save it
	 * this String used in writing(method run)
	 * it will be written after new text, because new text can override some important things
	 * @param index - integer value from file will be saved
	 * @return String from current index to the end of the file
	 * @throws IOException
	 */
	public String readFrom(int index) throws IOException {		
		this.raFile.seek(index);
		
		StringBuilder strBytes = new StringBuilder();
		
		int tempByte = this.raFile.read();
		
		while(tempByte!=-1) {
			strBytes.append((char)tempByte);
			tempByte = this.raFile.read();
		}
		
		String temp = strBytes.toString();
		
		return temp;
	}
	
	/**
	 * Method for writing into file
	 * @param index - parameter for putting cursor in this location
	 * @param temp - string that keeps value from current index to the end of the file
	 * @param newText - new text that needs to be written
	 * @throws IOException
	 */
	public void writeInto(int index, String temp, String newText) throws IOException {
		this.raFile.seek(index);
		
		this.raFile.writeBytes(newText);
		
		this.raFile.writeBytes(temp);
	}
	
	/**
	 * Find first index of current marker in file
	 * @param marker
	 * @return - int value - number of character position in file
	 * @throws IOException
	 */
	public int getFirstIndexOf(String marker) throws IOException {
		this.raFile.seek(0);
		
		String temp = this.raFile.readLine();
		
		while((temp!=null)&&(!temp.contains(marker))) {
			temp = this.raFile.readLine();
		}
		
		if (temp==null) {
			return -1;
		}
		/*
		 * logic that find position in current line
		 */
		int lineLength = temp.length() + 2;
		
		int posAtLine = temp.indexOf(marker);
		
		int index = (int)this.raFile.getFilePointer();
		
		index = index - (lineLength- posAtLine);
		
		return index;
	}
	
	/**
	 * Find first index of current maker in file from some index and by regex pattern
	 * @param marker - keeps regex pattern for searching in file
	 * @param ind - index from will be searched
	 * @return String value of marker that will be found
	 * @throws IOException
	 */
	public String getFirstIndexOfByPattern(String marker, int ind) throws IOException {
		this.raFile.seek(ind);
		
		Pattern pattern = Pattern.compile(marker);
		
		String temp = this.raFile.readLine();
		
		while((temp!=null)&&(!Pattern.matches(marker, temp))) {
			temp = this.raFile.readLine();
		}
		
		if (temp==null) {
			return "-1";
		}
		
		Matcher matcher = pattern.matcher(temp);
		
		matcher.find();
		
		String result = matcher.group(1);
		
		return result;
	}
	
	/**
	 * Find first index of current marker in file from some index
	 * @param marker - String that keeps marker
	 * @param ind index from will be searched
	 * @return int value - number of character position in file
	 * @throws IOException
	 */
	public int getFirstIndexOf(String marker, int ind) throws IOException {
		this.raFile.seek(ind);
		
		String temp = this.raFile.readLine();
		
		while((temp!=null)&&(!temp.contains(marker))) {
			temp = this.raFile.readLine();
		}
		
		if (temp==null) {
			return -1;
		}
		
		int lineLength = temp.length() + 2;
		
		int posAtLine = temp.indexOf(marker);
		
		int index = (int)this.raFile.getFilePointer();
		
		index = index - (lineLength- posAtLine);
		
		return index;
	}
	
	/**
	 * Method that search for all cases in all file by 1 marker
	 * @param marker - String for searching for
	 * @return Map of character indexes and lines
	 * @throws IOException
	 */
	public Map<Integer, String> getAllIndexAndLinesOf(String marker) throws IOException {
		this.raFile.seek(0);
		
		Map<Integer, String> mapOfIndex = new TreeMap<Integer, String>();
		
		String temp = this.raFile.readLine();
		
		while (temp!=null) {
			while((temp!=null)&&(!temp.contains(marker))) {
				temp = this.raFile.readLine();
			}
			
			if (temp==null) {
				break;
			}
			String sub = temp;
			while(sub.contains(marker)) {
				int lineLength = sub.length() + 2;
				
				int posAtLine = sub.indexOf(marker);
				
				int index = (int)this.raFile.getFilePointer();
				
				index = index - (lineLength- posAtLine);
				
				mapOfIndex.put(index, temp);
				
				sub = sub.substring(posAtLine + marker.length());
			}
			
			temp = this.raFile.readLine();			
		}
		return mapOfIndex;
	}
	
	/**
	 * Method that search for all cases in all file by 1 marker
	 * @param marker - String for searching for
	 * @return List of indexes of found cases
	 * @throws IOException
	 */
	public List<Integer> getAllIndexOf(String marker) throws IOException {
		this.raFile.seek(0);
		
		List<Integer> listOfIndex = new ArrayList<Integer>();
		
		String temp = this.raFile.readLine();
		
		while (temp!=null) {
			while((temp!=null)&&(!temp.contains(marker))) {
				temp = this.raFile.readLine();
			}
			
			if (temp==null) {
				break;
			}
			String sub = temp;
			while(sub.contains(marker)) {
				int lineLength = sub.length() + 2;
				
				int posAtLine = sub.indexOf(marker);
				
				int index = (int)this.raFile.getFilePointer();
				
				index = index - (lineLength- posAtLine);
				
				listOfIndex.add(index);
				
				sub = sub.substring(posAtLine + marker.length());
			}
			
			temp = this.raFile.readLine();			
		}		
		return listOfIndex;
	}
	
	/**
	 * Method that search for lines that contains current marker
	 * @param marker - String for searching for
	 * @return List of String that contains lines
	 * @throws IOException
	 */
	public List<String> getAllLinesOf(String marker) throws IOException {
		this.raFile.seek(0);
		
		List<String> listOfLines = new ArrayList<String>();
		
		String temp = this.raFile.readLine();
		
		int count = 1;
		
		while(temp!=null) {
			while((temp!=null)&&(!temp.contains(marker))) {
				temp = this.raFile.readLine();
				count++;
			}
			if (temp==null) {
				break;
			}
			listOfLines.add(temp);
			temp = this.raFile.readLine();
			count++;
		}
		
		return listOfLines;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String file) {
		this.fileName = file;
	}

	public RandomAccessFile getRaFile() {
		return raFile;
	}

	public void setRaFile(RandomAccessFile raFile) {
		this.raFile = raFile;
	}

	@Override
	public String toString() {
		return "App [file=" + fileName + "]";
	}

}
