package com.example.proyectinvoice.service


import com.example.proyectinvoice.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class UsersSecurityService: UserDetailsService {
    @Autowired
    lateinit var usersRepository: UsersRepository
    @Override
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(usersname: String): UserDetails? {
        val userEntity = usersRepository.findByUsersname(usersname)
            ?: throw
            UsernameNotFoundException(
                "User $usersname not found."
            )

        val role: Array<String?> = userEntity.role?.map {
                role -> role.role }!!.toTypedArray()

        return User.builder()
            .username(userEntity.username)
            .password(userEntity.password)
            .roles(*role)
            .accountLocked(userEntity.locked!!)
            .disabled(userEntity.disabled!!)
            .build()
    }

}



