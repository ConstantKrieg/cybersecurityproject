
package com.sec.cybersecurityproject.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Note extends AbstractPersistable<Long>{
    
    
    
    @NotNull
    private String name;
    
    @NotNull
    private String details;
      
    @NotNull
    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }




    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.details);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Note other = (Note) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.details, other.details)) {
            return false;
        }

        return true;
    }
    
    
    
    
    
    
}
