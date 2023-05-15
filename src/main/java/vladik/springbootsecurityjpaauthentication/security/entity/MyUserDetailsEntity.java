package vladik.springbootsecurityjpaauthentication.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vladik.springbootsecurityjpaauthentication.entity.UserEntity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetailsEntity implements UserDetails {

    private final String userName;
    private final String password;
    private final boolean active;
    private final List<GrantedAuthority> grantedAuthorities;

    public MyUserDetailsEntity(UserEntity user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.grantedAuthorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
