package me.grgamer2626.sortFilter.testUtils.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Set;

/**
 * Inverse side of a bidirectional many-to-many with {@link TestEntity}'s {@code manyToMany}.
 * Both sides are collections, and they are deliberately a {@link Set}, not a {@link java.util.List},
 * so the tests also cover other {@link java.util.Collection} implementations.
 */
@Entity
@SuppressWarnings("unused")
public class TestManyToManyEntity extends TestBaseEntity {

    private String name;

    // collection on both sides, allows paths such as "manyToMany.entities.testString"
    @ManyToMany(mappedBy = "manyToMany")
    private Set<TestEntity> entities;
}