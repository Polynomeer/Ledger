package beans;

import java.util.Date;

public class Ledger {
    private int lid;
    private Date date;
    private String method;
    private String type;
    private String item;
    private String description;
    private String location;
    private int credit;
    private int debit;
    private int balance;

    public Ledger(int lid, Date date, String method, String type, String item, String description, String location, int credit, int debit, int balance) {
        this.lid = lid;
        this.date = date;
        this.method = method;
        this.type = type;
        this.item = item;
        this.description = description;
        this.location = location;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public int getLid() {
        return lid;
    }

    public Date getDate() {
        return date;
    }

    public String getMethod() {
        return method;
    }

    public String getType() {
        return type;
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }

    public int getBalance() {
        return balance;
    }

}
