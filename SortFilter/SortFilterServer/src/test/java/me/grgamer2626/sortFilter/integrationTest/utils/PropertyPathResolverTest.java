package me.grgamer2626.sortFilter.integrationTest.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import me.grgamer2626.sortFilter.exception.InvalidPropertyException;
import me.grgamer2626.sortFilter.testUtils.TestEnum;
import me.grgamer2626.sortFilter.testUtils.entities.*;
import me.grgamer2626.sortFilter.utils.PropertyPathResolver;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.*;
import org.springframework.util.ClassUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class PropertyPathResolverTest {

    private static SessionFactory sessionFactory;

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<TestEntity> query;

    @BeforeAll
    public static void createSessionFactory() {
        sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder()
                .applySetting("jakarta.persistence.jdbc.url", "jdbc:h2:mem:property-path-resolver;DB_CLOSE_DELAY=-1")
                .applySetting("hibernate.hbm2ddl.auto", "create-drop")
                .build())
                .addAnnotatedClass(TestBaseEntity.class)
                .addAnnotatedClass(TestEntity.class)
                .addAnnotatedClass(TestOneToOneEntity.class)
                .addAnnotatedClass(TestManyToOneEntity.class)
                .addAnnotatedClass(TestOneToManyEntity.class)
                .addAnnotatedClass(TestManyToManyEntity.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    @AfterAll
    public static void closeSessionFactory() {
        sessionFactory.close();
    }

    @BeforeEach
    public void createQuery() {
        entityManager = sessionFactory.createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
        query = criteriaBuilder.createQuery(TestEntity.class);
    }

    @AfterEach
    public void closeEntityManager() {
        entityManager.close();
    }


    @Test
    public void resolvePath_propertyIsString() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testString";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(String.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveByte() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveByte";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(byte.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsByte() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testByte";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Byte.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveShort() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveShort";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(short.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsShort() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testShort";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Short.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveInt() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveInt";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(int.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsInteger() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testInteger";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Integer.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveLong() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveLong";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(long.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsLong() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testLong";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Long.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveFloat() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveFloat";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(float.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsFloat() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testFloat";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Float.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveDouble() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveDouble";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(double.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsDouble() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testDouble";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Double.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveBoolean() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveBoolean";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(boolean.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsBoolean() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testBoolean";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Boolean.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsPrimitiveChar() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testPrimitiveChar";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(char.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsCharacter() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testCharacter";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Character.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsBigDecimal() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testBigDecimal";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(BigDecimal.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsLocalDate() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testLocalDate";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(LocalDate.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsLocalDateTime() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testLocalDateTime";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(LocalDateTime.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsInstant() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testInstant";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(Instant.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsEnum() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "testEnum";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        assertJavaType(TestEnum.class, result);
        Assertions.assertSame(root, result.getParentPath());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsInheritedField() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "id";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(Long.class, result.getJavaType());
        assertQueryIsExecutable(root, result);
    }

    // to-one relations ------------------------------------------------------------------------------------------------

    @Test
    public void resolvePath_propertyIsOneToOneField() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "oneToOne.name";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(String.class, result.getJavaType());
        Assertions.assertEquals(TestOneToOneEntity.class, result.getParentPath().getJavaType());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsManyToOneField() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "manyToOne.name";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(String.class, result.getJavaType());
        Assertions.assertEquals(TestManyToOneEntity.class, result.getParentPath().getJavaType());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyGoesThroughTwoToOneRelations() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "oneToOne.owner.testString";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(String.class, result.getJavaType());
        assertQueryIsExecutable(root, result);
    }

    // collections -----------------------------------------------------------------------------------------------------

    @Test
    public void resolvePath_propertyIsSelfReferencingCollection() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "children";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Join<?, ?> join = Assertions.assertInstanceOf(Join.class, result);
        Assertions.assertEquals("children", join.getAttribute().getName());
        Assertions.assertEquals(TestEntity.class, join.getJavaType());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsOneToManyCollection() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "oneToMany";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Join<?, ?> join = Assertions.assertInstanceOf(Join.class, result);
        Assertions.assertEquals("oneToMany", join.getAttribute().getName());
        Assertions.assertEquals(TestOneToManyEntity.class, join.getJavaType());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyIsManyToManyCollection() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "manyToMany";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Join<?, ?> join = Assertions.assertInstanceOf(Join.class, result);
        Assertions.assertEquals("manyToMany", join.getAttribute().getName());
        Assertions.assertEquals(TestManyToManyEntity.class, join.getJavaType());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyGoesThroughCollection() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "children.testString";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(String.class, result.getJavaType());
        Assertions.assertTrue(joinedAttributeNames(root).contains("children"));
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyGoesThroughToOneRelationToCollection() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "parent.children.testString";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(String.class, result.getJavaType());
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyLeavesCollectionThroughToOneRelation() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "oneToMany.owner.testString";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(String.class, result.getJavaType());
        Assertions.assertTrue(joinedAttributeNames(root).contains("oneToMany"));
        assertQueryIsExecutable(root, result);
    }

    @Test
    public void resolvePath_propertyGoesThroughCollectionsOnBothSidesOfManyToMany() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "manyToMany.entities.testString";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when
        Path<?> result = PropertyPathResolver.resolvePath(root, rootEntity, property);

        //then
        Assertions.assertEquals(String.class, result.getJavaType());
        Assertions.assertTrue(joinedAttributeNames(root).contains("manyToMany"));
        assertQueryIsExecutable(root, result);
    }

    // errors ----------------------------------------------------------------------------------------------------------

    @Test
    public void resolvePath_propertyIsUnknown_throwsInvalidFilterPropertyException() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "nope";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when/then
        Assertions.assertThrows(InvalidPropertyException.class, () -> PropertyPathResolver.resolvePath(root, rootEntity, property));
    }

    @Test
    public void resolvePath_propertyIsUnknownFieldOfOneToOneEntity_throwsInvalidFilterPropertyException() {
        //given
        Class<?> rootEntity = TestEntity.class;
        String property = "oneToOne.nope";
        Root<TestEntity> root = query.from(TestEntity.class);

        //when/then
        Assertions.assertThrows(InvalidPropertyException.class, () -> PropertyPathResolver.resolvePath(root, rootEntity, property));
    }

    /**
     * Hibernate may report a primitive attribute as its wrapper type (int vs Integer), which is irrelevant
     * for the path itself, so both sides are normalised before comparing.
     */
    private static void assertJavaType(Class<?> expected, Path<?> path) {
        Assertions.assertEquals(
                ClassUtils.resolvePrimitiveIfNecessary(expected),
                ClassUtils.resolvePrimitiveIfNecessary(path.getJavaType()));
    }

    /** Builds and runs a query that uses the resolved path, so Hibernate validates it and generates real SQL. */
    private void assertQueryIsExecutable(Root<TestEntity> root, Path<?> path) {
        query.select(root).where(criteriaBuilder.isNotNull(path));

        Assertions.assertDoesNotThrow(() -> entityManager.createQuery(query).getResultList());
    }

    private static Set<String> joinedAttributeNames(Root<?> root) {
        return root.getJoins().stream()
                .map(join -> join.getAttribute().getName())
                .collect(Collectors.toSet());
    }
}
