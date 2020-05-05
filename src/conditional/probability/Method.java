/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditional.probability;

import java.text.DecimalFormat;

/**
 *
 * @author halla
 */
public class Method {

    Data head;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void insert(String patient_id, String test_r, String has_c) {
        Data data = new Data();
        data.patient_id = patient_id;
        data.test_r = test_r;
        data.has_c = has_c;

        if (head == null) {
            head = data;
        } else {
            Data d = head;
            while (d.next != null) {
                d = d.next;
            }
            d.next = data;
        }
    }

    public void show() {
        Data d = head, d2 = head;

        int size = 0;

        while (d2.next != null) {
            size++;
            d2 = d2.next;
        }

        if (d == null) {
            System.out.println("NO DATA FOUND!");
        } else {
            int x = 1;
            while (d.next != null) {
                if (x == 1) {
                    System.out.println(d.patient_id + "\t" + d.test_r + "\t" + d.has_c);
                    d = d.next;
                    x++;
                } else {
                    System.out.println(d.patient_id + "\t\t" + d.test_r + "\t" + d.has_c);
                    d = d.next;
                }
            }
            System.out.println(d.patient_id + "\t\t" + d.test_r + "\t" + d.has_c);
        }

    }

    public void count() {
        Data d = head, d2 = head;
        double size = 0;

        while (d2.next != null) {
            size++;
            d2 = d2.next;
        }

        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        while (d.next != null) {
            if (d.test_r.equalsIgnoreCase("Positive") && d.has_c.equalsIgnoreCase("True")) {
                c1++;
            } else if (d.test_r.equalsIgnoreCase("Negative") && d.has_c.equalsIgnoreCase("False")) {
                c2++;
            } else if (d.test_r.equalsIgnoreCase("Positive") && d.has_c.equalsIgnoreCase("False")) {
                c3++;
            } else if (d.test_r.equalsIgnoreCase("Negative") && d.has_c.equalsIgnoreCase("True")) {
                c4++;
            }
            d = d.next;
        }

        if (d.test_r.equalsIgnoreCase("Positive") && d.has_c.equalsIgnoreCase("True")) {
            c1++;
        } else if (d.test_r.equalsIgnoreCase("Negative") && d.has_c.equalsIgnoreCase("False")) {
            c2++;
        } else if (d.test_r.equalsIgnoreCase("Positive") && d.has_c.equalsIgnoreCase("False")) {
            c3++;
        } else if (d.test_r.equalsIgnoreCase("Negative") && d.has_c.equalsIgnoreCase("True")) {
            c4++;
        }

        System.out.println("");
        System.out.println("|------------------------------------------|");
        System.out.println("| has_cancer | test_result | patient_count |");
        System.out.println("|------------------------------------------|");
        System.out.println("|    False   |   Negative  |       " + c2 + "      |");
        System.out.println("|    False   |   Positive  |       " + c3 + "      |");
        System.out.println("|    True    |   Negative  |       " + c4 + "      |");
        System.out.println("|    True    |   Positive  |       " + c1 + "      |");
        System.out.println("|------------------------------------------|");

        System.out.println("");

        double num1 = c1 / size;
        double num2 = c3 / size;
        double num3 = c4 / size;
        double num4 = c2 / size;

        System.out.println("1. P(patients tested 'POSITIVE' | has cancer) = ("
                + c1 + "/" + Math.round(size) + ") = " + df2.format(num1));
        System.out.println("2. P(patients tested 'POSITIVE' | does not have cancer) = ("
                + c3 + "/" + Math.round(size) + ") = " + df2.format(num2));
        System.out.println("3. P(patients tested 'NEGATIVE' | has cancer) = "
                + c4 + "/" + Math.round(size) + ") = " + df2.format(num3));
        System.out.println("4. P(patients tested 'NEGATIVE' | does not have cancer) = "
                + c2 + "/" + Math.round(size) + ") = " + df2.format(num4));
    }

}
