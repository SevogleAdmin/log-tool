package com.sevogle;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DateConverter extends JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * @param args
     */
    public static void main(String[] args) {
        DateConverter dateConverter = new DateConverter();
        dateConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    DateConverter() {
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        JLabel lblDate = new JLabel("Date:");
        container.add(lblDate);
        final JTextField txtDateLong = new JTextField(25);
        container.add(txtDateLong);
        final JTextField lblResult = new JTextField("RESULT", 25);
        lblResult.setEditable(false);
        container.add(lblResult);
        txtDateLong.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                convert(txtDateLong, lblResult);
            }

        });
        txtDateLong.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                convert(txtDateLong, lblResult);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                convert(txtDateLong, lblResult);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                convert(txtDateLong, lblResult);
            }
        });
        txtDateLong.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                convert(txtDateLong, lblResult);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                convert(txtDateLong, lblResult);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                convert(txtDateLong, lblResult);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                convert(txtDateLong, lblResult);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                convert(txtDateLong, lblResult);
            }
        });
        this.setSize(400, 100);

        setVisible(true);
    }

    protected void convert(final JTextField txtDateLong, final JTextField lblResult) {
        String txt = txtDateLong.getText();
        try {
            long parseLong = Long.parseLong(txt);
            lblResult.setText(DateFormat.getDateTimeInstance().format(new Date(parseLong)));
        } catch (NumberFormatException e1) {
            lblResult.setText(e1.getMessage());
        }
    }
}
