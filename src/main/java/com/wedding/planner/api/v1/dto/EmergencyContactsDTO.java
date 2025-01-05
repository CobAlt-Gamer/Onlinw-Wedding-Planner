package com.wedding.planner.api.v1.dto;

public record EmergencyContactsDTO(Long contactId, String contactName, String[] numbers, String status, Long user) {

}
