package com.wedding.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.Services;
import com.wedding.planner.service.ServiceItemService;
import com.wedding.planner.service.ServicesService;
import com.wedding.planner.service.UserService;
import com.wedding.planner.service.VendorService;
import com.wedding.planner.utils.UtilityService;

@Controller
@RequestMapping("/services")
public class ServicesController {

	@Autowired
	private ServicesService servicesService;

	@Autowired
	private ServiceItemService itemService;

	@Autowired
	private UserService userService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private UtilityService utility;

	@RequestMapping
	public ModelAndView servicesHome(ModelAndView mv) {
		mv.addObject("services", servicesService.getAll().getBody());
		mv.setViewName("services");
		return mv;
	}

	/********************************************************************
	 * Services
	 *******************************************************************/

//	returns all the available Services
	@GetMapping("services")
	public ResponseEntity<List<Services>> servicesData() {
		return servicesService.getAll();
	}

//	adds Service
	@PostMapping("add")
	public ResponseEntity<Services> add(@RequestParam("service-name") String serviceName,
			@RequestParam("service-category") ServiceCategories category,
			@RequestParam("service-description") String serviceDescription,
			@RequestParam("service-location") String serviceLocation, @RequestParam("service-status") boolean status) {
		Services service = Services.builder().serviceName(serviceName).servicecategory(category)
				.serviceLocation(serviceLocation).serviceDescription(serviceDescription).status(status)
				.createdBy(vendorService.getVendor(userService.getUser(utility.getCurrentUsername()).getBody()).getBody()).build();
		return servicesService.add(service);
	}

//	Update Service
	@PutMapping("update")
	public ResponseEntity<Services> update(@RequestParam("edit-service-id") Long serviceId,
			@RequestParam("edit-service-name") String serviceName,
			@RequestParam("edit-service-description") String serviceDescription,
			@RequestParam("edit-service-category") ServiceCategories servicecategory,
			@RequestParam(name = "edit-service-status", required = false) Boolean status) {
		Services service = Services.builder().serviceId(serviceId).serviceName(serviceName)
				.servicecategory(servicecategory).serviceDescription(serviceDescription).status(status).build();
		return servicesService.update(service);
	}

//	Delete Service
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Services service) {
		return servicesService.delete(service);
	}

	/********************************************************************
	 * Service Items
	 *******************************************************************/

//	get Service Items by Service
	@GetMapping("service-items/{service}")
	public ResponseEntity<List<ServiceItem>> getItems(@PathVariable("service") Services service) {
		return itemService.getAll(service);
	}

// gets Service Item By Service Item Id;
	@GetMapping("service-item/{item}")
	public ResponseEntity<ServiceItem> getItem(@PathVariable("item") Long serviceItemId) {
		return itemService.get(serviceItemId);
	}

//	adds Service Item
	@PostMapping("add-item")
	public ResponseEntity<ServiceItem> addItem(@RequestParam("select-service") Services service,
			@RequestParam("service-item-name") String serviceItemName,
			@RequestParam("service-item-price") Double serviceItemPrice,
			@RequestParam("service-item-status") Boolean status,
			@RequestParam("item-images") MultipartFile[] itemImages) {
		return itemService.add(serviceItemName, service, serviceItemPrice, status, itemImages);
	}

	@PutMapping("update-item")
	public ResponseEntity<ServiceItem> updateItem(@RequestParam("edit-service-item-id") Long serviceItemId,
			@RequestParam("edit-select-service") Services service,
			@RequestParam("edit-service-item-name") String itemName,
			@RequestParam("edit-service-item-price") Double approxPrice,
			@RequestParam("edit-service-item-status") Boolean status) {
		ServiceItem item = ServiceItem.builder().serviceItemId(serviceItemId).itemName(itemName).status(status)
				.approxPrice(approxPrice).service(service).build();
		return itemService.update(item);
	}

//	deletes Service Item
	@DeleteMapping("delete-item/{item}")
	public ResponseEntity<String> deleteItsm(@PathVariable("item") ServiceItem item) {
		return itemService.delete(item);
	}
}
