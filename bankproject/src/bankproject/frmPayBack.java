package bankproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class frmPayBack extends JInternalFrame implements ActionListener, WindowListener
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
    static JButton btnSaveItem, btnSearchItem, btnPrintItem, btnCloseWindow;
    JScrollPane scrollpane;

    //=============  �솕硫� �븯�떒�쓽 status bar ===============//    
    JLabel lbStatusMessage = null;
    boolean bIsFirst = true;

    // �뜲�씠�꽣踰좎씠�뒪�� �뿰怨꾪븯�뿬 �궗�슜�맆 蹂��닔�뱾 
    /* class 蹂��닔 �꽑�뼵
        strLno : ��異쒕쾲�샇, 
        strCno : ��異� 怨좉컼肄붾뱶,
        dLamount : ��異쒖긽�솚湲덉븸,
        iSerialno : ��異쒖긽�솚 �씪�젴踰덊샇
    */
    
    String strLno, strCno;
    int iSerialno = 0;
    long lLamount;

    //=============  User Interface ===============//    
    static JLabel label1 = new JLabel("怨좉컼踰덊샇");
    static JLabel label2 = new JLabel("��異쒕쾲�샇");
    static JLabel label3 = new JLabel("�긽�솚湲덉븸");
    static JLabel label4 = new JLabel("�긽�솚�옍�븸");
    static JLabel label5 = new JLabel("��異쒖긽�솚�씪");
    
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField("0");
    JTextField tf3 = new JTextField("0");
    
    JComboBox  jcb1 = new JComboBox();

	/* 怨좉컼嫄곕옒 �옄猷뚮�� �굹���궪 JTable怨� �뿤�뜑 & �뜲�씠�꽣 諛곗뿴*/
    JTable jtAccountList = null;
    Object columnName[] = {"�씪�젴踰덊샇", "�긽�솚湲덉븸", "�긽�솚�씪"};
    Object dataTable[][] = null;
    
    frmPayBack(String title, Connection conn, JLabel lbMessage) {
        // JInternalFrame�쓽 �깮�꽦�옄 �샇異�
        /* 留ㅺ컻蹂��닔�쓽 媛믪뿉 �뵲�씪 李쎌쓽 �꽦吏� 蹂�寃� */
        super(title, false, true, true, true);

        // AppFrame�겢�옒�뒪�뿉�꽌 database Connection�쓣 諛쏆븘�꽌 �겢�옒�뒪�쓽 connection�뿉
        this.conn = conn;
        this.lbStatusMessage = lbMessage;

        // �솕硫� �븯�떒�뿉 '��異쒖긽�솚 嫄곕옒' display
        lbStatusMessage.setText("��異쒖긽�솚 嫄곕옒");

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
        label4.setBounds(10,120, 80, 20);

        tf1.setBounds(120, 30, 150, 20);
        jcb1.setBounds(120, 60, 150, 20);
        tf2.setBounds(120, 90, 100, 20);
        tf3.setBounds(120, 120, 100, 20);

        tf3.setEnabled(false);
                       
        center.add(label1);
        center.add(label2);
        center.add(label3);
        center.add(label4);
        
        tf1.addActionListener(this);        
        jcb1.addActionListener(this);
     
	center.add(tf1);
	center.add(tf2);
        center.add(tf3);        
        center.add(jcb1);

        getContentPane().add("Center", center); 
    }

    /* �뜲�씠�꽣踰좎씠�뒪瑜� Navigate�븷�닔 �엳�룄濡� �븵/�뮘,泥섏쓬,�걹�쑝濡� �씠�룞, 
        異붽�,�궘�젣,���옣�벑�쓽 �댋諛� */   
    private void initToolBar() {
        xToolBar = new JToolBar(JToolBar.HORIZONTAL);
        xToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
        
        btnSaveItem      = new JButton(new ImageIcon("./toolbar/save.gif"));
        btnSearchItem      = new JButton(new ImageIcon("./toolbar/search.gif"));
        btnPrintItem      = new JButton(new ImageIcon("./toolbar/print.gif"));
        btnCloseWindow   = new JButton(new ImageIcon("./toolbar/exit.gif"));

		btnSaveItem.setEnabled(false);
        btnPrintItem.setEnabled(false);

        xToolBar.add(btnSaveItem);
        xToolBar.add(btnSearchItem);        
        xToolBar.add(btnPrintItem);
        xToolBar.add(Box.createHorizontalGlue());
        xToolBar.add(btnCloseWindow);

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
        } else if(evt.getSource() == btnCloseWindow) {
            subCloseWindow();
        } else if(evt.getSource() == btnSearchItem) {
            subSearchItem();
        } else if(evt.getSource() == btnPrintItem) {
            subPrintItem();
        } else if(evt.getSource() == tf1) {
            subQueryLoanNo();
        } else if(evt.getSource() == jcb1) {
        // ��異쒕쾲�샇 �꽑�깮 肄ㅻ낫 諛뺤뒪
//            dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
//            subSearchItem();
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
        tf3.setText("0");
        jcb1.setSelectedIndex(0);
    }

    /* �솕硫댁쓽 textField�뱾�쓽 �궡�슜�쓣 �겢�옒�뒪 蹂��닔�뿉  */
    public boolean getItems() {
        strCno = tf1.getText().trim();                 // 怨좉컼踰덊샇踰덊샇
        strLno = (String)jcb1.getSelectedItem();       // 怨꾩쥖踰덊샇
        lLamount = Long.parseLong(tf2.getText().trim()); //�긽�솚湲덉븸

        // �엯�젰 textField�쓽 媛믪씠 �늻�씫�릺�뿀�뒗 �솗�씤
        if(lLamount <= 0) { 
            msgBox("�긽�솚�븸�쓣 �젙�솗�엳 �엯�젰�빐二쇱꽭�슂",""); 
            return false; 
        }

        // UserInterface濡쒕��꽣 �겢�옒�뒪蹂��닔濡� 媛��졇�삩 媛믪쓣 statusbar�뿉 display
        lbStatusMessage.setText("[怨좉컼踰덊샇 : " + strCno + "] [怨꾩쥖 : " + strLno + "] [�긽�솚�븸 : " + lLamount + "]");
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
                // �넻�옣�뿉�꽌 �늻�쟻 b_serial_no�쓽 留� 留덉�留� 媛� + 1 �쓣 媛��졇�삩�떎.                
                //strQuery = "select max(b_serial_no)+1 from borrow where b_cust_no = ? and b_loan_no = ?";
                strQuery = "select a_open_date, a_term, a_item_dist, a_item_name, a_b_no, max(a_serial_no)+1, sum(nvl(a_amount,0)) ";
                strQuery += " from account where a_c_no = ? and a_no = ? ";
                strQuery += " group by a_open_date, a_term, a_item_dist, a_item_name, a_b_no ";                
                pstmt = conn.prepareStatement(strQuery);
                pstmt.setString(1, strCno);
                pstmt.setString(2, strLno);
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
                //lTemp = Long.parseLong(tf3.getText().trim());

                // �긽�솚 �옍�븸 : ltemp
                lTemp = Long.parseLong(tf3.getText().trim());

                if(lLamount > lTemp) {
                    msgBox("�긽�솚�옍�븸�쓣 珥덇낵 �빀�땲�떎. �쁽�옱 �긽�솚�옍�븸�� : " + lTemp + "�엯�땲�떎", "");
                    return;
                }
                rs.close();
                pstmt.close();

                // borrow�뀒�씠釉붿뿉 ��異쒖긽�솚 �궡�뿭�쓣 湲곕줉
                strQuery = "INSERT INTO account select ?, ?, sysdate, ?, a.a_open_date, a.a_total_amount, a.a_term, a.a_item_dist, a.a_item_name, a.a_b_no, ? from account a where a.a_no = '" + strLno + "' and a.a_c_no = '" + strCno + "' and a_serial_no = 1 ";
	        pstmt = conn.prepareStatement(strQuery);
                pstmt.setString(1, strLno);
                pstmt.setLong(2, iSerialno);
                pstmt.setLong(3, lLamount);
                pstmt.setString(4, strCno);   
                
                pstmt.executeUpdate();             

                lbStatusMessage.setText("insert completed!!");
                conn.commit();  // db�뿉 commit;
                pstmt.close();
                clearItems();   // ���옣�븳�썑 �솕硫큓lear
                dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
	    } catch (SQLException se) {
	        msgBox(se, "Database Insert Into error");
                se.printStackTrace();
	    } //end try~catch
        }
	}

    // search踰꾪듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━
    public void subSearchItem() {
        dataTable((String)jcb1.getSelectedItem(), tf1.getText().trim());
    }

    /* 怨좉컼踰덊샇瑜� �엯�젰�븳�썑 寃��깋踰꾪듉�쓣 �닃���쓣寃쎌슦 
       �빐�떦 怨좉컼踰덊샇瑜� ��異쒓굅�옒 �뀒�씠釉붿뿉�꽌 
       ��異쒓퀎醫뚮쾲�샇留� select�븯�뿬 �솕硫� ��異쒓퀎醫뚮쾲�샇 肄ㅻ낫諛뺤뒪�뿉 additem
    */
    public void subQueryLoanNo() {
		String strTemp = null;
		String strCustno = tf1.getText().trim();
        strQuery =  "select A_NO, MAX(A_SERIAL_NO) from account where a_c_no =  '" + strCustno + "' and a_item_dist = 'L1' group by A_NO";
        
        // �씠�쟾�뿉 �엳�뜕 怨꾩쥖踰덊샇�뱾�쓣 clear
        jcb1.removeAllItems();    

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(strQuery);

            // ��異쒓퀎醫뚮쾲�샇�뱾�쓣 肄ㅻ낫諛뺤뒪�뿉 additem          
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

    /* 怨좉컼踰덊샇 �엯�젰 -> 議고쉶踰꾪듉 -> ��異쒓퀎醫뚮쾲�샇 �꽑�깮 �썑�뿉
      JTable濡� datatable�쓣 �깮�꽦�븯�뿬 �솕硫� �븯�떒�뿉 display 
    */
    public void dataTable(String strLoanno, String strCustno) {
        // save(���옣)踰꾪듉�쓣 �솢�꽦�솕 �떆�궓�떎.
        btnSaveItem.setEnabled(true);

        // 泥섏쓬�뿉 �솕硫� �떎�뻾�뻽�쓣�븣�뒗 bIsFirst 媛믪씠 true, 
        // �떎�쓬 �닔�뻾�떆遺��꽣�뒗 bIsFirst 媛믪씠 false
        // 媛믪쓣 媛뽯뒗�떎. �뵲�씪�꽌 �몢踰덉㎏ �닔�뻾�맆�븣遺��꽣�뒗 怨꾩냽�닔�뻾�맂�떎.
        if (!bIsFirst) {
            getContentPane().remove(scrollpane);
        }
            
        int lRowCount = 0, i = 0;
		
        // ��異쒓툑 �긽�솚 �궡�뿭�쓣 由ъ뒪�듃
        strQuery = "select a_serial_no, nvl(a_amount,0), a_date from account where a_no = '" + strLoanno + "' and a_c_no = '" + strCustno +"'";

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
			
            long lSumRepAmount, lLoanAmount, lRemainAmount;

            // �긽�솚 珥앹븸 援ы븯湲�.
            strQuery = "select sum(nvl(a_amount,0)) from account where a_no = ? and a_c_no = ? ";
            pstmt = conn.prepareStatement(strQuery);
            pstmt.setString(1, strLoanno);
            pstmt.setString(2, strCustno);            
            rs = pstmt.executeQuery();
            rs.next();
            lSumRepAmount = rs.getLong(1);

            rs.close();
            pstmt.close();

            // ��異쒓툑�븸 議고쉶
            strQuery = "select a_total_amount from account where a_no = ? and a_amount is null and rownum = 1 ";
            pstmt = conn.prepareStatement(strQuery);
            pstmt.setString(1, strLoanno);
            rs = pstmt.executeQuery();
            rs.next();
            lLoanAmount = rs.getLong(1);
            
            lRemainAmount = lLoanAmount - lSumRepAmount;

            // �긽�솚 �셿猷� �맂 寃쎌슦
            if (lRemainAmount == 0) {
                btnSaveItem.setEnabled(false);
            }
			
            // �긽�솚�빐�빞�븷 �옍�븸�씠 �궓�븘 �엳�뒗 寃쎌슦
            if (lRemainAmount > 0) {
                tf3.setText("" + lRemainAmount);
                btnSaveItem.setEnabled(true);
            }

            rs.close();
            pstmt.close();                
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