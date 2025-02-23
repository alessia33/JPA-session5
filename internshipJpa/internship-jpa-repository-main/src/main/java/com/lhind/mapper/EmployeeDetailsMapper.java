package com.lhind.mapper;

import com.lhind.model.dto.EmployeeDetailsDTO;
import com.lhind.model.entity.EmployeeDetails;
import com.lhind.model.enums.EmploymentStatus;

import java.util.Date;

public class EmployeeDetailsMapper extends AbstractMapper<EmployeeDetails, EmployeeDetailsDTO> {

    @Override
    public EmployeeDetails toEntity(EmployeeDetailsDTO dto) {
        if(dto == null) {
            return null;
        }
        EmployeeDetails employeeDetails =   new EmployeeDetails();
        employeeDetails.setEmail(dto.getEmail());
        employeeDetails.setEmploymentDate(dto.getEmploymentDate());
        employeeDetails.setPhoneNumber(dto.getPhoneNumber());
        employeeDetails.setEmploymentStatus(EmploymentStatus.ACTIVE);
        return employeeDetails;
    }

    @Override
    public EmployeeDetailsDTO toDto(EmployeeDetails entity) {
        if (entity == null) {
            return null;
        }
        EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();
        employeeDetailsDTO.setId(entity.getId());
        employeeDetailsDTO.setEmail(entity.getEmail());
        employeeDetailsDTO.setPhoneNumber(entity.getPhoneNumber());
        employeeDetailsDTO.setEmploymentDate(entity.getEmploymentDate());
        return employeeDetailsDTO;
    }
}
