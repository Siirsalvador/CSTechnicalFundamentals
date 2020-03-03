package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-09
 */
public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        if (transactions == null || transactions.length == 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            if (amountOverAThousand(transactions[i]) || relatedToAnotherTrans(i, transactions)) {
                res.add(transactions[i]);
            }
        }

        return res;
    }

    private boolean amountOverAThousand(String transaction) {
        String[] tranArr = transaction.split(",");
        return Integer.valueOf(tranArr[2]) > 1000;
    }

    private boolean relatedToAnotherTrans(int i, String[] transactions) {
        String tran = transactions[i];
        String[] tranArr = tran.split(",");

        for (int j = 0; j < transactions.length; j++) {
            if (i == j) continue;

            String[] aTrans = transactions[j].split(",");
            int diff = Math.abs(Integer.valueOf(aTrans[1]) - Integer.valueOf(tranArr[1]));
            if (diff <= 60 && tranArr[0].equals(aTrans[0]) && !tranArr[3].equals(aTrans[3])) {
                return true;
            }
        }

        return false;
    }
}
