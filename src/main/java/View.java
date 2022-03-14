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
		final JLabel outputLabel = new JLabel("Output text.");
		outputPanel.add(outputLabel);
		super.add(outputPanel, constraints);
		
		// ID
		constraints.gridy = 1;
		JPanel idPanel = new JPanel();
		JLabel idLabel = new JLabel("ID:");
		idPanel.add(idLabel);
		final JTextField idField = new JTextField(20);
		idPanel.add(idField);
		super.add(idPanel, constraints);
		
		// First name
		constraints.gridy = 2;
		JPanel fnPanel = new JPanel();
		JLabel fnLabel = new JLabel("First Name:");
		fnPanel.add(fnLabel);
		final JTextField fnField = new JTextField(20);
		fnPanel.add(fnField);
		super.add(fnPanel, constraints);
		
		// Last name
		constraints.gridy = 3;
		JPanel lnPanel = new JPanel();
		JLabel lnLabel = new JLabel("Last Name:");
		lnPanel.add(lnLabel);
		final JTextField lnField = new JTextField(20);
		lnPanel.add(lnField);
		super.add(lnPanel, constraints);
		
		// Code name
		constraints.gridy = 4;
		JPanel cnPanel = new JPanel();
		JLabel cnLabel = new JLabel("Codename:");
		cnPanel.add(cnLabel);
		final JTextField cnField = new JTextField(20);
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
					
				// Clears text fields
				idField.setText("");
				fnField.setText("");
				lnField.setText("");
				cnField.setText("");
			}
		});
		entryPanel.add(playerb);
		super.add(entryPanel, constraints);
		
		// Upload all players to database button
		constraints.gridy = 6;
		JPanel uploadPanel = new JPanel();
		JButton uploadb = new JButton("Upload Players to Database");
		uploadb.addActionListener(new ActionListener()
		{
			// Indirectly call database connection function
			public void actionPerformed(ActionEvent e)
			{
				model.modelPlayersInsert();
			}
		});
		uploadPanel.add(uploadb);
		super.add(uploadPanel, constraints);
		
		// Start game button TODO: REMOVE START GAME BUTTON WITH IMPLEMENTATION OF f5!
		constraints.gridy = 7;
		JPanel startPanel = new JPanel();
		JButton startGame = new JButton("Start Game!");  
		startGame.addActionListener(new ActionListener()
		{
			// Confirm all players have been entered and start game
			public void actionPerformed(ActionEvent e)
			{
				actionDisplayGUI();
			}
		});
		startPanel.add(startGame);
		super.add(startPanel, constraints);
	}


	
	// Action display GUI
	public void actionDisplayGUI()
	{
		// Removes all the components from container
		super.removeAll();

		super.validate();

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		super.setLayout(new GridBagLayout());

		// Create countdown timer
		Countdown countdown = new Countdown();
		JPanel countdownPanel = new JPanel();
		JLabel countdownLabel = new JLabel("COUNTDOWN TIMER");
		countdown.time(390, countdownLabel);
		countdownPanel.add(countdownLabel);
		super.add(countdownPanel, constraints);

		// Team 1 text
		constraints.gridy = 1;
		JPanel team1Panel = new JPanel();
		JLabel team1Label = new JLabel("TEAM 1");
		team1Panel.add(team1Label);
		super.add(team1Panel, constraints);

		// Team 2 text
		constraints.gridx = 6;
		JPanel team2Panel = new JPanel();
		JLabel team2Label = new JLabel("TEAM 2");
		team2Panel.add(team2Label);
		super.add(team2Panel, constraints);
		
		// Player 1 text
		if(model.modelNumRows() >= 1)
		{
			constraints.gridy = 2;
			constraints.gridx = 0;
			JPanel player1Panel = new JPanel();
			JLabel player1Label = new JLabel(model.modelPlayersRetrieve(0));
			player1Panel.add(player1Label);
			super.add(player1Panel, constraints);
		}

		// Player 2 text
		if(model.modelNumRows() >= 2)
		{
			constraints.gridy = 2;
			constraints.gridx = 6;
			JPanel player2Panel = new JPanel();
			JLabel player2Label = new JLabel(model.modelPlayersRetrieve(1));
			player2Panel.add(player2Label);
			super.add(player2Panel, constraints);
		}

		// Player 3 text
		if(model.modelNumRows() >= 3)
		{
			constraints.gridy = 3;
			constraints.gridx = 0;
			JPanel player3Panel = new JPanel();
			JLabel player3Label = new JLabel(model.modelPlayersRetrieve(2));
			player3Panel.add(player3Label);
			super.add(player3Panel, constraints);
		}

		// Player 4 text
		if(model.modelNumRows() >= 4)
		{
			constraints.gridy = 3;
			constraints.gridx = 6;
			JPanel player4Panel = new JPanel();
			JLabel player4Label = new JLabel(model.modelPlayersRetrieve(3));
			player4Panel.add(player4Label);
			super.add(player4Panel, constraints);
		}

		// Player 5 text
		if(model.modelNumRows() >= 5)
		{
			constraints.gridy = 4;
			constraints.gridx = 0;
			JPanel player5Panel = new JPanel();
			JLabel player5Label = new JLabel(model.modelPlayersRetrieve(4));
			player5Panel.add(player5Label);
			super.add(player5Panel, constraints);
		}

		// Player 6 text
		if(model.modelNumRows() >= 6)
		{
			constraints.gridy = 4;
			constraints.gridx = 6;
			JPanel player6Panel = new JPanel();
			JLabel player6Label = new JLabel(model.modelPlayersRetrieve(5));
			player6Panel.add(player6Label);
			super.add(player6Panel, constraints);
		}
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
	}
}
