package model;

import java.util.Date;

public class Transfer {

    private String sender;
    private String recipient;
    private double amount;
    private Date date;

    public Transfer(String sender, String recipient, double amount, Date date) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
