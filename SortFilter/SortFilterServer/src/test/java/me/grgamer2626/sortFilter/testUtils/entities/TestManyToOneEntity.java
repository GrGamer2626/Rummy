package me.grgamer2626.sortFilter.testUtils.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

/** "One" side of a bidirectional many-to-one with {@link TestEntity}'s {@code manyToOne}. */
@Entity
@SuppressWarnings("unused")
public class TestManyToOneEntity extends TestBaseEntity {

    private String name;

    // inverse one-to-many side, allows paths such as "manyToOne.entities.testString"
    @OneToMany(mappedBy = "manyToOne")
    private List<TestEntity> entities;
}
