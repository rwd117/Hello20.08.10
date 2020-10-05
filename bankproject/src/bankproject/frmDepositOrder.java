package bankproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class frmDepositOrder extends JInternalFrame implements ActionListener, WindowListener
{
   //=============  �뜲�씠�꽣踰좎씠�뒪 愿��젴 蹂��닔�뱾 ===============//
    static Connection conn = null;
    static String strQuery = null;
    static String strTableQuery = null;

    static ResultSet rs = null;
    static Statement stmt = null;
	static PreparedStatement pstmt = null;
    final int iColCount = 5;

    //=============  ToolBar�뿉 �궗�슜�릺�뒗 愿��젴 蹂��닔�뱾 ===============//
    JToolBar xToolBar = null;
    JButton btnInsertItem, btnSaveItem,  btnPrintItem, btnCloseWindow;

    //=============  �솕硫� �븯�떒�쓽 status bar ===============//
    JLabel lbStatusMessage = null;
    boolean bInsertFlag = true;

    // �뜲�씠�꽣踰좎씠�뒪�� �뿰怨꾪븯�뿬 �궗�슜�맆 蹂��닔�뱾 
    String strAno, strAcno, strAname, strAbcode, strDcustno;
    long lTerm, lSeq;
    
    // 吏��젏肄붾뱶 湲곗뼲�떆�궗 諛곗뿴
    String sBcode[] = null;
    long lCurrentRow;

    //=============  User Interface ===============//            
    static JLabel label1 = new JLabel("吏��젏");
    static JLabel label2 = new JLabel("怨좉컼援щ텇");
    static JLabel label3 = new JLabel("怨꾩쥖踰덊샇");
    static JLabel label4 = new JLabel("�삁湲덉쥌瑜�");
    static JLabel label5 = new JLabel("怨꾩빟湲곌컙");
    static JLabel label6 = new JLabel("怨좉컼踰덊샇");
    static JLabel label7 = new JLabel("媛쒖썡");
    static String customer_dist[] = { "媛쒖씤怨좉컼", "湲곗뾽怨좉컼" };
    
    static JTextField tf1 = new JTextField();
    static JTextField tf2 = new JTextField("0");
    static JTextField tf3 = new JTextField();

    JComboBox  jcb1 = new JComboBox();
    JComboBox  jcb2 = new JComboBox();
    JComboBox  jcb3 = new JComboBox();    
    JTable jtAccoutList = null;

    Object columnName[] = {"怨꾩쥖踰덊샇", "�삁湲덉긽�뭹紐�", "怨좉컼踰덊샇", "怨좉컼紐�", "媛쒖꽕�씪"};
    Object dataTable[][] = null;
    
    frmDepositOrder(String title, Connection conn, JLabel lbMessage) {
        // JInternalFrame�쓽 �깮�꽦�옄 �샇異�
        /* 留ㅺ컻蹂��닔�쓽 媛믪뿉 �뵲�씪 李쎌쓽 �꽦吏� 蹂�寃� */
        super(title, false, true, true, true);

        String query = null;
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

        // 怨좉컼 �삁湲덇굅�옒 �떊泥� 由ъ뒪�듃 JTable�뿉 蹂댁뿬吏� �궡�슜 select
        initTable();
        // �삁湲덇퀎醫뚮쾲�샇 �깮�꽦(吏��젏肄붾뱶, 媛쒖씤 or 湲곗뾽)
        subMakeAccountNumber(jcb1.getSelectedIndex(), jcb2.getSelectedIndex());        
    }
    
    private void initTable() {
        int lRowCount = 0, i = 0;
        // AppFrame�겢�옒�뒪�쓽 createview()�뿉�꽌 �깮�꽦�븳 view�궗�슜
        String query =" select A_NO, A_ITEM_NAME, C_NO, C_NAME, A_DATE from v_account_list where A_ITEM_DIST = 'A0' order by A_NO desc";        

        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            
            // �쟾泥� row�쓽 媛��닔+1�쓣 �뼸�뼱�삩�떎.
            rs.last();
            lRowCount = rs.getRow() + 1; // �쁽�옱cursor�쓽 �쐞移�
            
            // JTable �깮�꽦�떆 �븘�슂�븳 Object array �깮�꽦
            dataTable = new Object[lRowCount][iColCount];

            // cursor�쓽 �쐞移섎�� 泥섏쓬�씠�쟾�쓽 �쐞移섎줈 �씠�룞
            rs.beforeFirst();

            // cursor�뿉 �엳�뒗 �뜲�씠�꽣瑜� 諛곗뿴�뿉 ���옣
            while(rs.next()) {
                for(int j = 0; j < iColCount; j++) {
                    // 媛� 而щ읆�쓽 媛��닔留뚰겮 諛섎났�븯�뿬 諛곗뿴�뿉 ���옣
                    dataTable[i][j] = rs.getObject(j+1);
                }
                i++;
            }
			
            // �쁽�옱 �삁湲� 怨꾩쥖瑜� 媛�吏�怨� �엳�뒗 怨좉컼 紐⑸줉�뀒�씠釉� �깮�꽦
	        jtAccoutList = new JTable(dataTable, columnName);

            // 怨좉컼紐⑸줉�뀒�씠釉�(JTable)�뿉 �뒪�겕濡� 諛� 遺숈뿬二쇨린
    	       JScrollPane scrollpane = new JScrollPane(jtAccoutList);
        	  scrollpane.setPreferredSize(new Dimension(0, 200));        

	       getContentPane().add("South", scrollpane); 

            // �궗�슜�븳 resultSet�쓣 close
            rs.close();
            //  �궗�슜�븳 statement瑜� close
            stmt.close();

        } catch (SQLException se) {
            msgBox(se);
            se.printStackTrace();
        }
    }

    /* User Interface 珥덇린�솕       */       
    private void initContent() {
        JPanel center = new JPanel();
	center.setLayout(null);
 
	label1.setBounds(10, 30, 100, 20);
	label2.setBounds(10, 60, 100, 20);
	label3.setBounds(10, 90, 100, 20);
	label4.setBounds(10, 120, 100, 20);
	label5.setBounds(10, 150, 100, 20); 
        label6.setBounds(10, 180, 100, 20);
        label7.setBounds(185, 150, 70, 20);

        jcb1.setBounds(120, 30, 150, 20);
        jcb2.setBounds(120, 60, 150, 20);
        tf1.setBounds(120, 90, 150, 20);
        jcb3.setBounds(120, 120, 150, 20);       
        tf2.setBounds(120, 150, 100, 20);
        tf3.setBounds(120, 180, 150, 20);       
       
        center.add(label1);
        center.add(label2);
        center.add(label3);
        center.add(label4);
        center.add(label5);
        center.add(label6);
        center.add(label7);

        // 吏��젏肄붾뱶, 吏��젏紐낆쓣 媛��졇�삩�떎.
	strQuery = "select b_no, b_name from branch";
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(strQuery);
            int i=0;

            /* 吏��젏�씠由꾩씠 ���옣�릺�뒗 �씤�뜳�뒪媛믪뿉 �뵲�씪 吏��젏肄붾뱶媛� ���옣 */
            sBcode = new String[10];
            while(rs.next()) {
            	jcb1.addItem(rs.getString("b_name").trim());
               sBcode[i] = rs.getString("b_no").trim();
               i++;
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            msgBox(se);
        }

        // 怨좉컼援щ텇 �꽑�깮 肄ㅻ낫諛뺤뒪
        for(int i=0; i<customer_dist.length; i++) {
            jcb2.addItem(customer_dist[i]);
        }
        
        jcb1.addActionListener(this);
        jcb2.addActionListener(this);
     
	center.add(tf1);
	center.add(tf2);
        center.add(tf3);
        center.add(jcb1);
	center.add(jcb2);
        center.add(jcb3);

        getContentPane().add("Center", center); 
    }

    /* �뜲�씠�꽣踰좎씠�뒪瑜� Navigate�븷�닔 �엳�룄濡� �븵/�뮘,泥섏쓬,�걹�쑝濡� �씠�룞, 
       異붽�,�궘�젣,���옣�벑�쓽 �댋諛� */
    private void initToolBar() {
        xToolBar = new JToolBar(JToolBar.HORIZONTAL);
        xToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
        
        btnInsertItem    = new JButton(new ImageIcon("./toolbar/insert.gif"));
        btnSaveItem      = new JButton(new ImageIcon("./toolbar/save.gif"));
        btnPrintItem      = new JButton(new ImageIcon("./toolbar/print.gif"));
        btnCloseWindow   = new JButton(new ImageIcon("./toolbar/exit.gif"));

        btnPrintItem.setEnabled(false);

        xToolBar.add(btnInsertItem);
        xToolBar.add(btnSaveItem);
        xToolBar.add(btnPrintItem);
        xToolBar.add(Box.createHorizontalGlue());
        xToolBar.add(btnCloseWindow);

        btnInsertItem.addActionListener(this);
        btnSaveItem.addActionListener(this);
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
        } else if(evt.getSource() == jcb1) {
            subMakeAccountNumber(jcb1.getSelectedIndex(), jcb2.getSelectedIndex());
        } else if(evt.getSource() == jcb2) {
            subMakeAccountNumber(jcb1.getSelectedIndex(), jcb2.getSelectedIndex());
        }
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
        tf3.setText("");
        jcb1.setSelectedIndex(0);
        jcb2.setSelectedIndex(0);
        jcb3.setSelectedIndex(0);
    }

    /* �솕硫댁쓽 textField�뱾�쓽 �궡�슜�쓣 �겢�옒�뒪 蹂��닔�뿉 ���옣  */
    public boolean getItems() {
        strAbcode = sBcode[jcb1.getSelectedIndex()];        // 吏��젏肄붾뱶
        strAno   = tf1.getText().trim();                    // �삁湲덇퀎醫뚮쾲�샇
        //intIndex = (String) jcb2.getSelectedIndex();        // 怨좉컼援щ텇
        strAname = (String) jcb3.getSelectedItem();         // �삁湲덇퀎醫� �긽�뭹紐�
        lSeq     = 1;
        lTerm    = Long.parseLong(tf2.getText().trim());     // 怨꾩빟湲곌컙
        strDcustno = tf3.getText().trim();                  // 怨좉컼踰덊샇

        // �엯�젰 textField�쓽 媛믪씠 �늻�씫�릺�뿀�뒗 �솗�씤
        if (strAno.length() < 8) { msgBox("�삁湲덇퀎醫뚮쾲�샇媛� �옒紐삳릺�뿀�뒿�땲�떎."); return false; }
        if (strDcustno.equals("")) { msgBox("怨좉컼踰덊샇媛� �엯�젰�릺吏� �븡�븯�뒿�땲�떎."); return false; }

        // �엯�젰�맂 怨좉컼踰덊샇媛� 怨좉컼�뀒�씠釉붿뿉 議댁옱�븯�뒗 怨좉컼�씤吏� �솗�씤
        strQuery = "select count(c_no) from customer where c_no = '" + strDcustno + "'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(strQuery);
            
            rs.next();
            if (rs.getInt(1) < 1) {
                msgBox("�엯�젰�븯�떊 怨좉컼踰덊샇�뒗 怨좉컼���옣�뿉 �뾾�뒗 怨좉컼�씠嫄곕굹 �옒紐삳맂 怨좉컼踰덊샇�엯�땲�떎.", "�븣由�");
                return false;
            }
        } catch(SQLException se) {
        	msgBox(se);
        }

        // UserInterface濡쒕��꽣 �겢�옒�뒪蹂��닔濡� 媛��졇�삩 媛믪쓣 statusbar�뿉 display
        lbStatusMessage.setText("[strAno : " + strAno + "] [strDcustno : " + strDcustno + "] [strAbcode : " + strAbcode + "] [strAname : " + strAname + "] [lTerm : " + lTerm + "]");
        return true;
    }

    // �겢�옒�뒪 蹂��닔�뿉 �뱾�뼱 �엳�뒗 �궡�슜�뱾 database�뿉 諛섏쁺   
    public void subSaveItem() {
        // insert踰꾪듉�씠 �닃�졇�뿀�뒗吏�...
        // 利� �깉濡쒖슫 �뜲�씠�꽣�씤吏�, �쁽�옱 �뜲�씠�꽣�쓽 �닔�젙�씤吏�
        // Insert踰꾪듉�씠 �닃�졇�떎硫�..
	if (bInsertFlag == true) {
            // User Interface�쓽 �궡�슜�쓣 �겢�옒�뒪 蹂��닔�뿉 ���옣
	    if (getItems()) {
                try {
                    // 怨꾩쥖�뀒�씠釉붿뿉 怨꾩쥖�뜲�씠�꽣 insert
                    strQuery = "INSERT INTO account VALUES (?, ?, null, null, sysdate, null, ?, 'A0', ?, ?, ?)";
                    
                    pstmt = conn.prepareStatement(strQuery);
                    pstmt.setString(1, strAno);
                    pstmt.setLong(2, lSeq);
                    pstmt.setLong(3, lTerm);
                    pstmt.setString(4, strAname);
                    pstmt.setString(5, strAbcode);
		    pstmt.setString(6, strDcustno);
                    // 怨꾩쥖�뀒�씠釉붿뿉 �뜲�씠�꽣媛� �젙�긽�쟻�쑝濡� insert�릺�뿀�쑝硫�
                    // deposit�뀒�씠釉붿뿉 嫄곕옒�뜲�씠�꽣 insert
                    pstmt.executeUpdate();

                    pstmt.close();

                    bInsertFlag = false;
                    lbStatusMessage.setText("insert completed!!");
					
                    // �젙�긽�쟻�쑝濡� �뜲�씠�꽣 insert媛� �걹�굹硫� commit
                    conn.commit();

                    initTable();
                    clearItems();
                } catch (SQLException se) {
                    msgBox(se, "Database Insert Into error");
	        } //end try~catch
            }//end if(getItems())
        } else {
        // insert 踰꾪듉�씠 �닃由ъ� �븡�븯�떎硫�
        	if(getItems()) {
	            try {
                    	lbStatusMessage.setText("update completed!!");                
	                conn.commit();
		    } catch(SQLException se) {
                    	msgBox(se, "�엯�젰�옄猷� �삤瑜�");
	            }	// end try~catch
            } //end if(getItems())
        } // end if(bInsertFlag == true)
    }	// end subSaveItem()

    // Insert踰꾪듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━    	
    public void subInsertItem() {
	clearItems();
        bInsertFlag = true;
    }

    // 吏��젏蹂�寃�, 怨좉컼援щ텇 蹂�寃쎌뿉 �뵲�씪 怨꾩쥖踰덊샇 �깮�꽦
    public void subMakeAccountNumber(int bcodeIndex, int distIndex) {
        String c_dist = null, a_no = null, sTemp = null;
        
        // 怨좉컼援щ텇肄붾뱶瑜� 媛��졇�삩�떎.
        if (distIndex == 0) {
	    c_dist = "P";
            sTemp = "00";
        } else if(distIndex == 1) {
            c_dist = "E";
            sTemp = "11";
        }

        /* 怨꾩쥖踰덊샇 �깮�꽦 : A P 100 001
            A : account(�삁湲�)
            P : 媛쒖씤 , E : 湲곗뾽怨좉컼
            100 : 吏��젏肄붾뱶..
            001 : �씪�젴踰덊샇...
        */
        a_no = "A" + c_dist + sBcode[bcodeIndex];

        /* 怨꾩쥖踰덊샇 max媛� 媛��졇�삤湲�. 
            to_char(11, '09999')�븯硫� '00011' �굹�삩�떎.
            substr("100001", 5, 2) �븯硫� '01' �굹�삩�떎.
            nvl : 吏��젏�씠 理쒖큹濡� �깮�꽦�맂 肄붾뱶�씪硫�.. max媛믪씠 null�씠 �뱾�뼱�삩�떎.
        */
        strQuery = "select to_char(nvl(max(substr(a_no, 6,3)) + 1, 1), '099') from account where a_no like '" + a_no + "%' and A_ITEM_DIST = 'A0'";
        //msgBox(strQuery);

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(strQuery);

            rs.next();
            a_no = a_no + rs.getString(1).trim();
            tf1.setText(a_no);
            //msgBox(a_no);
            rs.close();

            // sTemp媛� : 媛쒖씤(00), 湲곗뾽(11)�뿉 �뵲�씪 �삁湲덉쥌瑜섎�� 媛��졇�삩�떎.
            strQuery = "select item_name from item where item_dist = 'A0' and item_c_dist = '" + sTemp +"'";
            rs = stmt.executeQuery(strQuery);

            // combo box�쓽 item�뱾�쓣 紐⑤몢 �궘�젣�썑 �떎�떆 insert�븯湲� �쐞�빐
            jcb3.removeAllItems();
            
            while(rs.next()) {
                jcb3.addItem(rs.getString(1).trim());
            }
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            msgBox(se);
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