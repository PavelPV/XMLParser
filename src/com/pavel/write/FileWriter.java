package com.pavel.write;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that contain all logic for working with randomAccessFile
 * Writing in file
 *
 * @author Pavel P
 *         Date 04-12-2015
 */
public class FileWriter {

    private String fileName = "";
    private RandomAccessFile randomAccessFile;

    public FileWriter(String file) throws FileNotFoundException, IOException {
        this.fileName = file;
        this.randomAccessFile = new RandomAccessFile(file, "rw");
    }

    /**
     * Method that makes changes in all cases that will be found
     * it has 3 modes:
     * 0 - add new value before marker
     * 1 - replace marker with new value
     * 2 = add new value after marker
     * Also it change length of the file if it necessary(replace writeMode)
     *
     * @param marker  - old string that keeps in file
     * @param newText - new string that we want to insert
     * @param writeMode    - writeMode of writing
     *
     * @throws IOException
     */
    public void changeFilePartUsingMode(String marker, String newText, int writeMode) throws IOException {
        List<Integer> listOfIndex = this.getAllIndexOf(marker);
        switch (writeMode) {
            case 0:
                for (int i = listOfIndex.size() - 1; i >= 0; --i) {
                    int index = listOfIndex.get(i);
                    String t = this.readFileFrom(index);
                    this.writeInto(index, t, newText + " ");
                }
                break;
            case 1:
                for (int i = listOfIndex.size() - 1; i >= 0; --i) {
                    int index = listOfIndex.get(i);
                    String t = this.readFileFrom(index + marker.length());
                    this.writeInto(index, t, newText);
                    if (newText.length() < marker.length()) {
                        randomAccessFile.setLength(randomAccessFile.length() - (marker.length() - newText.length()));
                    }
                }
                break;
            case 2:
                for (int i = listOfIndex.size() - 1; i >= 0; --i) {
                    int index = listOfIndex.get(i);
                    String t = this.readFileFrom(index + marker.length());
                    this.writeInto(index + marker.length(), t, " " + newText);
                }
                break;
            default:
                return;
        }

    }

    /**
     * Method that makes changes only in specified index if it exist
     * it has 3 modes:
     * 0 - add new value before marker
     * 1 - replace marker with new value
     * 2 = add new value after marker
     * Also it change length of the file if it necessary(replace writeMode)
     *
     * @param marker  - old string that keeps in file
     * @param newText - new string that we want to insert
     * @param indexOfMarker   - indexOfMarker of possible location marker(first symbol)
     * @param writeMode    - writeMode of writing
     *
     * @throws IOException
     */
    public void changeFilePartUsingMode(String marker, String newText, int indexOfMarker, int writeMode) throws IOException {
        String t;
        switch (writeMode) {
            case 0:
                t = this.readFileFrom(indexOfMarker);
                this.writeInto(indexOfMarker, t, newText + " ");
                break;
            case 1:
                t = this.readFileFrom(indexOfMarker + marker.length());
                this.writeInto(indexOfMarker, t, newText);
                if (newText.length() < marker.length()) {
                    randomAccessFile.setLength(randomAccessFile.length() - (marker.length() - newText.length()));
                }
                break;
            case 2:
                t = this.readFileFrom(indexOfMarker + marker.length());
                this.writeInto(indexOfMarker + marker.length(), t, " " + newText);
                break;
            default:
                return;
        }
    }


    /**
     * Method that makes changes only in specified index if it exist
     * it has 3 modes:
     * 0 - add new value before marker
     * 1 - replace marker with new value
     * 2 = add new value after marker
     * Also it change length of the file if it necessary(replace writeMode)
     *
     * @param markerLength  - length of old string that keeps in file
     * @param newText - new string that we want to insert
     * @param indexOfMarker   - indexOfMarker of possible location marker(first symbol)
     * @param writeMode    - writeMode of writing
     *
     * @throws IOException
     */
    public void changeFilePartUsingMode(int markerLength, String newText, int indexOfMarker, int writeMode) throws IOException {
        String t;
        switch (writeMode) {
            case 0:
                t = this.readFileFrom(indexOfMarker);
                this.writeInto(indexOfMarker, t, newText + " ");
                break;
            case 1:
                t = this.readFileFrom(indexOfMarker + markerLength);
                this.writeInto(indexOfMarker, t, newText);
                if (newText.length() < markerLength) {
                    randomAccessFile.setLength(randomAccessFile.length() - (markerLength - newText.length()));
                }
                break;
            case 2:
                t = this.readFileFrom(indexOfMarker + markerLength);
                this.writeInto(indexOfMarker + markerLength, t, " " + newText);
                break;
            default:
                return;
        }
    }

