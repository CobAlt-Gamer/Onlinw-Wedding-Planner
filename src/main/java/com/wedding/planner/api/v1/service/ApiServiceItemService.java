package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.ServiceItemDTO;
import com.wedding.planner.entity.Images;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.Services;

public interface ApiServiceItemService {

    /**
     * to get image urls from {@link Images} list
     *
     * @param images
     * @return
     */
    private List<String> images(List<Images> images) {
        return images.stream().map(Images::getUrl).collect(Collectors.toList());
    }

    /**
     * converts {@link ServiceItem} to {@link ServiceItemDTO}
     *
     * @param serviceItem
     * @return
     */
    default ServiceItemDTO convertToDTO(ServiceItem serviceItem) {
        return new ServiceItemDTO(serviceItem.getServiceItemId(), serviceItem.getItemName(),
                serviceItem.getApproxPrice(), images(serviceItem.getImages()));
    }

    /**
     * converts {@link ServiceItem} list to {@link ServiceItemDTO} list
     *
     * @param serviceItems
     * @return
     */
    default List<ServiceItemDTO> convertToDTO(List<ServiceItem> serviceItems) {
        return serviceItems.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * returns All the available service items in {@link ServiceItemDTO}
     *
     * @return
     */
    ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems();

    /**
     * returns All the available service items in {@link ServiceItemDTO} with paging
     *
     * @param page
     * @return
     */
    ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(Pageable page);

    /**
     * returns All the available service items in {@link ServiceItemDTO} for
     * spacific {@link Services}
     *
     * @param service
     * @return
     */
    ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(Services service);

    /**
     * returns All the available service items in {@link ServiceItemDTO} for
     * {@link Services} with paging
     *
     * @param service
     * @param page
     * @return
     */
    ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(Services service, Pageable page);

    /**
     * returns specified service item
     * @param item
     * @return
     */
	ResponseEntity<ServiceItemDTO> serviceItem(Long item);


}