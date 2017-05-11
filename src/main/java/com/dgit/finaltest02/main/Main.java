package com.dgit.finaltest02.main;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dgit.finaltest02.dto.Title;


@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton btnMem;
	private JButton btnPart;
	private JButton btnTitle;
	
	public Main() {
		setTitle("대구아이티ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));
		
		btnMem = new JButton("사원관리");
		btnMem.addActionListener(this);

		btnPart = new JButton("부서관리");
		btnPart.addActionListener(this);
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		
		contentPane.add(btnMem);
		contentPane.add(btnPart);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMem) {
			MemberMng m = new MemberMng();
			m.setVisible(true);
		} else if (e.getSource() == btnPart) {
			PartMng pm = new PartMng();
			pm.setVisible(true);
		} else if (e.getSource() == btnTitle) {
			TitleMng tm = new TitleMng();
			tm.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
