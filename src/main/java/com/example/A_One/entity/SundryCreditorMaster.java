package com.example.A_One.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sundry_creditor_master")
public class SundryCreditorMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sundry_creditor_name")
    private String sundryCreditorName;

    @Column(name = "under_group")
    private String underGroup;

    @Column(name = "bill_wise_status")
    private String billWiseStatus;

    @Column(name = "provide_bank_details")
    private String provideBankDetails;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_number")
    private BigInteger accountNumber;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "swift_code")
    private String swiftCode;

    @Column(name = "address_one")
    private String addressOne;

    @Column(name = "address_two")
    private String addressTwo;

    @Column(name = "address_three")
    private String addressThree;

    @Column(name = "address_four")
    private String addressFour;

    @Column(name = "address_five")
    private String addressFive;

    @Column(name = "land_mark_or_area")
    private String landMarkOrArea;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private Long pincode;

    @Column(name = "pan_or_it_number")
    private String panOrItNumber;

    @Column(name = "gst_number")
    private String gstinOrUinNumber;

    @Column(name = "msme_number")
    private String msmeNumber;

    @Column(name = "contact_person_name")
    private String contactPersonName;

    @Column(name = "mobile_number")
    private BigInteger mobileNumber;

    @Column(name = "landline_number")
    private String landlineNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "date_for_opening")
    private String dateForOpening;

    @Column(name = "opening_balance")
    private BigDecimal openingBalance;

    @Column(name = "credit_or_debit")
    private String creditOrDebit;

    @Column(name = "bill_wise_break_of")
    private String billWiseBreakOf;

    @Column(name = "upto_opening_balance_amount")
    private BigDecimal uptoOpeningBalanceAmount;

    @Column(name = "upto_credit_or_debit")
    private String uptoCreditOrDebit;

    @Column(name = "forex_date")
    private String forexDate;

    @Column(name = "reference_name")
    private String referenceName;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "forex_currency_type")
    private String forexCurrencyType;

    @Column(name = "forex_amount")
    private BigDecimal forexAmount;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;

    @Column(name = "reference_amount")
    private BigDecimal referenceAmount;

    @Column(name = "reference_credit_or_debit")
    private String referenceCreditOrDebit;
}