package com.portfolio.domain.model.product.phonecase;

import com.portfolio.domain.model.attachment.Attachment;
import com.portfolio.domain.model.material.Material;
import com.portfolio.domain.model.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "ID")      // product 의 아이디를 참조한다.
@DiscriminatorValue("PHONE_CASE")
public class PhoneCase extends Product {

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;
    private boolean sale;

    @Builder
    public PhoneCase(String name,
                     int price,
                     PhoneType phoneType,
                     Material material,
                     Attachment attachment) {
        super(name,price,material,attachment);
        this.phoneType = phoneType;
        this.sale = false;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
