/*
 * @author = Amar Daxini
 * Email = amardaxini@gmail.com
 */
import java.io.*;

class Sudoku {

  int i, j, i1, j1, v = 0;
  int flag = 0;
  int a[][] = new int[9][9];
  int s[][] = new int[9][9];

  public static void main(String arg[]) {
    Sudoku s3 = new Sudoku();

    s3.calc();
  }

  public void calc() {

    DataInputStream in = new DataInputStream(System.in);

    try {

      for (i = 0; i < 9; i++) {
        for (j = 0; j < 9; j++) //assigning restart
        {
          v = Integer.parseInt(in.readLine());
          a[i][j] = v;
          s[i][j] = a[i][j];
        }
      }

      //logic start




      for (i = 0; i < 9; i++) {
        for (j = 0; j < 9; j++) {
          /*if no is 0 then start from increment value
          and check it this value present in row ,column,or 3x3 box yes set flag
          & continue increasing value if value>9 then back track where 0th
          value is present & increae that value start from that value this done
          by taking 2 array so previously 0th value can be track


           */
          if (a[i][j] == 0) {

            for (s[i][j]++; s[i][j] <= 9; s[i][j]++) {
              flag = 0;
              for (i1 = 0; i1 < 9; i1++) //go byrow if value found take
              // another value
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
            if (s[i][j] > 9) //it back track the zeroth position
            {                      //this is done recursively upto result not
              s[i][j] = 0;              //found
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
//if(i==8&&j==8)
      display();
    } catch (Exception e) {
      System.out.println("error1" + e);
    }
  }

  public void display() {

    for (i = 0; i < 9; i++) //displaying element
    {

      for (j = 0; j < 9; j++) {
        System.out.print(s[i][j]);
      }
      System.out.print("\n");
    }
    while (a[i][j] > 0) {
      //if(i==0&&j==0)goto nomoresol;
      if (j > 0) {
        j--;
      } else {
        j = 8;
        i--;
      }
    }
    s[i][j] = 0;
    do {
      //if(i==0&&j==0)goto nomoresol;
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
