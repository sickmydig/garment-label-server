package com.esquel.b2b.schema;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "sdBulkOrder")
public class BulkOrder extends Model<BulkOrder, Long> implements Identity<Long> {
	
	public static final String BULK_ORDER_ID_FIELD_NAME = "bulk_order_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String AGPO_NUMBER_FIELD_NAME = "apgo_number";
	public static final String CUSTOMER_ORDER_NUMBER_FIELD_NAME = "customer_order_number";
	public static final String ORDER_TYPE_ID_FIELD_NAME = "order_type_id";
	public static final String STYLE_NUMBER_FIELD_NAME = "style_number";
	public static final String SEASON_FIELD_NAME = "season";
	public static final String BILL_TO_CUSTOMER_FIELD_NAME = "bill_to_customer";
	public static final String BILL_TO_CONTACT_PERSON_FIELD_NAME = "bill_to_contact_person";
	public static final String BILL_TO_TELEPHONE_FIELD_NAME = "bill_to_telephone";
	public static final String SHIP_TO_CUSTOMER_FIELD_NAME = "ship_to_customer";
	public static final String SHIP_TO_ADDRESS_ID_FIELD_NAME = "ship_to_address_id";
	public static final String SHIP_TO_ADDRESS_FIELD_NAME = "ship_to_address";
	public static final String SHIP_TO_CONTACT_PERSON_FIELD_NAME = "ship_to_contact_person";
	public static final String SHIP_TO_TELEPHONE_FIELD_NAME = "ship_to_telephone";
	public static final String BILL_TO_ADDRESS_ID_FIELD_NAME = "bill_to_address_id";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brand";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String SALES_TEAM_FIELD_NAME = "sales_team";
	public static final String SALES_FIELD_NAME = "SALES";
	public static final String FOLLOWER_ID_FIELD_NAME = "fllower_id";
	public static final String INVOICE_MODE_ID_FIELD_NAME = "invoice_model_id";
	public static final String TRANSPORT_MODE_ID_FIELD_NAME = "transport_model_id";
	public static final String ACCOUNT_NUMBER_FIELD_NAME = "account_number";
	public static final String PAYMENT_TERM_FIELD_NAME = "payment_term";
	public static final String BANK_CHARGE_FIELD_NAME = "bank_charge";
	public static final String QUOTATION_MODE_ID_FIELD_NAME = "quotation_model_id";
	public static final String CURRENCY_FIELD_NAME = "currency";
	public static final String PRO_FORMA_INVOICE_FIELD_NAME = "pro_forma_invoice";
	public static final String DELIVERY_AREAS_ID_FIELD_NAME = "delivery_areas_id";
	public static final String ORDER_REGION_ID_FIELD_NAME = "order_region_id";
	public static final String RECEIVED_AMOUNT_FIELD_NAME = "received_amount";
	public static final String ORDER_DATE_FIELD_NAME = "order_date";
	public static final String RECEIVE_DATE_FIELD_NAME = "receive_date";
	public static final String TARGET_DELIVERY_DATE_FIELD_NAME = "target_delivery_date";
	public static final String SHIPPED_AMOUNT_FIELD_NAME = "shipped_amount";
	public static final String IS_OVERDUE_FIELD_NAME = "is_overdue";
	public static final String CUSTOMER_CREDIT_USD_FIELD_NAME = "customer_credit_usd";
	public static final String PAYMENT_STATUS_FIELD_NAME = "payment_status";
	public static final String DELIVERY_INITIATED_BY_WH_FIELD_NAME = "delivery_initiated_by_wh";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String IS_ESCM_DOWNLOAD_FIELD_NAME = "is_escm_download";
	public static final String ESCM_AGPO_NUMBER_FIELD_NAME = "escm_agpo_number";
	public static final String COPY_FROM_AGPO_NUMBER_FIELD_NAME = "copy_from_agpo_number";
	public static final String LOG_INFO_FIELD_NAME = "log_info";
	public static final String ORDER_SOURCE_FIELD_NAME = "order_source";
	
	@DatabaseField(
			columnName = "BulkOrderID", 
			canBeNull = false,
			id = true)
	@SerializedName(BULK_ORDER_ID_FIELD_NAME)
	@Expose
	private Long bulkOrderID;
	
	@DatabaseField(
			columnName = "iden", 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "AGPONo", 
			canBeNull = true)
	@SerializedName(AGPO_NUMBER_FIELD_NAME)
	@Expose
	private String agpoNumber;
	
