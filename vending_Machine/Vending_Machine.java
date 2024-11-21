package vending_Machine;

public class Vending_Machine {
    // Beverage
    private Beverage[] beverages = new Beverage[10];
    private int beverageIndex = 0;

    // Card
    private Card[] cards = new Card[10];
    private int cardIndex = 0;

    // Column
    private Column[] columns = new Column[4];

    public Vending_Machine() {

    }

    public void addBeverage(String name, double price) {
        Beverage beverage = new Beverage();
        beverage.setName(name);
        beverage.setPrice(price);

        if (beverageIndex == beverages.length) {
            Beverage[] newArr = new Beverage[beverages.length * 2];
            for (int i = 0; i < beverages.length; i++) {
                newArr[i] = beverages[i];
            }
            beverages = newArr;
        }
        beverages[beverageIndex++] = beverage;
    }

    public double getPrice(String beverageName) {
        for (Beverage beverage : beverages) {
            if (beverage != null && beverage.getName().equals(beverageName)) {
                return beverage.getPrice();
            }
        }
        return -1.0;
    }

    public void rechargeCard(int cardId, double credit) {
        Card card = getCardById(cardId);
        if (card == null) {
            Card newCard = new Card();
            newCard.setId(cardId);
            newCard.setCredit(credit);
            cards[cardIndex++] = newCard;

            if (cardIndex == cards.length) {
                Card[] newArr = new Card[cards.length * 2];
                for (int i = 0; i < cards.length; i++) {
                    newArr[i] = cards[i];
                }
                cards = newArr;
            }
        } else {
            card.setCredit(card.getCredit() + credit);
        }
    }

    public Card getCardById(Integer cardId) {
        for (Card card : cards) {
            if (card != null && card.getId().equals(cardId)) {
                return card;
            }
        }
        return null;
    }

    public double getCredit(int cardId) {
        for (Card card : cards) {
            if (card != null && card.getId().equals(cardId)) {
                return card.getCredit();
            }
        }
        return -1.0;
    }

    public void refillColumn(int column, String beverageName, int cans) {
        Column column1 = new Column();
        column1.setColumn(column);
        column1.setBeverageName(beverageName);
        column1.setCans(cans);

        columns[column - 1] = column1;
    }

    public int availableCans(String beverageName) {
        int count = 0;
        for (Column column : columns) {
            if (column != null && column.getBeverageName().equals(beverageName)) {
                count += column.getCans();
            }
        }
        return count;
    }

    public int sell(String beverageName, int cardId) {
        Beverage beverage = getBeverageByName(beverageName);
        Card card = getCardById(cardId);
        Column column = getColumnByBeverageName(beverageName);
        if (beverage == null || card == null || column == null || card.getCredit() < beverage.getPrice()) {
            return -1;
        }

        card.setCredit(card.getCredit() - beverage.getPrice());

        column.setCans(column.getCans() - 1);

        return column.getColumn();
    }

    public Beverage getBeverageByName(String beverageName) {
        for (Beverage beverage : beverages) {
            if (beverage != null && beverage.getName().equals(beverageName)) {
                return beverage;
            }
        }
        return null;
    }

    public Column getColumnByBeverageName(String beverageName) {
        for (Column column : columns) {
            if (column != null && column.getBeverageName().equals(beverageName) && column.getCans() > 0) {
                return column;
            }
        }
        return null;
    }
}