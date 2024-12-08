import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryController {

    @FXML
    private Button HapusButton;

    @FXML
    private TextField JudulAlbum;

    @FXML
    private TextField JumlahRented;

    @FXML
    private TextField JumlahTotal;

    @FXML
    private TextField NamaArtis;

    @FXML
    private Button RentButton;

    @FXML
    private Button TambahButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private TableView<Album> albumTableView;

    @FXML
    private TableColumn<Album, String> albumNameColumn;

    @FXML
    private TableColumn<Album, String> artistColumn;

    @FXML
    private TableColumn<Album, Integer> availableColumn;

    @FXML
    private TableColumn<Album, Integer> totalColumn;

    // Observable list to store albums
    private ObservableList<Album> albumList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize TableView columns
        albumNameColumn.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        // Set the items to the TableView
        albumTableView.setItems(albumList);
    }

    @FXML
    public void handleTambahButtonAction() {
        try {
            // Validate input fields
            if (JudulAlbum.getText().isEmpty() || NamaArtis.getText().isEmpty() || 
                JumlahTotal.getText().isEmpty() || JumlahRented.getText().isEmpty()) {
                showAlert("Please fill in all fields");
                return;
            }

            String albumName = JudulAlbum.getText();
            String artist = NamaArtis.getText();
            int total = Integer.parseInt(JumlahTotal.getText());
            int rented = Integer.parseInt(JumlahRented.getText());

            // Validate total and rented numbers
            if (rented > total) {
                showAlert("Rented albums cannot be more than total albums");
                return;
            }

            // Create new album
            Album newAlbum = new Album(albumName, artist, total, total - rented, rented);
            
            // Add to list
            albumList.add(newAlbum);

            // Clear input fields
            clearInputFields();
        } catch (NumberFormatException e) {
            showAlert("Please enter valid numbers for Total and Rented");
        }
    }

    @FXML
    public void handleHapusButtonAction() {
        // Get selected album
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
            clearInputFields();
        } else {
            showAlert("Please select an album to delete");
        }
    }

    @FXML
    public void handleRentButtonAction() {
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        
        if (selectedAlbum != null) {
            if (selectedAlbum.getAvailable() > 0) {
                // Update album details
                selectedAlbum.setAvailable(selectedAlbum.getAvailable() - 1);
                selectedAlbum.setRented(selectedAlbum.getRented() + 1);
                
                // Refresh TableView
                albumTableView.refresh();
            } else {
                showAlert("No available albums to rent");
            }
        } else {
            showAlert("Please select an album to rent");
        }
    }

    @FXML
    public void handleUpdateButtonAction() {
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        
        if (selectedAlbum != null) {
            try {
                // Update album details from input fields
                selectedAlbum.setAlbumName(JudulAlbum.getText());
                selectedAlbum.setArtist(NamaArtis.getText());
                
                int total = Integer.parseInt(JumlahTotal.getText());
                int rented = Integer.parseInt(JumlahRented.getText());
                
                // Validate total and rented
                if (rented > total) {
                    showAlert("Rented albums cannot be more than total albums");
                    return;
                }
                
                selectedAlbum.setTotal(total);
                selectedAlbum.setAvailable(total - rented);
                selectedAlbum.setRented(rented);
                
                // Refresh TableView
                albumTableView.refresh();
                clearInputFields();
            } catch (NumberFormatException e) {
                showAlert("Please enter valid numbers for Total and Rented");
            }
        } else {
            showAlert("Please select an album to update");
        }
    }

    // Helper method to show alerts
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Clear input fields
    private void clearInputFields() {
        JudulAlbum.clear();
        NamaArtis.clear();
        JumlahTotal.clear();
        JumlahRented.clear();
    }
}