public class Assignment6 {
    static class Node{
        int coeff;
        int pow;
        Node next;
        Node(){
            coeff=pow=0;
            next=null;
        }
    }

    static class Poly {
        
        Node head=null;

        void create(int x,int y){
            Node nn=new Node();
            nn.coeff=x;
            nn.pow=y;
            if(head==null){
                head=nn;
                return ;
            }
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=nn;
        }

        void polyAdd(Poly p1,Poly p2){
            Node h1=p1.head;
            Node h2=p2.head;
            Node res=new Node();
            Node curr=res;
            while(h1!=null && h2!=null){
                Node nn=new Node();
                if(h1.pow>h2.pow){
                    nn.coeff=h1.coeff;
                    nn.pow=h1.pow;
                    curr.next=nn;
                    curr=curr.next;
                    h1=h1.next;
                }
                else if(h1.pow<h2.pow){
                    nn.coeff=h2.coeff;
                    nn.pow=h2.pow;
                    curr.next=nn;
                    curr=curr.next;
                    h2=h2.next;
                }
                else{
                    nn.coeff=h1.coeff+h2.coeff;
                    nn.pow=h2.pow;
                    curr.next=nn;
                    curr=curr.next;
                    h1=h1.next;
                    h2=h2.next;
                }
            }

            while(h1!=null){
                Node nn=new Node();
                nn.coeff=h1.coeff;
                nn.pow=h1.pow;
                curr.next=nn;
                curr=curr.next;
                h1=h1.next;
            }
            
            while(h2!=null){
                Node nn=new Node();
                nn.coeff=h2.coeff;
                nn.pow=h2.pow;
                curr.next=nn;
                curr=curr.next;
                h2=h2.next;
            }
            head=res.next;
        }

        void showPoly(){
            Node temp=head;
            while (temp.next!=null) {
                System.out.print(temp.coeff+"x^"+temp.pow+" + ");
                temp=temp.next;
            }
            System.out.print(temp.coeff+"x^"+temp.pow);
            System.out.println();
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        Poly l1=new Poly();
        Poly l2=new Poly();

        l1.create(12, 5);
        l1.create(41, 3);
        l1.create(6,  1);
        System.out.println("First Polynomial:");
        l1.showPoly();

        System.out.println("Second Polynomial:");

        l2.create(15, 4);
        l2.create(34, 3);

        l2.showPoly();

        Poly l3=new Poly();
        System.out.println("After Addition:");
        l3.polyAdd(l1, l2);
        l3.showPoly();
    }
}
