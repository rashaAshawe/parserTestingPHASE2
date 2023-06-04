package phase2;

import java.io.FileWriter;
import java.io.IOException;

public class CreateTestFiles {

    public static void main(String[] args) {
        String validFilePath = "C:\\Users\\rasha\\Desktop\\valid_file.txt";
        String emptyFilePath = "C:\\Users\\rasha\\Desktop\\empty_file.txt";
        String invalidFilePath = "C:\\Users\\rasha\\Desktop\\invalid_file.txt";
        String singleRowFilePath = "C:\\Users\\rasha\\Desktop\\single_row_file.txt";
        String multipleRowsFilePath = "C:\\Users\\rasha\\Desktop\\multiple_rows_file.txt";
        String singleColumnFilePath = "C:\\Users\\rasha\\Desktop\\single_column_file.txt";
        String multipleColumnsFilePath = "C:\\Users\\rasha\\Desktop\\multiple_columns_file.txt";
        String sameColumnsFilePath = "C:\\Users\\rasha\\Desktop\\same_columns_file.txt";
        String differentColumnsFilePath = "C:\\Users\\rasha\\Desktop\\different_columns_file.txt";

        try {
            createFile(validFilePath, "1 2 3\n4 5 6\n7 8 9");
            createFile(emptyFilePath, "");
            // Invalid file path, no need to create

            createFile(singleRowFilePath, "1 2 3 4 5 6 7");
            createFile(multipleRowsFilePath, "1 2 3\n4 5 6\n7 8 9\n10 11 12\n13 14 15");

            createFile(singleColumnFilePath, "1\n2\n3\n4");
            createFile(multipleColumnsFilePath, "1 2 3 4 5 6 7");
            createFile(sameColumnsFilePath, "5 4 3 2 1\n1 2 3 4 5\n1 2 3 4 5\n1 2 3 4 5\n1 2 3 4 5");
            createFile(differentColumnsFilePath, "1 2 3 4\n1 2\n1 2 3 4 5 6");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile(String filePath, String content) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }
}
