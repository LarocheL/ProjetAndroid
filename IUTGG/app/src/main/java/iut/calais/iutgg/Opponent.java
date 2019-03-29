package iut.calais.iutgg;

class Opponent {
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ConcreteOpponent getOpponent() {
        return opponent;
    }

    public void setOpponent(ConcreteOpponent opponent) {
        this.opponent = opponent;
    }

    ConcreteOpponent opponent;
}
