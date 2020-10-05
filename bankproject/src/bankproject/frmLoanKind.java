package bankproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class frmLoanKind extends JInternalFrame implements ActionListener, WindowListener
{
   //=============  �뜲�씠�꽣踰좎씠�뒪 愿��젴 蹂��닔�뱾 ===============//
    static Connection conn = null;
    static String strQuery = "select item_name, item_limit, item_dist, item_c_dist, term1, rate1, term2, rate2, term3, rate3 from item where ITEM_DIST = 'L1'";    
    static ResultSet rs = null;
    static Statement stmt = null;

    //=============  ToolBar�뿉 �궗�슜�릺�뒗 愿��젴 蹂��닔�뱾 ===============//
    JToolBar xToolBar;
    JButton btnMoveFirst, btnMovePrev, btnMoveNext, btnMoveLast;
    JButton btnInsertItem, btnDeleteItem, btnSaveItem, btnPrintItem, btnCloseWindow;    

    //=============  �솕硫� �븯�떒�쓽 status bar ===============//
    JLabel lbStatusMessage;

    // �뜲�씠�꽣踰좎씠�뒪�� �뿰怨꾪븯�뿬 �궗�슜�맆 蹂��닔�뱾
    String strLkname, strLkdist, strLkcdist;
    //String strLkname, strLkdishi;
    long  lLklimit;
    int iLkterm1, iLkterm2, iLkterm3;
    float fLkrate1,  fLkrate2,  fLkrate3; 

     // cursor�쓽 �쁽�옱 �쐞移�    
    long lCurrentRow;

    // 異붽�踰꾪듉�씠 �늻�젮吏꾪썑�뿉 ���옣踰꾪듉�씠 �닃�졇�뒗吏� 泥댄겕
    // true: insert -> save, false : �궡�슜 �닔�젙�썑 -> save
    boolean bInsertFlag = false;
    
    //=============  User Interface ===============//
    static JLabel label1 = new JLabel("��異쒖긽�뭹紐�");
    static JLabel label2 = new JLabel("��異쒗븳�룄");
    static JLabel label3 = new JLabel("�긽�뭹援щ텇");    
    static JLabel label4 = new JLabel("怨좉컼援щ텇");
    static JLabel label5 = new JLabel("湲곌컙1");
    static JLabel label6 = new JLabel("�씠�쑉1");
    static JLabel label7 = new JLabel("湲곌컙2");
    static JLabel label8 = new JLabel("�씠�쑉2");
    static JLabel label9 = new JLabel("湲곌컙3");
    static JLabel label10 = new JLabel("�씠�쑉3");
    static String customer_dist[] = { "媛쒖씤怨좉컼", "湲곗뾽怨좉컼" };
    static String item_dist[] = { "�삁湲�", "��異�" };    
    
    static JTextField tf1 = new JTextField();
    static JTextField tf2 = new JTextField();
    static JTextField tf3 = new JTextField();
    static JTextField tf4 = new JTextField();
    static JTextField tf5 = new JTextField();
    static JTextField tf6 = new JTextField();
    static JTextField tf7 = new JTextField();
    static JTextField tf8 = new JTextField();

    JComboBox  jcb1 = new JComboBox();
    JComboBox  jcb2 = new JComboBox();

    frmLoanKind(String title, Connection conn, JLabel lbMessage) {
        // JInternalFrame�쓽 �깮�꽦�옄 �샇異�
        /* 留ㅺ컻蹂��닔�쓽 媛믪뿉 �뵲�씪 李쎌쓽 �꽦吏� 蹂�寃� */
        super(title, true, true, true, true);

        // AppFrame�겢�옒�뒪�뿉�꽌 database Connection�쓣 諛쏆븘�꽌 �겢�옒�뒪�쓽 connection�뿉
        this.conn = conn;
        this.lbStatusMessage = lbMessage;

        // �솕硫� �븯�떒�뿉 '��異쒖긽�뭹 愿�由�' display                
        lbStatusMessage.setText("��異쒖긽�뭹 愿�由�");

        getContentPane().setLayout(new BorderLayout());

        // Toolbar 珥덇린�솕       		
        initToolBar();

        getContentPane().add("North", xToolBar); // �댋諛� 遺숈씠湲�

        // User Interface 珥덇린�솕
        initContent();

        // 湲곕낯�쟻�쑝濡� �궗�슜�맆 resultSet�쓣 �뜲�씠�꽣踰좎씠�뒪�뿉�꽌 Query
        // "select Lk_name, Lk_limit, Lk_dishi, Lk_term1, Lk_rate1,
        //         Lk_term2, Lk_rate2, Lk_term3, Lk_rate3 from loan_kind";
        initResultSet(strQuery);
        subMoveFirst();
    }

    /* 湲곕낯�쟻�쑝濡� �궗�슜�맆 resultSet�쓣 �뜲�씠�꽣踰좎씠�뒪�뿉�꽌 Query    */            
    public void initResultSet(String strQuery) 
    {
        try {
            // update 媛��뒫�븯硫댁꽌, �떎瑜� �궗�슜�옄�쓽 �뜲�씠�꽣 蹂�寃쎌쓣 媛먯�        
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);            
            rs = stmt.executeQuery(strQuery);
        } catch (SQLException se) {
            msgBox(se.toString(), "SQLException");
        }
    }
	   
    /* User Interface 珥덇린�솕       */
    private void initContent() {
       JPanel north = new JPanel();
       north.setLayout(null);
 
       label1.setBounds(10, 30, 100, 20);
       label2.setBounds(10, 60, 100, 20);
       label3.setBounds(10, 90, 100, 20);
       label4.setBounds(10, 120, 100, 20);
       label5.setBounds(10, 150, 100, 20); 
       label6.setBounds(10, 180, 100, 20);
       label7.setBounds(10, 210, 100, 20);
       label8.setBounds(10, 240, 100, 20);
       label9.setBounds(10, 270, 100, 20);
       label10.setBounds(10, 300, 100, 20);       

       tf1.setBounds(120, 30, 150, 20);
       tf2.setBounds(120, 60, 150, 20);
       jcb1.setBounds(120, 90, 150, 20);
       jcb2.setBounds(120, 120, 150, 20);       
       tf3.setBounds(120, 150, 150, 20);
       tf4.setBounds(120, 180, 150, 20);
       tf5.setBounds(120, 210, 150, 20);
       tf6.setBounds(120, 240, 150, 20);
       tf7.setBounds(120, 270, 150, 20);
       tf8.setBounds(120, 300, 150, 20);

       north.add(label1);
       north.add(label2);
       north.add(label3);
       north.add(label4);
       north.add(label5);
       north.add(label6);
       north.add(label7);
       north.add(label8);
       north.add(label9);
       north.add(label10);       

       for(int i=0; i<customer_dist.length; i++) {
           jcb1.addItem(customer_dist[i]);
 	   }
     
       for(int i=0; i<item_dist.length; i++) {
           jcb2.addItem(item_dist[i]);
 	   } 	   
     
       jcb2.disable();     
     
       north.add(tf1);
       north.add(tf2);
       north.add(tf3);
       north.add(jcb1);
       north.add(jcb2);       
       north.add(tf4);
       north.add(tf5);
       north.add(tf6);
       north.add(tf7);
       north.add(tf8);

       getContentPane().add("Center", north); 
    }

    /* �뜲�씠�꽣踰좎씠�뒪瑜� Navigate�븷�닔 �엳�룄濡� �븵/�뮘,泥섏쓬,�걹�쑝濡� �씠�룞, 
       異붽�,�궘�젣,���옣�벑�쓽 �댋諛� */
    private void initToolBar() {
        xToolBar = new JToolBar(JToolBar.HORIZONTAL);
        xToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
        
        btnMoveFirst     = new JButton(new ImageIcon("./toolbar/first.gif"));
        btnMovePrev      = new JButton(new ImageIcon("./toolbar/prev.gif"));
        btnMoveNext      = new JButton(new ImageIcon("./toolbar/next.gif"));
        btnMoveLast      = new JButton(new ImageIcon("./toolbar/last.gif"));
        btnInsertItem    = new JButton(new ImageIcon("./toolbar/insert.gif"));
        btnDeleteItem    = new JButton(new ImageIcon("./toolbar/delete.gif"));        
        btnSaveItem      = new JButton(new ImageIcon("./toolbar/save.gif"));
        btnPrintItem      = new JButton(new ImageIcon("./toolbar/print.gif"));
        btnCloseWindow   = new JButton(new ImageIcon("./toolbar/exit.gif"));

        btnPrintItem.setEnabled(false);

        xToolBar.add(btnMoveFirst);
        xToolBar.add(btnMovePrev);
        xToolBar.add(btnMoveNext);
        xToolBar.add(btnMoveLast);
        xToolBar.addSeparator();
        xToolBar.add(btnInsertItem);
        xToolBar.add(btnDeleteItem);
        xToolBar.add(btnSaveItem);
        xToolBar.add(btnPrintItem);
        xToolBar.add(Box.createHorizontalGlue());
        xToolBar.add(btnCloseWindow);

        btnMoveFirst.addActionListener(this);
        btnMovePrev.addActionListener(this);
        btnMoveNext.addActionListener(this);
        btnMoveLast.addActionListener(this);    
        btnInsertItem.addActionListener(this);
        btnDeleteItem.addActionListener(this);
        btnSaveItem.addActionListener(this);
        btnPrintItem.addActionListener(this);
        btnCloseWindow.addActionListener(this);
    }        

    /* �댋諛붿쓽 踰꾪듉�뱾�쓽 clicked �씠踰ㅽ듃�뿉 �뵲�씪 �샇異쒕맆 �븿�닔�젙�쓽  */    	
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == btnSaveItem) {
      		subSaveItem();
        } else if(evt.getSource() == btnInsertItem) {
            subInsertItem();
        } else if(evt.getSource() == btnDeleteItem) {
        	subDeleteItem();
        } else if(evt.getSource() == btnMoveFirst) {
            subMoveFirst();
        } else if(evt.getSource() == btnMovePrev) {
        	subMovePrev();
        } else if(evt.getSource() == btnMoveNext) {
        	subMoveNext();
        } else if(evt.getSource() == btnMoveLast) {
        	subMoveLast();
        } else if(evt.getSource() == btnPrintItem) {
            subPrintItem();
        } else if(evt.getSource() == btnCloseWindow) {
        	subCloseWindow();
        }
    }

    /* �궗�슜�옄�뿉寃� �븣�젮�빞 �븷 硫붿떆吏� 泥섎━  
       overload�쑝濡� 留ㅺ컻蹂��닔�뿉 �뵲�씪 �떎瑜멸린�뒫�쓣 援ы쁽 */
    public void msgBox(String strMsg) {
        JOptionPane.showMessageDialog(this, strMsg, "�븣由�", JOptionPane.INFORMATION_MESSAGE);
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
          tf1.setText("");      // ��異쒖긽�뭹紐�
          tf2.setText("0");     // ��異쒗븳�룄
          tf3.setText("0");     // 湲곌컙1
          tf4.setText("0.0");   // �씠�쑉1
          tf5.setText("0");     // 湲곌컙2
          tf6.setText("0.0");   // �씠�쑉2
          tf7.setText("0");     // 湲곌컙3
          tf8.setText("0.0");   // �씠�쑉3
          jcb1.setSelectedIndex(0); // 怨좉컼援щ텇
          jcb2.setSelectedIndex(1); // �긽�뭹援щ텇          
    }

    /* �솕硫댁쓽 textField�뱾�뿉 �쁽�옱 cursor�쓽 �궡�슜�쓣 setting */
    public void setItems() {
        try {
            // cursor�뿉�꽌 �겢�옒�뒪 蹂��닔濡� �옄猷� �씠�룞
            strLkname  = rs.getString(1).trim();    // �삁湲덉긽�뭹紐�
            lLklimit = rs.getLong(2);               // �삁湲덊븳�룄�븸
            strLkdist = rs.getString(3).trim();    // �긽�뭹援щ텇 A0, L1
            strLkcdist = rs.getString(4).trim();    // 怨좉컼援щ텇 00 媛쒖씤, 11 湲곗뾽
            iLkterm1 = rs.getInt(5);                // 湲곌컙 1(媛쒖썡)
            fLkrate1 = rs.getFloat(6);              // �씠�쑉 1
            iLkterm2 = rs.getInt(7);                // 湲곌컙 2(媛쒖썡)
            fLkrate2 = rs.getFloat(8);              // �씠�쑉 2
            iLkterm3 = rs.getInt(9);                // 湲곌컙 3(媛쒖썡)
            fLkrate3 = rs.getFloat(10);              // �씠�쑉 3
                        
            lCurrentRow = rs.getRow();

            // �뜲�씠�꽣 踰좎씠�뒪�뿉�꽌 媛��졇�삩 媛믩뱾�쓣 �솕硫댁븘�옒�뿉 �엳�뒗 statusbar�뿉 �몴�떆            
            lbStatusMessage.setText("[row : " + lCurrentRow + "] [Lk_name : " + strLkname + "] [Lk_limit : " + lLklimit + "] [Lk_dishi : " + strLkcdist + "] [Lk_term1 : " + iLkterm1 + "] [Lk_rate1 : " + fLkrate1 + "] [Lk_term2 : " + iLkterm2 + "] [Lk_rate2 : " + fLkrate2 + "] [Lk_term3 : " + iLkterm3 + "] [Lk_rate3 : " + fLkrate3 + "] ");

            // �겢�옒�뒪 蹂��닔�뿉�꽌 �솕硫� Interface濡� �옄猷� 蹂듭궗
            tf1.setText(strLkname);
            tf2.setText("" + lLklimit);
            tf3.setText("" + iLkterm1);
            tf4.setText("" + fLkrate1);
            tf5.setText("" + iLkterm2);
            tf6.setText("" + fLkrate2);
            tf7.setText("" + iLkterm3);
            tf8.setText("" + fLkrate3);
        
            if (strLkcdist.equals("00")) {
                jcb1.setSelectedIndex(0);
            } else if (strLkcdist.equals("11")) {
                jcb1.setSelectedIndex(1);
            }
            
            jcb2.setSelectedIndex(1);            
        } catch(SQLException se) {
             msgBox(se, "setitems()");
        }
	}

    /* �솕硫댁쓽 textField�뱾�쓽 �궡�슜�쓣 �겢�옒�뒪 蹂��닔�뿉  */
    public boolean getItems() {
    	int intIndex;

        strLkname   = tf1.getText().trim();                     // ��異쒖긽�뭹紐�
        lLklimit    = Long.parseLong(tf2.getText().trim());     // ��異쒗븳�룄�븸
        iLkterm1    = Integer.parseInt(tf3.getText().trim());   // 湲곌컙 1(媛쒖썡)
        fLkrate1    = Float.parseFloat(tf4.getText().trim());   // �씠�쑉 1
        iLkterm2    = Integer.parseInt(tf5.getText().trim());   // 湲곌컙 2(媛쒖썡)
        fLkrate2    = Float.parseFloat(tf6.getText().trim());   // �씠�쑉 2
        iLkterm3    = Integer.parseInt(tf7.getText().trim());   // 湲곌컙 3(媛쒖썡)
        fLkrate3    = Float.parseFloat(tf8.getText().trim());   // �씠�쑉 3

        intIndex = jcb1.getSelectedIndex();

        // �엯�젰 textField�쓽 媛믪씠 �늻�씫�릺�뿀�뒗 �솗�씤
        if (strLkname == null) { msgBox("��異쒖긽�뭹紐낆씠 �늻�씫�릺�뿀�뒿�땲�떎."); return false; }
        if (iLkterm1 > 60 ) { msgBox("媛��뒫 湲곌컙�� 60媛쒖썡 誘몃쭔�엯�땲�떎."); return false; }
        if (iLkterm2 > 60 ) { msgBox("媛��뒫 湲곌컙�� 60媛쒖썡 誘몃쭔�엯�땲�떎."); return false; }
        if (iLkterm3 > 60 ) { msgBox("媛��뒫 湲곌컙�� 60媛쒖썡 誘몃쭔�엯�땲�떎."); return false; }
                    
        // 怨좉컼援щ텇
        switch(intIndex) {
            case 0 : strLkcdist = "00";
            case 1 : strLkcdist = "11";
        }

	   strLkdist = "L1";

        // UserInterface濡쒕��꽣 �겢�옒�뒪蹂��닔濡� 媛��졇�삩 媛믪쓣 statusbar�뿉 display
        lbStatusMessage.setText("[row : " + lCurrentRow + "] [Lk_name : " + strLkname + "] [Lk_limit : " + lLklimit + "] [Lk_dishi : " + strLkcdist + "] [Lk_term1 : " + iLkterm1 + "] [Lk_rate1 : " + fLkrate1 + "] [Lk_term2 : " + iLkterm2 + "] [Lk_rate2 : " + fLkrate2 + "] [Lk_term3 : " + iLkterm3 + "] [Lk_rate3 : " + fLkrate3 + "] ");
        return true;
    }

    // cursor�쓽 �쐞移섎�� 泥섏쓬�쑝濡� �씠�룞
    public void subMoveFirst() {
		try {
            if(!rs.isFirst()) {
	            rs.first();
                setItems();
	        }
        } catch(SQLException se) {
             msgBox(se);
        }
    }

    // cursor�쓽 �쐞移섎�� �쁽�옱�뿉�꽌 �씠�쟾�쑝濡� �씠�룞
    public void subMovePrev() {
    	try {
	        if(!rs.isFirst()) {
	            rs.previous();
                setItems();
	        }
        } catch(SQLException se) {
             msgBox(se);
        }
    }

    // cursor�쓽 �쐞移섎�� �쁽�옱�뿉�꽌 �떎�쓬�쑝濡� �씠�룞
    public void subMoveNext() {
        try {
            if(!rs.isLast()) {
	            rs.next();
                setItems();
            }
        } catch(SQLException se) {
             msgBox(se);
        }
    }

    // cursor�쓽 �쐞移섎�� 留덉�留됱쑝濡� �씠�룞
    public void subMoveLast() {
    	try {
	        if(!rs.isLast()) {
	            rs.last();
                setItems();
    	    }
        } catch(SQLException se) {
             msgBox(se);
        }
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

                    // cursor�쓽 �쐞移섎�� insert buffer濡� �씠�룞
		            rs.moveToInsertRow();

                    // cursor�쓽 �궡�슜�쓣 �겢�옒�뒪 蹂��닔濡� setting
                    rs.updateString(1, strLkname.trim());
                    rs.updateLong(2, lLklimit);
                    rs.updateString(3, strLkdist.trim());
                    rs.updateString(4, strLkcdist.trim());
                    rs.updateInt(5, iLkterm1);
                    rs.updateFloat(6, fLkrate1);
                    rs.updateInt(7, iLkterm2);
                    rs.updateFloat(8, fLkrate2);
                    rs.updateInt(9, iLkterm3);
                    rs.updateFloat(10, fLkrate3);

                    // setting�맂 insert buffer�궡�슜�쓣 �뜲�씠�꽣踰좎씠�뒪�뿉 諛섏쁺
                    rs.insertRow();

                    //msgBox("[row : " + lCurrentRow + "] [Lk_name : " + strLkname + "] [Lk_limit : " + lLklimit + "] [Lk_dishi : " + strLkcdist + "] [Lk_term1 : " + iLkterm1 + "] [Lk_rate1 : " + fLkrate1 + "] [Lk_term2 : " + iLkterm2 + "] [Lk_rate2 : " + fLkrate2 + "] [Lk_term3 : " + iLkterm3 + "] [Lk_rate3 : " + fLkrate3 + "] ", "�떎�쓬�뜲�씠�꽣瑜� ���옣�빀�땲�떎.");
	                bInsertFlag = false;

                    lbStatusMessage.setText("insert completed!!");

                    // �뜲�씠�꽣 踰좎씠�뒪瑜� commit
                    conn.commit();
                    rs.moveToCurrentRow();
                    //rs.refreshRow();
		        } catch (SQLException se) {
                    msgBox(se, "Database Insert Into error");
		        } //end try~catch
            }//end if(getItems())
        } else {
        // insert 踰꾪듉�씠 �닃由ъ� �븡�븯�떎硫�
        
        	if(getItems()) {
	            try {
                    // �겢�옒�뒪 蹂��닔�쓽 �궡�슜�쓣 cursor�뿉 諛섏쁺        
                    rs.updateString(1, strLkname.trim());
                    rs.updateLong(2, lLklimit);
                    rs.updateString(3, strLkdist.trim());
                    rs.updateString(4, strLkcdist.trim());
                    rs.updateInt(5, iLkterm1);
                    rs.updateFloat(6, fLkrate1);
                    rs.updateInt(7, iLkterm2);
                    rs.updateFloat(8, fLkrate2);
                    rs.updateInt(9, iLkterm3);
                    rs.updateFloat(10, fLkrate3);

                    // cursor�쓽 蹂�寃쎌궗�빆�쓣 �뜲�씠�꽣踰좎씠�뒪�뿉 諛섏쁺
                    rs.updateRow();

                    lbStatusMessage.setText("update completed!!");                

                    //�뜲�씠�꽣踰좎씠�뒪 commit
	                conn.commit();
		        } catch(SQLException se) {
                    msgBox(se, "�엯�젰�옄猷� �삤瑜�");
	                System.out.println("hi");
	            }	// end try~catch
            } //end if(getItems())
        } // end if(bInsertFlag == true)
    }	// end subSaveItem()
	
    // Insert踰꾪듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━
    public void subInsertItem() {
		clearItems();
        bInsertFlag = true;
    }

    // Delete踰꾪듉�씠 �닃�졇�쓣 寃쎌슦 泥섎━
    public void subDeleteItem() {
		int rtnValue;

        //�궘�젣 �솗�씤 硫붿떆吏� 李쎌쓣 �쓣�슫�떎.    
        rtnValue = JOptionPane.showConfirmDialog(null, "�쁽�옱 �뜲�씠�꽣瑜� �궘�젣 �빀�땲�떎.", "�솗�씤", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	
		try {

            // �궘�젣 �솗�씤 踰꾪듉�씠 �닃由곌꼍�슦
            if (rtnValue == 0) {

                // �쁽�옱 而ㅼ꽌�쓽 �쐞移섏뿉 �엳�뒗 �뜲�씠�꽣瑜� �궘�젣
	    	    rs.deleteRow();

                // �떎�쓬�뻾�쑝濡� �씠�룞
                subMoveNext();
                                
                lbStatusMessage.setText("delete completed!!");

                // �뜲�씠�꽣 踰좎씠�뒪 commit
                conn.commit();
            }
        } catch (SQLException se) {
            msgBox(se, "subDelteItem()");
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
            stmt.close();
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