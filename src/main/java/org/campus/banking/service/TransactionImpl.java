package org.campus.banking.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * The main implementation for `Transaction` interface.
 * 
 * @author Alireza Dastyar
 */
class TransactionImpl implements Transaction{


    private static long id = 0;

    private final long transactionId;
    private final BankAccount account;
    private final Type type;
    private final long amount;
    private final Consumer<Long> action;
    private final Consumer<Long> reverse;
    private Status status;
    private LocalDateTime date;

    TransactionImpl(BankAccount account, Type type, long amount, Consumer<Long> action, Consumer<Long> reverse) {
        this.transactionId = ++TransactionImpl.id;
        this.status = Status.PENDING;
        this.account = account;
        this.amount = amount;
        this.type = type;
        this.action = action;
        this.reverse = reverse;
    }

    @Override
    public void execute() {
        if (this.status == Status.PENDING) {
            action.accept(this.amount);
            this.date = LocalDateTime.now();
            this.status = Status.COMPLETED;
        }
    }
    
    @Override
    public void rollback() {
        if (this.status == Status.COMPLETED) {
            reverse.accept(this.amount);
            this.status = Status.CANCELED;
        }
    }

    @Override
    public long getTransactionId() {
        return this.transactionId;
    }

    @Override
    public BankAccount getAccount() {
        return this.account;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public Optional<LocalDateTime> getDate() {
        return Optional.ofNullable(this.date);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.transactionId ^ (this.transactionId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransactionImpl other = (TransactionImpl) obj;
        return this.transactionId == other.transactionId;
    }
}
