package atto;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private Card card;
    private Terminal terminal;
    private double fair;
    private LocalDateTime creatDate;

    public Card getCard() {
        return card;
    }

    public double getFair() {
        return fair;
    }

    public void setFair(double fair) {
        this.fair = fair;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public LocalDateTime getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(LocalDateTime creatDate) {
        this.creatDate = creatDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", card=" + card +
                ", terminal=" + terminal +
                ", fair=" + fair +
                ", creatDate=" + creatDate +
                '}';
    }
}