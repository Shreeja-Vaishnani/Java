package Java;
class parent{
    int a=10;
    parent()
    {
        System.out.println("parent");
    }
}
class child1 extends parent{
    child1()
    {
        System.out.println("child1");
    }

}
class child2 extends parent{
    child2()
    {System.out.println("child2");}
}
public class hyr {
    public static void main(String[] arg)
    child1 c1= new child1();
    child2 c2= new child2();
}