    /**
     * Method that read all file from specified indexFrom and save it
     * this String used in writing(method changeFilePartUsingMode)
     * it will be written after new text, because new text can override some important things
     *
     * @param indexFrom - integer value from file will be saved
     *
     * @return String from current indexFrom to the end of the file
     *
     * @throws IOException
     */
    public String readFileFrom(int indexFrom) throws IOException {
        this.randomAccessFile.seek(indexFrom);
        StringBuilder byteContainer = new StringBuilder();
        int tempByte = this.randomAccessFile.read();

        while (tempByte != -1) {
            byteContainer.append((char) tempByte);
            tempByte = this.randomAccessFile.read();
        }

        String text = byteContainer.toString();
        return text;
    }

    /**
     * Method that read all file from specified indexFrom to specify indexFrom and save it
     * this String used in writing(method changeFilePartUsingMode)
     * it will be written after new text, because new text can override some important things
     *
     * @param indexFrom - integer value from file will be saved
     * @param indexTo - integer value to file will be saved
     *
     * @return String from current indexFrom to specify indexFrom of the file
     *
     * @throws IOException
     */
    public String readFileFrom(int indexFrom, int indexTo) throws IOException {
        this.randomAccessFile.seek(indexFrom);
        StringBuilder byteContainer = new StringBuilder();
        int tempByte = this.randomAccessFile.read();

        while (this.randomAccessFile.getFilePointer() != indexTo) {
            byteContainer.append((char) tempByte);
            tempByte = this.randomAccessFile.read();
        }

        String text = byteContainer.toString();
        return text;
    }

    /**
     * Method for writing into file
     *
     * @param indexFrom   - parameter for putting cursor in this location
     * @param textToEndFile    - string that keeps value from current indexFrom to the end of the file
     * @param newText - new text that needs to be written
     *
     * @throws IOException
     */
    public void writeInto(int indexFrom, String textToEndFile, String newText) throws IOException {
        this.randomAccessFile.seek(indexFrom);
        this.randomAccessFile.writeBytes(newText);
        this.randomAccessFile.writeBytes(textToEndFile);
    }

    /**
     * Find first index of current marker in file
     *
     * @param marker
     *
     * @return - int value - number of character position in file
     *
     * @throws IOException
     */
    public int getFirstIndexOf(String marker) throws IOException {
        this.randomAccessFile.seek(0);
        String tempLine = this.randomAccessFile.readLine();
        long pointer = this.randomAccessFile.getFilePointer();

        while ((tempLine != null) && (!tempLine.contains(marker))) {
            pointer = this.randomAccessFile.getFilePointer();
            tempLine = this.randomAccessFile.readLine();
        }
        if (tempLine == null) {
            return -1;
        }
        /*
		 * logic that find position in current line
		 */
//        int lineLength = tempLine.length() + 1;
        int positionAtLine = tempLine.indexOf(marker);
        int resultIndex = (int)pointer + positionAtLine;
        return resultIndex;
    }

    /**
     * Find first index of current maker in file from some index and by regex pattern
     *
     * @param marker - keeps regex pattern for searching in file
     * @param indexFrom    - index from will be searched
     *
     * @return String value of marker that will be found
     *
     * @throws IOException
     */
    public String getValueInFirstIndexByPattern(String marker, int indexFrom) throws IOException {
        this.randomAccessFile.seek(indexFrom);
        Pattern pattern = Pattern.compile(marker);
        String tempLine = this.randomAccessFile.readLine();

        while ((tempLine != null) && (!Pattern.matches(marker, tempLine))) {
            tempLine = this.randomAccessFile.readLine();
        }
        if (tempLine == null) {
            return "-1";
        }

        Matcher matcher = pattern.matcher(tempLine);
        matcher.find();
        String result = matcher.group(1);
        return result;
    }

