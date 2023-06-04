package phase2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PuzzleParser {

    // Private constructor to prevent instantiation
    private PuzzleParser() {
    }

    /*
      * @param filePath the path of the file containing the puzzle data
      * @return a 2D array of strings representing the parsed puzzle data
      * @throws IOException if an I/O error occurs while reading the file
     */
    /*
      @ Test 
      partition:
    
      subdomain :
      Test Cases :
      
      */
    public static String[][] parsePuzzleData(String filePath) throws IOException {
        // Create a BufferedReader to read the puzzle data from the file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Determine the number of rows and columns in the file
        int numRows = countRows(filePath);
        int numCols = countCols(filePath);

        // Create a 2D array to store the puzzle data
        String[][] puzzle = new String[numRows][numCols];

        // Reset the reader to the beginning of the file
        reader.close();
        reader = new BufferedReader(new FileReader(filePath));

        // Loop through each line in the file and parse the puzzle data
        int row = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] cells = line.split(" ");
            for (int col = 0; col < cells.length; col++) {
                puzzle[row][col] = cells[col];
            }
            row++;
        }

        // Close the reader and return the parsed puzzle data
        reader.close();
        return puzzle;
    }

    /**
     * @param filePath the path of the file to count the rows in
     * @return the number of rows in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
     // @ Test :
     // partition:
     // 1. filePath
     // subdomain :
     // 1.1 The file is empty (0 columns)
     // 1.2 The file contains a single row
     // 1.3 The file contains multiple rows
     // Test Cases :
     // File is empty (cover 1.1) --> return zero row
     // File includes the following : 1 2 3 4 5 6 7 (cover 1.2) --> return 1 rows
     // File includes the following : 5 4 3 2 1 (cover 1.3) --> reuturn 5 columns
     //                               1 2 3 4 5 
    static int countRows(String filePath) throws IOException {
        // Create a BufferedReader to read the puzzle data from the file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Count the number of rows in the file
        int numRows = 0;
        while (reader.readLine() != null) {
            numRows++;
        }

        // Close the reader and return the number of rows
        reader.close();
        return numRows;
    }

    /**
     * @param filePath the path of the file to count the columns in
     * @return the number of columns in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    /*
     // @ Test :
     // partition:
     // 1. filePath
     // subdomain :
     // 1.1 The file is empty (0 columns)
     // 1.2 The file contains a single row with one column
     // 1.3 The file contains a single row with multiple columns
     // 1.4 The file contains multiple rows with the same number of columns
     // 1.5 The file contains multiple rows with different numbers of columns
     // Test Cases :
     // File is empty (cover 1.1) --> return zero column
     // File has number 4 only (cover 1.2) --> return 1 column
     // File includes the following : 1 2 3 4 5 6 7 (cover 1.3) --> return 7 columns
     // File includes the following : 5 4 3 2 1 (cover 1.4) --> reuturn 5 columns
     //                               1 2 3 4 5 
     // File includes the following : 1 2 3 4 (cover 1.5) --> return 6 columns
     //                               1 2
     //                               1 2 3 4 5 6 
      * 
      * 
      * */
    static int countCols(String filePath) throws IOException {
        // Create a BufferedReader to read the puzzle data from the file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Determine the number of columns in the file
        int numCols = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            int count = line.split(" ").length;
            if (count > numCols) {
                numCols = count;
            }
        }

        // Close the reader and return the number of columns
        reader.close();
        return numCols;
    }

}
