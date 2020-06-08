import enums.PaymentMethod;
import enums.PaymentStatus;

import java.math.BigDecimal;

public class Payment extends ObjectPlusPlus{

    private int id;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private BigDecimal amount;

    public Payment(int id, PaymentMethod paymentMethod, PaymentStatus paymentStatus, BigDecimal amount) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.STARTED;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentMethod=" + paymentMethod +
                ", paymentStatus=" + paymentStatus +
                ", amount=" + amount +
                '}';
    }
}
