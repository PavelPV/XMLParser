package com.pavel.xml;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.pavel.xml.entity.Blocks_item;
import com.pavel.xml.entity.Columns_item;
import com.pavel.xml.entity.Fields_item;
import com.pavel.xml.entity.Generator;

public class Window extends JFrame implements ActionListener {
	
	private AppXML app;
	
	private JPanel report;
	private JPanel detail;
	
	private JButton b_choosefile;
	private JButton b_chooseFileChanges;
	
	private JLabel l_pageName;
	private JTextField t_pageName;
	
	private JLabel l_reportName;
	private JTextField t_reportName;
	private JLabel l_reportLabel;
	private JTextField t_reportLabel;
	private JLabel l_reportDBObject;
	private JTextField t_reportDBObject;
	
	private JTextArea ta_report;
	private JScrollPane s_report;
	
	private JLabel l_detailName;
	private JTextField t_detailName;
	private JLabel l_detailLabel;
	private JTextField t_detailLabel;
	private JLabel l_detailDBObject;
	private JTextField t_detailDBObject;
	
	private JTextArea ta_detail;
	private JScrollPane s_detail;
	

	
	
	public Window() {
		super("Xml Parser");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(200, 80, 950, 650);
//		this.setResizable(false);
		
		this.b_choosefile = new JButton("Xml File");
		this.b_chooseFileChanges = new JButton("Change");
		this.l_pageName = new JLabel("Page Name: ");
		this.t_pageName = new JTextField(30);
		this.t_pageName.setEditable(false);
		
		this.l_reportName = new JLabel("Report name:                ");
		this.t_reportName = new JTextField(20);
		this.t_reportName.setEditable(false);
		this.l_reportLabel = new JLabel("Label                       ");
		this.t_reportLabel = new JTextField(20);
		this.t_reportLabel.setEditable(false);
		this.l_reportDBObject = new JLabel("DB Object                   ");
		this.t_reportDBObject = new JTextField(20);
		this.t_reportDBObject.setEditable(false);
		
		this.l_detailName = new JLabel("Detail name:                 ");
		this.t_detailName = new JTextField(20);
		this.t_detailName.setEditable(false);
		this.l_detailLabel = new JLabel("Label                        ");
		this.t_detailLabel = new JTextField(20);
		this.t_detailLabel.setEditable(false);
		this.l_detailDBObject = new JLabel("DB Object                    ");
		this.t_detailDBObject = new JTextField(20);
		this.t_detailDBObject.setEditable(false);
		
		this.ta_report = new JTextArea();
		this.s_report = new JScrollPane(ta_report);
		this.ta_report.setEditable(false);
		this.ta_report.setColumns(40);
		this.ta_report.setRows(30);
		
		this.ta_detail = new JTextArea();
		this.s_detail = new JScrollPane(ta_detail);
		this.ta_detail.setEditable(false);
		this.ta_detail.setColumns(40);
		this.ta_detail.setRows(30);
		
		this.report = new JPanel();
		this.report.setPreferredSize(new Dimension(450, 600));
		this.report.add(l_reportName);
		this.report.add(t_reportName);
		this.report.add(l_reportLabel);
		this.report.add(t_reportLabel);
		this.report.add(l_reportDBObject);
		this.report.add(t_reportDBObject);
//		this.report.add(s_report);
		
		this.detail = new JPanel();
		this.detail.setPreferredSize(new Dimension(450, 600));
		this.detail.add(l_detailName);
		this.detail.add(t_detailName);
		this.detail.add(l_detailLabel);
		this.detail.add(t_detailLabel);
		this.detail.add(l_detailDBObject);
		this.detail.add(t_detailDBObject);
//		this.detail.add(s_detail);
		
		JPanel panel = new JPanel();
		panel.add(b_choosefile);
		panel.add(l_pageName);
		panel.add(t_pageName);
		panel.add(b_chooseFileChanges);
		panel.add(report);
		panel.add(detail);
		
		b_choosefile.addActionListener(this);
		b_chooseFileChanges.addActionListener(this);
		
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Window window = new Window();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==b_choosefile) {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.setCurrentDirectory(new File("C:/Users/Andreas/Desktop/workXMLFolder"));
			int approve = fileOpen.showDialog(null, "Choose xml file");
			if (approve==JFileChooser.APPROVE_OPTION) {
				try {
					this.app = new AppXML(fileOpen.getSelectedFile().getAbsolutePath().replace('\\', '/'));
					Generator generator = this.app.parseXml();
					Blocks_item reportBlock = new Blocks_item();
					Blocks_item detailBlock = new Blocks_item();
					for(Blocks_item block : generator.getBlocks_item()) {
						if (block.getName()!=null) {
							if (block.getName().contains("report")){
								reportBlock = block;
							} else {
								detailBlock = block;
							}
						}
					}
					this.t_pageName.setText(generator.getFile_name());
					
					this.t_reportName.setText(reportBlock.getName());
					this.t_reportLabel.setText(reportBlock.getTitle());
					this.t_reportDBObject.setText(reportBlock.getDb_object());
					for(Columns_item column : reportBlock.getColumns_item()) {
						if (column.getName()!=null) {
							this.report.add(new JLabel("Name: " + column.getName() + " Label: " + column.getLabel() + " Type: " + column.getType()));
						}
					}
//					this.ta_report.setText(reportBlock.getColumns_item().toString());
					
					this.t_detailName.setText(detailBlock.getName());
					this.t_detailLabel.setText(detailBlock.getTitle());
					this.t_detailDBObject.setText(detailBlock.getDb_object());
					for(Fields_item field : detailBlock.getFields_item()) {
						if (field.getName()!=null) {
							this.detail.add(new JLabel("Name: " + field.getName() + " Label: " + field.getLabel() + " Type: " + field.getType() + " Not Null: " + field.getNot_null()));
						}
					}
					this.ta_detail.setText(detailBlock.getFields_item().toString());
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} else if (event.getSource()==b_chooseFileChanges) {
			JFileChooser fileChanges = new JFileChooser();
			fileChanges.setCurrentDirectory(new File("C:/Users/Andreas/Desktop/workXMLFolder"));
			int approve = fileChanges.showDialog(null, "Choose file with your changes");
			if (approve==JFileChooser.APPROVE_OPTION) {
				try {
					this.app.makeChanges(new BufferedReader(new FileReader(fileChanges.getSelectedFile().getAbsolutePath())));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
