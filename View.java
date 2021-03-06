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
					
				// Clears text fields
				idField.setText("");
				fnField.setText("");
				lnField.setText("");
				cnField.setText("");
			}
		});
		entryPanel.add(playerb);
		super.add(entryPanel, constraints);

		// Start game button TODO: REMOVE START GAME BUTTON WITH IMPLEMENTATION OF f5!
		constraints.gridy = 6;
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

		// Team 1 text
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
		if(model.players.size() >= 1)
		{
			constraints.gridy = 1;
			constraints.gridx = 0;
			JPanel player1Panel = new JPanel();
			JLabel player1Label = new JLabel(model.players.get(0).code_name.toString());
			player1Panel.add(player1Label);
			super.add(player1Panel, constraints);
		}

		// Player 2 text
		if(model.players.size() >= 2)
		{
			constraints.gridy = 1;
			constraints.gridx = 6;
			JPanel player2Panel = new JPanel();
			JLabel player2Label = new JLabel(model.players.get(1).code_name.toString());
			player2Panel.add(player2Label);
			super.add(player2Panel, constraints);
		}

		// Player 3 text
		if(model.players.size() >= 3)
		{
			constraints.gridy = 2;
			constraints.gridx = 0;
			JPanel player3Panel = new JPanel();
			JLabel player3Label = new JLabel(model.players.get(2).code_name.toString());
			player3Panel.add(player3Label);
			super.add(player3Panel, constraints);
		}

		// Player 4 text
		if(model.players.size() >= 4)
		{
			constraints.gridy = 2;
			constraints.gridx = 6;
			JPanel player4Panel = new JPanel();
			JLabel player4Label = new JLabel(model.players.get(3).code_name.toString());
			player4Panel.add(player4Label);
			super.add(player4Panel, constraints);
		}

		// Player 5 text
		if(model.players.size() >= 5)
		{
			constraints.gridy = 3;
			constraints.gridx = 0;
			JPanel player5Panel = new JPanel();
			JLabel player5Label = new JLabel(model.players.get(4).code_name.toString());
			player5Panel.add(player5Label);
			super.add(player5Panel, constraints);
		}

		// Player 6 text
		if(model.players.size() >= 6)
		{
			constraints.gridy = 3;
			constraints.gridx = 6;
			JPanel player6Panel = new JPanel();
			JLabel player6Label = new JLabel(model.players.get(5).code_name.toString());
			player6Panel.add(player6Label);
			super.add(player6Panel, constraints);
		}
		// Player 7 text
			if(model.players.size() >= 7)
		{
			constraints.gridy = 4;
			constraints.gridx = 0;
			JPanel player7Panel = new JPanel();
			JLabel player7Label = new JLabel(model.players.get(6).code_name.toString());
			player7Panel.add(player7Label);
			super.add(player7Panel, constraints);
		}
		// Player 8 text
			if(model.players.size() >= 8)
		{
			constraints.gridy = 4;
			constraints.gridx = 6;
			JPanel player8Panel = new JPanel();
			JLabel player8Label = new JLabel(model.players.get(7).code_name.toString());
			player8Panel.add(player8Label);
			super.add(player8Panel, constraints);
		}
		// Player 9 text
			if(model.players.size() >= 9)
		{
			constraints.gridy = 5;
			constraints.gridx = 0;
			JPanel player9Panel = new JPanel();
			JLabel player9Label = new JLabel(model.players.get(8).code_name.toString());
			player9Panel.add(player9Label);
			super.add(player9Panel, constraints);
		}
		// Player 10 text
			if(model.players.size() >= 10)
		{
			constraints.gridy = 5;
			constraints.gridx = 6;
			JPanel player10Panel = new JPanel();
			JLabel player10Label = new JLabel(model.players.get(9).code_name.toString());
			player10Panel.add(player10Label);
			super.add(player10Panel, constraints);
		}
		// Player 11 text
			if(model.players.size() >= 11)
		{
			constraints.gridy = 6;
			constraints.gridx = 0;
			JPanel player11Panel = new JPanel();
			JLabel player11Label = new JLabel(model.players.get(10).code_name.toString());
			player11Panel.add(player11Label);
			super.add(player11Panel, constraints);
		}
		// Player 12 text
			if(model.players.size() >= 12)
		{
			constraints.gridy = 6;
			constraints.gridx = 6;
			JPanel player12Panel = new JPanel();
			JLabel player12Label = new JLabel(model.players.get(11).code_name.toString());
			player12Panel.add(player12Label);
			super.add(player12Panel, constraints);
		}
		// Player 13 text
			if(model.players.size() >= 13)
		{
			constraints.gridy = 7;
			constraints.gridx = 0;
			JPanel player13Panel = new JPanel();
			JLabel player13Label = new JLabel(model.players.get(12).code_name.toString());
			player13Panel.add(player13Label);
			super.add(player13Panel, constraints);
		}
		// Player 14 text
			if(model.players.size() >= 14)
		{
			constraints.gridy = 7;
			constraints.gridx = 6;
			JPanel player14Panel = new JPanel();
			JLabel player14Label = new JLabel(model.players.get(13).code_name.toString());
			player14Panel.add(player14Label);
			super.add(player14Panel, constraints);
		}
		// Player 15 text
			if(model.players.size() >= 15)
		{
			constraints.gridy = 8;
			constraints.gridx = 0;
			JPanel player15Panel = new JPanel();
			JLabel player15Label = new JLabel(model.players.get(14).code_name.toString());
			player15Panel.add(player15Label);
			super.add(player15Panel, constraints);
		}
		// Player 16 text
			if(model.players.size() >= 16)
		{
			constraints.gridy = 8;
			constraints.gridx = 6;
			JPanel player16Panel = new JPanel();
			JLabel player16Label = new JLabel(model.players.get(15).code_name.toString());
			player16Panel.add(player16Label);
			super.add(player16Panel, constraints);
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
		
		// Player selection GUI
		// TODO: Handle switching screens
	}
}
