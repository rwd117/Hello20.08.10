package chatting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient {

 JTextArea incoming; // �����κ��� �о�� �޽����� ǥ���� ����
 JTextField outgoing; // �����κ��� �޽����� �Է��� ����
 BufferedReader reader; // �����κ��� �� �޽����� �о�帱 �б����
 PrintWriter writer; // �޽����� ���� ��Ʈ���� ���� ���� ��Ʈ��
 Socket sock; // ����
 
 public static void main(String[] args) {
  SimpleChatClient client = new SimpleChatClient();
  client.go();
 }
 
 public void go() {
  // ä��â UI
  JFrame frame = new JFrame("Ludicrously Simple Chat Client");
  JPanel mainPanel = new JPanel();
  incoming = new JTextArea(15,40);
  incoming.setLineWrap(true); //�ڵ� ����
  incoming.setWrapStyleWord(true); // ���� �ѱ� �� ���� ������ �ܾ ���࿡ ���� ������ �ʵ��� �ϱ�
  incoming.setEditable(false);
  incoming.setVisible(true);
  JScrollPane qScroller = new JScrollPane(incoming);
  qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //���� ��ũ�ѹ� ǥ�� ��å : �׻� �����ֱ�
  qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// ���� ��ũ�ѹ� ǥ�� ��å : �׻� �����ֱ�
  outgoing = new JTextField(20);
  JButton sendButton = new JButton("Send");
  sendButton.addActionListener(new SendButtonListener());
  JButton exitButton = new JButton("Exit");
  exitButton.addActionListener(new ExitButtonListener());
  mainPanel.add(qScroller);
  mainPanel.add(outgoing);
  mainPanel.add(sendButton);
  mainPanel.add(exitButton);
  incoming.append("notice : UI �ʱ�ȭ\n");
  
  // ���� ��� �ʱ�ȭ
  setUpNetWorking();
  incoming.append("notice : ���� ��� �ʱ�ȭ\n");
  incoming.append("notice : ä�ÿ� �����ϼ̽��ϴ�.\n\n");
  
  // �б� ������ ����, ����
  Thread readerThread = new Thread(new IncomingReader());
  readerThread.start();
  
  // UI visual(����,ũ��) ����
  frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
  frame.setSize(500, 500);
  frame.setVisible(true);
 }
 
 private void setUpNetWorking() { // Ŭ���̾�Ʈ�� ������ ����� �غ�
  try {
   
   // ���� ��ü ����
   sock = new Socket("127.0.0.1", 5000);
   
   // ���۸��� + �Է½�Ʈ������ + �����Է½�Ʈ�� ü�̴�
   InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
   reader = new BufferedReader(streamReader);
   
   // printwriter + ������½�Ʈ�� ü�̴�
   writer = new PrintWriter(sock.getOutputStream());
   
   System.out.println("networking established");
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
 // Send ��ư ������
 public class SendButtonListener implements ActionListener {
  
  // ��ư ������
  public void actionPerformed(ActionEvent ev) {
   try {
    writer.println(outgoing.getText()); // outgoing ������ �ؽ�Ʈ�� ������ writer�� ����.
    writer.flush(); // ���͸� ���� ���� �ٷ� flush
   } catch(Exception ex) {
    ex.printStackTrace();
   }
   outgoing.setText(""); //���� ���� outgoing ������ ����.
   outgoing.requestFocus(); //��Ŀ���� �ؽ�Ʈâ�� ���´�.
  }
 }
 
 public class ExitButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent ev) {
   try {
    System.exit(0);
   } catch(Exception e) {
    e.printStackTrace();
   }
  }
 }
 
 public class IncomingReader implements Runnable {
  public void run() {
   String message;
   try {
    while ((message = reader.readLine()) != null) {
     System.out.println("read " + message);
     incoming.append(message + "\n");
    }    
   } catch (Exception e) {e.printStackTrace();}
  }
 }
}

