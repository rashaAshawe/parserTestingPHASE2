package phase2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PuzzleParserTest {

    @Test
    void testParsePuzzleData() throws IOException {
        // Partition: filePath
        // Subdomain: Parsing puzzle data from a file
        // Test Cases:
        // 1. Valid file path with correct puzzle data
        // 2. Valid file path with empty puzzle data
        // 3. Invalid file path
        String[][] expectedPuzzle = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        String validFilePath =  "C:\\Users\\rasha\\Desktop\\valid_file.txt";
        String emptyFilePath = "C:\\Users\\rasha\\Desktop\\empty_file.txt";
        String invalidFilePath = "C:\\Users\\rasha\\Desktop\\invalid_file.txt";

        String[][] parsedPuzzle = PuzzleParser.parsePuzzleData(validFilePath);
        Assertions.assertArrayEquals(expectedPuzzle, parsedPuzzle);

        parsedPuzzle = PuzzleParser.parsePuzzleData(emptyFilePath);
        Assertions.assertEquals(0, parsedPuzzle.length);

        Assertions.assertThrows(IOException.class, () -> PuzzleParser.parsePuzzleData(invalidFilePath));
    }

    @Test
    void testCountRows() throws IOException {
        // Partition: filePath
        // Subdomain: Counting the number of rows in a file
        // Test Cases:
        // 1. Empty file (0 rows)
        // 2. File with a single row
        // 3. File with multiple rows
        String emptyFilePath = "C:\\Users\\rasha\\Desktop\\empty_file.txt";
        String singleRowFilePath = "C:\\Users\\rasha\\Desktop\\single_row_file.txt";
        String multipleRowsFilePath = "C:\\Users\\rasha\\Desktop\\multiple_rows_file.txt";

        int numRows = PuzzleParser.countRows(emptyFilePath);
        Assertions.assertEquals(0, numRows);

        numRows = PuzzleParser.countRows(singleRowFilePath);
        Assertions.assertEquals(1, numRows);

        numRows = PuzzleParser.countRows(multipleRowsFilePath);
        Assertions.assertEquals(5, numRows);
    }

    @Test
    void testCountCols() throws IOException {
        // Partition: filePath
        // Subdomain: Counting the number of columns in a file
        // Test Cases:
        // 1. Empty file (0 columns)
        // 2. File with a single row and one column
        // 3. File with a single row and multiple columns
        // 4. File with multiple rows with the same number of columns
        // 5. File with multiple rows with different numbers of columns
        String emptyFilePath = "C:\\Users\\rasha\\Desktop\\empty_file.txt";
        String singleColumnFilePath = "C:\\Users\\rasha\\Desktop\\single_column_file.txt";
        String multipleColumnsFilePath = "C:\\Users\\rasha\\Desktop\\multiple_columns_file.txt";
        String sameColumnsFilePath = "C:\\Users\\rasha\\Desktop\\same_columns_file.txt";
        String differentColumnsFilePath = "C:\\Users\\rasha\\Desktop\\different_columns_file.txt";

        int numCols = PuzzleParser.countCols(emptyFilePath);
        Assertions.assertEquals(0, numCols);

        numCols = PuzzleParser.countCols(singleColumnFilePath);
        Assertions.assertEquals(1, numCols);

        numCols = PuzzleParser.countCols(multipleColumnsFilePath);
        Assertions.assertEquals(7, numCols);

        numCols = PuzzleParser.countCols(sameColumnsFilePath);
        Assertions.assertEquals(5, numCols);

        numCols = PuzzleParser.countCols(differentColumnsFilePath);
        Assertions.assertEquals(6, numCols);
    }
}
