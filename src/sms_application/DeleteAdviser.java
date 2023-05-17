package sms_application;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.*;

public class DeleteAdviser extends BasicFrame {

    private static final long serialVersionUID = 1L;

    public DeleteAdviser() {
        this.setLocationRelativeTo(null);
        makeVisible();
    }

    public void addMainSection() {
        JPanel main_section = new JPanel();
        main_section.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
        main_section.setLayout(new BoxLayout(main_section, BoxLayout.Y_AXIS));

        //Main Heading
        JPanel main_heading_panel = new JPanel();
        main_heading_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        JTextField main_heading = new JTextField("DELETE ADVISER");
        main_heading.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        main_heading.setForeground(Color.DARK_GRAY);
        main_heading.setBackground(main_section.getBackground());
        main_heading.setBorder(BorderFactory.createEmptyBorder());
        main_heading_panel.add(main_heading);
        main_heading_panel.setVisible(true);
        main_section.add(main_heading_panel);
        //Main Heading End

        //Main Para
        JPanel main_para_panel = new JPanel();
        main_para_panel.setLayout(new BoxLayout(main_para_panel, BoxLayout.Y_AXIS));

        JPanel username_panel = new JPanel();
        username_panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 80, 0));
        JLabel username = new JLabel("User ID: ");
        username.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        username.setForeground(Color.GRAY);
        username_panel.add(username);
        JTextField user_input = new JTextField(20);
        user_input.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        user_input.setForeground(Color.GRAY);
        username_panel.add(user_input);
        username_panel.setVisible(true);
        main_para_panel.add(username_panel);

        JPanel button_panel = new JPanel();
        button_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton main_button = new JButton("Delete Adviser");
        main_button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        main_button.setForeground(main_heading.getForeground());

        //When Button is Pressed
        main_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ad_id = user_input.getText();

                if (databases.AdviserOperations.deleteUser(ad_id)) {
                    JOptionPane.showMessageDialog(main_section, "Adviser " + ad_id + " deleted Successfully!");
                    new DeleteAdviser();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(main_section, "Couldn't delete the user!");
                }
            }
        });

        button_panel.add(main_button);
        button_panel.setVisible(true);
        main_para_panel.add(button_panel);

        JPanel all_button_panel = new JPanel();
        all_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton all_main_button = new JButton("");
        


        all_button_panel.setVisible(true);
        main_para_panel.add(all_button_panel);
        main_para_panel.setVisible(true);
        main_section.add(main_para_panel);
        //Main Para End

        //Footer Button
        JPanel footer_button_panel = new JPanel();
        footer_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton footer_button = new JButton("Admin Dashboard");
        footer_button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        footer_button.setBackground(Color.WHITE);
        footer_button.setForeground(main_heading.getForeground());

        //When Button is Pressed
        footer_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminDashboard();
                disposeWindow();
            }
        });

        footer_button_panel.add(footer_button);
        footer_button_panel.setVisible(true);
        main_section.add(footer_button_panel);
        //Footer Button End

        main_section.setVisible(true);
        main_panel.add(main_section);
    }
}
