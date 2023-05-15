package dev.camila.request.credit.system.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

@Entity
@Table(name = "tb_customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    var firstName: String = "",
    @Column(nullable = false)
    var lastName: String = "",
    @Column(nullable = false, unique = true)
    var cpf: String = "",
    @Column(nullable = false, unique = true)
    var email: String = "",
    @Column(nullable = false)
    var password: String = "",
    @Embedded
    var address: Address = Address(),
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.PERSIST], mappedBy = "customer")
    var credit: List<Credit> = mutableListOf(),
    var income: BigDecimal = BigDecimal.ZERO
)
