package atto;

public class Main {
    public static void main(String[] args) {
        Managing managing = new Managing();
        managing.setFaire(2000);

        Card card1 = managing.addCard(1, 5600);
        Card card2 = managing.addCard(2, 5800);
        Card card3 = managing.addCard(3, 15000);
        Card card4 = managing.addCard(4, 25000);

        System.out.println(managing.getCard(2));

        System.out.println(managing.recharge(1, 8000));


        Card[] cards = managing.getCardList();
        for (Card card : cards) {
            if (card != null) {
                System.out.println(card);
            }
        }

        Terminal terminal1 = managing.addTerminal(1, "Northern line");
        Terminal terminal2 = managing.addTerminal(2, "Victoria line");
        Terminal terminal3 = managing.addTerminal(3, "Jubilee line");
        Terminal terminal4 = managing.addTerminal(4, "District line");
        Terminal terminal5 = managing.addTerminal(5, "Piccadilly line");

        System.out.println(managing.getTerminalById(3));

        Terminal[] terminals = managing.terminalList();
        for (Terminal terminal : terminals) {
            if (terminal != null) {
                System.out.println(terminal);
            }
        }

        System.out.println(managing.getCard(3));
        Transaction transaction = managing.makeTransaction(2, 3);
        System.out.println(transaction);

        Transaction transaction1 = managing.makeTransaction(2, 3);
        System.out.println(transaction1); // null -> 1 minutdan oshmadi hali

        System.out.println(managing.getCard(2));
        Transaction transaction3 = managing.makeTransaction(2, 2);
        System.out.println(transaction3);

        System.out.println(managing.getById(transaction3.getId()));

        Transaction[] transactionList = managing.transactionListByTerminal(2);
        for (Transaction t : transactionList) {
            if (t != null) {
                System.out.println(t);
            }
        }

        Transaction[] transactionCardList = managing.transactionListByCard(3);
        for (Transaction t : transactionCardList) {
            if (t != null) {
                System.out.println(t);
            }
        }

        Transaction[] transactionList1 = managing.getTransactionsByDate("2024.11.17");
        for (Transaction t : transactionList1) {
            if (t != null) {
                System.out.println(t);
            }
        }

        Transaction[] transactionList2 = terminal2.transactionsList();
        for (Transaction t : transactionList2) {
            if (t != null) {
                System.out.println(t);
            }
        }

        System.out.println(terminal1.getAmountByDay("2024.11.17"));

        System.out.println(card1.getTransactionAmountByDay("2024.11.17"));

    }
}
