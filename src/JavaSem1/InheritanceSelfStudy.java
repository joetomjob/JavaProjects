/**
 * Created by Admin on 14-09-2016.
 */
class above{
    int k=0;
    public void add(int i,int j)
    {
        k = i+j;
        System.out.println("Output is : "+ k);
    }
    public void sub(int i,int j)
    {
        k = i-j;
        System.out.println("Output is : "+ k);
    }
    public above(int age)
    {
        System.out.println("The age is : "+age);
    }
}
public class InheritanceSelfStudy extends above{
    int m;
    public void mul(int i,int j)
    {
        m = i*j;
        System.out.println("Output is : "+ m);
    }
    public InheritanceSelfStudy(int ag)
    {
        super(ag);
    }

    public static void main(String[] args) {
        InheritanceSelfStudy a = new InheritanceSelfStudy(100);
        a.add(1,2);
        a.sub(2,1);
        a.mul(3,5);

        above b = new InheritanceSelfStudy(50);
        b.add(14,17);
        b.sub(12,6);
        //If a class is inheriting the properties of another class. And if the members of the superclass have the names
        // same as the sub class, to differentiate these variables we use super keyword as shown below.
        //super.variable
        //super.method();

    }
}
