package com.esquel.b2b.resource;
import static com.google.common.base.Preconditions.checkNotNull;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.restlet.Application;
import org.restlet.data.CacheDirective;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.BrandCustomer;
import com.esquel.b2b.schema.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.joyaether.datastore.representation.ExceptionRepresentation;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;

public class BrandVendorsServerResource extends ReadonlyDataObjectServerResource<BrandCustomer, Long> {
	
	/** Error message */
	private static final String ERROR_MESSAGE = "%s cannot be null";
	
	/** vendor id parameter */
	private static final String BRAND_PARAM = "brand_id";
	
	/**
	 * @author Admin
	 * The json output object
	 */
	private class Brand {
		
		@SerializedName("Brand")
		@Expose
		List<BrandVendors> brands;

		public Brand(List<BrandVendors> brands) {
			this.brands = brands;
		}
	}
	
	/** The json output object. */
	private class BrandVendors {
		
		@SerializedName("brand_id")
		@Expose
		private Integer brandId;
		
		@SerializedName("contact_person")
		@Expose
		private String contactPerson;

		@SerializedName("customer_id")
		@Expose
		private Integer customerId;
		
		@SerializedName("customer_name")
		@Expose
		private String customerName;
		
		@SerializedName("telephone")
		@Expose
		private String telephone;
		
		public BrandVendors(BrandCustomer brand) throws SQLException {
			setCustomer(brand);
		}
		
		private void setCustomer(BrandCustomer brand) {
			checkNotNull(brand);
			Query q = new Query();
			CloseableWrappedIterable<Customer> iterable = null;
			CloseableIterator<Customer> iterator = null;
			try {
				DatastoreApplication app = (DatastoreApplication) Application.getCurrent();
				//q.fieldIsEqualTo(Customer.CUSTOMER_ID_FIELD_NAME, brand.getCustomerId());
				iterable = Model.fetch(app.getDatastore(Store.EAP).getConnectionSource(), Customer.class, q);
				if (iterable != null) {
					iterator =  iterable.closeableIterator();
					if (iterator.hasNext()) {
						Customer customer = iterator.next();
						if (customer != null) {
							//brandId = brand.getBrandId();
							contactPerson = customer.getContactPerson();
							//customerId = brand.getCustomerId();
							customerName = customer.getCustomerName();
							telephone = customer.getTelephone();
						}
					}
				}
			} catch(SQLException ex) {
				getLogger().log(Level.WARNING, "Unable to get brand customer information : ", ex);
			}
		}
	}
	
	@Override
	protected Query parseRequest(boolean isCountQuery) throws SQLException, MalformedURLException {
		Query query = super.parseRequest(isCountQuery);
		final Form queryParams = getQuery();
		int brandId = Integer.parseInt(queryParams.getFirstValue(BRAND_PARAM));
		checkNotNull(brandId,String.format(ERROR_MESSAGE, BRAND_PARAM));

		// Remove the argument from query, it is not a valid query parameter
		query.getArguments().remove(BRAND_PARAM);
		query.fieldIsEqualTo(BrandCustomer.BRAND_CUSTOMER_ID_FIELD_NAME, brandId).selectField(BrandCustomer.CUSTOMER_FIELD_NAME);
		return query;
	}
	
	@Override
	@Get("json")
	public Representation handleGet() {
		Representation result = null;
		BrandVendors vendor = null;
		CloseableIterator<BrandCustomer> iterator = null;
		CloseableWrappedIterable<BrandCustomer> iterable = null;
		
		try {
			DatastoreApplication app = (DatastoreApplication) Application.getCurrent();
			Query query = parseRequest();
			iterable = Model.fetch(app.getDatastore(Store.EAP).getConnectionSource(), BrandCustomer.class, query);
			iterator = iterable.closeableIterator();
			List<BrandVendors> brands = new ArrayList<BrandVendors>();
			while (iterator.hasNext()) {
				BrandCustomer brand = iterator.next();
				if (brand != null) {
					vendor = new BrandVendors(brand);
					brands.add(vendor);
				}
			}
			Brand outputBrand = new Brand(brands);
			final Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation()
					.serializeNulls()
					.setPrettyPrinting()
					.create();
			result = new JsonRepresentation(gson.toJson(outputBrand));
			setStatus(Status.SUCCESS_OK);
		} catch (Exception ex) {
			
			Status status = getApplication().getStatusService().getStatus(ex, this);
			setStatus(status);
			result = new ExceptionRepresentation(ex);
		} finally {
			
			// Closes the iterator
			if (iterable != null) {
				try {
					iterable.close();
				} catch (SQLException e) {
					getLogger().log(Level.WARNING, "Unable to close iterator after performing query : ", e);
				}
			}
			if (iterator != null) {
				iterator.closeQuietly();
			}
		}
		
		addCacheDirective(getResponse(), CacheDirective.noCache());
		return result;
	}
	
	@Override
	protected Long getId() {
		Long id = (Long) getRequest().getAttributes().get(BrandCustomer.ID_FIELD_NAME);
		return id;
	}
	
	@Override
	protected Class<BrandCustomer> getResourceType() {
		return BrandCustomer.class;
	}
}