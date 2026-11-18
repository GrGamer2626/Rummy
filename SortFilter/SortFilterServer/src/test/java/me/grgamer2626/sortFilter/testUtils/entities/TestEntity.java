package me.grgamer2626.sortFilter.testUtils.entities;

import jakarta.persistence.*;
import me.grgamer2626.sortFilter.testUtils.TestEnum;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Type graph used only by tests. Tables exist only in an in-memory H2 database created by the integration tests.
 * Fields are private, like in real entities. One class covers every case the tests need.
 */
@Entity
@SuppressWarnings("unused")
public class TestEntity extends TestBaseEntity {

    // simple types
    private String testString;
    private byte testPrimitiveByte;
    private Byte testByte;
    private short testPrimitiveShort;
    private Short testShort;
    private int testPrimitiveInt;
    private Integer testInteger;
    private long testPrimitiveLong;
    private Long testLong;
    private float testPrimitiveFloat;
    private Float testFloat;
    private double testPrimitiveDouble;
    private Double testDouble;
    private boolean testPrimitiveBoolean;
    private Boolean testBoolean;
    private char testPrimitiveChar;
    private Character testCharacter;
    private BigDecimal testBigDecimal;
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;
    private Instant testInstant;
    private TestEnum testEnum;

    // relations (no annotations: the library reads only the field type)
    @ManyToOne
    private TestEntity parent;                        // self-reference, to-one
    @OneToMany(mappedBy = "parent")
    private List<TestEntity> children;                // self-reference, to-many
    @OneToOne
    private TestOneToOneEntity oneToOne;              // one-to-one, owning side
    @ManyToOne
    private TestManyToOneEntity manyToOne;            // many-to-one, owning side
    @OneToMany(mappedBy = "owner")
    private List<TestOneToManyEntity> oneToMany;      // one-to-many (the other side has a many-to-one "owner")
    @ManyToMany
    private Set<TestManyToManyEntity> manyToMany;     // many-to-many, owning side

    @Transient
    @SuppressWarnings("rawtypes")
    private List testRawTypeList;

    // not Comparable, so it cannot be sorted or compared
    @Transient
    private Object notComparable;

    public TestEntity getParent() {
        return parent;
    }

    public void setParent(TestEntity parent) {
        this.parent = parent;
    }


}
