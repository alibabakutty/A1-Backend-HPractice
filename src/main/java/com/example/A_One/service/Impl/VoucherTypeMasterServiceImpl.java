package com.example.A_One.service.Impl;

import com.example.A_One.dto.VoucherTypeMasterDto;
import com.example.A_One.entity.VoucherTypeMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.VoucherTypeMasterMapper;
import com.example.A_One.repository.VoucherTypeMaterDAO;
import com.example.A_One.service.VoucherTypeMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoucherTypeMasterServiceImpl implements VoucherTypeMasterService {

    @Autowired
    private VoucherTypeMaterDAO voucherTypeMaterDAO;

    @Override
    public VoucherTypeMasterDto createVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto){

        //validate voucher type name object
        validateVoucherTypeMaster(voucherTypeMasterDto);

        //check for duplicate entry
        if (voucherTypeMaterDAO.existsByVoucherTypeName(voucherTypeMasterDto.getVoucherTypeName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + voucherTypeMasterDto.getVoucherTypeName());
        }

        VoucherTypeMaster voucherTypeMaster = VoucherTypeMasterMapper.mapToVoucherTypeMaster(voucherTypeMasterDto);

        VoucherTypeMaster saveVoucherTypeMaster = voucherTypeMaterDAO.save(voucherTypeMaster);

        return VoucherTypeMasterMapper.mapToVoucherTypeMasterDto(saveVoucherTypeMaster);
    }

    private void validateVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto){
        if (voucherTypeMasterDto.getVoucherTypeName() == null || voucherTypeMasterDto.getVoucherTypeName().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }

    @Override
    public VoucherTypeMasterDto getVoucherTypeName(String voucherTypeName){
        VoucherTypeMaster voucherTypeMaster = voucherTypeMaterDAO.findByVoucherTypeName(voucherTypeName).orElseThrow(() ->

                new ResourceNotFoundException("Voucher type name is not found with this name:" + voucherTypeName));

        return VoucherTypeMasterMapper.mapToVoucherTypeMasterDto(voucherTypeMaster);
    }

    @Override
    public List<VoucherTypeMasterDto> getAllVoucherTypeMasters(){
        List<VoucherTypeMaster> voucherTypeMaster = voucherTypeMaterDAO.findAll();
        return voucherTypeMaster.stream().map(VoucherTypeMasterMapper::mapToVoucherTypeMasterDto).toList();
    }

    @Override
    public VoucherTypeMasterDto updateVoucherTypeMaster(String voucherTypeName, VoucherTypeMasterDto updatedVoucherTypeMaster){
        VoucherTypeMaster voucherTypeMaster = voucherTypeMaterDAO.findByVoucherTypeName(voucherTypeName).orElseThrow(() ->

                new ResourceNotFoundException("Voucher type name is not found with this name:" + voucherTypeName));

        voucherTypeMaster.setId(updatedVoucherTypeMaster.getId());
        voucherTypeMaster.setVoucherTypeName(updatedVoucherTypeMaster.getVoucherTypeName());
        voucherTypeMaster.setVoucherType(updatedVoucherTypeMaster.getVoucherType());
        voucherTypeMaster.setStartingNumber(updatedVoucherTypeMaster.getStartingNumber());
        voucherTypeMaster.setWidthOfNumericalPart(updatedVoucherTypeMaster.getWidthOfNumericalPart());
        voucherTypeMaster.setPrefillWithZero(updatedVoucherTypeMaster.getPrefillWithZero());
        voucherTypeMaster.setRestartNumberingApplicationForm(updatedVoucherTypeMaster.getRestartNumberingApplicationForm());
        voucherTypeMaster.setRestartNumberingStartingNumber(updatedVoucherTypeMaster.getRestartNumberingStartingNumber());
        voucherTypeMaster.setRestartNumberingPeriodicity(updatedVoucherTypeMaster.getRestartNumberingPeriodicity());
        voucherTypeMaster.setPrefixDetailsApplicationForm(updatedVoucherTypeMaster.getPrefixDetailsApplicationForm());
        voucherTypeMaster.setPrefixDetailsParticulars(updatedVoucherTypeMaster.getPrefixDetailsParticulars());
        voucherTypeMaster.setSuffixDetailsApplicationForm(updatedVoucherTypeMaster.getSuffixDetailsApplicationForm());
        voucherTypeMaster.setSuffixDetailsParticulars(updatedVoucherTypeMaster.getSuffixDetailsParticulars());

        VoucherTypeMaster voucherTypeMasterObj = voucherTypeMaterDAO.save(voucherTypeMaster);

        return VoucherTypeMasterMapper.mapToVoucherTypeMasterDto(voucherTypeMasterObj);
    }

    @Override
    public void deleteByVoucherTypeMaster(Long id){
        VoucherTypeMaster voucherTypeMaster = voucherTypeMaterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Voucher type name is not found with this name:" + id));

        voucherTypeMaterDAO.deleteById(id);
    }
}
