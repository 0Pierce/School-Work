import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.Color;
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AmzSorterFrame extends JFrame {
	static String row = "";
	private JPanel MaincontentPanel;
	private ArrayList csvImport = new ArrayList();
	List<List<String>> twoDList = new ArrayList<>();
	List<String> rowList;
	JList list;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	// Construcotr
	public AmzSorterFrame() {
		setTitle("Amazon Sorter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 592);
		MaincontentPanel = new JPanel();
		MaincontentPanel.setBackground(Color.decode("#202124"));
		MaincontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MaincontentPanel);
		setVisible(true);
		System.out.println("Ran frame");
		Panel();
		
	}

	// Main Panel
	// ====================================================================================
	public void Panel() {
		// Imports the csv data
		try {
			ImportData();
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Ran frame2");
		// Auto generated frame code
		// ==========================================================================
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		// Scroll bar color
		// scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		// @Override
		// protected void configureScrollBarColors() {
		// this.thumbColor = Color.decode("#202124");
		// }
		// });

		// Imports the data

		// Creates the InnerList
		List<String> enterInnerList = twoDList.get(0);
		

		 list = new JList();

		scrollPane.setViewportView(list);

		DefaultListModel<String> lModel = new DefaultListModel<>();

		
		
		JLabel lblStaticSellPrice = new JLabel("Sell Price");
		lblStaticSellPrice.setForeground(Color.WHITE);
		lblStaticSellPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaticSellPrice.setFont(new Font("Toledo", Font.BOLD, 25));

		JLabel lblStaticMosales = new JLabel("Mo/Sales");
		lblStaticMosales.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaticMosales.setForeground(Color.WHITE);
		lblStaticMosales.setFont(new Font("Toledo", Font.BOLD, 25));

		JLabel lblStaticBuyCost = new JLabel("Buy Cost");
		lblStaticBuyCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaticBuyCost.setForeground(Color.WHITE);
		lblStaticBuyCost.setFont(new Font("Toledo", Font.BOLD, 25));

		JLabel lblStaticProfit = new JLabel("Profit");
		lblStaticProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaticProfit.setForeground(Color.WHITE);
		lblStaticProfit.setFont(new Font("Toledo", Font.BOLD, 25));

		JLabel lbSPrice = new JLabel("E");
		lbSPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbSPrice.setForeground(Color.WHITE);
		lbSPrice.setFont(new Font("Toledo", Font.BOLD, 25));

		JLabel lbBCost = new JLabel("E");
		lbBCost.setHorizontalAlignment(SwingConstants.CENTER);
		lbBCost.setForeground(Color.WHITE);
		lbBCost.setFont(new Font("Toledo", Font.BOLD, 25));

		JLabel lbMSales = new JLabel("E");
		lbMSales.setHorizontalAlignment(SwingConstants.CENTER);
		lbMSales.setForeground(Color.WHITE);
		lbMSales.setFont(new Font("Toledo", Font.BOLD, 25));

		JLabel lbProfit = new JLabel("E");
		lbProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lbProfit.setForeground(Color.WHITE);
		lbProfit.setFont(new Font("Toledo", Font.BOLD, 25));
		
		JButton btnAddProduct = new JButton("Add Product");
		
		
		
		JButton btnImportCsv = new JButton("Import CSV");
		
		JButton btnDeleteProduct = new JButton("Delete Product");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#202124"));
		
		

		GroupLayout gl_MaincontentPanel = new GroupLayout(MaincontentPanel);
		gl_MaincontentPanel.setHorizontalGroup(
			gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MaincontentPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_MaincontentPanel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStaticSellPrice, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(lbSPrice, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
						.addGroup(gl_MaincontentPanel.createSequentialGroup()
							.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_MaincontentPanel.createSequentialGroup()
									.addGap(5)
									.addComponent(btnImportCsv, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
								.addGroup(gl_MaincontentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnDeleteProduct, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(btnAddProduct, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_MaincontentPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_MaincontentPanel.createSequentialGroup()
									.addComponent(lblStaticBuyCost, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblStaticMosales, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_MaincontentPanel.createSequentialGroup()
									.addComponent(lbBCost, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lbMSales, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
									.addGap(14)))
							.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStaticProfit, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addComponent(lbProfit, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
							.addGap(30))
						.addGroup(gl_MaincontentPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		gl_MaincontentPanel.setVerticalGroup(
			gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MaincontentPanel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_MaincontentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_MaincontentPanel.createSequentialGroup()
							.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStaticSellPrice, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStaticBuyCost, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStaticMosales, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStaticProfit, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbProfit, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbMSales, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbBCost, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbSPrice, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_MaincontentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_MaincontentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
									.addComponent(btnDeleteProduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnAddProduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(btnImportCsv, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addGap(42))
								.addGroup(gl_MaincontentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		
		
		
		
		JButton btnPAdd = new JButton("Add");
		
		
		JButton btnPCancel = new JButton("Cancel");
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBuyCost = new JLabel("Sell Price");
		lblBuyCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyCost.setForeground(Color.WHITE);
		lblBuyCost.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblMosales = new JLabel("Buy Cost");
		lblMosales.setHorizontalAlignment(SwingConstants.CENTER);
		lblMosales.setForeground(Color.WHITE);
		lblMosales.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblMosales_1 = new JLabel("Mo/Sales");
		lblMosales_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMosales_1.setForeground(Color.WHITE);
		lblMosales_1.setFont(new Font("Verdana", Font.BOLD, 20));
		
		 JTextField textFieldName;
		 JTextField textFieldSP;
		 JTextField textFieldBC;
		 JTextField textFieldMS;
		 JTextField textFieldP;
		
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		
		textFieldSP = new JTextField();
		textFieldSP.setColumns(10);
		
		textFieldBC = new JTextField();
		textFieldBC.setColumns(10);
		
		textFieldMS = new JTextField();
		textFieldMS.setColumns(10);
		
		JLabel lblMosales_1_1 = new JLabel("Profit");
		lblMosales_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMosales_1_1.setForeground(Color.WHITE);
		lblMosales_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		
		textFieldP = new JTextField();
		textFieldP.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
					.addGap(82))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFieldSP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
								.addComponent(textFieldMS, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
								.addComponent(lblMosales_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblBuyCost, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblMosales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textFieldBC, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
									.addComponent(lblMosales_1_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldP, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnPCancel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addGap(33))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuyCost, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMosales, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldBC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMosales_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMosales_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldMS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPAdd)
						.addComponent(btnPCancel))
					.addGap(11))
		);
		
		panel.setVisible(false);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked");
				panel.setVisible(true);
			}
		});
		
		btnPCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		
		
		 //textFieldName;
		 //textFieldSP;
		 //textFieldBC;
		 //textFieldMS;
		 //textFieldP;
		
		btnPAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textFieldName.getText() != null && textFieldSP.getText() != null && textFieldBC.getText() != null && textFieldMS.getText() != null && textFieldP.getText() != null ) {
					String s1 = textFieldSP.getText();
					String s2 = textFieldBC.getText();
					String s3 = textFieldMS.getText();
					String s4 = textFieldP.getText();
					
					
					
					
					for(int i = 0; i < s1.length();i++) {
						if ((Character.isLetter(s1.charAt(i)) == false)) {
							System.out.println("No letter detected 1");
				         }
					}
					
					for(int i = 0; i < s2.length();i++) {
						if ((Character.isLetter(s1.charAt(i)) == false)) {
							System.out.println("No letter detected 1");
				         }
						
					}
					
					for(int i = 0; i < s3.length();i++) {
						if ((Character.isLetter(s1.charAt(i)) == false)) {
							System.out.println("No letter detected 1");
				         }
					}
					
					for(int i = 0; i < s4.length();i++) {
						if ((Character.isLetter(s1.charAt(i)) == false)) {
							System.out.println();
				         }
					}
					
					
					
					
				}else {
					System.out.println("Empty field detected");
				}
			
			}
		});
		
		panel.setLayout(gl_panel);
		MaincontentPanel.setLayout(gl_MaincontentPanel);

		String options[] = { "Default", "Sort By Alphabet", "Sort By Profit", "Sort By Cost", "Sort By Mo/Sales",
				"Sort By Sell Price", "Product Search" };

		//List<String> dupInnerList = twoDList.get(0);
		
		
		//lblStaticSellPrice
		//lblStaticMosales
		//lblStaticBuyCost
		//lblStaticProfit
		
		JComboBox comboBox = new JComboBox(options);
		
		
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch (comboBox.getSelectedIndex()) {
				case -1:
					System.out.println("-1 error");
					break;
				case 0:
					
					
					try {
						twoDList.clear();
						ImportData();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lModel.clear();
					List<String> dupInnerList = twoDList.get(0);
					for (int i = 0; i < twoDList.size(); i++) {
						dupInnerList = twoDList.get(i);
						lModel.add(i, dupInnerList.get(0));

					}
					
					comboBox.setEditable(false);
					System.out.println("C0");
					break;
				case 1:
					
					lblStaticBuyCost.setForeground(Color.white);
					lblStaticProfit.setForeground(Color.white);
					lblStaticSellPrice.setForeground(Color.white);
					lblStaticMosales.setForeground(Color.white);
					sortJListAlphabetically();
					System.out.println("C1");
					comboBox.setEditable(false);
					break;
				case 2:
					
					lblStaticBuyCost.setForeground(Color.white);
					lblStaticProfit.setForeground(Color.green);
					lblStaticSellPrice.setForeground(Color.white);
					lblStaticMosales.setForeground(Color.white);
					comboBox.setEditable(false);
					sortJListProfit();
					System.out.println("C2");
					break;
				case 3:
					lblStaticBuyCost.setForeground(Color.green);
					lblStaticProfit.setForeground(Color.white);
					lblStaticSellPrice.setForeground(Color.white);
					lblStaticMosales.setForeground(Color.white);
					sortJListByCost();
					comboBox.setEditable(false);
					System.out.println("C3");
					break;
				case 4:
					lblStaticBuyCost.setForeground(Color.white);
					lblStaticProfit.setForeground(Color.white);
					lblStaticSellPrice.setForeground(Color.white);
					lblStaticMosales.setForeground(Color.green);
					sortJListByMoSales();
					comboBox.setEditable(false);
					System.out.println("C4");
					break;
				case 5:
					lblStaticBuyCost.setForeground(Color.white);
					lblStaticProfit.setForeground(Color.white);
					lblStaticSellPrice.setForeground(Color.green);
					lblStaticMosales.setForeground(Color.white);
					sortJListBySellPrice();
					comboBox.setEditable(false);
					System.out.println("C5");
					break;
					
				case 6:
					lblStaticBuyCost.setForeground(Color.white);
					lblStaticProfit.setForeground(Color.white);
					lblStaticSellPrice.setForeground(Color.white);
					lblStaticMosales.setForeground(Color.white);
					comboBox.setEditable(true);
					String temp = (String) comboBox.getItemAt(6);
					
					//System.out.println(temp +"Search result");
					//searchJList(temp);
					JTextField editorComponent = (JTextField) comboBox.getEditor().getEditorComponent();

					
					editorComponent.addKeyListener(new KeyAdapter() {
					    @Override
					    public void keyReleased(KeyEvent e) {
					        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					            // Get the search query from the text field
					            String searchQuery = editorComponent.getText().toLowerCase();

					            // Call the search method with the search query
					            searchJList(searchQuery);
					        }
					    }
					});
					
					
					
					break;
					

				}
			}
		});

		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setToolTipText("Sort by");
		scrollPane.setColumnHeaderView(comboBox);

		comboBox.setSelectedIndex(0);

		// ==========================================================================
		// Panel Cosmetics
		// ==========================================================================

		Border border = BorderFactory.createLineBorder(Color.decode("#207c44"), 2);

		list.setFixedCellHeight(30);
		list.setBackground(Color.decode("#207c44"));
		list.setForeground(Color.WHITE);
		list.setBorder(border);
		list.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
		scrollPane.setBorder(border);
		scrollPane.setBackground(Color.decode("#202124"));
		scrollPane.setForeground(Color.decode("#202124"));
		scrollPane.setAutoscrolls(rootPaneCheckingEnabled);

		list.setModel(lModel);

		// ==========================================================================
		// Panel Logic
		// ==========================================================================

		//When a element in the jList is clicked the labels will update with the corresponding info
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//System.out.println(list.getSelectedIndex()+ "culprit?");
				
				//Makes sure the selected index isnt -1 preventing an error
				int selectedIndex = list.getSelectedIndex();
				if(selectedIndex != -1) {
					List<String> enterInnerList = twoDList.get(list.getSelectedIndex());
					
					System.out.println(enterInnerList.get(1));

					lbSPrice.setText(enterInnerList.get(1));
					lbMSales.setText(enterInnerList.get(2));
					lbProfit.setText(enterInnerList.get(3));
					lbBCost.setText(enterInnerList.get(4));

				}
				

				// lbSPrice
				// lbBCost
				// lbMSales
				// lbProfit

				
			}
		});

		// Loads up the jList with elements from the list
		for (int i = 0; i < twoDList.size(); i++) {
			//Assigns a row to the InnerList
			enterInnerList = twoDList.get(i);
			lModel.add(i, enterInnerList.get(0));

		}
		System.out.println(enterInnerList);

	}

	// ====================================================================================
	String path = "Data.csv";
	static String line = "";
	String[][] tempdata = new String[100][5];
	

	// Imports data
	public void ImportData() throws IOException {
		//twoDList.clear();
		BufferedReader br = new BufferedReader(new FileReader(path));
		int i = 0;
		String[] temp;

		// Inserts data into data array
		while ((row = br.readLine()) != null) {
			temp = row.split(",");
			int x2 = 0;
			// Automatically checks for letters past the first index and corrects the order
			// of variables
			for (int x = 0; x <= 4; x++) {
				char ch = temp[x].charAt(0);

				if (x == 1 && Character.isDigit(ch) == false) {
					System.out.println("Detected");

					tempdata[i][x] = temp[x + 1];
					x2++;
				} else {
					tempdata[i][x] = temp[x2];
				}
				x2++;
			}
			i++;
		}

		System.out.println(Arrays.deepToString(tempdata));
		System.out.println();

		for (i = 0; i < tempdata.length; i++) {
			if (tempdata[i][0] != null) {
				rowList = new ArrayList<>();
				for (int x = 0; x <= 4; x++) {
					rowList.add(tempdata[i][x]);

					// System.out.println(rowList);
				}
				// System.out.println("Added row");
				twoDList.add(rowList);
				// if null is detected look will exit
			} else {
				break;
			}

		}

		// System.out.println(twoDList.get(1));

	}

	public void saveData() {
		
	}
	// ====================================================================================

	private void sortJListAlphabetically() {
		// Sort the twoDList alphabetically by the first column 
	    Collections.sort(twoDList, new Comparator<List<String>>() {
	        public int compare(List<String> o1, List<String> o2) {
	            return o1.get(0).compareToIgnoreCase(o2.get(0));
	        }
	    });

	    // Update the JList model with the sorted data
	    DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	    model.clear();
	    for (List<String> row : twoDList) {
	        model.addElement(row.get(0));
	    }

	    // Refresh the JList to display the sorted data
	    list.setModel(model);
	    
	   
	}
	
	private void sortJListProfit() {
	    // Sort the twoDList by the "Profit" column (assuming it's the fourth column with index 3)
	    Collections.sort(twoDList, new Comparator<List<String>>() {
	        public int compare(List<String> o1, List<String> o2) {
	            // Parse the "Profit" values as doubles for comparison
	            double profit1 = Double.parseDouble(o1.get(3));
	            double profit2 = Double.parseDouble(o2.get(3));

	            // Compare the profits
	            return Double.compare(profit2, profit1);
	        }
	    });

	    // Update the JList model with the sorted data
	    DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	    model.clear();
	    for (List<String> row : twoDList) {
	        model.addElement(row.get(0));
	    }

	    // Refresh the JList to display the sorted data
	    list.setModel(model);
		
	}
	
	private void sortJListByCost() {
	    // Sort the twoDList by the "Buy Cost" column (assuming it's the fifth column with index 4)
	    Collections.sort(twoDList, new Comparator<List<String>>() {
	        public int compare(List<String> o1, List<String> o2) {
	            // Parse the "Buy Cost" values as doubles for comparison
	            double cost1 = Double.parseDouble(o1.get(4));
	            double cost2 = Double.parseDouble(o2.get(4));

	            // Compare the costs
	            return Double.compare(cost2, cost1);
	        }
	    });

	    // Update the JList model with the sorted data
	    DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	    model.clear();
	    for (List<String> row : twoDList) {
	        model.addElement(row.get(0));
	    }

	    // Refresh the JList to display the sorted data
	    list.setModel(model);
	}
	
	private void sortJListByMoSales() {
	    // Sort the twoDList by the "Mo/Sales" column (assuming it's the third column with index 2)
	    Collections.sort(twoDList, new Comparator<List<String>>() {
	        public int compare(List<String> o1, List<String> o2) {
	            // Parse the "Mo/Sales" values as doubles for comparison
	            double moSales1 = Double.parseDouble(o1.get(2));
	            double moSales2 = Double.parseDouble(o2.get(2));

	            // Compare the Mo/Sales
	            return Double.compare(moSales2, moSales1);
	        }
	    });

	    // Update the JList model with the sorted data
	    DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	    model.clear();
	    for (List<String> row : twoDList) {
	        model.addElement(row.get(0));
	    }

	    // Refresh the JList to display the sorted data
	    list.setModel(model);
	}
	
	private void sortJListBySellPrice() {
	    // Sort the twoDList by the "Sell Price" column (assuming it's the second column with index 1)
	    Collections.sort(twoDList, new Comparator<List<String>>() {
	        public int compare(List<String> o1, List<String> o2) {
	            // Parse the "Sell Price" values as doubles for comparison
	            double sellPrice1 = Double.parseDouble(o1.get(1));
	            double sellPrice2 = Double.parseDouble(o2.get(1));

	            // Compare the Sell Prices
	            return Double.compare(sellPrice2, sellPrice1);
	        }
	    });

	    // Update the JList model with the sorted data
	    DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	    model.clear();
	    for (List<String> row : twoDList) {
	        model.addElement(row.get(0));
	    }

	    // Refresh the JList to display the sorted data
	    list.setModel(model);
	}
	
	private void searchJList(String input) {
	    // Filter the twoDList based on the search query
	    List<List<String>> filteredList = new ArrayList<>();
	    for (List<String> row : twoDList) {
	        if (row.get(0).toLowerCase().contains(input.toLowerCase())) {
	            filteredList.add(row);
	        }
	    }

	    // Update the JList model with the filtered data
	    DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
	    model.clear();
	    for (List<String> row : filteredList) {
	        model.addElement(row.get(0));
	    }

	    // Refresh the JList to display the filtered data
	    list.setModel(model);
	}
	// Legacy method, is not used
	public void Data() throws IOException {

		String count = "row%d";

		BufferedReader br = new BufferedReader(new FileReader(path));
		List<List<String>> twoDList = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			String[] word = line.split(",");
			List<String> row = new ArrayList<>();
			row.add(word[0]);
			row.add(word[1]);
			row.add(word[2]);
			row.add(word[3]);
			// row.add(word[5]);
			System.out.println(row);
			System.out.println();
			twoDList.add(row);

		}

		for (List<String> row : twoDList) {
			System.out.println(row);
		}

		// System.out.println(tempList.toString());
		// System.out.println(Arrays.toString(tempList.toArray()));

		PrintWriter clean = new PrintWriter(new FileWriter(new File(path), true));

	}
}
