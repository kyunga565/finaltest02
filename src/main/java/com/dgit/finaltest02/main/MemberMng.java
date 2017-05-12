package com.dgit.finaltest02.main;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dgit.finaltest02.dto.Department;
import com.dgit.finaltest02.dto.Employee;
import com.dgit.finaltest02.dto.Employee22;
import com.dgit.finaltest02.dto.Title;
import com.dgit.finaltest02.mappers.TitleMapper;
import com.dgit.finaltest02.service.CompanyService;
import javax.swing.SpinnerNumberModel;

public class MemberMng extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfDate;
	private JTable table;
	private JButton btnOK;
	private JButton btnCancel;
	private JComboBox cbTitle;
	JComboBox cbPart;
	private JSpinner spSalary;
//	ButtonGroup bg;
	private JRadioButton rdbtnW,rdbtnM;
	JPopupMenu popupMenu;
	
	public MemberMng() {
		setTitle("사원관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(8, 2, 35, 10));
		
		JLabel lblNo = new JLabel("번호");
		panel_1.add(lblNo);
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfNo = new JTextField();
		int eno = CompanyService.getInstance().getEno();
		tfNo.setText(eno+"");
		tfNo.enable(false);
		panel_1.add(tfNo);
		tfNo.setColumns(2);
		
		JLabel lblName = new JLabel("사원명");
		panel_1.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfName = new JTextField();
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTitle = new JLabel("직책");
		panel_1.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbTitle = new JComboBox<>();
		List<Title> listtitle = CompanyService.getInstance().selectAll();
		for(Title t : listtitle){
			cbTitle.addItem(t.toString());//.getTname()
		}
		
		panel_1.add(cbTitle);
		
		JLabel lblSalary = new JLabel("급여");
		panel_1.add(lblSalary);
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		
		spSalary = new JSpinner();
		spSalary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		panel_1.add(spSalary);
		
		JLabel lblGender = new JLabel("성별");
		panel_1.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Panel panel = new Panel();
		panel_1.add(panel);
		
		rdbtnW = new JRadioButton("여성");
		panel.add(rdbtnW);
		
		rdbtnM = new JRadioButton("남성");
		rdbtnM.setSelected(true);
		panel.add(rdbtnM);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnM);
		bg.add(rdbtnW);
		
		JLabel lblPart = new JLabel("부서");
		panel_1.add(lblPart);
		lblPart.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbPart = new JComboBox<>();
		List<Department> listpart = CompanyService.getInstance().selectAllPart();
		for(Department d : listpart){
			cbPart.addItem(d.toString());//getDname()
		}
		panel_1.add(cbPart);
		
		JLabel lblDate = new JLabel("입사일");
		panel_1.add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfDate = new JTextField();
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sf.format(date);
		tfDate.setText(d);
		panel_1.add(tfDate);
		tfDate.setColumns(10);
		
		btnOK = new JButton("확인");
		btnOK.addActionListener(this);
		panel_1.add(btnOK);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				popupMenu = new JPopupMenu();
				popupMenu.setBounds(0, 0, 80, 50);
				
				JMenuItem item1 = new JMenuItem("수정");
				item1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String no = (String) table.getValueAt(table.getSelectedRow(),0);
						String name = (String) table.getValueAt(table.getSelectedRow(),1);
					//	String salary = (String) table.getValueAt(table.getSelectedRow(), 3);
						System.out.println(table.getSelectedRow());
						String date = (String) table.getValueAt(table.getSelectedRow(), 6);
						tfNo.setText(no);
						tfName.setText(name);
						tfDate.setText(date);
						btnOK.setText("수정");
					
					}
				});
				popupMenu.add(item1);
				
				JMenuItem item2 = new JMenuItem("삭제");
				item2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String no = (String) table.getValueAt(table.getSelectedRow(),0);
						CompanyService.getInstance().deleteEmployee(no);
						
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
						
						DefaultTableModel model = new DefaultTableModel(row(), col());
						table.setModel(model);
						tfNo.setText(CompanyService.getInstance().getEno()+"");	
						tfName.setText("");
						cbPart.setSelectedIndex(0);
						cbTitle.setSelectedIndex(0);
						spSalary.setValue(1500000);
					}
				});
				popupMenu.add(item2);
				table.add(popupMenu);
				
				if(e.getModifiers() == e.BUTTON3_MASK){
					popupMenu.show(table, e.getX(), e.getY());
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setBounds(8, 51, 100, 50);
		table.setModel(new DefaultTableModel(row(), col()));
		panel_2.add(new JScrollPane(table));

		
	}

	private String[] col() {
		return new String[] { "번호", "사원명", "직책", "급여", "성별", "부서","입사일" };
	}

	private String[][] row() {
		List<Employee> list = CompanyService.getInstance().selectEmployee();
		
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			Employee e = list.get(i);
			Title title = CompanyService.getInstance().selectTitle(e.getTcode());
			Department dpart = CompanyService.getInstance().getDcode(e.getDcode());
			
			SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
			String gender = null;
			if(e.getGender() == 1){
				gender = "여자";
			}else{
				gender = "남자";
			}
			System.out.println(rowDatas[0]);
			rowDatas[i] = new String[]{e.getEno()+"", e.getEname() ,title.getTname(),e.getSalary()+"",gender ,dpart.getDname(),df.format(e.getJoindate())+""};
			
		}
		return rowDatas;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtncancel(e);
		}
		if (e.getSource() == btnOK) {
			actionPerformedBtnAdd(e);
		}
		
	}


	private void actionPerformedBtnAdd(ActionEvent e) {
		if(e.getActionCommand() == "확인"){
			Employee dObj;
			dObj = getObject();
			
			if(tfName.getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, "빈칸을 확인하세요.");
				return;
			}else{
				CompanyService.getInstance().insertEmployee(dObj);
				JOptionPane.showMessageDialog(null, "추가되었습니다.");
			}
			

			tfNo.setText(CompanyService.getInstance().getEno()+"");
			tfName.setText("");
			cbPart.setSelectedIndex(0);
			cbTitle.setSelectedIndex(0);
			spSalary.setValue(1500000);
			
			DefaultTableModel model = new DefaultTableModel(row(), col());
			table.setModel(model);
			
		}else{
			Employee dObj;
			dObj = getObject();
			CompanyService.getInstance().updateEmployee(dObj);
			JOptionPane.showMessageDialog(null, "수정되었습니다?.");
			
			tfNo.setText(CompanyService.getInstance().getEno()+"");
			tfName.setText("");
			cbPart.setSelectedIndex(0);
			cbTitle.setSelectedIndex(0);
			spSalary.setValue(1500000);
			
			DefaultTableModel model = new DefaultTableModel(row(), col());
			table.setModel(model);
		}
		
		
	}

	private void actionPerformedBtncancel(ActionEvent e) {
		tfNo.setText(CompanyService.getInstance().getEno()+"");
		tfName.setText("");
		cbPart.setSelectedIndex(0);
		cbTitle.setSelectedIndex(0);
		spSalary.setValue(1500000);
		
	}
	private Employee getObject(){
		int eno = Integer.parseInt(tfNo.getText().trim());
		String ename = tfName.getText().trim();
		String tcode = (String) cbTitle.getSelectedItem();
		System.out.println(tcode);
		
		int tco = 0;
		List<Title> list = CompanyService.getInstance().selectAll();
		for(Title t :list){
			if(tcode.equals(t.getTname())){
				tco = t.getTcode();
			}
		}
		int salary  =  (Integer) spSalary.getValue();

		int gender = 0;
		if(rdbtnM.isSelected()){
			gender = 0;
		}else{
			gender = 1;
		}
		String dcode = (String) cbPart.getSelectedItem();
		dcode = dcode.substring(0,dcode.indexOf("("));
		int dco = 0;
		List<Department> list2 = CompanyService.getInstance().selectAllPart();
		for(Department d:list2){
			if(dcode.equals(d.getDname())){
				dco = d.getDcode();
			}
		}

		System.out.println(dcode);

		String[] date = tfDate.getText().split("-");
		int y = Integer.parseInt(date[0]);
		int m = Integer.parseInt(date[1]);
		int d = Integer.parseInt(date[2]);
		GregorianCalendar g = new GregorianCalendar(y, m-1, d);
		Date joindate = g.getTime();
		
		System.out.println(eno+"/"+ename+"/"+tco+"/"+salary+"/"+gender+"/"+dco+"/"+joindate);
		return new Employee(eno, ename, tco, salary, gender, dco, joindate);
		
	}

}
