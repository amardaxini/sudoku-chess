/*
 * @author = Amar Daxini
 * Email = amardaxini@gmail.com
 */
import java.awt.*;
import javax.swing.*;
import java.awt.Image.*;
import java.awt.event.*;

class Sudokugen extends JFrame {

  int i, j, i1, j1, v = 0;
  int flag = 0;
  String s1;
  JTextField button[][] = new JTextField[9][9];
  int a[][] = new int[9][9];
  int s[][] = new int[9][9];
  JPanel jp;
  JTextField jt1, jt2;
//	 AccessibleContext 	at1;

  Sudokugen() {
    //	jt1=new JTextField();

    jp = new JPanel(new GridLayout(9, 9));
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {

        jt1 = new JTextField("0", 2);
        //jp.add(jt1);
        button[i][j] = jt1;
        a[i][j] = Integer.parseInt(button[i][j].getText());
        s[i][j] = a[i][j];
        jp.add(button[i][j]);
      }
    }

    /*    getContentPane().add(jp);
    setSize(500,500);
    setVisible(true);*/
    try {
      //logic start
      for (i = 0; i < 9; i++) //displaying element
      {
        for (j = 0; j < 9; j++) {
          System.out.print(s[i][j]);
        }
        System.out.print("\n");
      }

      for (i = 0; i < 9; i++) {
        for (j = 0; j < 9; j++) {
          if (a[i][j] == 0) //	System.out.println(a[i][j]);
          //	else
          {
            //System.out.print("\n");

            //v=s[i][j]++;
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
                //if(i==0&&j==0)
                //break;

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




    } catch (Exception e) {
      System.out.println("error1" + e);
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
        button[i][j].setEditable(false);//text field can be seen but can not be modified
      }
    }
    getContentPane().add(jp);
    setSize(500, 500);
    setVisible(true);
  }

  public static void main(String arg[]) {
    new Sudokugen();
  }
}
