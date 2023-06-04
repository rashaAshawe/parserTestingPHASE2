package phase2;

import java.io.IOException;

public class tryParser {
	

	    public static void main(String[] args) {
	        // Test file path
	        String filePath =  "C:\\Users\\rasha\\Desktop\\valid_file.txt";

	        try {
	            // Parse the puzzle data
	            String[][] puzzle = PuzzleParser.parsePuzzleData(filePath);

	            // Print the parsed puzzle data
	            for (String[] row : puzzle) {
	                for (String cell : row) {
	                    System.out.print(cell + " ");
	                }
	                System.out.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


