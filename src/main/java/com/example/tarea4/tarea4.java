package com.example.tarea4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class tarea4 {

    int size_debit = 15;
    int size_credit = 10;
    int size_eliminate = 5;
    int[] debit_arr = new int[size_debit];
    int[] credit_arr = new int[size_credit];
    int[] eliminate_arr = new int[size_eliminate];

    @RequestMapping("/")
    public String index(@RequestParam Integer[] debits, Integer[] credits, Integer[] eliminations) {
        setArrays(debits, credits, eliminations);
        return
                "El total de Débitos es: " + totalDebit() + "<br>"
                + "El total de Créditos es: " + totalCredit() + "<br>"
                + "El total de Saldo es: " + saldo() + "<br>"
                + "El promedio de Débitos es: " + avgDebit() + "<br>"
                + "El monto de Débitos más grande es: " + maxDebit() + "<br>"
                + "El total de operaciones es: " + totalTransactions() + "<br>"
                + "Débitos: " + Arrays.toString(printDebit()) + "<br>"
                + "Créditos: " + Arrays.toString(printCredit()) + "<br>" + "<br>"
                + "Después de eliminar:" + eliminate() + "<br>"
                + "El total de Débitos es: " + totalDebit() + "<br>"
                + "El total de Créditos es: " + totalCredit() + "<br>"
                + "El total de Saldo es: " + saldo() + "<br>"
                + "El promedio de Débitos es: " + avgDebit() + "<br>"
                + "El monto de Débitos más grande es: " + maxDebit() + "<br>"
                + "El total de operaciones es: " + totalTransactions();
    }

    public int totalDebit() {
        int total_debit = 0;
        for (int value : debit_arr) {
            total_debit = total_debit + value;
        }
        return total_debit;
    }

    public int totalCredit() {
        int total_credit = 0;
        for (int value : credit_arr) {
            total_credit = total_credit + value;
        }
        return total_credit;
    }

    public int saldo() {
        return totalDebit() - totalCredit();
    }

    public double avgDebit() {
        int n = 0;
        for (int value : debit_arr) {
            if (value != 0) {
                n++;
            }
        }
        return (1.0 * totalDebit()) / n;
    }

    public int maxDebit() {
        int max = debit_arr[0];
        for (int i = 1; i < debit_arr.length; i++) {
            if (debit_arr[i] > max) {
                max = debit_arr[i];
            }
        }
        return max;
    }

    public int totalTransactions() {
        int transactions = 0;
        for (int value : debit_arr) {
            if (value != 0) {
                transactions++;
            }
        }
        for (int value : credit_arr) {
            if (value != 0) {
                transactions++;
            }
        }
        return transactions;
    }

    public int[] printDebit() {
        return debit_arr;
    }

    public int[] printCredit() {
        return credit_arr;
    }

    public String eliminate() {
        for (int value : eliminate_arr) {
            if (value > 0) {
                debit_arr[value - 1] = 0;
                credit_arr[value - 1] = 0;
            }
        }
        return "";
    }

    public void setArrays(Integer[] debits, Integer[] credits, Integer[] eliminations) {
        for (int i = 0; i < debits.length; i++) {
            debit_arr[i] = debits[i];
        }
        for (int i = 0; i < credits.length; i++) {
            credit_arr[i] = credits[i];
        }
        for (int i = 0; i < eliminations.length; i++) {
            eliminate_arr[i] = eliminations[i];
        }
    }

}
