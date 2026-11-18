package me.grgamer2626.sortFilter.unitTest.utils;

import me.grgamer2626.sortFilter.exception.InvalidPropertyException;
import me.grgamer2626.sortFilter.testUtils.TestEnum;
import me.grgamer2626.sortFilter.testUtils.entities.TestEntity;
import me.grgamer2626.sortFilter.testUtils.entities.TestManyToManyEntity;
import me.grgamer2626.sortFilter.testUtils.entities.TestOneToManyEntity;
import me.grgamer2626.sortFilter.testUtils.entities.TestOneToOneEntity;
import me.grgamer2626.sortFilter.utils.PropertyPathResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PropertyPathResolverTest {

    @Test
    public void resolveType_propertyIsString() {
        //given
        String property = "testString";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveByte() {
        //given
        String property = "testPrimitiveByte";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(byte.class, result);
    }

    @Test
    public void resolveType_propertyIsByte() {
        //given
        String property = "testByte";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Byte.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveShort() {
        //given
        String property = "testPrimitiveShort";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(short.class, result);
    }

    @Test
    public void resolveType_propertyIsShort() {
        //given
        String property = "testShort";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Short.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveInt() {
        //given
        String property = "testPrimitiveInt";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(int.class, result);
    }

    @Test
    public void resolveType_propertyIsInteger() {
        //given
        String property = "testInteger";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Integer.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveLong() {
        //given
        String property = "testPrimitiveLong";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(long.class, result);
    }

    @Test
    public void resolveType_propertyIsLong() {
        //given
        String property = "testLong";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Long.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveFloat() {
        //given
        String property = "testPrimitiveFloat";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(float.class, result);
    }

    @Test
    public void resolveType_propertyIsFloat() {
        //given
        String property = "testFloat";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Float.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveDouble() {
        //given
        String property = "testPrimitiveDouble";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(double.class, result);
    }

    @Test
    public void resolveType_propertyIsDouble() {
        //given
        String property = "testDouble";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Double.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveBoolean() {
        //given
        String property = "testPrimitiveBoolean";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(boolean.class, result);
    }

    @Test
    public void resolveType_propertyIsBoolean() {
        //given
        String property = "testBoolean";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Boolean.class, result);
    }

    @Test
    public void resolveType_propertyIsPrimitiveChar() {
        //given
        String property = "testPrimitiveChar";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(char.class, result);
    }

    @Test
    public void resolveType_propertyIsCharacter() {
        //given
        String property = "testCharacter";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Character.class, result);
    }

    @Test
    public void resolveType_propertyIsBigDecimal() {
        //given
        String property = "testBigDecimal";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(BigDecimal.class, result);
    }

    @Test
    public void resolveType_propertyIsLocalDate() {
        //given
        String property = "testLocalDate";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(LocalDate.class, result);
    }

    @Test
    public void resolveType_propertyIsLocalDateTime() {
        //given
        String property = "testLocalDateTime";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(LocalDateTime.class, result);
    }

    @Test
    public void resolveType_propertyIsInstant() {
        //given
        String property = "testInstant";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Instant.class, result);
    }

    @Test
    public void resolveType_propertyIsEnum() {
        //given
        String property = "testEnum";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(TestEnum.class, result);
    }

    @Test
    public void resolveType_propertyIsInheritedField() {
        //given
        String property = "id";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(Long.class, result);
    }

    @Test
    public void resolveType_propertyIsOneToOneField() {
        //given
        String property = "oneToOne.name";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void resolveType_propertyIsCollection() {
        //given
        String property = "children";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(TestEntity.class, result);
    }

    @Test
    public void resolveType_propertyGoesThroughCollection() {
        //given
        String property = "children.testString";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void resolveType_propertyIsOneToOneEntity() {
        //given
        String property = "oneToOne";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(TestOneToOneEntity.class, result);
    }

    @Test
    public void resolveType_propertyGoesThroughToOneRelationToCollection() {
        //given
        String property = "parent.children.testString";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void resolveType_propertyIsUnknown() {
        //given
        String property = "nope";

        //when/then
        Assertions.assertThrows(InvalidPropertyException.class, () -> PropertyPathResolver.resolveType(TestEntity.class, property));
    }

    @Test
    public void resolveType_propertyIsUnknownFieldOfOneToOneEntity() {
        //given
        String property = "oneToOne.nope";

        //when/then
        Assertions.assertThrows(InvalidPropertyException.class,
                () -> PropertyPathResolver.resolveType(TestEntity.class, property));
    }

    @Test
    public void resolveType_propertyIsRawCollection() {
        //given
        String property = "testRawTypeList";

        //when/then
        Assertions.assertThrows(InvalidPropertyException.class,
                () -> PropertyPathResolver.resolveType(TestEntity.class, property));
    }

    @Test
    public void resolveType_propertyIsOneToManyEntity() {
        //given
        String property = "oneToMany";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(TestOneToManyEntity.class, result);
    }

    @Test
    public void resolveType_propertyLeavesCollectionThroughToOneRelation() {
        //given
        String property = "oneToMany.owner.testString";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void resolveType_propertyIsManyToManyEntity() {
        //given
        String property = "manyToMany";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(TestManyToManyEntity.class, result);
    }

    @Test
    public void resolveType_propertyGoesThroughCollectionsOnBothSidesOfManyToMany() {
        //given
        String property = "manyToMany.entities.testString";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void resolveType_propertyGoesThroughTwoToOneRelations() {
        //given
        String property = "oneToOne.owner.testString";

        //when
        Class<?> result = PropertyPathResolver.resolveType(TestEntity.class, property);

        //then
        Assertions.assertEquals(String.class, result);
    }

    @Test
    public void resolveType_propertyIsUnknownFieldOfOneToManyEntity() {
        //given
        String property = "oneToMany.nope";

        //when/then
        Assertions.assertThrows(InvalidPropertyException.class, () -> PropertyPathResolver.resolveType(TestEntity.class, property));
    }
}
