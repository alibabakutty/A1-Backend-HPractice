package com.example.A_One.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "voucher_type_master")
public class VoucherTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "voucher_type_name")
    private String voucherTypeName;

    @Column(name = "voucher_type")
    private String voucherType;

    @Column(name = "starting_number")
    private Long startingNumber;

    @Column(name = "width_of_numerical_part")
    private Long widthOfNumericalPart;

    @Column(name = "prefill_with_zero")
    private String prefillWithZero;

    @Column(name = "restart_numbering_application_form")
    private String restartNumberingApplicationForm;

    @Column(name = "restart_numbering_starting_number")
    private Long restartNumberingStartingNumber;

    @Column(name = "restart_numbering_periodicity")
    private String restartNumberingPeriodicity;

    @Column(name = "prefix_details_application_form")
    private String prefixDetailsApplicationForm;

    @Column(name = "prefix_details_particulars")
    private String prefixDetailsParticulars;

    @Column(name = "suffix_details_application_form")
    private String suffixDetailsApplicationForm;

    @Column(name = "suffix_details_particulars")
    private String suffixDetailsParticulars;

}
