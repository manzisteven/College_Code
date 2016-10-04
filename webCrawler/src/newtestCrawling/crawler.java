package newtestCrawling;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.activation.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;






















import java.net.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.awt.*;
import java.io.*;
import java.util.regex.*;
import java.util.*;
public class crawler extends JFrame{
	// This array was used for testing, it allowed us to specify the maximum number of links to crawl 
	static final String[] MAX_PAGES = {"5", "50", "100", "500", "1000"};
	// These are the GUI controls
	JTextField searchField;
	JButton indexSearch;
	JButton documentSearch;
	
	public JProgressBar progressBar;
	JTable results;
	JButton documentSearch1;
	JComboBox maxComboBox;
	JCheckBox caseSensitive;
	private HashMap cache = new HashMap();
	private  String url;
	HashSet <String> hashset;
	int v = 0;
	// These hashmaps were used for indexing for both index search and document search
	public HashMap<String, HashSet<String>> indexMap = new HashMap<String, HashSet<String>>();
	public HashMap<String, HashSet<String>> docindexMap = new HashMap<String, HashSet<String>>();
	public HashMap<String, HashSet<String> > hashedMap = new HashMap<String, HashSet<String>> ();
	public HashMap<String, HashSet<String> > dochashedMap = new HashMap<String, HashSet<String>> ();
	public HashMap<String, HashSet<String>> indexMap00 = new HashMap<String, HashSet<String>>();
	
	// This is a boolean flag to control the crawling operation 
	boolean is_Crawling;
	String file11 = "crawledfiles.txt";
	// This file holds words indexed to links to web pages where there can be found
	String file15 = "crawleddocuments.txt";
	String file10 = "test.txt";
	
	PrintWriter write;
	PrintWriter write1;
	PrintWriter docwrite1;
	PrintWriter indexwrite1;
	String  searchString = null;
	String file20 = "newIndexfiles.txt";

