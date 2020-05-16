package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

//Tasks:
//1) list all files from a directory recursively
//2) list all .txt files in a folder and delete them
//3) copy one file into another
//4) copy a file from one directory to another directory

public class FileAndStreams {
	public void listDirectory(String dirPath, int level) {
		System.out.println("\n------------All files------------");
        File dir = new File(dirPath);
        File[] firstLevelFiles = dir.listFiles();
        if (firstLevelFiles != null && firstLevelFiles.length > 0) {
            for (File aFile : firstLevelFiles) {
                for (int i = 0; i < level; i++) {
                    System.out.print("\t");
                }
                if (aFile.isDirectory()) {
                    System.out.println("[" + aFile.getName() + "]");
                    listDirectory(aFile.getAbsolutePath(), level + 1);
                } else {
                    System.out.println(aFile.getName());
                }
            }
        }
    }
	
	public void listtxtFile() {
File directoryPath = new File("C:/Users/Sangram/Desktop/Desk");
		
				
		//List text files only
		System.out.println("\n------------Text files------------");
		File[] files=directoryPath.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
	
	public void copyToAnother() {
		FileInputStream instream = null;
		FileOutputStream outstream = null;
		System.out.println("\n------------Copy files------------");
	    	try{
	    	    File infile =new File("C:/Users/Sangram/Desktop/Desk/san.txt");
	    	    File outfile =new File("C:/Users/Sangram/Desktop/ram.txt");
	 
	    	    instream = new FileInputStream(infile);
	    	    outstream = new FileOutputStream(outfile);
	 
	    	    byte[] buffer = new byte[1024];
	 
	    	    int length;

	    	    while ((length = instream.read(buffer)) > 0){
	    	    	outstream.write(buffer, 0, length);
	    	    }

	    	    //Closing the input/output file streams
	    	    instream.close();
	    	    outstream.close();

	    	    System.out.println("File copied successfully!!");
	 
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	 }
	}
	public static void main(String[] args) {
		FileAndStreams test = new FileAndStreams();
        String dirToList = "C:/Users/Sangram/Desktop/postmandownload/Data";
        test.listDirectory(dirToList, 0);
        
        test.listtxtFile();
        
        test.copyToAnother();
	}

}
