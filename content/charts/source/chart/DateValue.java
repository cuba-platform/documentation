package com.haulmont.sampler.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "SAMPLER_DATE_VALUE")
@Entity(name = "sampler$DateValue")
public class DateValue extends StandardEntity {
    private static final long serialVersionUID = -2231246080704190615L;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    @Column(name = "VALUE_", nullable = false)
    protected Integer value;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }


}