    /**
     * Find first index of current marker in file from some index
     *
     * @param marker - String that keeps marker
     * @param indexFrom    index from will be searched
     *
     * @return int value - number of character position in file
     *
     * @throws IOException
     */
    public int getFirstIndexOf(String marker, int indexFrom) throws IOException {
        this.randomAccessFile.seek(indexFrom);
        String tempLine = this.randomAccessFile.readLine();
        long pointer = this.randomAccessFile.getFilePointer();

        while ((tempLine != null) && (!tempLine.contains(marker))) {
            pointer = this.randomAccessFile.getFilePointer();
            tempLine = this.randomAccessFile.readLine();
        }
        if (tempLine == null) {
            return -1;
        }
        int positionAtLine = tempLine.indexOf(marker);
        int resultIndex = (int)pointer + positionAtLine;
        return resultIndex;
    }

    /**
     * Method that return first previous index of marker from currentindex
     *
     * @param marker - String for searching for
     * @param indexFrom - Index where search stop
     * @param indexTo - Index from searching start
     *
     * @return int value - index of first symbol in marker
     *
     * @throws IOException
     */
    public int getFirstPreviousIndex(String marker, int indexFrom, int indexTo) throws IOException {
        if (indexTo >= indexFrom) {
            String piece = this.readFileFrom(indexFrom, indexTo);
            int index = piece.lastIndexOf(marker);
            return indexFrom + index;
        } else {
            return -1;
        }
    }

    /**
     * Method that search for all cases in all file by 1 marker
     *
     * @param marker - String for searching for
     *
     * @return Map of character indexes and lines
     *
     * @throws IOException
     */
    public Map<Integer, String> getAllIndexAndLinesOf(String marker) throws IOException {
        this.randomAccessFile.seek(0);
        Map<Integer, String> resultMap = new TreeMap<Integer, String>();
        String tempLine = this.randomAccessFile.readLine();
        long pointer = this.randomAccessFile.getFilePointer();

        while (tempLine != null) {
            while ((tempLine != null) && (!tempLine.contains(marker))) {
                tempLine = this.randomAccessFile.readLine();
                pointer = this.randomAccessFile.getFilePointer();
            }
            if (tempLine == null) {
                break;
            }
            String subLine = tempLine;
            while (subLine.contains(marker)) {
//                int lineLength = subLine.length() + 2;
                int positionAtLine = subLine.indexOf(marker);
                int resultIndex = (int)pointer + positionAtLine;
                resultMap.put(resultIndex, tempLine);
                subLine = subLine.substring(positionAtLine + marker.length());
            }
            tempLine = this.randomAccessFile.readLine();
        }
        return resultMap;
    }

    /**
     * Method that search for all cases in all file by 1 marker
     *
     * @param marker - String for searching for
     *
     * @return List of indexes of found cases
     *
     * @throws IOException
     */
    public List<Integer> getAllIndexOf(String marker) throws IOException {
        this.randomAccessFile.seek(0);
        List<Integer> listOfIndex = new ArrayList<Integer>();
        String tempLine = this.randomAccessFile.readLine();
        long pointer = this.randomAccessFile.getFilePointer();

        while (tempLine != null) {
            while ((tempLine != null) && (!tempLine.contains(marker))) {
                pointer = this.randomAccessFile.getFilePointer();
                tempLine = this.randomAccessFile.readLine();
            }
            if (tempLine == null) {
                break;
            }
            String subLine = tempLine;
            while (subLine.contains(marker)) {
//                int lineLength = subLine.length() + 1;
                int positionAtLine = subLine.indexOf(marker);
                int resultIndex = (int) pointer + positionAtLine;
                listOfIndex.add(resultIndex);
                subLine = subLine.substring(positionAtLine + marker.length());
            }
            tempLine = this.randomAccessFile.readLine();
        }
        return listOfIndex;
    }

    /**
     * Method that search for lines that contains current marker
     *
     * @param marker - String for searching for
     *
     * @return List of String that contains lines
     *
     * @throws IOException
     */
    public List<String> getAllLinesOf(String marker) throws IOException {
        this.randomAccessFile.seek(0);
        List<String> listOfLines = new ArrayList<String>();
        String tempLine = this.randomAccessFile.readLine();

        while (tempLine != null) {
            while ((tempLine != null) && (!tempLine.contains(marker))) {
                tempLine = this.randomAccessFile.readLine();
            }
            if (tempLine == null) {
                break;
            }
            listOfLines.add(tempLine);
            tempLine = this.randomAccessFile.readLine();
        }

        return listOfLines;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String file) {
        this.fileName = file;
    }

    public RandomAccessFile getRandomAccessFile() {
        return randomAccessFile;
    }

    public void setRandomAccessFile(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public String toString() {
        return "FileWriter [file=" + fileName + "]";
    }

}
