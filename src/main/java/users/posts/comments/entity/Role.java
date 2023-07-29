package users.posts.comments.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    private Long id;
    private String role;

    @ManyToMany
    private List<User> users = new ArrayList<>();
}
