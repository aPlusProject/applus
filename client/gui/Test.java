package client.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {
   private static final String INTRO = "intro";
   private static final String GAME = "game";
   private CardLayout cardlayout = new CardLayout();
   private JPanel mainPanel = new JPanel(cardlayout);
   private IntroPanel introPanel = new IntroPanel();
   private GamePanel gamePanel = new GamePanel();

   public Test() {
      mainPanel.add(introPanel.getMainComponent(), INTRO);
      mainPanel.add(gamePanel.getMainComponent(), GAME);

      introPanel.addBazBtnActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cardlayout.show(mainPanel, GAME);
         }
      });

      gamePanel.addBackBtnActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cardlayout.show(mainPanel, INTRO);
         }
      });
   }

   private JComponent getMainComponent() {
      return mainPanel;
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("Foo Bar Baz");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Test().getMainComponent());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

class IntroPanel {
   private JPanel mainPanel = new JPanel();
   private JButton baz = new JButton("Baz");
   private JButton exit = new JButton("Exit");

   public IntroPanel() {
      mainPanel.setLayout(new FlowLayout());
      baz = new JButton("Start");
      exit = new JButton("exit");

      mainPanel.add(new JLabel("Hello World"));
      mainPanel.add(baz);
      mainPanel.add(exit);

      exit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Window win = SwingUtilities.getWindowAncestor(mainPanel);
            win.dispose();
         }
      });
   }

   public void addBazBtnActionListener(ActionListener listener) {
      baz.addActionListener(listener);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

}

class GamePanel {
   private static final Dimension MAIN_SIZE = new Dimension(400, 200);
   private JPanel mainPanel = new JPanel();

   private JButton foo;
   private JButton bar;
   private JButton back;

   public GamePanel() {
      foo = new JButton("Foo");
      bar = new JButton("Bar");
      back = new JButton("return to main menu");

      mainPanel.add(foo);
      mainPanel.add(bar);
      mainPanel.add(back);
      mainPanel.setPreferredSize(MAIN_SIZE);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void addBackBtnActionListener(ActionListener listener) {
      back.addActionListener(listener);
   }

}