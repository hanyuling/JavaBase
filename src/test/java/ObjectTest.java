import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class ObjectTest {

    ArrayList list = new ArrayList<String>(){};
    ArrayList list1 = list;
    public static void main(String[] args) throws Exception {
        ObjectTest objectTest = new ObjectTest();
//        objectTest.list.add("aa");
//        objectTest.list.add(1);

        Class<?> list = getListGenericType(objectTest.getClass().getDeclaredField("list1"));
        System.out.println(list);
        Type type = objectTest.list1.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = ParameterizedType.class.cast(type);
        for (Type typeArgument : parameterizedType.getActualTypeArguments()) {
            System.out.println(typeArgument.getTypeName());
        }


        // 创建两个不同泛型的list集合
        List<A> integerList = new ArrayList<>();
        List<B> stringList = new ArrayList<>();

        System.out.println(integerList.getClass() == stringList.getClass());

        System.out.println("integerList----> "+integerList.getClass().getName());
        System.out.println("stringList----> "+stringList.getClass().getName());

        List<Integer> list2 = new ArrayList<Integer>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        System.out.println(Arrays.toString(list2.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));


    }
    private static Class<?> getListGenericType(Field field) throws Exception {
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            return (Class<?>) parameterizedType.getActualTypeArguments()[0];
        }
        return null;
    }

    class A{

    }
    class B{

    }

}
