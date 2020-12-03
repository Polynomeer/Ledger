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

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
