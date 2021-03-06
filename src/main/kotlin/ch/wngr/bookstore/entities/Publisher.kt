package ch.wngr.bookstore.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "publisher")
class Publisher(
    var name: String = "",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = -1,
    @ManyToOne
    @JoinColumn(name = "default_distributor_id")
    var defaultDistributor: Distributor? = Distributor(),
) {

    override fun toString(): String {
        return this.name
    }
}


