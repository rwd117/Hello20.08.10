package bankproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class frmInOut extends JInternalFrame implements ActionListener, WindowListener
{
   //=============  �뜲�씠�꽣踰좎씠�뒪 愿��젴 蹂��닔�뱾 ===============//
    static Connection conn = null;
    static String strQuery = null;
    static ResultSet rs = null;
    static Statement stmt = null;
	static PreparedStatement pstmt = null;
    final int iColCount = 3;

    //=============  ToolBar�뿉 �궗�슜�릺�뒗 愿��젴 蹂��닔�뱾 ===============//
    static JToolBar xToolBar = null;
    static JButton btnInsertItem, btnSaveItem, btnSearchItem, btnPrintItem, btnCloseWindow;
    JScrollPane scrollpane;

    //=============  �솕硫� �븯�떒�쓽 status bar ===============//
    JLabel lbStatusMessage = null;

    boolean bIsFirst = true;

    // �뜲�씠�꽣踰좎씠�뒪�� �뿰怨꾪븯�뿬 �궗�슜�맆 蹂��닔�뱾 
    String strAno, strCno;
    int iSerialno = 0, iInout = 1;
    long lAmount;

    //=============  User Interface ===============//
    static JLabel label1 = new JLabel("怨좉컼踰덊샇");
    static JLabel label2 = new JLabel("怨꾩쥖踰덊샇");
    static JLabel label3 = new JLabel("�엯/異쒓툑");
    static JLabel label4 = new JLabel("湲덉븸");
    static String customer_dist[] = { "�엯湲�", "異쒓툑" };
    
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();

    JComboBox  jcb1 = new JComboBox();
    JComboBox  jcb2 = new JComboBox();
    JTable jtAccountList = null;

    Object columnName[] = {"�씪�젴踰덊샇", "嫄곕옒湲덉븸", "嫄곕옒�씪"};
    Object dataTable[][] = null;
    
    frmInOut(String title, Connection conn, JLabel lbMessage) {
        // JInternalFrame�쓽 �깮�꽦�옄 �샇異�
        /* 留ㅺ컻蹂��닔�쓽 媛믪뿉 �뵲�씪 李쎌쓽 �꽦吏� 蹂�寃� */
        super(title, false, true, true, true);

        // AppFrame�겢�옒�뒪�뿉�꽌 database Connection�쓣 諛쏆븘�꽌 �겢�옒�뒪�쓽 connection�뿉
        this.conn = conn;
        this.lbStatusMessage = lbMessage;

        // �솕硫� �븯�떒�뿉 '�삁湲덇굅�옒�떊泥�' display
        lbStatusMessage.setText("�삁湲덇굅�옒 �떊泥�");

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
	label4.setBounds(10, 120, 100, 20);

        tf1.setBounds(120, 30, 150, 20);
        jcb1.setBounds(120, 60, 150, 20);
        jcb2.setBounds(120, 90, 150, 20);
        tf2.setBounds(120, 120, 100, 20);
       
        center.add(label1);
        center.add(label2);
        center.add(label3);
        center.add(label4);

        for(int i=0; i<customer_dist.length; i++) {
            jcb2.addItem(customer_dist[i]);
        }

	tf1.addActionListener(this);        
        jcb1.addActionListener(this);
     
	center.add(tf1);
	center.add(tf2);
        center.add(jcb1);
	center.add(jcb2);

        getContentPane().add("Center", center); 
    }

    /* �뜲�씠�꽣踰좎씠�뒪瑜� Navigate�븷�닔 �엳�룄濡� �븵/�뮘,泥섏쓬,�걹�쑝濡� �씠�룞, 
       異붽�,�궘�젣,���옣�벑�쓽 �댋諛� */
    private void initToolBar() {
        xToolBar = new JToolBar(JToolBar.HORIZONTAL);
        xToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
        
        btnInsertItem    = new JButton(new ImageIcon("./toolbar/insert.gif"));
        btnSaveItem      = new JButton(new ImageIcon("./toolbar/save.gif"));
        btnSearchItem    = new JButton(new ImageIcon("./toolbar/search.gif"));
        btnPrintItem     = new JButton(new ImageIcon("./toolbar/print.gif"));
        btnCloseWindow   = new JButton(new ImageIcon("./toolbar/exit.gif"));

        // Print踰꾪듉 disable
        btnPrintItem.setEnabled(false);

        xToolBar.add(btnInsertItem);
        xToolBar.add(btnSaveItem);
        xToolBar.add(btnSearchItem);        
        xToolBar.add(btnPrintItem);        
        xToolBar.add(Box.createHorizontalGlue());
        xToolBar.add(btnCloseWindow);

        btnInsertItem.addActionListener(this);
        btnSaveItem.addActionListener(this);
        btnSearchItem.addActionListener(this);        
        btnPrintItem.addActionListener(this);
        btnCloseWindow.addActionListener(this);

        getContentPane().add("North", xToolBar); // �댋諛� 遺숈씠湲�
    }        

    /* �댋諛붿쓽 踰꾪듉�뱾�쓽 clicked �씠踰ㅽ듃�뿉 �뵲�씪 �샇異쒕맆 �븿�닔�젙�쓽  */	
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == btnSaveItem) {
      		subSaveItem();
        } else if(evt.getSource() == btnInsertItem) {
            subInsertItem();
        } else if(evt.getSource() == btnCloseWindow) {
            subCloseWindow();
        } else if(evt.getSource() == btnPrintItem) {
            subPrintItem();
        } else if(evt.getSource() == btnSearchItem) {
            // 寃��깋踰꾪듉�씠 �닃由щ㈃... datatable�쓣 �떎�떆 肉뚮젮以��떎.
            dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
			//subSearchItem();
        } else if(evt.getSource() == tf1) {
            subQueryAccountNo();
        } else if(evt.getSource() == jcb1) {
            // 寃��깋�븳 怨좉컼�씠 �냼�슂�븯怨� �엳�뒗 怨꾩쥖媛� �뿬�윭媛쒖씪寃쎌슦 �빐�떦 怨꾩쥖�쓽 �엯異쒓툑�궡�뿭�쓣 datatable�뿉 display        
            // 	msgBox(evt.getActionCommand(), "");
            //dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
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
        tf2.setText("0");
        jcb1.setSelectedIndex(0);
        jcb2.setSelectedIndex(0);
    }

    /* �솕硫댁쓽 textField�뱾�쓽 �궡�슜�쓣 �겢�옒�뒪 蹂��닔�뿉  */
    public boolean getItems() {
        strCno = tf1.getText().trim();                 // 怨좉컼踰덊샇踰덊샇
        strAno = (String)jcb1.getSelectedItem();       // 怨꾩쥖踰덊샇
        lAmount = Long.parseLong(tf2.getText().trim());

        // �엯�젰 textField�쓽 媛믪씠 �늻�씫�릺�뿀�뒗 �솗�씤
        if(lAmount <= 0) { 
            msgBox("�엯/異쒓툑�븸�쓣 �젙�솗�엳 �엯�젰�빐二쇱꽭�슂"); 
            return false; 
        }
        
        // �엯湲덉씤吏� 異쒓툑�씤吏�.. �엯湲덉씪寃쎌슦 +, 異쒓툑�씪寃쎌슦 -媛믪쓣 怨깊븳�떎.        
        if(jcb2.getSelectedIndex() == 0)
            lAmount = lAmount * 1;
        else if(jcb2.getSelectedIndex() == 1)
            lAmount = lAmount * -1;

        // UserInterface濡쒕��꽣 �겢�옒�뒪蹂��닔濡� 媛��졇�삩 媛믪쓣 statusbar�뿉 display
        lbStatusMessage.setText("[怨좉컼踰덊샇 : " + strCno + "] [怨꾩쥖 : " + strAno + "] [湲덉븸 : " + lAmount + "]");
        return true;
    }

    // �겢�옒�뒪 蹂��닔�뿉 �뱾�뼱 �엳�뒗 �궡�슜�뱾 database�뿉 諛섏쁺   
    public void subSaveItem() {
	if(getItems()) {
            long lTemp = 0;
            String openDate = "";
            long a_term = 0;
            String a_item_dist = "";
            String a_item_name = "";
            String a_b_no = "";
	    try {
                // �넻�옣�뿉�꽌 �늻�쟻 d_serial_no�쓽 留� 留덉�留� 媛� + 1 �쓣 媛��졇�삩�떎.                
                strQuery = "select a_open_date, a_term, a_item_dist, a_item_name, a_b_no, max(a_serial_no)+1, sum(nvl(a_amount,0)) ";
                strQuery += " from account where a_c_no = ? and a_no = ? ";
                strQuery += " group by a_open_date, a_term, a_item_dist, a_item_name, a_b_no ";
                pstmt = conn.prepareStatement(strQuery);
                pstmt.setString(1, strCno);
                pstmt.setString(2, strAno);
                rs = pstmt.executeQuery();

                /* Result Set�쓽 諛섑솚 �뻾�닔媛� 1媛� 諛뽰뿉 �뾾�떎.  
                   why? max(d_serial_no) �뵲�씪�꽌 while臾몄옣�씠 �븘�슂�뾾�떎. */
                rs.next(); 

                openDate = rs.getString(1);
                a_term = rs.getLong(2);
                a_item_dist = rs.getString(3);
                a_item_name = rs.getString(4);
                a_b_no = rs.getString(5);
                iSerialno = rs.getInt(6);
                lTemp = rs.getLong(7);
                
                if( jcb2.getSelectedIndex() == 1) {
                    if(lAmount * -1 > lTemp) {
    	                msgBox("�옍�븸�씠 遺�議깊빀�땲�떎. �쁽�옱 �옍�븸�� : " + lTemp, "");
        	            return;
            	    }
                }
                rs.close();
                pstmt.close();

                // deposit�뀒�씠釉붿뿉 �엯/異쒓툑 �궡�뿭�쓣 湲곕줉
                strQuery = "INSERT INTO account select ?, ?, sysdate, ?, a.a_open_date, null, a.a_term, a.a_item_dist, a.a_item_name, a.a_b_no, ? from account a where a.a_no = '" + strAno + "' and a.a_c_no = '" + strCno + "' and a_serial_no = 1 ";
	        pstmt = conn.prepareStatement(strQuery);
                pstmt.setString(1, strAno);
                pstmt.setLong(2, iSerialno);
                pstmt.setLong(3, lAmount);
                pstmt.setString(4, strCno);                

                /* executeUpdate()�쓽 由ы꽩媛믪� insert臾몄옣�뿉 �쓽�빐 �닔�뻾�맂 row�쓽 �닔瑜� 由ы꽩�븿 
                   �뵲�씪�꽌 �엯�젰�븳 row媛� �븳媛� �씠誘�濡� 1�씤媛�瑜� 泥댄겕�븯�뿬 �삤瑜섏쿂由� */
	        pstmt.executeUpdate();

	        lbStatusMessage.setText("insert completed!!");
                conn.commit();  // db�뿉 commit;
                pstmt.close();
                clearItems();   // ���옣�븳�썑 �솕硫큓lear
                
                subSearchItem();
	    } catch (SQLException se) {
	        msgBox(se, "Database Insert Into error");
                se.printStackTrace();
	    } //end try~catch
        }
    }

    // Insert踰꾪듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━
    public void subInsertItem() {
	clearItems();
    }

    // search踰꾪듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━
    public void subSearchItem() {
        dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
    }

    /* 怨좉컼踰덊샇瑜� �엯�젰�븳�썑 寃��깋踰꾪듉�쓣 �닃���쓣寃쎌슦 
       �빐�떦 怨좉컼踰덊샇瑜� �삁湲덇굅�옒 �뀒�씠釉붿뿉�꽌 
       �삁湲덇퀎醫뚮쾲�샇留� select�븯�뿬 �솕硫� 怨꾩쥖踰덊샇 肄ㅻ낫諛뺤뒪�뿉 additem
    */
    public void subQueryAccountNo() {
	String strTemp = null;
	String strCustno = tf1.getText().trim();
        strQuery =  "select A_NO, MAX(A_SERIAL_NO) from account where a_c_no =  '" + strCustno + "' and a_item_dist = 'A0' group by A_NO";

        msgBox(strQuery);
        
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
        strQuery = "select a_serial_no, nvl(a_amount,0), a_date from account where a_no = '" + strAccountno + "' and a_c_no = '" + strCustno +"'";
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
            //iSerialno = rs.getInt(1);
            
            // JTable �깮�꽦�븳�떎.
            jtAccountList = new JTable(dataTable, columnName);
	
            // scroll bar瑜� �깮�꽦
            scrollpane = new JScrollPane(jtAccountList);
            scrollpane.setPreferredSize(new Dimension(0, 200));        
            getContentPane().add("South", scrollpane); 

            rs.close();
            stmt.close();
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