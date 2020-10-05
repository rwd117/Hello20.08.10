package bankproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class frmDepositStatement extends JInternalFrame implements ActionListener, WindowListener
{
   //=============  �뜲�씠�꽣踰좎씠�뒪 愿��젴 蹂��닔�뱾 ===============//
    static Connection conn = null;
    static String strQuery = null;
    static String strTableQuery = null;
    static ResultSet rs = null;
    static Statement stmt = null;
	static PreparedStatement pstmt = null;
    final int iColCount = 3;

    //=============  ToolBar�뿉 �궗�슜�릺�뒗 愿��젴 蹂��닔�뱾 ===============//
    static JToolBar xToolBar = null;
    static JButton btnSearchItem, btnPrintItem, btnCloseWindow;
    JScrollPane scrollpane;

    //=============  �솕硫� �븯�떒�쓽 status bar ===============//
    JLabel lbStatusMessage = null;
    boolean bIsFirst = true;

    // �뜲�씠�꽣踰좎씠�뒪�� �뿰怨꾪븯�뿬 �궗�슜�맆 蹂��닔�뱾 
    String strAno, strCno;
    int iSerialno = 0, iInout = 1;

    //=============  User Interface ===============//            
    static JLabel label1 = new JLabel("怨좉컼踰덊샇");
    static JLabel label2 = new JLabel("怨꾩쥖踰덊샇");
    static JLabel label3 = new JLabel("�옍�븸");
    
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();

    JComboBox  jcb1 = new JComboBox();

    JTable jtAccountList = null;
    Object columnName[] = {"�씪�젴踰덊샇", "嫄곕옒湲덉븸", "嫄곕옒�씪"};
    Object dataTable[][] = null;
    
    frmDepositStatement(String title, Connection conn, JLabel lbMessage) {
        // JInternalFrame�쓽 �깮�꽦�옄 �샇異�
        /* 留ㅺ컻蹂��닔�쓽 媛믪뿉 �뵲�씪 李쎌쓽 �꽦吏� 蹂�寃� */
        super(title, false, true, true, true);

        // AppFrame�겢�옒�뒪�뿉�꽌 database Connection�쓣 諛쏆븘�꽌 �겢�옒�뒪�쓽 connection�뿉
        this.conn = conn;
        this.lbStatusMessage = lbMessage;

        // �솕硫� �븯�떒�뿉 '�삁湲덇굅�옒 �궡�뿭議고쉶' display                
        lbStatusMessage.setText("�삁湲덇굅�옒 �궡�뿭 議고쉶");

        getContentPane().setLayout(new BorderLayout());
		
        // Toolbar 珥덇린�솕       
        initToolBar();

        // User Interface 珥덇린�솕
        initContent();
    }

    /* User Interface 珥덇린�솕       */    
    private void initContent() {
        JPanel center = new JPanel();
		center.setLayout(null);
 
		label1.setBounds(10, 30, 100, 20);
		label2.setBounds(10, 60, 100, 20);
		label3.setBounds(10, 90, 100, 20);

        tf1.setBounds(120, 30, 150, 20);
        jcb1.setBounds(120, 60, 150, 20);
        tf2.setBounds(120, 90, 100, 20);
       
        center.add(label1);
        center.add(label2);
        center.add(label3);


		tf1.addActionListener(this);        
        jcb1.addActionListener(this);
     
		center.add(tf1);
		center.add(tf2);
        center.add(jcb1);

        getContentPane().add("Center", center); 
    }

    /* �뜲�씠�꽣踰좎씠�뒪瑜� Navigate�븷�닔 �엳�룄濡� �븵/�뮘,泥섏쓬,�걹�쑝濡� �씠�룞, 
       異붽�,�궘�젣,���옣�벑�쓽 �댋諛� */
    private void initToolBar() {
        xToolBar = new JToolBar(JToolBar.HORIZONTAL);
        xToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
        
        btnSearchItem      = new JButton(new ImageIcon("./toolbar/search.gif"));
        btnPrintItem      = new JButton(new ImageIcon("./toolbar/print.gif"));
        btnCloseWindow   = new JButton(new ImageIcon("./toolbar/exit.gif"));

        btnPrintItem.setEnabled(false);

        xToolBar.add(btnSearchItem);
        xToolBar.add(btnPrintItem);        
        xToolBar.add(Box.createHorizontalGlue());
        xToolBar.add(btnCloseWindow);

        btnSearchItem.addActionListener(this);        
        btnPrintItem.addActionListener(this);
        btnCloseWindow.addActionListener(this);

        getContentPane().add("North", xToolBar); // �댋諛� 遺숈씠湲�
    }        

    /* �댋諛붿쓽 踰꾪듉�뱾�쓽 clicked �씠踰ㅽ듃�뿉 �뵲�씪 �샇異쒕맆 �븿�닔�젙�쓽  */	
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == btnCloseWindow) {
            subCloseWindow();
        } else if(evt.getSource() == btnSearchItem) {
          dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
        } else if(evt.getSource() == btnPrintItem) {
            subPrintItem();
        } else if(evt.getSource() == tf1) {
            subQueryAccountNo();
        }
    }

    /* �솕硫� resize : datatable�씠 �옱�깮�꽦�릺�뼱�룄 �솕硫댁씠 refresh�릺�뼱�빞
      �젙�솗�븳 紐⑥뒿�씠 �굹���궃�떎. 
      �젙留� 臾섑븳 �쁽�긽�씠�떎. swing�뿉�꽌留� 洹몃윴吏� 紐⑤Ⅴ寃좊떎.
    */
    private void resize() {
        Dimension fsize = this.getSize();
        this.setSize(fsize.width - 1, fsize.height - 1);

        fsize = this.getSize();
        this.setSize(fsize.width + 1, fsize.height + 1);        
    }

    /* �궗�슜�옄�뿉寃� �븣�젮�빞 �븷 硫붿떆吏� 泥섎━  
       overload�쑝濡� 留ㅺ컻蹂��닔�뿉 �뵲�씪 �떎瑜멸린�뒫�쓣 援ы쁽 */
    public void msgBox(String strMsg) {
        lbStatusMessage.setText(strMsg);
    }

    public void msgBox(String strMsg, String title) {
        JOptionPane.showMessageDialog(this, strMsg, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public void msgBox(SQLException se) {
    	lbStatusMessage.setText(se.toString());
    }

    public void msgBox(SQLException se, String title) {
        lbStatusMessage.setText(title + " : " + se.toString());
    }

    // �솕硫댁뿉 �엳�뒗 User Interface�뱾以묒뿉 textField�뱾�쓽 �궡�슜�쓣 吏��슫�떎.
    public void clearItems() {
        tf1.setText("");
        tf2.setText("0");
        jcb1.setSelectedIndex(0);
    }
	
    // �엯�젰諛쏆� 怨좉컼踰덊샇�� 怨꾩쥖踰덊샇瑜� �씠�슜�븯�뿬 嫄곕옒�궡�뿭 議고쉶
    public void subSearchItem() {
        dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
    }

	
    // �엯�젰諛쏆� 怨좉컼踰덊샇瑜� �씠�슜�븯�뿬 �냼�쑀�븯怨좎엳�뒗 怨꾩쥖踰덊샇 議고쉶
	public void subQueryAccountNo() {
		String strTemp = null;
		String strCustno = tf1.getText().trim();
        strQuery =  "select A_NO, MAX(A_SERIAL_NO) from account where a_c_no =  '" + strCustno + "' group by A_NO";
    
        //msgBox(strQuery);
        
        // �씠�쟾�뿉 �엳�뜕 怨꾩쥖踰덊샇�뱾�쓣 clear
        jcb1.removeAllItems();    

        try {
            stmt = conn.createStatement();
        	rs = stmt.executeQuery(strQuery);

            // �삁湲덇퀎醫뚮쾲�샇�뱾�쓣 肄ㅻ낫諛뺤뒪�뿉 additem			        	
            while(rs.next()) {
                strTemp = rs.getString(1).trim();
                jcb1.addItem(strTemp);
	    }
    	    rs.close();
            stmt.close();
        } catch (SQLException se) {
            msgBox(se);
        }
    }

    /* 怨좉컼踰덊샇 �엯�젰 -> 議고쉶踰꾪듉 -> 怨꾩쥖踰덊샇 �꽑�깮 �썑�뿉
      JTable濡� datatable�쓣 �깮�꽦�븯�뿬 �솕硫� �븯�떒�뿉 display 
    */
    public void dataTable(String strAccountno, String strCustno) {
        // 李쎌쓣 �쓣�슫�썑 泥섏쓬 datatable�씪 �깮�꽦�맆�븣�뿉�뒗 content panel�뿉�꽌
        // �젣嫄고븷 �븘�슂媛� �뾾�떎.
        if (!bIsFirst) {
            getContentPane().remove(scrollpane);
        }
            
        int lRowCount = 0, i = 0;

        // �빐�떦怨좉컼踰덊샇, �빐�떦 怨꾩쥖踰덊샇瑜� 留뚯”�븯�뒗 嫄곕옒 �궡�뿭�쓣 select		
        strQuery = "select a_serial_no, to_char(a_amount, '9,999,999,999'), to_char(a_date, 'yyyy-mm-dd') from account where a_no = '" + strAccountno + "' and a_c_no = '" + strCustno +"'";
	dataTable = null;        

        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(strQuery);
            
            rs.last();
            lRowCount = rs.getRow() + 1;

            // Object諛곗뿴 �꽑�뼵            
            dataTable = new Object[lRowCount][iColCount];

            rs.beforeFirst();
            while(rs.next()) {
                for(int j = 0; j < iColCount; j++) {
                    // Object 諛곗뿴�뿉 �뜲�씠�꽣 ���옣.
                    dataTable[i][j] = rs.getObject(j+1);
                }
                i++;
            }
			rs.last();

            // 留� 留덉�留됱쓽 serial踰덊샇瑜� 媛��졇�삩�떎. 
            // �빐�떦 怨꾩쥖�쓽 �떎�쓬 嫄곕옒 serial踰덊샇瑜� �깮�꽦�븯湲� �쐞�빐
            iSerialno = rs.getInt(1);

            // JTable �깮�꽦�븳�떎.            
            jtAccountList = new JTable(dataTable, columnName);

            // scroll bar瑜� �깮�꽦            
            scrollpane = new JScrollPane(jtAccountList);
            scrollpane.setPreferredSize(new Dimension(0, 200));        
            getContentPane().add("South", scrollpane); 

            rs.close();
            stmt.close();

            // 怨꾩쥖 �옍�븸 select
            strQuery = "select to_char(sum(nvl(a_amount,0)), '9,999,999,999') from account where a_no = ? and a_c_no = ? ";
            
            pstmt = conn.prepareStatement(strQuery);
            pstmt.setString(1, strAccountno);
            pstmt.setString(2, strCustno);
            rs = pstmt.executeQuery();
            
            rs.next();

            // �솕硫댁뿉 setting
            tf2.setText((String)rs.getString(1));

            bIsFirst = false;

            // �솕硫� refresh : �렪踰�
            resize();       

        } catch (SQLException se) {
            msgBox(se);
            se.printStackTrace();
        }
    }

    // �씤�뇙踰꾪듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━    
    public void subPrintItem() 
    {
        // �씤�뇙紐⑤뱢 援ъ꽦
    }

    // �떕湲곕쾭�듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━
    public void subCloseWindow() {
        try {
            if (pstmt != null) pstmt.close();
            if (stmt != null) stmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        setVisible(false);
        dispose();
    }

    //  WindowListener瑜� implements �뻽�쓣 寃쎌슦 紐⑤뱺 Method瑜� overriding�빐�빞 �븳�떎.
    public void windowOpened(WindowEvent evt) {}
  	public void windowClosed(WindowEvent evt) {}

    public void windowClosing(WindowEvent evt) {
		subCloseWindow();
	}        

    public void windowIconified(WindowEvent evt) {}
  	public void windowDeiconified(WindowEvent evt) {}
  	public void windowActivated(WindowEvent evt) {}
  	public void windowDeactivated(WindowEvent evt) {}
}