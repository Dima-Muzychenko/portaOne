import java.awt.*;
import java.io.FileNotFoundException;

public class FileChoose {

    public String chooseFile() throws FileNotFoundException {
        FileDialog fileDialog = new FileDialog(new Frame(), "Select File to Open", FileDialog.LOAD);

        // Set the file dialog to open only .txt files (optional)
        fileDialog.setFile("*.txt");

        // Display the file dialog
        fileDialog.setVisible(true);

        // Get the chosen file
        String directory = fileDialog.getDirectory();
        String file = fileDialog.getFile();
        String filePath = null;

        if (directory != null && file != null) {
            // Combine directory and file to get the full path
            filePath = directory + file;

            // Now you can use the filePath variable to access the chosen file
            System.out.println("Selected file: " + filePath);
        } else {
            throw new FileNotFoundException();
        }
        return filePath;
    }

}
