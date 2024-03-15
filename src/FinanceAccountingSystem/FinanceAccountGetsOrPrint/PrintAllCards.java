package FinanceAccountingSystem.FinanceAccountGetsOrPrint;

import FinanceAccountingSystem.financeEntities.FinanceAccount;

import java.util.ArrayList;
import java.util.List;

public class PrintAllCards {
    public static void print(){
        List<FinanceAccount> list = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : list){
            System.out.println(a + "\n");
        }
    }

    public static void printSecond(List<FinanceAccount> list){
        for (FinanceAccount a : list){
            System.out.println(a + "\n");
        }
    }
}
