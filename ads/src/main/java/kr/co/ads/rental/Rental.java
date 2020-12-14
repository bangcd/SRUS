package kr.co.ads.rental;

import java.io.Serializable;
import java.time.LocalDate;

public class Rental implements Serializable {
    private int no;
    private String memberId;
    private int rentalBoxNo;
    private LocalDate paymentDate;
    private int amountOfPayment;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate cancellationDate;

    public Rental() {
    }

    public Rental(int no, String memberId, int rentalBoxNo, LocalDate paymentDate, int amountOfPayment, LocalDate startDate, LocalDate endDate, LocalDate cancellationDate) {
        this.no = no;
        this.memberId = memberId;
        this.rentalBoxNo = rentalBoxNo;
        this.paymentDate = paymentDate;
        this.amountOfPayment = amountOfPayment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationDate = cancellationDate;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return this.no;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setRentalBoxNo(int rentalBoxNo) {
        this.rentalBoxNo = rentalBoxNo;
    }

    public int getRentalBoxNo() {
        return this.rentalBoxNo;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    public void setAmountOfPayment(int amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    public int getAmountOfPayment() {
        return this.amountOfPayment;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public LocalDate getCancellationDate() {
        return this.cancellationDate;
    }
}
