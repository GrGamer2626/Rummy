package me.grgamer2626.sortFilter.testUtils.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/** Superclass of {@link TestEntity}, used to test fields inherited from a parent class. */
@MappedSuperclass
@SuppressWarnings("unused")
public abstract class TestBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
