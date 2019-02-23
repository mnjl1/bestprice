package com.mmplus.bestprice.entity.profile;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.util.Constants;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "company")
public class Company{

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = Constants.REQUIRED_FIELD)
    @Column(name = "company_name")
    private String companyName;

    @Email
    @NotBlank(message = Constants.REQUIRED_FIELD)
    @Column(name = "email")
    private String email;

    @NotBlank(message = Constants.REQUIRED_FIELD)
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "company")
    private List<HotPriceOrder> hotPriceOrders;
}
