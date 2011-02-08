
import java.awt.*;
import javax.swing.*;
import java.awt.Image.*;
import java.awt.event.*;

class Startsudoku extends JFrame implements ActionListener {

  JButton play, solve;
  JPanel jp;

  Startsudoku() {
    play = new JButton("play");
    solve = new JButton("solve");
    jp = new JPanel(new GridLayout(1, 2));
    jp.add(play);
    jp.add(solve);
    getContentPane().add(jp);
    play.addActionListener(this);
    solve.addActionListener(this);
    getContentPane().add(jp);
    setSize(500, 500);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {


    if (e.getSource() == play) {
      new Sudokugen();
    }
    if (e.getSource() == solve) {
      new Sudokusolve();
    }
  }

  public static void main(String arg[]) {
    new Startsudoku();
  }
}
