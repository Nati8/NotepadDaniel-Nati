package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class StartFrame extends JFrame {

    public JPanel panel = new JPanel();
    public JLabel[][] indexRowCol;

    JMenuBar menuBar;
    JTextArea textArea;
    JFrame frame;
    JMenu file,edit,format,view,help;
    JMenuItem newFile,open,save,saveAs, exit;
    JMenuItem cut,copy,paste,delete,find,findNext,replace;
    JMenuItem font;
    JMenuItem statusBar;
    JMenuItem aboutNotePad;


    public StartFrame() {

        menuBar = new JMenuBar();

        textArea = new JTextArea(100,100);
        textArea.setVisible(true);
        this.add(textArea);

        file = new JMenu("File");
        newFile = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As...");
        exit = new JMenuItem("Exit");



        edit = new JMenu("Edit");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        delete = new JMenuItem("Delete");
        find = new JMenuItem("Find");
        findNext = new JMenuItem("Find Next");
        replace = new JMenuItem("Replace...");

        format = new JMenu("Formate");
        font = new JMenuItem("Font");

        view = new JMenu("View");
        statusBar = new JMenuItem("Status Bar");

        help = new JMenu("Help");
        aboutNotePad = new JMenuItem("About NotePad");

        setTitle("Notepad");
        setSize(500, 400);
        setLocation(250, 30);
        panel.setLayout(null);
        getContentPane().add(textArea);

        menuBar.add(file);
        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(exit);

        menuBar.add(edit);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);
        edit.add(find);
        edit.add(findNext);
        edit.add(replace);

        menuBar.add(format);
        format.add(font);

        menuBar.add(view);
        view.add(statusBar);

        menuBar.add(help);
        help.add(aboutNotePad);

        this.setJMenuBar(menuBar);

        setDefaultCloseOperation(StartFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();



        final int[] counter = {1};
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                textArea.setText("");
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                JFileChooser j = new JFileChooser("f:");

                int r = j.showOpenDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {
                    // Взимане на файла от зададения път
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        String s1 = "", sl = "";

                        FileReader fr = new FileReader(fi);

                        BufferedReader br = new BufferedReader(fr);

                        sl = br.readLine();

                        // Взимане на информацията от файла
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }

                        // Поставяне на текста в текстовото поле
                        textArea.setText(sl);
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(frame, evt.getMessage());
                    }
            }
            }
        });


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                textArea.getText().replace(textArea.getText(),textArea.getText());
            }
        });

        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                JFileChooser j = new JFileChooser("f:");

                int r = j.showSaveDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {

                    // Създаване на файл на избраното от потребителя място
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {

                        FileWriter wr = new FileWriter(fi, false);

                        BufferedWriter w = new BufferedWriter(wr);
                        
                        w.write(textArea.getText());

                        w.flush();
                        w.close();
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(frame, evt.getMessage());
                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit(0);
            }
        });

        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                textArea.cut();
            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                textArea.copy();
            }
        });

        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                textArea.paste();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                textArea.setText(textArea.getText().replace(textArea.getSelectedText(),""));
            }
        });

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                FindFrame findFrame = new FindFrame();
            }
        });

        findNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                ReplaceFrame replaceFrame = new ReplaceFrame();
            }
        });

        font.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                FontFrame fontFrame = new FontFrame();
            }
        });

        statusBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        aboutNotePad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                AboutFrame aboutFrame = new AboutFrame();
            }
        });
    }


}

