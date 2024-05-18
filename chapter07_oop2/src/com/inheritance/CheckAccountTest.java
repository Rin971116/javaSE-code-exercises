package com.inheritance;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/20 下午 07:28
 * @Version 1.0
 */
public class CheckAccountTest {

    public static void main(String[] args) {
        CheckAccount creditCard = new CheckAccount(1122,20000,0.045,5000);

        creditCard.withdraw(5000);
        creditCard.show(creditCard.getBalance(),creditCard.getOverdraft());

        creditCard.withdraw(18000);
        creditCard.show(creditCard.getBalance(),creditCard.getOverdraft());

        creditCard.withdraw(3000);
        creditCard.show(creditCard.getBalance(),creditCard.getOverdraft());
    }
}
