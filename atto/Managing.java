package atto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Managing {
    // Card Array
    Card[] cards = new Card[10];
    int cardIndex = 0;

    // Terminal Array
    Terminal[] terminals = new Terminal[10];
    int terminalIndex = 0;

    //Transaction Array
    Transaction[] transactions = new Transaction[10];
    int transactionIndex = 0;

    //Transaction id
    private int generalId = 1;

    private double fair;

    public void setFaire(double fair) {
        this.fair = fair;
    }

    public Card addCard(Integer id, double balance) {
        Card card = new Card();
        card.setId(id);
        card.setBalance(balance);

        if (cardIndex == cards.length) {
            Card[] newCards = new Card[cards.length * 2];
            for (int i = 0; i < cards.length; i++) {
                newCards[i] = cards[i];
            }
            cards = newCards;
        }
        cards[cardIndex++] = card;

        return card;
    }

    public Card getCard(Integer id) {
        for (int i = 0; i < cards.length; i++) {
            Card card = cards[i];
            if (card != null && card.getId().equals(id)) {
                return card;
            }
        }
        return null;
    }

    public Card recharge(Integer id, double amount) {
        Card card = getCard(id);
        if (card == null) {
            return null;
        }
        //double newBalance = card.getBalance() + amount;
        card.setBalance(card.getBalance() + amount);
        return card;
    }

    public Card[] getCardList() {
        return cards;
    }

    public Terminal addTerminal(Integer id, String address) {
        Terminal terminal = new Terminal();
        terminal.setId(id);
        terminal.setAddress(address);

        if (terminalIndex == terminals.length) {
            Terminal[] newTerminals = new Terminal[terminals.length * 2];
            for (int i = 0; i < terminals.length; i++) {
                newTerminals[i] = terminals[i];
            }
            terminals = newTerminals;
        }
        terminals[terminalIndex++] = terminal;

        return terminal;
    }

    public Terminal getTerminalById(Integer id) {
        for (Terminal terminal : terminals) {
            if (terminal != null && terminal.getId().equals(id)) {
                return terminal;
            }
        }
        return null;
    }

    public Terminal[] terminalList() {
        return terminals;
    }

    public Transaction makeTransaction(Integer terminalId, Integer cardId) {
        // 1. null  agar terminal topilmasa

        Terminal terminal = getTerminalById(terminalId);
        if (terminal == null) {
            return null;
        }

        // 2. null agar  carta topilmasa
        Card card = getCard(cardId);
        if (card == null) {
            return null;
        }

        // 3. null agar cartada yetarli pul bo'lmasa
        if (card.getBalance() < fair) {
            return null;
        }

        // 4. null agar shu 1 munit ichida  terminal va carta dan qayta foydalanilsa
        LocalDateTime checkTime = LocalDateTime.now().minusDays(1);
        for (Transaction t : transactions) {
            if (t != null && t.getCard().getId().equals(cardId) && t.getTerminal().getId().equals(terminalId)
                    && t.getCreatDate().isAfter(checkTime)) {
                return null;
            }
        }


        // 5.  agar hammasi to'g'ri bo'lsa  Transaction objecti
        Transaction transaction = new Transaction();
        transaction.setId(generalId++);
        transaction.setCard(card);
        transaction.setTerminal(terminal);
        transaction.setFair(fair);
        transaction.setCreatDate(LocalDateTime.now());
        terminal.addTransaction(transaction);
        card.addTransaction(transaction);

        if (transactionIndex == transactions.length) {
            Transaction[] newTransactions = new Transaction[transactions.length * 2];
            for (int i = 0; i < transactions.length; i++) {
                newTransactions[i] = transactions[i];
            }
            transactions = newTransactions;
        }
        transactions[transactionIndex++] = transaction;

        //6. Carddan yo`lkira haqqi yechib olinishi kerak
        card.setBalance(card.getBalance() - fair);

        return transaction;
    }

    public Transaction getById(Integer id) {
        for (Transaction t : transactions) {
            if (t != null && t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    //  terminal id bo'yicha barcha  transaction lar
    public Transaction[] transactionListByTerminal(Integer terminalId) {
        int i = 0;
        Transaction[] tempArr = new Transaction[transactionIndex];
        for (Transaction t : transactions) {
            if (t != null && t.getTerminal().getId().equals(terminalId)) {
                tempArr[i++] = t;
            }
        }
        return tempArr;
    }

    //  carta id si  bo'yicha barcha  transaction lar
    public Transaction[] transactionListByCard(Integer cardId) {
        int i = 0;
        Transaction[] tempArr = new Transaction[transactionIndex];
        for (Transaction t : transactions) {
            if (t != null && t.getCard().getId().equals(cardId)) {
                tempArr[i++] = t;
            }
        }
        return tempArr;
    }

    // kun bo'yicha barcha transaction lar (yyyy.MM.dd    keladigan  kun formati)
    public Transaction[] getTransactionsByDate(String dateStr) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDate2 = LocalDate.parse(dateStr, formatter);
        Transaction[] tempArr = new Transaction[transactionIndex];
        int i = 0;
        for (Transaction t : transactions) {
            if (t != null && t.getCreatDate().toLocalDate().isEqual(localDate2)) {
                tempArr[i++] = t;
            }
        }
        return tempArr;
    }

    // Transactionlar soni bo'yicha  terminallar ro'yxatini return qiling.
    public Terminal[] terminalList_orderedByTransactionsCount() {
        return null;
    }

    //  berilgan kunda  transaction lar soni bo'yicha tartiblangan terminallar yo'yxatini return qiling.
    public Terminal[] terminalList_orderedByTransactionsCount_aDay(String day) {
        return null;
    }

    // umumiy yo'l kira xaqqini olish
    public double getTotalFaire() {
        return 0.0;
    }

}