	// constructor for initializing the crawler interface
	public crawler() {
		

		// setting up the interface
		setTitle("Crawler Engine");
		setSize(600, 600);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		JLabel maximumLabel = new JLabel("MAX_PAGES:");
		JLabel searchLabel;
		JLabel progressLabel;
		JPanel resultsPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		 

		// adding component to the frame's panels
		// using the GridBagLayout to organize components on the interface
		GridBagConstraints position = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		inputPanel.setLayout(layout);
		position.anchor = GridBagConstraints.EAST;
		position.insets = new Insets(5, 5, 0, 0);
		layout.setConstraints(inputPanel, position);
		//inputPanel.add(maximumLabel);

		maxComboBox = new JComboBox(MAX_PAGES);
		maxComboBox.setEditable(true);
		position = new GridBagConstraints();
		position.insets = new Insets(5, 5, 0, 0);
		position.gridwidth = 0;
		layout.setConstraints(maxComboBox, position);
	


		searchLabel = new JLabel("SEARCH STRING:");
		position = new GridBagConstraints();
		position.anchor = GridBagConstraints.EAST;
		position.insets = new Insets(5, 5, 0, 0);
		layout.setConstraints(searchLabel, position);
		inputPanel.add(searchLabel);

		searchField = new JTextField();
		position = new GridBagConstraints();
		position.fill = GridBagConstraints.HORIZONTAL;
		position.insets = new Insets(5, 5, 0, 0);
		position.gridwidth = 0;
		position.weightx = 0;
		layout.setConstraints(searchField, position);
		inputPanel.add(searchField);
	    searchString = searchField.getText().trim();
		caseSensitive = new JCheckBox("Case Sensitive");
		position = new GridBagConstraints();
		position.insets = new Insets(5, 5, 0, 5);
		position.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(caseSensitive, position);
		//inputPanel.add(caseSensitive);
		
		indexSearch = new JButton("Crawl");
		// adding the action listener to the index search button
		// adding the function
		indexSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSearch();
			}
		});
		position = new GridBagConstraints();
		position.gridwidth = GridBagConstraints.WEST;
		position.insets = new Insets(5, 5, 0, 0);
		layout.setConstraints(indexSearch, position);
		//inputPanel.add(indexSearch);

		documentSearch = new JButton("indexSearch");
		// adding the action listener to the document search button
		// adding the function
		documentSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    searchString = searchField.getText().trim();
				   
					
					printResults0(searchString);
			
			}
		});
		position = new GridBagConstraints();
		position.gridwidth = GridBagConstraints.WEST;
		position.insets = new Insets(5, 5, 0, 0);
		layout.setConstraints(documentSearch, position);
		inputPanel.add(documentSearch);
		documentSearch1 = new JButton("Document Search");
        // adding the action listener to the document search button
        // adding the function
        documentSearch1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 searchString = searchField.getText().trim();
				 String [] myarray = docSearchPhrase(searchString);
				 docPrintResults(myarray);
            }
        });
        position = new GridBagConstraints();
        position.gridwidth = GridBagConstraints.REMAINDER;
        position.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(documentSearch1, position);
        inputPanel.add(documentSearch1);

		progressLabel = new JLabel("Loading file contents:");
		position = new GridBagConstraints();
		position.anchor = GridBagConstraints.EAST;
		position.insets = new Insets(5, 5, 0, 0);
		layout.setConstraints(progressLabel, position);
		inputPanel.add(progressLabel);

		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setStringPainted(true);
		position = new GridBagConstraints();
		position.fill = GridBagConstraints.HORIZONTAL;
		position.gridwidth = GridBagConstraints.REMAINDER;
		position.insets = new Insets(5, 5, 0, 0);
		layout.setConstraints(progressBar, position);
		inputPanel.add(progressBar);

		results = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{""}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});

		// setting the results table
		resultsPanel.setBorder(
				BorderFactory.createTitledBorder("SEARCH RESULTS"));
		resultsPanel.setLayout(new BorderLayout());
		resultsPanel.add(new JScrollPane(results),BorderLayout.CENTER);

		// adding components' panels to the frame
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		getContentPane().add(resultsPanel, BorderLayout.CENTER);

	}

	void exit() {
		System.exit(0);
	}
	public void startSearch() {
		// If stop button is clicked, turn Is_crawling flag off.
		if (is_Crawling) {
			is_Crawling = false;
			return;
		}
		// Create an array to hold error messages
		ArrayList errorMessage = new ArrayList();
		// Hardcode the www.textfiles.com as the initialUrl
		String initialUrl = "http://www.textfiles.com/occult/URANTIA";
		int maximum_Url = -1;
		String maximumUrl = ((String) maxComboBox.getSelectedItem()).trim();
		// Check whether the maximumUrl is empty or a number. 
		if (maximumUrl.length() > 0) {
			try {
				maximum_Url = Integer.parseInt(maximumUrl);
			} catch (NumberFormatException e) {
			}


			if (maximum_Url < 1) {
				errorMessage.add("the maximumUrl value is invalid.");
			}
		}
		// Check if the search string has been entered
		//String searchString = searchField.getText().trim();
		// if (searchString.length() < 1) {
		// errorMessage.add("Please enter the search string");
		//}
		// Concatenate errors into single message.
		if (errorMessage.size() > 0) {
			StringBuffer ConcatenatedMessage = new StringBuffer();

			for (int i = 0; i < errorMessage.size(); i++) {
				ConcatenatedMessage.append(errorMessage.get(i));
				if (i + 1 < errorMessage.size()) {
					ConcatenatedMessage.append("\n");
				}
			}
			displayError( ConcatenatedMessage.toString());
			return;
		}
		// Remove WWW from the initial URL
		initialUrl = cutWwwOutOfUrl( initialUrl);
		searchWebsite(initialUrl, maximum_Url);
	}
	public void displayError (String errorMessage) 
	{
		JOptionPane.showMessageDialog(this, errorMessage, "Error", 
				JOptionPane.ERROR_MESSAGE);
	}
	public String cutWwwOutOfUrl(String myUrl)
	{   
		int index_1 = myUrl.indexOf("://www.");
		if (index_1 != -1) {
			return myUrl.substring(0, index_1 + 3) +
					myUrl.substring(index_1 + 7);
		}
		return myUrl;
	}
	
	private void searchWebsite( final String initialUrl,final int maximum_Url)
	{
		// Start the search in a new thread.
		Thread thread = new Thread(new Runnable() {
			public void run() {   
				// Show hour glass cursor while crawling is under way.
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				// Disable search controls.

				maxComboBox.setEnabled(false);

				searchField.setEnabled(false);
				caseSensitive.setEnabled(false);
				// Switch Search button to "Stop."
				indexSearch.setText("Stop");
			
				results.setModel(new DefaultTableModel(new Object[][]{},
						new String[]{"Matched URL"}) {
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				});
				showCrawlingStatus(0, 0, maximum_Url);
				
				try {
					write = new PrintWriter(new FileWriter(file11));
				} catch (Exception e) {
					displayError("Unable to open crawledfile.");
					return;
				}
				try
				{
					indexwrite1 = new PrintWriter(new FileWriter(file20));
				} 
				catch (Exception ex) {
					displayError("Unable to open newIndexfile.");
					return;
				}
				// Turn crawling flag on.
				is_Crawling = true;
				// Perform the actual crawling.
				startCrawl(initialUrl, maximum_Url,  caseSensitive.isSelected());
				// Turn crawling flag off.
				is_Crawling = false;
				
				try {
					write.close();
				} catch (Exception e) {
					displayError("Unable to close crawled file.");
				}
				try {
					indexwrite1.close();
				} catch (Exception e) {
					displayError("Unable to close crawled file.");
				}
				// Enable search controls.

				maxComboBox.setEnabled(true);

				searchField.setEnabled(true);
				caseSensitive.setEnabled(true);
				// Switch search button back to "Search."
				indexSearch.setText("Crawl");
				// Return to default cursor.
				setCursor(Cursor.getDefaultCursor());
				// Show message if search string not found.
				if (results.getRowCount() == 0) {
					JOptionPane.showMessageDialog(crawler.this,
							"Sorry your search string is not found.",
							"Try another one",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		thread.start();
	}
	private URL checkUrl(String urlstring)
	{
		// only HTTP URL are allowed
		if (!urlstring.toLowerCase().startsWith("http://"))
		{
			return null;
		}
		// Convert the URL string into a URL object
		URL checkedURL = null;
		try
		{
			checkedURL = new URL (urlstring);
		}
		catch (Exception e)
		{
			return null;
		}
		return checkedURL;
	}
	public boolean checkRobotProtocol (URL link)
	{
		String host = link.getHost().toLowerCase();
		// Retrieve host's disallow list from cache.
		ArrayList disallowedList =
				(ArrayList) cache.get(host);
		// If list is not in the cache, download and cache it.
		if (disallowedList == null) {
			disallowedList = new ArrayList();
			try {
				URL robotsFileUrl =
						new URL("http://" + host + "/robots.txt");
				// Open connection to robot file URL for reading.
				BufferedReader reader =
						new BufferedReader(new InputStreamReader(
								robotsFileUrl.openStream()));
				// Read robot file, creating list of disallowed paths.
				String line;
				while ((line = reader.readLine()) != null) {
					if (line.indexOf("Disallow:") == 0) {
						String disallowPath =
								line.substring("Disallow:".length());
						// Check disallow path for comments and remove if present.
						int commentIndex = disallowPath.indexOf("#");
						if (commentIndex != -1) {
							disallowPath =
									disallowPath.substring(0, commentIndex);
						}
						// Remove leading or trailing spaces from disallow path.
						disallowPath = disallowPath.trim();
						// Add disallow path to list.
						disallowedList.add(disallowPath);
					}
				}
				// Add new disallow list to cache.
				cache.put(host, disallowedList);
			}
			catch (Exception e) {
				/* Assume robot is allowed since an exception
				is thrown if the robot file doesn't exist. */
				return true;
			}
		}
		/* Loop through disallow list to see if
			crawling is allowed for the given URL. */
		String file = link.getFile();
		System.out.println(file);
		System.out.println(link);
		for (int i = 0; i < disallowedList.size(); i++) {
			String disallow = (String) disallowedList.get(i);
			if (file.startsWith(disallow)) {
				return false;
			}
		}
		return true;
	}
	public String downloadPageContent (URL link)
	{
		try {
			// Open connection to URL for reading.
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(
							link.openStream()));
			// Read page into buffer.
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("     ");
			}
			return buffer.toString();
		} catch (Exception e) {
		}
		return null;
	}
	private void showCrawlingStatus( int crawledLinks, int toCrawlLinks, int maximumUrls)
	{
		if (maximumUrls == -1) {
			progressBar.setMaximum(crawledLinks + toCrawlLinks);
		} else {
			progressBar.setMaximum(maximumUrls);
		}
		progressBar.setValue(crawledLinks);
	}
	public ArrayList getLinks (URL retrievedPage, String downloadedPageContents, HashSet crawledLinks)
	{
		URL check = null;
		URL test = null;
		URL test1 = null;
		URL test5 = null;
		URL u = null;
		String str = null;
		String str2 = null;
		// Compile link matching pattern.
		Pattern e = Pattern.compile("<a\\s+href\\s*=\\s*\"?(.*?)[\"|>]", Pattern.CASE_INSENSITIVE);
		Matcher matched = e.matcher(downloadedPageContents);
		// Create list of link matches.
		ArrayList linkList = new ArrayList();
		while (matched.find()) {
			String link = matched.group(1).trim();
			// Skip empty links.
			if (link.length() < 1) {
				continue;
			}
			// Skip links that are just page anchors.
			if (link.charAt(0) == '#') {
				continue;
			}
			// Skip mailto links.
			if (link.indexOf("mailto:") != -1) {
				continue;
			}
			// Skip JavaScript links.
			if (link.toLowerCase().indexOf("javascript") != -1) {
				continue;
			}
			// Prefix absolute and relative URLs if necessary.
			if (link.indexOf("://") == -1) {
				// Handle absolute URLs.
				if (link.charAt(0) == '/') {
					link = "http://" + retrievedPage.getHost() + link;
					// Handle relative URLs.
				} else {
					String file = retrievedPage.getFile();
					if (file.indexOf('/') == -1) {
						link = "http://" + retrievedPage.getHost() + "/" + link;
					} else {
						String path =
								file.substring(0, file.lastIndexOf('/') + 1);
						link = "http://" + retrievedPage.getHost() + path + link;
					}
				}
			}
			// Remove anchors from link.
			int index = link.indexOf('#');
			if (index != -1) {
				link = link.substring(0, index);
			}
			// Remove leading "www" from URL's host if present.
			link = cutWwwOutOfUrl(link);
			// Verify link and skip if invalid.
			URL verifiedLink = checkUrl(link);
			if (verifiedLink == null) {
				continue;
			}
			/* If specified, limit links to those
			   having the same host as the start URL. */
			if (!retrievedPage.getHost().toLowerCase().equals(verifiedLink.getHost().toLowerCase()))
			{
				continue;
			}
			// Skip link if it has already been crawled.
			if (crawledLinks.contains(link)) {
				continue;
			}
			



			   // Add link to list.
			linkList.add(link);
		
			System.out.println (url);
			System.out.println (link);
			try {
				test = new URL (url);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String j = "http://" + test.getHost() ;
			String k = url.substring(j.length()); 
			int index4 = k.indexOf("/");
			String h = "/";
			int index6 = k.indexOf(".html");
			if ( index4 != -1)
			{
				 str2 = k.substring(h.length());
			}
			if (index4 !=-1 && index6 == -1 )
			{  // a top url without html extension 
				int indexi = url.lastIndexOf("/");
				String m = url.substring(indexi+1);
				//System.out.println (str);
				System.out.println(m);
				indexwrite1.print(m);
				indexwrite1.print("->");
				indexwrite1.print(url);
				indexwrite1.println();
			}
			if ( index6 != -1)
			{   // a top url with html extension
				int index5 = str2.indexOf(".");
				String str1 = str2.substring(0, index5);
				//System.out.println (str1);
				indexwrite1.print(str1);
				indexwrite1.print("->");
				indexwrite1.print(url);
				indexwrite1.println();
			}
			
			if (link.indexOf(".html") != -1)
			{   
				// second link with html extension 
				try {
					test5 = new URL (link);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String str5 = "http://" + test5.getHost();
				String sj = link.substring(str5.length());
				String hr = "/";
				String str6 = sj.substring(hr.length());
				int index7 = str6.indexOf(".");
				String str0 = str6.substring(0, index7);
				//System.out.println (str0);
				indexwrite1.print(str0);
				indexwrite1.print("->");
				indexwrite1.print(link);
				indexwrite1.println();
			}
			int indexe1 = link.indexOf("/");
			int indexe2 = link.indexOf(".html");
			if (indexe1 !=-1 && indexe2 == -1 )
			{
				// second link without html extension 
				try {
					test5 = new URL (link);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String str9 = "http://" + test5.getHost();
				String hr1 = "/";
				String fr = link.substring(str9.length());
				String fr1 = fr.substring(hr1.length());
				
				//System.out.println (fr1);
				indexwrite1.print(fr1);
				indexwrite1.print("->");
				indexwrite1.print(link);
				indexwrite1.println();
				
			}
			 if (link.indexOf(".txt") != -1 || link.indexOf(".phk") != -1 || link.indexOf(".pro") != -1 || link.indexOf(".hum") != -1
						|| link.indexOf(".art") != -1 || link.indexOf(".fun") != -1 || link.indexOf(".ham") != -1 || link.indexOf(".hum") != -1 
						|| link.indexOf(".hac") != -1 || link.indexOf(".box") != -1 || link.indexOf(".app") != -1 || link.indexOf(".wars") != -1
						|| link.indexOf(".ana") != -1 || link.indexOf(".drg") != -1 || link.indexOf(".cmd") != -1 || link.indexOf(".bug") != -1 
						|| link.indexOf(".adv") != -1 || link.indexOf(".nfo") != -1 || link.indexOf(".omn") != -1 || link.indexOf(".pgmrs") != -1
						|| link.indexOf(".dj") != -1 || link.indexOf(".news") != -1 || link.indexOf(".jok") != -1 || link.indexOf(".ame") != -1
						|| link.indexOf(".oct") != -1 || link.indexOf(".ufo") != -1 || link.indexOf(".c_f") != -1 || link.indexOf(".basics") != -1  
						|| link.indexOf(".cap") != -1 || link.indexOf(".eas") != -1 || link.indexOf(".cc") != -1 || link.indexOf(".doc") != -1
						|| link.indexOf(".new") != -1 || link.indexOf(".tso") != -1 || link.indexOf(".hch") != -1 || link.indexOf(".dmg") != -1
						|| link.indexOf(".gÝd") != -1 || link.indexOf(".cla") != -1 || link.indexOf(".fus") != -1 || link.indexOf(".bom") != -1
						|| link.indexOf(".bgr") != -1 || link.indexOf(".apo") != -1 || link.indexOf(".jok") != -1 || link.indexOf(".lif") != -1
						|| link.indexOf(".rev") != -1 || link.indexOf(".lst") != -1 || link.indexOf(".epi") != -1 || link.indexOf(".ans") != -1
						|| link.indexOf(".trv") != -1 || link.indexOf(".lis") != -1 || link.indexOf(".mov") != -1 || link.indexOf(".asc") != -1
						|| link.indexOf(".sol") != -1 || link.indexOf(".drv") != -1 || link.indexOf(".gun") != -1)
				 
			 {
				 try {
						test = new URL (link);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 String jt = "http://" + test.getHost();
				 String kt = link.substring(jt.length()); 
				 int index2 = link.lastIndexOf("/");
				 String ut = link.substring(index2);
				
				 String ft = url + ut;
				 System.out.println(ft);
				 String dt = "/";
				 String vt = kt.substring(dt.length());
				 int indexo = vt.indexOf(".");
				 String gt = vt.substring(0, indexo);
				 int indexc = link.lastIndexOf("/");
				 String found = link.substring(indexc+1);
				 int indexf = found.indexOf(".");
				 String found1 = found.substring(0, indexf);
				 //System.out.println(gt);
				 indexwrite1.print(found1);
				 System.out.println(found1);
				 indexwrite1.print("->");
				 indexwrite1.print(ft);
				 indexwrite1.println();
				
				 String v = "http://" + test.getHost();
				 String p = ft.substring(v.length());
				 String newstring = p + kt;
				 try {
						test1 = new URL (ft);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String page = docDownloadPageContent(test1);
					System.out.println(test1);
					docCrawl (p, page);
			 }
		}
		return (linkList);
	}
	public void crawl (String current, String pageContents)
	{ 
		if (pageContents == null)
		{
			return;
		}
		pageContents =   pageContents.toLowerCase().replaceAll("[^\\w\\s\\-]", " ");
		String [] terms= pageContents.split("\\s");

		for (int i = 0; i < terms.length; i++)
		{   


			// if this string is already in the hashmap, get its corresponding hashset and add the new URL to the hashset 
			if (hashedMap.containsKey(terms[i]))
			{
				HashSet a = hashedMap.get(terms[i]);
				a.add(current);
				if (terms[i].length()> 3)
				{
					hashedMap.put(terms[i], a);
				}
			}
			else
			{
				// if this string is not in the hashmap, create a new hashset object and add both the string and hashset 
				// to the hashmap. 
				HashSet <String> k = new HashSet <String>();
				k.add(current);
				if (terms[i].length()> 3)
				{
					hashedMap.put(terms[i], k);
				}
			}
		}


	}
	public void writeToFile ()
	{
		Set<String> keys = hashedMap.keySet();
		for (String key : keys) {
			write.print(key);
			write.print("->");
			HashSet t = hashedMap.get(key);
			Iterator itr = t.iterator();
			while (itr.hasNext())
			{
				write.print(itr.next());

				if (v+1 < t.size())
				{
					write.print(",");
				}
				v++;
			}
			v= 0;
			write.println();
		}
	}
	public String docDownloadPageContent (URL link)
	{
		try {
			// Open connection to URL for reading.
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(
							link.openStream()));
			// Read page into buffer.
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("    ");
			}
			return buffer.toString();
		} catch (Exception e) {
		}
		return null;
	}
	public void docWriteToFile ()
	{
		try
		{
			docwrite1 = new PrintWriter(new FileWriter(file15));
		} 
		catch (Exception e) {
			displayError("Unable to open crawleddocuments.");
			return;
		}

		Set<String> keys = dochashedMap.keySet();
		for (String key : keys) {
			docwrite1.print(key);
			docwrite1.print("->");
			HashSet t = dochashedMap.get(key);
			Iterator itr = t.iterator();
			while (itr.hasNext())
			{
				docwrite1.print(itr.next());

				if (v+1 < t.size())
				{
					docwrite1.print(",");
				}
				v++;
			}
			v= 0;
			docwrite1.println();
		}
	}
	public void docCrawl (String current, String pageContents)
	{ 
		if (pageContents == null)
		{
			return;
		}
		pageContents =   pageContents.toLowerCase().replaceAll("[^\\w\\s\\-]", " ");
		String [] terms= pageContents.split("\\s");

		for (int i = 0; i < terms.length; i++)
		{   


			// if this string is already in the hashmap, get its corresponding hashset and add the new URL to the hashset 
			if (dochashedMap.containsKey(terms[i]))
			{
				HashSet a = dochashedMap.get(terms[i]);
				a.add(current);
				if (terms[i].length()> 3)
				{
					dochashedMap.put(terms[i], a);
				}
			}
			else
			{
				// if this string is not in the hashmap, create a new hashset object and add both the string and hashset 
				// to the hashmap. 
				HashSet <String> k = new HashSet <String>();
				k.add(current);
				if (terms[i].length()> 3)
				{
					dochashedMap.put(terms[i], k);
				}
			}
		}

	}
	public void docReadSearchCacheToMem() throws IOException {
		
		
		File f1=new File(file15);
		// 
		 
			 	
		BufferedReader	br = new BufferedReader(new FileReader(f1));
		
		

        long totalLength = f1.length();
        double lengthPerPercent = 100.0 / totalLength;
        long readLength = 0;
		// Init HashMap to store searchCache retrieved from memory. 
		HashSet<String> tempSet = new HashSet<String>();
		String line, word; 
		int pos;  // Store position in string.
		// Read next line while not at end of file.
		
			while ((line = br.readLine()) != null) {
				
				pos = line.indexOf("->");
				if (pos == -1) continue;   // Handles bad input line.
				line = line.trim(); 
				word = line.substring(0, pos);
				line = line.substring(pos+2);
				String [] words = line.split(",");
				if (docindexMap.containsKey(word))
				{
					HashSet <String> a = new HashSet <String> ();
					a = docindexMap.get(word);
					for (int i = 0; i < words.length; i++) {
						a.add(words[i]);
					}
					docindexMap.put(word, new HashSet<String>(a));
				}
				else
				{
					for (int i = 0; i < words.length; i++) {
						tempSet.add(words[i]);
					}
					docindexMap.put(word, new HashSet<String>(tempSet));
					tempSet.clear();
				}
				readLength += line.length();
				progressBar.setValue((int) Math.round(lengthPerPercent * readLength));
			}
		
		
		progressBar.setValue(100);
		
		
			br.close();
	
		
	}
	public String [] docSearchPhrase(String phrase)  {
		
		results.setModel(new DefaultTableModel(new Object[][]{},
				new String[]{"URL"}) {
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		});
	
		// split phrase into sub strings
		phrase = phrase.trim().toLowerCase();
		String [] words = phrase.split(" ");
		// 2 sets to store hashmap
		HashSet<String> urls1 = null;
		ArrayList <HashSet<String>> setOfUrls = new ArrayList <HashSet<String>> ();

		// For each word, add it's urls to set.  
		for (int i = 0; i < words.length; i++) {
			
			if (words[i].length() < 4) continue;
			
			// If word in phrase is not in indexMap, then phrase was not found. 
			if (!docindexMap.containsKey(words[i]))
				return null;

			setOfUrls.add(new HashSet<String>(docindexMap.get(words[i])));
		}

		// Get intersection of Urls where each word in phrase is found.    	
		if (setOfUrls.isEmpty())
			return null;
		
		urls1 = setOfUrls.get(0);
		for (int i = 1; i < setOfUrls.size(); i++) {
			// Retain all does an intersection. Use "addAll" for union
			urls1.retainAll(setOfUrls.get(i));
			// urls1.retainAll(setOfUrls.get(i));
			// If intersection is 
			if (urls1.isEmpty())
				return null;
		}
		return urls1.toArray(new String[urls1.size()]);
	}

	public void startCrawl(String initialUrl, int maxUrls,  boolean caseSensitive)
	{
		
		URL test = null;
		// Set up crawl lists.
		HashSet crawledList = new HashSet();
		LinkedHashSet toCrawlList = new LinkedHashSet();
		// Add start URL to the to crawl list.
		toCrawlList.add(initialUrl);
		/* Perform actual crawling by looping
				   through the To Crawl list. */
		while (is_Crawling && toCrawlList.size() > 0)
		{
			/* Check to see if the max URL count has
				   been reached, if it was specified.*/
			if (maxUrls != -1) {
				if (crawledList.size() == maxUrls) {
					break;
				}
			}
			// Get URL at bottom of the list.
			url = (String) toCrawlList.iterator().next();
			// Remove URL from the To Crawl list.
			toCrawlList.remove(url);
			// Convert string url to URL object.
			URL verifiedUrl = checkUrl(url);
			// Skip URL if robots are not allowed to access it.
			if (!checkRobotProtocol(verifiedUrl)) {
				continue;
			}
			// Update crawling stats.
			showCrawlingStatus( crawledList.size(), toCrawlList.size(), maxUrls);
			// Add page to the crawled list.
			crawledList.add(url);
			// Download the page at the given URL.
			String pageContents = downloadPageContent(verifiedUrl);
			/* If the page was downloaded successfully, retrieve all its
				   links and then see if it contains the search string. */
		   
			String j = "http://" + verifiedUrl.getHost();
			String h = "manzi";
			int index12 = url.indexOf(j);
			int index123 = url.indexOf(h);
			//System.out.println(index123);
			String newUrl = url.substring(j.length());
			//System.out.println(newUrl);

			crawl (newUrl, pageContents);
			if (pageContents != null && pageContents.length() > 0)
			{
				// Retrieve list of valid links from page.
				ArrayList links = getLinks(verifiedUrl, pageContents, crawledList);
				// Add links to the To Crawl list.
				toCrawlList.addAll(links);
				/* Check if search string is present in
				   page, and if so, record a match. */

			}
			// Update crawling stats.
			showCrawlingStatus( crawledList.size(), toCrawlList.size(),
					maxUrls);
		}
		//writeToFile ();
		docWriteToFile();
	}
	/**
	 * Reads file into memory. Specifically into a HashMap of structure
	 * HashMap<String, HashSet<String>> indexMap
	 * @throws IOException
	 * @param  none
	 * @return void 
	 */
	public void readSearchCacheToMem() throws IOException {
		// 
		BufferedReader br = new BufferedReader(new FileReader("crawledFiles.txt")); 
		// Init HashMap to store searchCache retrieved from memory. 
		HashSet<String> tempSet = new HashSet<String>();
		String line, word; 
		int pos;  // Store position in string.
		// Read next line while not at end of file.
		while ((line = br.readLine()) != null) {
			pos = line.indexOf("->");
			if (pos == -1) continue;   // Handles bad input line.
			line = line.trim().toLowerCase(); 
			word = line.substring(0, pos);
			line = line.substring(pos+2);
			String [] words = line.split(",");
			for (int i = 0; i < words.length; i++) {
				tempSet.add(words[i]);
			}
			indexMap.put(word, new HashSet<String>(tempSet));
			tempSet.clear();
		}
		
		br.close();
		
	
		
	}
	public String [] searchPhrase(String phrase)  {
		results.setModel(new DefaultTableModel(new Object[][]{},
				new String[]{"URL"}) {
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		});
		// split phrase into sub strings
		phrase = phrase.trim().toLowerCase();
		String [] words = phrase.split(" ");
		// 2 sets to store hashmap
		HashSet<String> urls1 = null;
		ArrayList <HashSet<String>> setOfUrls = new ArrayList <HashSet<String>> ();

		// For each word, add it's urls to set.  
		for (int i = 0; i < words.length; i++) {
			// If word in phrase is not in indexMap, then phrase was not found. 
			if (!indexMap.containsKey(words[i]))
				return null;

			setOfUrls.add(new HashSet<String>(indexMap.get(words[i])));
		}

		// Get intersection of Urls where each word in phrase is found.    	
		urls1 = setOfUrls.get(0);
		for (int i = 1; i < setOfUrls.size(); i++) {
			// Retain all does an intersection. Use "addAll" for union
			urls1.retainAll(setOfUrls.get(i));
			// urls1.retainAll(setOfUrls.get(i));
			// If intersection is 
			if (urls1.isEmpty())
				return null;
		}
		return urls1.toArray(new String[urls1.size()]);
	}
	public void printResults (String [] array1)
	{  
		if (array1 == null)
		{
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"Your search is not found"});
			return;
		}
		for (int i =0; i<array1.length; i++)

		{
          if (array1[i].indexOf(searchString) != -1 )
          {
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"http://textfiles.com" + array1[i]});
          }
        
		}
	}
	public void loadIndexFiletoHashmap() throws IOException {
		//
		
		BufferedReader br = new BufferedReader(new FileReader("newIndexfiles.txt")); 
		// Init HashMap to store searchCache retrieved from memory. 
		HashSet<String> tempSet = new HashSet<String>();
		String line, word; 
		int pos;  // Store position in string.
		// Read next line while not at end of file.
		while ((line = br.readLine()) != null) {
			pos = line.indexOf("->");
			if (pos == -1) continue;   // Handles bad input line.
			line = line.trim(); 
			word = line.substring(0, pos);
			String line1 = line.substring(pos+2);
			if (indexMap00.containsKey(word))
			{
			HashSet <String> a = new HashSet <String> ();
			a = indexMap00.get(word);
			a.add(line1);
			indexMap00.put(word, new HashSet<String>(a));
			}
			else
			{
				tempSet.add(line1);
				
				indexMap00.put(word, new HashSet<String>(tempSet));
				tempSet.clear();
			}
			
		}
		
		br.close();
		
	
		
	}
	public void printResults0 (String newstring)
	{
		results.setModel(new DefaultTableModel(new Object[][]{},
				new String[]{"URL"}) {
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		});
		if (newstring.length() == 0)
		{
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"Please enter the search string"});
			return;
		}
		
	
		HashSet <String> b = new HashSet <String> ();
		if (indexMap00.containsKey(newstring) == false)
		{
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"Your search is not found"});
			return;
		}
		
		b = indexMap00.get(newstring);
		Iterator itr = b.iterator();
		while (itr.hasNext())
		{
			
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{itr.next()});
			
			
			

			
		}
		
		
	}
	public void docPrintResults (String [] array1)
	{ 
		results.setModel(new DefaultTableModel(new Object[][]{},
				new String[]{"URL"}) {
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		});
		if (searchString.length() == 0)
		{
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"Please enter the search string"});
			return;
		}
		if (searchString.length() < 4)
		{
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"Words whose length is less than four characters were not cached "});
			return;
		}
		if (array1 == null)
		{
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"Your search is not found"});
			return;
		}
		for (int i =0; i<array1.length; i++)

		{
          
			DefaultTableModel model =
					(DefaultTableModel) results.getModel();
			model.addRow(new Object[]{"http://textfiles.com" + array1[i]});
          
         
		}
	}

}
