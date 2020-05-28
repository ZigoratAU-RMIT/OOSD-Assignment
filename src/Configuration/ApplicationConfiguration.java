package Configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import Controller.Controller;


public class ApplicationConfiguration {
	
	private Properties prop = new Properties();
	private InputStream input = null;
	private int boardRows;
	private int boardColumns;
	private boolean gameTurn;
	private List<String> tilesList = new ArrayList<>();
	
	



	public ApplicationConfiguration() {		
	    try {
	        input = new FileInputStream("src/Configuration/config.properties");	        
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public void ReadApplicationConfiguration() {
		try {
			// load a properties file
	        prop.load(input);
	        // get the property value and print it out
	        
	        boardRows = Integer.parseInt(prop.getProperty("boardRows","8"));	      	
	        boardColumns = Integer.parseInt(prop.getProperty("boardColumns","8"));	
	        gameTurn = Boolean.parseBoolean(prop.getProperty("gameTurn","false"));	
	        String board = prop.getProperty("board","true");
	        if(board.length() > 0)
	        //tilesList = Arrays.asList(prop.getProperty("board","").split(","));	
	        tilesList = new LinkedList<>(Arrays.asList(prop.getProperty("board","").split(",")));
	        } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	public void WriteApplicationConfiguration(Controller controller) {
		try (OutputStream output = new FileOutputStream("src/Configuration/config.properties")) {

            Properties prop = new Properties();
            // set the properties value
            prop.setProperty("boardRows", String.valueOf(controller.getView().getBoard().getRow()));	      	
	        prop.setProperty("boardColumns",String.valueOf(controller.getView().getBoard().getColumn()));	
	        prop.setProperty("gameTurn",String.valueOf(controller.getView().getBoard().getEagleSharkTurn()));
	        tilesList.removeAll(tilesList);
	        for(int i=0; i<controller.getModel().getTiles().size(); i++) {
	        	tilesList.add(controller.getModel().getTiles().get(i).getAttribute());	        
	        }
	        prop.setProperty("board", String.join(",", tilesList));
            // save properties to project root folder
            prop.store(output, null);

            //System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
	}
	
	public int getBoardRows() {
		return boardRows;
	}

	public void setBoardRows(int boardRows) {
		this.boardRows = boardRows;
	}

	public int getBoardColumns() {
		return boardColumns;
	}

	public void setBoardColumns(int boardColumns) {
		this.boardColumns = boardColumns;
	}

	public boolean getGameTurn() {
		return gameTurn;
	}

	public void setGameTurn(boolean gameTurn) {
		this.gameTurn = gameTurn;
	}

	public List<String> getTilesList() {
		return tilesList;
	}

	public void setTilesList(List<String> tilesList) {
		this.tilesList = tilesList;
	}
}
