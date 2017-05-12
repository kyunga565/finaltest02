package com.dgit.finaltest02.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dgit.finaltest02.dto.Department;
import com.dgit.finaltest02.service.CompanyService;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;


public class PartMng extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField tfName;
	private JButton btnOk;
	private JButton btnCancel;
	private JTextField tffloor;
	private JTable table;
	JPopupMenu popupMenu;
	JPanel panel_1;
	JScrollPane scrollPane;
	
	public PartMng(){
		setTitle("부서관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setBounds(0, 1, 302, 136);
		panel.add(pMain);
		pMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		pMain.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("번호");
		pMain.add(lblNo);
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfNo = new JTextField();
		tfNo.setEditable(false);
		int dno = CompanyService.getInstance().getDno();
		tfNo.setText(dno+"");
		tfNo.enable(false);
		pMain.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("부서명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain.add(lblName);
		
		tfName = new JTextField();
		pMain.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblfloor = new JLabel("위치");
		lblfloor.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain.add(lblfloor);
		
		tffloor = new JTextField();
		pMain.add(tffloor);
		tffloor.setColumns(10);
		
		JPanel pBtn = new JPanel();
		pBtn.setBounds(0, 137, 302, 55);
		panel.add(pBtn);
		
		btnOk = new JButton("추가");
		btnOk.setBounds(45, 0, 106, 37);
		btnOk.addActionListener(this);
		pBtn.setLayout(null);
		pBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(163, 0, 106, 37);
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 202, 302, 207);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {
				popupMenu = new JPopupMenu();
				popupMenu.setBounds(0, 0, 80, 50);
				
				JMenuItem item1 = new JMenuItem("수정");
				item1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String no = (String) table.getValueAt(table.getSelectedRow(),0);
						String name = (String) table.getValueAt(table.getSelectedRow(),1);
						String floor = (String) table.getValueAt(table.getSelectedRow(),2);
						tfNo.setText(no);
						tfName.setText(name);
						tffloor.setText(floor);
						btnOk.setText("수정");
						
					}
				});
				popupMenu.add(item1);
				
				JMenuItem item2 = new JMenuItem("삭제");
				item2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String no = (String) table.getValueAt(table.getSelectedRow(),0);
						CompanyService.getInstance().deleteItem(no);
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
						
						DefaultTableModel model = new DefaultTableModel(row(), col());
						table.setModel(model);
						tfNo.setText(CompanyService.getInstance().getDno()+"");
					}
				});
				popupMenu.add(item2);
				table.add(popupMenu);
				
				if(e.getModifiers() == e.BUTTON3_MASK){
					popupMenu.show(table, e.getX(), e.getY());
				}
			}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {}
		});
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setBounds(20, 20, 260, 165);
		table.setModel(new DefaultTableModel(row(), col()));
		scrollPane = new JScrollPane(table);
		scrollPane.setLocation(0, 0);
		scrollPane.setSize(302, 200);
		panel_1.add(scrollPane);


	}

	private String[] col() {
		return new String[] { "번호", "부서명", "위치" };
	}

	private  String[][] row() {
		List<Department> list = CompanyService.getInstance().selectAllPart();
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			String[] ar = list.get(i).toArray();
			rowDatas[i] = ar;
		}
		return rowDatas;
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtncancel(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnAdd(e);
		}
		
	}

	private void actionPerformedBtncancel(ActionEvent e) {
		tffloor.setText("");
		tfName.setText("");
		btnOk.setText("추가");
	}

	private void actionPerformedBtnAdd(ActionEvent e) {
		if (e.getActionCommand() == "추가") {
			Department dObj = getObject();
			CompanyService.getInstance().insertItem(dObj);
			JOptionPane.showMessageDialog(null, "추가되었습니다.");
			tffloor.setText("");
			tfName.setText("");
			
			DefaultTableModel model = new DefaultTableModel(row(), col());
			table.setModel(model);
			
		}else{
			Department dObj = getObject();
			CompanyService.getInstance().updateItem(dObj);
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
			tfNo.setText(CompanyService.getInstance().getDno()+"");
			tffloor.setText("");
			tfName.setText("");
			btnOk.setText("추가");
			
			DefaultTableModel model = new DefaultTableModel(row(), col());
			table.setModel(model);
		
		}
		
	}


	private Department getObject() {
		int dcode = Integer.parseInt(tfNo.getText().trim());
		String dname = tfName.getText().trim();
		int floor = Integer.parseInt(tffloor.getText().trim());
		return new Department(dcode, dname, floor);
	}

}
