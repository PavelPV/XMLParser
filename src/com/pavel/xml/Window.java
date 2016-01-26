package com.pavel.xml;

import com.pavel.xml.entity.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Window extends JFrame implements ActionListener {

    private static String FOLDER = "/home/bobsworld-user/Folder for Linux Pavlo/desktop/workXMLfolder/";

    private XMLReader app;

    private Blocks_item reportBlock;
    private Blocks_item detailBlock;

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

    private JLabel l_detailName;
    private JTextField t_detailName;
    private JLabel l_detailLabel;
    private JTextField t_detailLabel;
    private JLabel l_detailDBObject;
    private JTextField t_detailDBObject;

    private JScrollPane s_report;
    private JTable tab_report;
    private JScrollPane s_detail;
    private JTable tab_detail;

    private JTabbedPane tabbedPaneLeft;
    private JTabbedPane tabbedPaneRight;
    private JPanel panelRight;
    private JPanel panelRelation;
    private JPanel panelLink;
    private JPanel panelCode;
    private JPanel panelLov;
    private JTable tab_Right;
    private JTable tab_Relation;
    private JTable tab_Link;
    private JTable tab_Lov;
    private JTextArea ta_Code;
    private JScrollPane scrolTabRight;
    private JScrollPane scrolRelation;
    private JScrollPane scrolLink;
    private JScrollPane scrolCode;
    private JScrollPane scrolLov;
    private JSplitPane splitPanel;

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

        this.l_reportName = new JLabel("Report name:");
        this.t_reportName = new JTextField(20);
        this.t_reportName.setEditable(false);
        this.l_reportLabel = new JLabel("Label");
        this.t_reportLabel = new JTextField(20);
        this.t_reportLabel.setEditable(false);
        this.l_reportDBObject = new JLabel("DB Object");
        this.t_reportDBObject = new JTextField(20);
        this.t_reportDBObject.setEditable(false);

        this.l_detailName = new JLabel("Detail name:");
        this.t_detailName = new JTextField(20);
        this.t_detailName.setEditable(false);
        this.l_detailLabel = new JLabel("Label");
        this.t_detailLabel = new JTextField(20);
        this.t_detailLabel.setEditable(false);
        this.l_detailDBObject = new JLabel("DB Object");
        this.t_detailDBObject = new JTextField(20);
        this.t_detailDBObject.setEditable(false);

        this.report = new JPanel();
        this.report.setLayout(null);
        this.report.setPreferredSize(new Dimension(450, 600));
        this.report.add(l_reportName);
        l_reportName.setSize(200, 20);
        l_reportName.setLocation(30, 5);
        this.report.add(t_reportName);
        t_reportName.setSize(255, 20);
        t_reportName.setLocation(180, 5);
        this.report.add(l_reportLabel);
        l_reportLabel.setSize(200, 20);
        l_reportLabel.setLocation(30, 30);
        this.report.add(t_reportLabel);
        t_reportLabel.setSize(255, 20);
        t_reportLabel.setLocation(180, 30);
        this.report.add(l_reportDBObject);
        l_reportDBObject.setSize(200, 20);
        l_reportDBObject.setLocation(30, 55);
        this.report.add(t_reportDBObject);
        t_reportDBObject.setSize(255, 20);
        t_reportDBObject.setLocation(180, 55);

        this.detail = new JPanel();
        this.detail.setLayout(null);
        this.detail.setPreferredSize(new Dimension(450, 600));
        this.detail.add(l_detailName);
        l_detailName.setSize(200, 20);
        l_detailName.setLocation(30, 5);
        this.detail.add(t_detailName);
        t_detailName.setSize(255, 20);
        t_detailName.setLocation(180, 5);
        this.detail.add(l_detailLabel);
        l_detailLabel.setSize(200, 20);
        l_detailLabel.setLocation(30, 30);
        this.detail.add(t_detailLabel);
        t_detailLabel.setSize(255, 20);
        t_detailLabel.setLocation(180, 30);
        this.detail.add(l_detailDBObject);
        l_detailDBObject.setSize(200, 20);
        l_detailDBObject.setLocation(30, 55);
        this.detail.add(t_detailDBObject);
        t_detailDBObject.setSize(255, 20);
        t_detailDBObject.setLocation(180, 55);

        String[] columnsReport = {"Name", "Label", "R", "L", "C", "B"};
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.tab_report = new JTable(new DefaultTableModel(new Object[][]{}, columnsReport) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        this.tab_report.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.tab_report.getColumnModel().getColumn(1).setPreferredWidth(220);
        this.tab_report.getColumnModel().getColumn(2).setPreferredWidth(25);
        this.tab_report.getColumnModel().getColumn(2).setCellRenderer(renderer);
        this.tab_report.getColumnModel().getColumn(3).setPreferredWidth(25);
        this.tab_report.getColumnModel().getColumn(3).setCellRenderer(renderer);
        this.tab_report.getColumnModel().getColumn(4).setPreferredWidth(25);
        this.tab_report.getColumnModel().getColumn(4).setCellRenderer(renderer);
        this.tab_report.getColumnModel().getColumn(5).setPreferredWidth(25);
        this.tab_report.getColumnModel().getColumn(5).setCellRenderer(renderer);
        this.s_report = new JScrollPane(tab_report);
//        this.s_report.setPreferredSize(new Dimension(450, 300));
        this.s_report.setSize(450, 300);
        this.s_report.setLocation(8, 80);
        this.tab_report.setAutoscrolls(true);

        this.report.add(s_report);

        String[] columnsDetail = {"Name", "Label", "Not Null", "R", "L", "C", "B"};
        this.tab_detail = new JTable(new DefaultTableModel(new Object[][]{}, columnsDetail) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        this.tab_detail.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.tab_detail.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.tab_detail.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.tab_detail.getColumnModel().getColumn(3).setCellRenderer(renderer);
        this.tab_detail.getColumnModel().getColumn(3).setPreferredWidth(25);
        this.tab_detail.getColumnModel().getColumn(4).setCellRenderer(renderer);
        this.tab_detail.getColumnModel().getColumn(4).setPreferredWidth(25);
        this.tab_detail.getColumnModel().getColumn(5).setCellRenderer(renderer);
        this.tab_detail.getColumnModel().getColumn(5).setPreferredWidth(25);
        this.tab_detail.getColumnModel().getColumn(6).setCellRenderer(renderer);
        this.tab_detail.getColumnModel().getColumn(6).setPreferredWidth(25);
        this.s_detail = new JScrollPane(tab_detail);
//        this.s_detail.setPreferredSize(new Dimension(450, 300));
        this.s_detail.setSize(450, 300);
        this.s_detail.setLocation(8, 80);
        this.tab_detail.setAutoscrolls(true);

        this.detail.add(s_detail);

        this.tabbedPaneLeft = new JTabbedPane();
        this.tabbedPaneLeft.add(report, "Report");
        this.tabbedPaneLeft.add(detail, "Detail");
        this.tabbedPaneLeft.setPreferredSize(new Dimension(500, 500));

        this.panelRight = new JPanel();

        String[] columnsRight = new String[]{"Name", "Value"};
        this.tab_Right = new JTable(new DefaultTableModel(new Object[][]{}, columnsRight) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        this.tab_Right.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.tab_Right.getColumnModel().getColumn(1).setPreferredWidth(290);
        this.scrolTabRight = new JScrollPane(tab_Right);
        this.scrolTabRight.setPreferredSize(new Dimension(400, 471));
        this.panelRight.add(scrolTabRight);

        this.tabbedPaneRight = new JTabbedPane();
        this.tabbedPaneRight.add(panelRight, "Field");

        this.panelRelation = new JPanel();
        this.tabbedPaneRight.add(panelRelation, "Relation");
        this.tab_Relation = new JTable(new DefaultTableModel(new Object[][]{}, columnsRight) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        this.tab_Relation.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.tab_Relation.getColumnModel().getColumn(1).setPreferredWidth(290);
        this.scrolRelation = new JScrollPane(tab_Relation);
        this.scrolRelation.setPreferredSize(new Dimension(400, 471));
        this.panelRelation.add(scrolRelation);

        this.panelLink = new JPanel();
        this.tab_Link = new JTable(new DefaultTableModel(new Object[][]{}, columnsRight) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        this.tab_Link.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.tab_Link.getColumnModel().getColumn(1).setPreferredWidth(290);
        this.scrolLink = new JScrollPane(tab_Link);
        this.scrolLink.setPreferredSize(new Dimension(400, 471));
        this.panelLink.add(scrolLink);
        this.tabbedPaneRight.add(panelLink, "Link");

        this.panelCode = new JPanel();
        this.ta_Code = new JTextArea();
        this.ta_Code.setColumns(37);
        this.ta_Code.setRows(29);
        this.ta_Code.setEditable(false);
        this.scrolCode = new JScrollPane(ta_Code);
        this.panelCode.add(scrolCode);
        this.tabbedPaneRight.add(panelCode, "Code");

        this.panelLov = new JPanel();
        this.tab_Lov = new JTable(new DefaultTableModel(new Object[][]{}, columnsRight) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        this.tab_Lov.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.tab_Lov.getColumnModel().getColumn(1).setPreferredWidth(290);
        this.scrolLov = new JScrollPane(tab_Lov);
        this.scrolLov.setPreferredSize(new Dimension(400, 471));
        this.panelLov.add(scrolLov);
        this.tabbedPaneRight.add(panelLov, "Lov");

        this.splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPaneLeft, tabbedPaneRight);
        this.splitPanel.setPreferredSize(new Dimension(900, 510));
        this.splitPanel.setDividerLocation(470);

        JPanel panel = new JPanel();
        panel.add(b_choosefile);
        panel.add(l_pageName);
        panel.add(t_pageName);
        panel.add(b_chooseFileChanges);
        panel.add(splitPanel);

        this.b_choosefile.addActionListener(this);
        this.b_chooseFileChanges.addActionListener(this);
        this.tab_report.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                Integer s = tab_report.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) tab_Right.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                if (s == -1) {
                    return;
                }
                Columns_item col = reportBlock.getColumns_item().get(s);
                model.addRow(new Object[]{"Name", col.getName()});
                model.addRow(new Object[]{"DB Column", col.getDatabase_column()});
                model.addRow(new Object[]{"Label", col.getLabel()});
                model.addRow(new Object[]{"Localisation", col.getI18n()});
                model.addRow(new Object[]{"Type", col.getType()});
                model.addRow(new Object[]{"Visible", col.getVisible()});
                model.addRow(new Object[]{"Order", col.getColumn_order()});

                model = (DefaultTableModel) tab_Relation.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                if (col.getColumnRelation() != null) {
                    if (col.getColumnRelation().getElements_item() != null) {
                        model.addRow(new Object[]{"DB Object", col.getColumnRelation().getDb_object()});
                        model.addRow(new Object[]{"File", col.getColumnRelation().getColumnRelationEnumerationFile()});
                        for (Field_relation.Elements_item element : col.getColumnRelation().getElements_item()) {
                            model.addRow(new Object[]{"Master / Slave", element.getMaster_name() + " / " + element.getSlave_name()});
                        }
                    }
                }

                model = (DefaultTableModel) tab_Link.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }

                if (col.getLink() != null) {
                    model.addRow(new Object[]{"Href", col.getLink().getHref()});
                    for (Link.Parameters_item parameter : col.getLink().getParameters_item()) {
                        model.addRow(new Object[]{"Value / Type", parameter.getValue() + " / " + parameter.getClazz()});
                    }
                }

                if (col.getFormula() != null) {
                    ta_Code.setText(col.getFormula().replace("\t", ""));
                }
            }
        });
        this.tab_detail.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                Integer s = tab_detail.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) tab_Right.getModel();

                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                if (s == -1) {
                    return;
                }
                Fields_item field = detailBlock.getFields_item().get(s);
                model.addRow(new Object[]{"Name", field.getName()});
                model.addRow(new Object[]{"DB Column", field.getDatabase_column()});
                model.addRow(new Object[]{"Class", field.getClazz()});
                model.addRow(new Object[]{"Label", field.getLabel()});
                model.addRow(new Object[]{"Localisation", field.getI18n()});
                model.addRow(new Object[]{"Help Label", field.getHelp()});
                model.addRow(new Object[]{"Help Localisation", field.getI18nHelp()});
                model.addRow(new Object[]{"Type", field.getType()});
                model.addRow(new Object[]{"Not Null", field.getNot_null()});
                model.addRow(new Object[]{"Size", field.getSize()});
                model.addRow(new Object[]{"Max Length", field.getMaxlength()});
                model.addRow(new Object[]{"Max value", field.getHighest_value()});
                model.addRow(new Object[]{"Min value", field.getLowest_value()});
                model.addRow(new Object[]{"Customized", field.getIsCustomized()});
                model.addRow(new Object[]{"Read Only", field.getReadonly()});
                model.addRow(new Object[]{"Show help", field.getShow_help()});
                model.addRow(new Object[]{"Code", field.getCodeItem()});
                model.addRow(new Object[]{"Format", field.getFormat()});
                model.addRow(new Object[]{"Case restriction", field.getCase_restriction()});
                model.addRow(new Object[]{"Break line", field.getBreak_line()});
                model.addRow(new Object[]{"Disabled", field.getDisabled()});
                model.addRow(new Object[]{"Localisation", field.getI18n()});
                model.addRow(new Object[]{"Select", field.getSelect_allowed()});
                model.addRow(new Object[]{"Insert", field.getInsert_allowed()});
                model.addRow(new Object[]{"Update", field.getUpdate_allowed()});
                model.addRow(new Object[]{"Options", field.getOptions()});

                model = (DefaultTableModel) tab_Relation.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                if (field.getField_relation() != null) {
                    if (field.getField_relation().getElements_item() != null) {
                        model.addRow(new Object[]{"DB Object", field.getField_relation().getDb_object()});
                        for (Field_relation.Elements_item element : field.getField_relation().getElements_item()) {
                            model.addRow(new Object[]{"Master / Slave", element.getMaster_name() + " / " + element.getSlave_name()});
                        }
                    }
                }

                model = (DefaultTableModel) tab_Lov.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                if (field.getLovObject() != null) {
                    model.addRow(new Object[]{"Action", field.getLovObject().getLovAction()});
                    for (LovObject.LovReturns_item item : field.getLovObject().getLovReturns_item()) {
                        model.addRow(new Object[]{"Return / Type", item.getValue() + " / " + item.getClazz()});
                    }
                }
            }

        });

        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Window window = new Window();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == b_choosefile) {
            this.tab_detail.clearSelection();
            this.tab_report.clearSelection();
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.setCurrentDirectory(new File(FOLDER));
            int approve = fileOpen.showDialog(null, "Choose xml file");
            if (approve == JFileChooser.APPROVE_OPTION) {
                try {
                    Date start = new Date();
                    this.app = new XMLReader(fileOpen.getSelectedFile().getAbsolutePath().replace('\\', '/'));
                    Generator generator = this.app.parseXml();
                    reportBlock = new Blocks_item();
                    detailBlock = new Blocks_item();
                    for (Blocks_item block : generator.getBlocks_item()) {
                        if (block.getName() != null) {
                            if (block.getName().contains("report")) {
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
                    List<Object[]> objectsReport = new ArrayList<Object[]>();
                    for (Columns_item column : reportBlock.getColumns_item()) {
                        if (column.getName() != null) {
                            objectsReport.add(new Object[]{column.getName(), column.getLabel(),
                                    column.getColumnRelation() != null && column.getColumnRelation().getElements_item() != null ? "\u2713" : "\u00d7",
                                    column.getLink() != null ? "\u2713" : "\u00d7",
                                    column.getFormula() != null && !(column.getFormula().equals("")) ? "\u2713" : "\u00d7",
                                    false ? "\u2713" : "\u00d7"});
                        }
                    }
                    DefaultTableModel modelReport = (DefaultTableModel) this.tab_report.getModel();
                    while (modelReport.getRowCount() > 0) {
                        modelReport.removeRow(0);
                    }
                    for (Object[] o : objectsReport) {
                        modelReport.addRow(o);
                    }

                    this.t_detailName.setText(detailBlock.getName());
                    this.t_detailLabel.setText(detailBlock.getTitle());
                    this.t_detailDBObject.setText(detailBlock.getDb_object());
                    List<Object[]> objectsDetail = new ArrayList<Object[]>();
                    for (Fields_item field : detailBlock.getFields_item()) {
                        if (field.getName() != null) {
                            objectsDetail.add(new Object[]{field.getName(), field.getLabel(), field.getNot_null(),
                                    field.getField_relation() != null && field.getField_relation().getElements_item() != null ? "\u2713" : "\u00d7",
                                    false ? "\u2713" : "\u00d7",
                                    field.getCodeItem() != null && !(field.getCodeItem().equals("")) ? "\u2713" : "\u00d7",
                                    field.getLovObject() != null && field.getLovObject().getLovAction() != null ? "\u2713" : "\u00d7"});
                        }
                    }
                    DefaultTableModel modelDetail = (DefaultTableModel) this.tab_detail.getModel();
                    while (modelDetail.getRowCount() > 0) {
                        modelDetail.removeRow(0);
                    }
                    for (Object[] o : objectsDetail) {
                        modelDetail.addRow(o);
                    }
                    Date end = new Date();
                    System.out.println(end.getTime() - start.getTime());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (event.getSource() == b_chooseFileChanges) {

            JFileChooser fileChanges = new JFileChooser();
            fileChanges.setCurrentDirectory(new File(FOLDER));
            int approve = fileChanges.showDialog(null, "Choose file with your changes");
            if (approve == JFileChooser.APPROVE_OPTION) {
                try {
                    Date start = new Date();
                    this.app.makeChanges(new BufferedReader(new FileReader(fileChanges.getSelectedFile().getAbsolutePath())));
                    Date end = new Date();
                    System.out.println(end.getTime() - start.getTime());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


