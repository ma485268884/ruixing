package com.yintu.ruixing.entity.rbac;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {
    private static final long serialVersionUID = 840489173773176226L;
    private Long id;

    private String username;

    private String password;

    private String trueName;

    private String phone;

    private String email;

    private Short authType;

    private Short locked;

    private Short enabled;

    private String salt;

    private Date loginTime;

    private List<RoleEntity> roleEntities;


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roleEntities.size());
        for (RoleEntity roleEntity : roleEntities) {
            authorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return getLocked() == (short) 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnabled() == (short) 1;
    }
}