	@DatabaseField(
			columnName = "CustomerOrderNo", 
			canBeNull = true)
	@SerializedName(CUSTOMER_ORDER_NUMBER_FIELD_NAME)
	@Expose
	private String customerOrderNumber;
	
	@DatabaseField(
			columnName = "OrderTypeID", 
			canBeNull = false)
	@SerializedName(ORDER_TYPE_ID_FIELD_NAME)
	@Expose
	private Long orderTypeID;
	
	@DatabaseField(
			columnName = "StyleNo", 
			canBeNull = true)
	@SerializedName(STYLE_NUMBER_FIELD_NAME)
	@Expose
	private String styleNumber;
	
	@DatabaseField(
			columnName = "SeasonID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SEASON_FIELD_NAME)
	@Expose
	private Season season;
	
	@DatabaseField(
			columnName = "BillToCustomerID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(BILL_TO_CUSTOMER_FIELD_NAME)
	@Expose
	private Customer billToCustomer;
	
	@DatabaseField(
			columnName = "BillToContactPerson", 
			canBeNull = true)
	@SerializedName(BILL_TO_CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String billToContactPerson;
	
	@DatabaseField(
			columnName = "BillToTelphone", 
			canBeNull = true)
	@SerializedName(BILL_TO_TELEPHONE_FIELD_NAME)
	@Expose
	private String billToTelephone;
	
	@DatabaseField(
			columnName = "ShipToCustomerID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SHIP_TO_CUSTOMER_FIELD_NAME)
	@Expose
	private Customer shipToCustomer;
	
	@DatabaseField(
			columnName = "ShipToAddressID", 
			canBeNull = false)
	@SerializedName(SHIP_TO_ADDRESS_ID_FIELD_NAME)
	@Expose
	private Long shipToAddressID;
	
	@DatabaseField(
			columnName = "ShipToAddress", 
			canBeNull = true)
	@SerializedName(SHIP_TO_ADDRESS_FIELD_NAME)
	@Expose
	private String shipToAddress;
	
	@DatabaseField(
			columnName = "ShipToContactPerson", 
			canBeNull = true)
	@SerializedName(SHIP_TO_CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String shipToContactPerson;
	
	@DatabaseField(
			columnName = "ShipToTelphone", 
			canBeNull = true)
	@SerializedName(SHIP_TO_TELEPHONE_FIELD_NAME)
	@Expose
	private String shipToTelephone;
	
	@DatabaseField(
			columnName = "BillToAddressID", 
			canBeNull = false)
	@SerializedName(BILL_TO_ADDRESS_ID_FIELD_NAME)
	@Expose
	private Long billToAddressID;
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(SUB_BRAND_FIELD_NAME)
	@Expose
	private SubBrand subBrand;
	
	@DatabaseField(
			columnName = "BrandName", 
			canBeNull = true)
	@SerializedName(BRAND_NAME_FIELD_NAME)
	@Expose
	private String brandName;
	
	@DatabaseField(
			columnName = "SalesTeamID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(SALES_TEAM_FIELD_NAME)
	@Expose
	private SalesTeam salesTeam;
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(SALES_FIELD_NAME)
	@Expose
	private Sale sales;
	
	@DatabaseField(
			columnName = "FollowerID", 
			canBeNull = false)
	@SerializedName(FOLLOWER_ID_FIELD_NAME)
	@Expose
	private Long followerID;
	
	@DatabaseField(
			columnName = "InvoiceModeID", 
			canBeNull = false)
	@SerializedName(INVOICE_MODE_ID_FIELD_NAME)
	@Expose
	private Long invoiceModeID;
	
	@DatabaseField(
			columnName = "TransportModeID", 
			canBeNull = true)
	@SerializedName(TRANSPORT_MODE_ID_FIELD_NAME)
	@Expose
	private Long transportModeID;
	
	@DatabaseField(
			columnName = "ACNO", 
			canBeNull = true)
	@SerializedName(ACCOUNT_NUMBER_FIELD_NAME)
	@Expose
	private String accountNumber;
	
	@DatabaseField(
			columnName = "PaymentTermID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(PAYMENT_TERM_FIELD_NAME)
	@Expose
	private PaymentTerm paymentTerm;
	
	@DatabaseField(
			columnName = "BankCharge", 
			canBeNull = true)
	@SerializedName(BANK_CHARGE_FIELD_NAME)
	@Expose
	private Double bankCharge;
	
	@DatabaseField(
			columnName = "QuotationModeID", 
			canBeNull = false)
	@SerializedName(QUOTATION_MODE_ID_FIELD_NAME)
	@Expose
	private Long quotationModeID;
	
	@DatabaseField(
			columnName = "CurrencyID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(CURRENCY_FIELD_NAME)
	@Expose
	private Currency currency;
	
	@DatabaseField(
			columnName = "ProFormaInvoice", 
			canBeNull = true)
	@SerializedName(PRO_FORMA_INVOICE_FIELD_NAME)
	@Expose
	private String proFormaInvoice;
	
	@DatabaseField(
			columnName = "DeliveryAreasID", 
			canBeNull = true)
	@SerializedName(DELIVERY_AREAS_ID_FIELD_NAME)
	@Expose
	private Long deliveryAreasID;
	
	@DatabaseField(
			columnName = "OrderRegionID", 
			canBeNull = false)
	@SerializedName(ORDER_REGION_ID_FIELD_NAME)
	@Expose
	private Long orderRegionID;
	
	@DatabaseField(
			columnName = "ReceivedAmount", 
			canBeNull = true)
	@SerializedName(RECEIVED_AMOUNT_FIELD_NAME)
	@Expose
	private Double receivedAmount;
	
	@DatabaseField(
			columnName = "OrderDate", 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(ORDER_DATE_FIELD_NAME)
	@Expose
	private Date orderDate;
	
	@DatabaseField(
			columnName = "ReceiveDate", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(RECEIVE_DATE_FIELD_NAME)
	@Expose
	private Date receiveDate;
	
	@DatabaseField(
			columnName = "TargetDeliveryDate", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(TARGET_DELIVERY_DATE_FIELD_NAME)
	@Expose
	private Date targetDeliveryDate;
	
	@DatabaseField(
			columnName = "ShippedAmount", 
			canBeNull = true)
	@SerializedName(SHIPPED_AMOUNT_FIELD_NAME)
	@Expose
	private Double shippedAmount;
	
	@DatabaseField(
			columnName = "IsOverdue", 
			canBeNull = true)
	@SerializedName(IS_OVERDUE_FIELD_NAME)
	@Expose
	private boolean isOverdue;
	
	@DatabaseField(
			columnName = "CustomerCreditUSD", 
			canBeNull = true)
	@SerializedName(CUSTOMER_CREDIT_USD_FIELD_NAME)
	@Expose
	private Double customerCreditUSD;
	
	@DatabaseField(
			columnName = "PaymentStatus", 
			canBeNull = true)
	@SerializedName(PAYMENT_STATUS_FIELD_NAME)
	@Expose
	private String paymentStatus;
	
	@DatabaseField(
			columnName = "DelvieryInitiatedByWH", 
			canBeNull = true)
	@SerializedName(DELIVERY_INITIATED_BY_WH_FIELD_NAME)
	@Expose
	private boolean deliveryInitiatedByWH;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = false)
	@SerializedName(CREATE_BY_FIELD_NAME)
	@Expose
	private String createBy;
	
	@DatabaseField(
			columnName = "CreateTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATE_TIME_FIELD_NAME)
	@Expose
	private Date createTime;
	
	@DatabaseField(
			columnName = "LastModifyBy", 
			canBeNull = false)
	@SerializedName(LAST_MODIFY_BY_FIELD_NAME)
	@Expose
	private String lastModifyBy;

    @DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	@Expose
	private Date lastModifyTime;
	
	@DatabaseField(
			columnName = "IsESCMDownload", 
			canBeNull = true)
	@SerializedName(IS_ESCM_DOWNLOAD_FIELD_NAME)
	@Expose
	private boolean isEscmDownload;
	
	@DatabaseField(
			columnName = "ESCMAGPONo", 
			canBeNull = true)
	@SerializedName(ESCM_AGPO_NUMBER_FIELD_NAME)
	@Expose
	private String escmAgpoNumber;
	
	@DatabaseField(
			columnName = "CopyFromAGPONo", 
			canBeNull = true)
	@SerializedName(COPY_FROM_AGPO_NUMBER_FIELD_NAME)
	@Expose
	private String copyFromAgpoNumber;
	
	@DatabaseField(
			columnName = "LogInfo", 
			canBeNull = true)
	@SerializedName(LOG_INFO_FIELD_NAME)
	@Expose
	private String logInfo;
	
	@DatabaseField(
			columnName = "OrderSoure", 
			canBeNull = true)
	@SerializedName(ORDER_SOURCE_FIELD_NAME)
	@Expose
	private String orderSource;
	
	public BulkOrder() {
	}
	
	@Override
	public Long getIdentity() {
		return bulkOrderID;
	}

	@Override
	public String getIdentityAttribute() {
		return BULK_ORDER_ID_FIELD_NAME;
	}
}