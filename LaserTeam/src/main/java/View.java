// Author: Team 15
// Date: Spring 2022
// Purpose: View component of Software Engineering project

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class View extends JPanel
{
	// Class members
	Model model;
	
	// Constructor
	View(Controller c, Model m)
	{
		model = m;
		c.setView(this);
		
		// Player selection GUI elements
		buildSelectionGUI();
	}
	
	// Build player selection GUI
	public void buildSelectionGUI()
	{
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		super.setLayout(new GridBagLayout());
		
		// Output text
		JPanel outputPanel = new JPanel();
		JLabel outputLabel = new JLabel("Output text.");
		outputPanel.add(outputLabel);
		super.add(outputPanel, constraints);
		
		// ID
		constraints.gridy = 1;
		JPanel idPanel = new JPanel();
		JLabel idLabel = new JLabel("ID:");
		idPanel.add(idLabel);
		JTextField idField = new JTextField(20);
		idPanel.add(idField);
		super.add(idPanel, constraints);
		
		// First name
		constraints.gridy = 2;
		JPanel fnPanel = new JPanel();
		JLabel fnLabel = new JLabel("First Name:");
		fnPanel.add(fnLabel);
		JTextField fnField = new JTextField(20);
		fnPanel.add(fnField);
		super.add(fnPanel, constraints);
		
		// Last name
		constraints.gridy = 3;
		JPanel lnPanel = new JPanel();
		JLabel lnLabel = new JLabel("Last Name:");
		lnPanel.add(lnLabel);
		JTextField lnField = new JTextField(20);
		lnPanel.add(lnField);
		super.add(lnPanel, constraints);
		
		// Code name
		constraints.gridy = 4;
		JPanel cnPanel = new JPanel();
		JLabel cnLabel = new JLabel("Codename:");
		cnPanel.add(cnLabel);
		JTextField cnField = new JTextField(20);
		cnPanel.add(cnField);
		super.add(cnPanel, constraints);
		
		// Player entry button
		constraints.gridy = 5;
		JPanel entryPanel = new JPanel();
		JButton playerb = new JButton("Enter Player");  
		playerb.addActionListener(new ActionListener()
		{
			// Submit information to new player object
			public void actionPerformed(ActionEvent e)
			{
				// Harvest information from text fields
				if (canParse(idField.getText()))	// if ID field is valid
				{
					int idText = Integer.parseInt(idField.getText());
					String cnText = cnField.getText();
					if(idIsUnique(idText, cnText))
					{
						String fnText = fnField.getText();
						String lnText = lnField.getText();
				
						// Submit information through addPlayer function in Model class
						model.addPlayer(idText, fnText, lnText, cnText);
						outputLabel.setText("Player successfully entered.");
					}
					else
						outputLabel.setText("Invalid input: ID must be unique");
				}
				else
					outputLabel.setText("Invalid input");
			}
		});
		entryPanel.add(playerb);
		super.add(entryPanel, constraints);
	}
	
	// TODO: Close player selection GUI
	public void closeSelectionGUI()
	{
		
	}
	
	// Method to determine whether input can be parsed as integer
	public boolean canParse(String statement)
	{
		try {
			Integer.parseInt(statement);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	// Method to determine whether ID and codename are unique
	public boolean idIsUnique(int id, String codename)
	{
		for(int i = 0; i < model.players.size(); i++)
		{
			Player n = model.players.get(i);
			if((id == n.id) || (codename.equals(n.code_name)))
				return false;
		}
		return true;
	}
	
	// Method to update view (for displaying visuals)
	public void paintComponent(Graphics g)
	{
		// Set background color
		g.setColor(new Color(50, 50, 50));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Player selection GUI
		// TODO: Handle switching screens
	}
}
