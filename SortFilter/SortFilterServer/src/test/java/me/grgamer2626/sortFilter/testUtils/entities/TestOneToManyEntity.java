package me.grgamer2626.sortFilter.testUtils.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/** "Many" side of a bidirectional one-to-many with {@link TestEntity}'s {@code oneToMany}. */
@Entity
@SuppressWarnings("unused")
public class TestOneToManyEntity extends TestBaseEntity {

    private String name;

    // "value" is a reserved word in H2
    @Column(name = "test_value")
    private Integer value;

    // many-to-one back-reference, allows paths that leave a collection through a single-valued relation,
    // e.g. "oneToMany.owner.testString"
    @ManyToOne
    private TestEntity owner;
}
