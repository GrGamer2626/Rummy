package me.grgamer2626.sortFilter.testUtils.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

/** Inverse side of a bidirectional one-to-one with {@link TestEntity}'s {@code oneToOne}. */
@Entity
@SuppressWarnings("unused")
public class TestOneToOneEntity extends TestBaseEntity {

    private String name;

    // back-reference to the owning side, allows cyclic paths such as "oneToOne.owner.testString"
    @OneToOne(mappedBy = "oneToOne")
    private TestEntity owner;
}
