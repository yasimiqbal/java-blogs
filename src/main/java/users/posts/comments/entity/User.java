package users.posts.comments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private UserProfile userProfile;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private Address address;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Post> posts;
}
