class interest{
    int p;
    int r;
    int t;
  float simple_interest(int p,int r,int t)
  {
      return (p*r*t)/100;
  }
}

class max_of_three{
    int a;
    int b;
    int c;
    int max_number(int a,int b,int c)
    {
        if(a>b)
        {
            if(a>c)
            {
                return a;
            }
        }
        else if(b>c)
        {
            return b;
        }
        return c;
    }
}



public class first
{
	public static void main(String[] args) {
	  interest tt=new interest();
	  tt.p=1000;
	  tt.t=2;
	  tt.r=3;
	  System.out.println(tt.simple_interest(tt.p,tt.r,tt.t));
	  max_of_three m=new max_of_three();
	  m.a=10;
	  m.b=20;
	  m.c=30;
	  System.out.print(m.max_number(m.a,m.b,m.c));
	  return;
     }
}
