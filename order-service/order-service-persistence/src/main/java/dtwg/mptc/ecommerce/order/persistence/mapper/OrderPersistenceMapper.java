package dtwg.mptc.ecommerce.order.persistence.mapper;

import dtwg.mptc.ecommerce.domain.entity.Business;
import dtwg.mptc.ecommerce.domain.entity.Customer;
import dtwg.mptc.ecommerce.order.persistence.entity.BusinessEntity;
import dtwg.mptc.ecommerce.order.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    @Mapping(source = "id" , target = "id.value")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);


    @Mapping(source = "businessId", target = "id.value")
    Business businessEntityToBusiness(BusinessEntity businessEntity);
}
