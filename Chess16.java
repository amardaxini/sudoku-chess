/*
 * @author = Amar Daxini
 * Email = amardaxini@gmail.com
 */
import java.awt.*;
import javax.swing.*;
import java.awt.Image.*;
import java.awt.event.*;

class Chess16 extends JFrame implements ActionListener {

    JButton button[][] = new JButton[8][8];
    int x = 0, y = 0, z = 0, d;
    JButton but, first = null, sec = null;
    JPanel jp;
    boolean flag = true;
    JButton b1;
    int a[][] = new int[8][8];

    Chess16() {

        jp = new JPanel(new GridLayout(8, 8));
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {

                but = new JButton();
                //pawns
                if (i == 1) {
                    but = new JButton(new ImageIcon("pawn.gif"));
                }

                if (i == 6) {
                    but = new JButton(new ImageIcon("wpawn.gif"));
                }
                //bishops
                if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    but = new JButton(new ImageIcon("bbishop.gif"));
                }

                if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    but = new JButton(new ImageIcon("wbishop.gif"));
                }

                //ele
                if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    but = new JButton(new ImageIcon("bele.gif"));
                }
                if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    but = new JButton(new ImageIcon("wele.gif"));
                }
                //knight

                if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    but = new JButton(new ImageIcon("bknight.gif"));
                }
                if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    but = new JButton(new ImageIcon("wknight.gif"));
                }

                //queen
                if (i == 0 && j == 3) {
                    but = new JButton(new ImageIcon("bqueen.gif"));
                }
                if (i == 7 && j == 3) {
                    but = new JButton(new ImageIcon("wqueen.gif"));
                }
                //king
                if (i == 0 && j == 4) {
                    but = new JButton(new ImageIcon("bking.gif"));
                }
                if (i == 7 && j == 4) {
                    but = new JButton(new ImageIcon("wking.gif"));
                }

                if ((i + j) % 2 == 0) {
                    but.setBackground(Color.white);
                } else {
                    but.setBackground(Color.black);
                }


                jp.add(but);
                int k = 6, l = 12;

                for (int c = 1; c < 2; c++) {
                    for (int b = 0; b < 8; b++) {
                        a[c][b] = k;                 //Black pawn initialise to 6
                    }
                }

                a[0][0] = a[0][7] = 1;
                a[0][1] = a[0][6] = 2;
                a[0][2] = a[0][5] = 3;
                a[0][3] = 4;
                a[0][4] = 5;
                a[7][0] = 7;
                a[7][7] = 7;

                a[7][1] = a[7][6] = 8;

                a[7][2] = a[7][5] = 9;
                a[7][3] = 10;
                a[7][4] = 11;


                for (int m = 2; m < 6; m++) //Empty spaces made 0
                {
                    for (int n = 0; n < 8; n++) {
                        a[m][n] = 0;
                    }
                }

                for (int x = 6; x < 7; x++) //pawns = l=12
                {
                    for (int y = 0; y < 8; y++) {
                        a[x][y] = l;
                    }
                }

                button[i][j] = but;
                but.addActionListener(this);

            }
        }
        getContentPane().add(jp);


        setSize(500, 500);
        pack();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {


        b1 = (JButton) e.getSource();
        if (flag) {
            first = b1;

            flag = false;
        } else {
            flag = true;
            sec = b1;
            int firsti = 0, firstj = 0, seci = 0, secj = 0;
            for (int i = 0; i < 8; i++) {

                for (int j = 0; j < 8; j++) {
                    if (button[i][j] == first) {
                        firsti = i;
                        firstj = j;
                    }
                    if (button[i][j] == sec) {
                        seci = i;
                        secj = j;
                    }
                }


            }
            //initialise condition
            if (a[firsti][firstj] == 12) //whitepawn
            {
                x = a[seci][secj];
                if ((seci == firsti - 1) && (x == 0) && (firstj == secj)) {
                    a[seci][secj] = 12;
                    a[firsti][firstj] = 0;
                    sec.setIcon(first.getIcon());
                    first.setIcon(new ImageIcon(""));
                } else if ((x < 7) && (x > 0) && (secj == (firstj - 1) || secj == (firstj + 1))) {

                    if (seci == firsti - 1) {
                        a[seci][secj] = 12;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid");
                    }


                }
            }
            if (a[firsti][firstj] == 6) //blackpawn
            {
                x = a[seci][secj];
                if ((seci == firsti + 1) && (x == 0) && (firstj == secj)) {
                    a[seci][secj] = 6;
                    a[firsti][firstj] = 0;

                    sec.setIcon(first.getIcon());
                    first.setIcon(new ImageIcon(""));
                } else if ((x > 7) && (((secj == (firstj - 1)) || (secj == (firstj + 1))))) {

                    if (seci == firsti + 1) {
                        a[seci][secj] = 6;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid");
                    }
                }
            }
            if (a[firsti][firstj] == 7) //white el
            {
                if ((seci > firsti) && (firstj == secj)) {                                //vertical down
                    for (d = firsti; d < seci; d++) {
                        firsti = firsti + 1;
                        if (firsti == 8 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if (d == seci && a[seci][secj] < 7) {
                        a[seci][secj] = 7;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }

                if ((seci < firsti) && (firstj == secj)) {                           //vertical  up
                    for (d = firsti; d > seci; d--) {
                        firsti = firsti - 1;
                        if (firsti < 0 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if (d == seci && a[seci][secj] < 7) {
                        a[seci][secj] = 7;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if ((secj > firstj) && (firsti == seci)) //horizontal rhs
                {
                    for (d = firstj; d < secj; d++) {
                        firstj = firstj + 1;
                        if (firstj == 8 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if (d == secj && a[seci][secj] < 7) {
                        a[seci][secj] = 7;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if ((secj < firstj) && (firsti == seci)) {                    //horizontal lhs
                    for (d = firstj; d > secj; d--) {
                        firstj = firstj - 1;
                        if (firstj < 0 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if (d == secj && a[seci][secj] < 7) {
                        a[seci][secj] = 7;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
            }
            if (a[firsti][firstj] == 1) // blackele
            {
                if ((seci > firsti) && (firstj == secj)) {                                //vertical down
                    for (d = firsti; d < seci; d++) {
                        firsti = firsti + 1;
                        if (firsti == 8 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if (d == seci && a[seci][secj] > 7) {
                        a[seci][secj] = 1;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }

                if ((seci < firsti) && (firstj == secj)) {                           //vertical  up
                    for (d = firsti; d > seci; d--) {
                        firsti = firsti - 1;
                        if (firsti < 0 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if (d == seci && a[seci][secj] > 7) {
                        a[seci][secj] = 1;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if ((secj > firstj) && (firsti == seci)) //horizontal rhs
                {
                    for (d = firstj; d < secj; d++) {
                        firstj = firstj + 1;
                        if (firstj == 8 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if ((d == secj) && (a[seci][secj] > 7)) {
                        a[seci][secj] = 1;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if ((secj < firstj) && (firsti == seci)) {                    //horizontal lhs
                    for (d = firstj; d > secj; d--) {
                        firstj = firstj - 1;
                        if (firstj < 0 || a[firsti][firstj] != 0) {

                            JOptionPane.showMessageDialog(this, "Invalid");
                            break;
                        }
                    }
                    if (d == secj && a[seci][secj] > 7) {
                        a[seci][secj] = 1;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
            }

            if (a[firsti][firstj] == 8) //white knight
            {
                if (((seci == (firsti + 2)) || (seci == (firsti - 2))) && ((secj == firstj + 1) || (secj == firstj - 1))) {
                    if ((a[seci][secj] < 7) || (a[seci][secj] == 0)) {
                        a[seci][secj] = 8;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid");
                    }
                }
                if (((secj == (firstj + 2)) || (secj == (firstj - 2))) && ((seci == firsti + 1) || (seci == firsti - 1))) {
                    if (a[seci][secj] < 7 || a[seci][secj] == 0) {
                        a[seci][secj] = 8;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid");
                    }
                }
            }
            if (a[firsti][firstj] == 2) //black knight
            {
                if (((seci == (firsti + 2)) || (seci == (firsti - 2))) && ((secj == firstj + 1) || (secj == firstj - 1))) {
                    if (a[seci][secj] > 7 || a[seci][secj] == 0) {
                        a[seci][secj] = 2;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid");
                    }
                }
                if (((secj == (firstj + 2)) || (secj == (firstj - 2))) && ((seci == firsti + 1) || (seci == firsti - 1))) {
                    if (a[seci][secj] > 7 || a[seci][secj] == 0) {
                        a[seci][secj] = 2;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid");
                    }	//	   	JOptionPane.showMessageDialog(this,"Invalid");
                }
            }

            if (a[firsti][firstj] == 11) //white king
            {

                if (((seci == firsti + 1) || (seci == firsti - 1)) && (secj == firstj)) {
                    if (a[seci][secj] < 7) {
                        a[seci][secj] = 11;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if (((secj == firstj + 1) || (secj == firstj - 1)) && (seci == firsti)) {
                    if (a[seci][secj] < 7) {
                        a[seci][secj] = 11;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if (((secj == firstj + 1) || (secj == firstj - 1)) && ((seci == firsti + 1) || (seci == firsti - 1))) {
                    if (a[seci][secj] < 7) {

                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }

            }
            if (a[firsti][firstj] == 5) //black king
            {

                if (((seci == firsti + 1) || (seci == firsti - 1)) && (secj == firstj)) {
                    if (a[seci][secj] > 7) {
                        a[seci][secj] = 5;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if (((secj == firstj + 1) || (secj == firstj - 1)) && (seci == firsti)) {
                    if (a[seci][secj] > 7) {
                        a[seci][secj] = 5;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
                if (((secj == firstj + 1) || (secj == firstj - 1)) && ((seci == firsti + 1) || (seci == firsti - 1))) {
                    if (a[seci][secj] > 7) {
                        a[seci][secj] = 5;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                }
            }
            if (a[firsti][firstj] == 9) // white bishop
            {
                if ((Math.abs(firsti - seci)) == (Math.abs(firstj - secj))) {
                    if ((a[seci][secj] < 7) || (a[seci][secj] == 0)) {
                        if (firsti < seci && firstj < secj) {

                            for (int h = firsti + 1, j = firstj + 1; h < seci && j < secj; h++, j++) {
                                if (Math.abs(firsti - h) == Math.abs(firstj - j)) {
                                    if (a[h][j] != 0) {
                                        JOptionPane.showMessageDialog(this, "Invalid");
                                    } else {
                                        a[seci][secj] = 9;
                                        a[firsti][firstj] = 0;
                                        sec.setIcon(first.getIcon());
                                        first.setIcon(new ImageIcon(""));
                                    }
                                }
                            }
                        }
                        if (firsti > seci && firstj < secj) {

                            for (int h = firsti - 1, j = firstj + 1; h < seci && j < secj; h--, j++) {
                                if (Math.abs(firsti - h) == Math.abs(firstj - j)) {
                                    if (a[h][j] != 0) {
                                        JOptionPane.showMessageDialog(this, "Invalid");
                                    } else {

                                        a[seci][secj] = 9;
                                        a[firsti][firstj] = 0;
                                        sec.setIcon(first.getIcon());
                                        first.setIcon(new ImageIcon(""));

                                    }
                                }
                            }
                        }
                        if (firsti > seci && firstj > secj) {

                            for (int h = firsti - 1, j = firstj - 1; h < seci && j < secj; h--, j--) {
                                if ((Math.abs(firsti - h)) == (Math.abs(firstj - j))) {
                                    if (a[h][j] != 0) {
                                        JOptionPane.showMessageDialog(this, "Invalid");
                                    } else {

                                        a[seci][secj] = 9;
                                        a[firsti][firstj] = 0;
                                        sec.setIcon(first.getIcon());

                                        first.setIcon(new ImageIcon(""));
                                    }
                                }
                            }
                        }
                        if (firsti < seci && firstj > secj) {

                            for (int h = firsti + 1, j = firstj - 1; h < seci && j < secj; h++, j--) {
                                if (Math.abs(firsti - h) == Math.abs(firstj - j)) {
                                    if (a[h][j] != 0) {

                                        JOptionPane.showMessageDialog(this, "Invalid");
                                    } else {

                                        a[seci][secj] = 9;
                                        a[firsti][firstj] = 0;
                                        sec.setIcon(first.getIcon());
                                        first.setIcon(new ImageIcon(""));
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid");
                        }

                    }
                }
            }
            if (a[firsti][firstj] == 3) // black bishop
            {
                if ((Math.abs(firsti - seci)) == (Math.abs(firstj - secj))) {
                    if ((a[seci][secj] < 7) || (a[seci][secj] == 0)) {

                        a[seci][secj] = 3;
                        a[firsti][firstj] = 0;
                        sec.setIcon(first.getIcon());
                        first.setIcon(new ImageIcon(""));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid");
                }
            }

            /*if(a[firsti][firstj]==10)
            {
            if(((Math.abs(firsti-seci))==(Math.abs(firstj-secj)))||(( (firsti==seci)&&(secj<8) )
            {
            }
            }*/


        }
    }

    public static void main(String arg[]) {
        new Chess16();
    }
}
