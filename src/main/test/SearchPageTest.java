package main.test;

import java.util.List;

import controller.algorithm.CSVFileReadAlgorithm;
import controller.algorithm.JsonFileReadAlgorithm;
import controller.page.SearchPageController;
import controller.post.BlogViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.post.BlogPost;

public class SearchPageTest extends Application{
	
//	CSVFileReadAlgorithm csvFileReadAlgorithm = new CSVFileReadAlgorithm("data/csv/blog_new (1).csv");
//	List<String> listItems = csvFileReadAlgorithm.csvFileRead();
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// Thiết lập scene builder
		JsonFileReadAlgorithm jsonFileReadAlgorithm = new JsonFileReadAlgorithm("/data/json/datatwitter.json");
		final String SEARCH_PAGE_FXML_FILE_PATH = "/view/page/SearchPageView.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(SEARCH_PAGE_FXML_FILE_PATH));
		// Thiết lập controller và khởi tạo dữ liệu
		SearchPageController searchPageController = new SearchPageController();
		fxmlLoader.setController(searchPageController);
		Parent root = fxmlLoader.load();
		List<String> listItems = jsonFileReadAlgorithm.jsonReadAlgorithm();
		searchPageController.setData(listItems);
		primaryStage.setTitle("SearchPage");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}