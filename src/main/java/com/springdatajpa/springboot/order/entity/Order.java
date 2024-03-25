package com.springdatajpa.springboot.order.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "order_checksum")
    private String orderChecksum;

    @Column(name = "order_token")
    private String orderToken;

    @Column(name = "order_type", nullable = false)
    private Integer orderType;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column(name = "parent_order_number")
    private String parentOrderNumber;

    @Column(name = "receipt_number")
    private String receiptNumber;

    @Column(name = "channel", nullable = false)
    private Integer channel;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "parent_organization_id")
    private Long parentOrganizationId;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "purchase_order_number")
    private String purchaseOrderNumber;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_type", nullable = false)
    private Integer userType;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "floating_balance", nullable = false)
    private BigDecimal floatingBalance;

    @Column(name = "available_balance", nullable = false)
    private BigDecimal availableBalance;

    @Column(name = "last_pull_time")
    private LocalDateTime lastPullTime;

    @Column(name = "phone")
    private String phone;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "estimated_tax", nullable = false)
    private BigDecimal estimatedTax;

    @Column(name = "items_subtotal", nullable = false)
    private BigDecimal itemsSubtotal;

    @Column(name = "shipping_handling_charge", nullable = false)
    private BigDecimal shippingHandlingCharge;

    @Column(name = "partial_refund_total")
    private BigDecimal partialRefundTotal;

    @Column(name = "grand_total_collected", nullable = false)
    private BigDecimal grandTotalCollected;

    @Column(name = "total_discount", nullable = false)
    private BigDecimal totalDiscount;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "refunded_amount", nullable = false)
    private BigDecimal refundedAmount;

    @Column(name = "shipping_label_cost")
    private BigDecimal shippingLabelCost;

    @Column(name = "shipping_first_name")
    private String shippingFirstName;

    @Column(name = "shipping_last_name")
    private String shippingLastName;

    @Column(name = "shipping_phone")
    private String shippingPhone;

    @Column(name = "shipping_email")
    private String shippingEmail;

    @Column(name = "cancelled_tax")
    private BigDecimal cancelledTax;

    @Column(name = "cancelled_amount")
    private BigDecimal cancelledAmount;

    @Column(name = "gift", nullable = false)
    private Integer gift;

    @Column(name = "gift_message")
    private String giftMessage;

    @Column(name = "gift_recipient_email")
    private String giftRecipientEmail;

    @Column(name = "ship_from_location_id")
    private String shipFromLocationId;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "post_box")
    private String postBox;

    @Column(name = "shipping_label")
    private String shippingLabel;

    @Column(name = "suite")
    private String suite;

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "is_tax_exempt", nullable = false)
    private Boolean isTaxExempt;

    @Column(name = "tax_exempt_id", nullable = false)
    private Long taxExemptId;

    @Column(name = "customer_account_number", nullable = false)
    private Integer customerAccountNumber;

    @Column(name = "parent_customer_account_number", nullable = false)
    private Integer parentCustomerAccountNumber;

    @Column(name = "sales_rep_id", nullable = false)
    private String salesRepId;

    @Column(name = "tax_rate", nullable = false)
    private BigDecimal taxRate;

    @Column(name = "tax_state", nullable = false)
    private String taxState;

    @Column(name = "refunded_tax", nullable = false)
    private BigDecimal refundedTax;

    @Column(name = "service_level", nullable = false)
    private String serviceLevel;

    @Column(name = "carrier", nullable = false)
    private String carrier;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "attention")
    private String attention;

    @Column(name = "aftersales_status")
    private Integer aftersalesStatus;

    @Column(name = "return_value")
    private BigDecimal returnValue;

    @Column(name = "tax_return_value")
    private BigDecimal taxReturnValue;

    @Column(name = "appeasement_discount")
    private BigDecimal appeasementDiscount;

    @Column(name = "appeasement_discount_tax")
    private BigDecimal appeasementDiscountTax;

    @Column(name = "refunded_shipping_fee")
    private BigDecimal refundedShippingFee;

    @Column(name = "refunded_shipping_tax")
    private BigDecimal refundedShippingTax;

    @Column(name = "shipping_fee_return_value")
    private BigDecimal shippingFeeReturnValue;

    @Column(name = "shipping_tax_return_value")
    private BigDecimal shippingTaxReturnValue;

    @Column(name = "handling_fee")
    private BigDecimal handlingFee;

    @Column(name = "handling_tax")
    private BigDecimal handlingTax;

    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;

    @Column(name = "shipping_tax")
    private BigDecimal shippingTax;

    @Column(name = "loyalty_id")
    private String loyaltyId;

    @Column(name = "promise_ship_date")
    private LocalDateTime promiseShipDate;

    @Column(name = "promise_delivery_date")
    private LocalDateTime promiseDeliveryDate;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated_time", nullable = false)
    private LocalDateTime updatedTime;
}
