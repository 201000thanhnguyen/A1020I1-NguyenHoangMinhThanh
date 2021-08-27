package thanh.code.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thanh.code.models.MyUserDetail;
import thanh.code.models.User;
import thanh.code.repository.IUserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {

    private final IUserRepository userRepository;

    public MyUserDetailService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findById(username).orElse(null);
        if (user == null){
            throw new UsernameNotFoundException("user name not found: "+username);
        }
        return new MyUserDetail(user);
    }
}
