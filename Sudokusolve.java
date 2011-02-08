
import java.awt.*;
import javax.swing.*;
import java.awt.Image.*;
import java.awt.event.*;

class Sudokusolve extends JFrame implements ActionListener {

  int i, j, i1, j1, v = 0, v1, i2, j2;
  int flag = 0, flag1 = 0;

  ;
  String s1;
  JTextField button[][] = new JTextField[9][9];
  int a[][] = new int[9][9];
  int s[][] = new int[9][9];
  int a2[][] = new int[9][9];
  int s2[][] = new int[9][9];
  JPanel jp;
  JButton confirm, restart;
  JLabel jl1;
//	confirm=new JButton("confirm");
//	restart=new JButton("restart");
  JTextField jt1, jt2;
//	 AccessibleContext 	at1;

  Sudokusolve() {
    //	jt1=new JTextField();

    jp = new JPanel(new GridLayout(10, 9));
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {

        jt1 = new JTextField("0", 2);
        //jp.add(jt1);
        button[i][j] = jt1;
        //a[i][j]=Integer.parseInt(button[i][j].getText());
        // s[i][j]=a[i][j];
        jp.add(button[i][j]);
      }
    }
    confirm = new JButton("confirm");
    restart = new JButton("restart");
    jp.add(confirm);
    jp.add(restart);
    jl1 = new JLabel("PLEASE INSERT VALUE BETWEEN 0-9 & CORRECT VALUE");
    jp.add(jl1);
    confirm.addActionListener(this);
    restart.addActionListener(this);
    getContentPane().add(jp);
    setSize(500, 500);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == confirm) {
      //check();
      solve();
    }
    if (e.getSource() == restart) {
      new Sudokusolve();
    }
  }
  /*public void check()
  {
  try
  {
  for(i=0;i<9;i++)              //entering element element
  {

  for(j=0;j<9;j++)
  {
  v1=Integer.parseInt(button[i][j].getText());
  if(v1>9)
  v1=0;
  a2[i][j]=v1;
  s2[i][j]=a2[i][j];
  }
  System.out.println("amar");

  if(a[i][j]!=0)
  {
  for(i2=0;i2<9;i2++)         //go byrow if value found take another value
  if(i!=i2&&s2[i][j]==s2[i2][j])flag1=1;
  System.out.println("amar");
  for(j2=0;j2<9;j2++)       //go by column
  if(j!=j2&&s2[i][j]==s2[i][j2])flag1=1;
  for(i1=0;i1<9;i1++)    //check in 3x3 block
  for(j1=0;j1<9;j1++)
  if((i!=i2||j!=j2)&&i/3==i2/3&&j/3==j2/3&&s2[i][j]==s2[i2][j2])
  flag1=1;
  }System.out.println("amar");
  if(flag==0)
  {
  solve();
  }
  else
  {
  JOptionPane.showMessageDialog(this,"Invalid input");
  }

  }
  }
  catch(Exception e)
  {
  System.out.println("invalid input");
  }
  }*/

  public void solve() {

    try {

      //logic start
      for (i = 0; i < 9; i++) //displaying element
      {
        for (j = 0; j < 9; j++) {
          v = Integer.parseInt(button[i][j].getText());
          if (v > 9) {
            v = 0;
          }
          a[i][j] = v;
          s[i][j] = a[i][j];
        }
      }

      for (i = 0; i < 9; i++) {
        for (j = 0; j < 9; j++) {
          if (a[i][j] == 0) {
            for (s[i][j]++; s[i][j] <= 9; s[i][j]++) {
              flag = 0;
              for (i1 = 0; i1 < 9; i1++) //go byrow if value found take another value
              {
                if (i != i1 && s[i][j] == s[i1][j]) {
                  flag = 1;
                }
              }
              for (j1 = 0; j1 < 9; j1++) //go by column
              {
                if (j != j1 && s[i][j] == s[i][j1]) {
                  flag = 1;
                }
              }
              for (i1 = 0; i1 < 9; i1++) //check in 3x3 block
              {
                for (j1 = 0; j1 < 9; j1++) {
                  if ((i != i1 || j != j1) && i / 3 == i1 / 3 && j / 3 == j1 / 3 && s[i][j] == s[i1][j1]) {
                    flag = 1;
                  }
                }
              }
              if (flag == 0) {
                break;
              }
            }
            if (s[i][j] > 9) {
              s[i][j] = 0;
              do {
                //	if(i==0&&j==0)
                //	{
                //
                //	break;
                //	}
                if (j > 0) {
                  j--;
                } else {
                  j = 8;
                  i--;
                }
              } while (a[i][j] > 0);
              j--;
            }
          }
        }
      }
    } catch (Exception e1) {
      System.out.println("error1" + e1);
    }
    for (i = 0; i < 9; i++) //displaying element
    {

      for (j = 0; j < 9; j++) {
        System.out.print(s[i][j]);
      }
      System.out.print("\n");
    }


    for (i = 0; i < 9; i++) //displaying element on text box
    {

      for (j = 0; j < 9; j++) {

        button[i][j].setText(String.valueOf(s[i][j]));
        // button[i][j].setEditable(false);//text field can be seen but can not be modified
      }
    }

  }

  public static void main(String arg[]) {
    new Sudokusolve();
  }
}
