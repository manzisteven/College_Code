// I am sorry for using the default package
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class WorstEverFrame extends JFrame {
	    // Gui controls
		private JTextField startTextField;
        private JCheckBox songBox;
	    private JCheckBox artistBox;
		private JButton searchButton;
	    private JTable table;
		// The constructor constructs the GUI and within in it the functions that read the file and perform 
	    // searches are invoked when the search button is clicked. 
	    public  WorstEverFrame()
		{
		
		setTitle("Search engine");
	
		setSize(600, 600);
		// Handle window closing events.
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		actionExit();
		}
		});
		
		
		// Set up search panel.
		JPanel searchPanel = new JPanel();
		GridBagConstraints constraints;
		GridBagLayout layout = new GridBagLayout();
		searchPanel.setLayout(layout);
		JLabel startLabel = new JLabel("Enter name");
		constraints = new GridBagConstraints();
		
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 0);
		layout.setConstraints(startLabel, constraints);
		searchPanel.add(startLabel);
		startTextField = new JTextField(20);
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.insets = new Insets(5, 5, 0, 5);
		layout.setConstraints(startTextField, constraints);
		searchPanel.add(startTextField);
		songBox = new JCheckBox("songs");
		constraints = new GridBagConstraints();

		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(0, 10, 0, 0);
		layout.setConstraints(songBox, constraints);
		searchPanel.add(songBox);
		JLabel blankLabel = new JLabel();
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(blankLabel, constraints);
		searchPanel.add(blankLabel);
        artistBox = new JCheckBox("Artist");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 5);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(artistBox, constraints);
		searchPanel.add(artistBox);
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
		// Respond to button events
		public void actionPerformed(ActionEvent e) {
		// Retrieve the search string
			String searchString = startTextField.getText().toLowerCase();
		// Refresh the table 
			table.setModel(new DefaultTableModel(new Object[][]{},
					new String[]{""}) {
				public boolean isCellEditable(int row, int column)
				{
					return false;
				}
			});
		// call the function that construct all the objects, let it return an arrayList
			ArrayList <SongRecord>listOfObjects = constructObjects ();
	
			if (songBox.isSelected())
			{
				// Refresh the table 
				table.setModel(new DefaultTableModel(new Object[][]{},
						new String[]{""}) {
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				});
				// obj contains all the objects with the matching search string
				ArrayList <SongRecord> obj = returnSongs(searchString, listOfObjects);
				// Print the results in the GUI text area 
				printResults(obj);
						
			}
			if (artistBox.isSelected())
			{
				// Refresh the text area 
				table.setModel(new DefaultTableModel(new Object[][]{},
						new String[]{""}) {
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				});
				// obj contains all the objects with the matching search string
				ArrayList <SongRecord> obj = returnArtists(searchString, listOfObjects);	
				// Print the results in the GUI text area 
				printResults(obj);
			}
		
		}
		});
		constraints = new GridBagConstraints();
		
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.insets = new Insets(5, 5, 5, 5);
		layout.setConstraints(searchButton, constraints);
		searchPanel.add(searchButton);
		table = new JTable(new DefaultTableModel(new Object[][]{},
		new String[]{""}) {
		public boolean isCellEditable(int row, int column)
		{
		return false;
		}
		});
	
		JPanel matchesPanel = new JPanel();
		matchesPanel.setBorder(
		BorderFactory.createTitledBorder("Matches"));
		matchesPanel.setLayout(new BorderLayout());
		matchesPanel.add(new JScrollPane(table),
		BorderLayout.CENTER);
		// Add panels to display.
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(searchPanel, BorderLayout.NORTH);
		getContentPane().add(matchesPanel, BorderLayout.CENTER);
		}
		// Exit this program.
		private void actionExit() {
		System.exit(0);
		}
      
		// This function reads the file while constructing objects
		// It returns an arrayList containing all the objects 
		public ArrayList<SongRecord> constructObjects ()
       {
    	   ArrayList <SongRecord> array = new ArrayList <SongRecord>();
    	   try {
   			FileReader file = new FileReader ("hundred-worst.txt");
   			BufferedReader buff = new BufferedReader (file);
   			String line = " ";
   			try {
   				while ((line =buff.readLine())!= null)
   				{
   					int ranking = 0; 
   					String songTitle = null;
   					String artist = null;
   					int year = 0; 
   				
   					String [] terms= line.split("\t");
   					for (int i= 0; i<terms.length; i++)
   					{
   						if (i==0)
   						{
   							ranking = Integer.parseInt(terms[i]);
   						}
   						if (i==1)
   						{
   							songTitle = terms[i];
   						}
   						if (i==2)
   						{
   							artist = terms[i];
   						}
   						if (i==3)
   						{
   							year = Integer.parseInt(terms[i]);
   						}
   					}
   					
   					SongRecord obj = new SongRecord (ranking, songTitle, artist, year);
   					array.add(obj);
   				}
   				
   			} catch (IOException e) {
   				
   			}
   			
   		} catch (FileNotFoundException e) {
   			
   		}
    	   return array;
       }
       // This function searches the objects with the matching song keyword search string
	  //  It returns an arrayList containing all the objects with the matching search string
		public ArrayList <SongRecord> returnSongs (String searchString, ArrayList<SongRecord> listOfObjects)
       {
    	   ArrayList <SongRecord> matchedSongs = new ArrayList <SongRecord> ();
    	   for (int i =0; i<listOfObjects.size(); i++)
    	   {
    		   String title = listOfObjects.get(i).getSongtitle();
    		   
    		   String title1 = title.toLowerCase();
    		   int index = title1.indexOf(searchString);
    		   if (index != -1)
    		   {
    			   matchedSongs.add(listOfObjects.get(i));
    		   }
    	   }
    	   return  matchedSongs;
       }
	  // This function searches the objects with the matching song keyword search string
	 //  It returns an arrayList containing all the objects with the matching search string
       public ArrayList <SongRecord> returnArtists (String searchString, ArrayList<SongRecord> listOfObjects)
       {
    	   ArrayList <SongRecord> matchedSongs = new ArrayList <SongRecord> ();
    	   for (int i =0; i<listOfObjects.size(); i++)
    	   {
    		   String title = listOfObjects.get(i).getArtist();
    		   
    		   String title1 = title.toLowerCase();
    		   int index = title1.indexOf(searchString);
    		   if (index != -1)
    		   {
    			   matchedSongs.add(listOfObjects.get(i));
    		   }
    	   }
    	   return  matchedSongs;
       }
      // This function prints the search results in the GUI text area 
       public void printResults (ArrayList <SongRecord> obj)
       {
    	   if (obj.size() == 0)
    	   {
    		   DefaultTableModel model1 =
						(DefaultTableModel) table.getModel();
				model1.addRow(new Object[]{"Your search string is not found"});
				
				return;
    	   }
    	   DefaultTableModel model =
					(DefaultTableModel) table.getModel();
			model.addRow(new Object[]{"Rank"+ "                 " +"Title" + "                      "+ "Artist"+ "                          " + "Year"});
			for (int i =0; i<obj.size(); i++)
			{
				int rank = obj.get(i).getRanking();
				String title = obj.get(i).getSongtitle();
				String artist = obj.get(i).getArtist();
				int year = obj.get(i).getYear();
				DefaultTableModel model1 =
						(DefaultTableModel) table.getModel();
				model1.addRow(new Object[]{rank+ "   " +title + "   "+ artist+ "   " + year});
				
			}
       }
}
