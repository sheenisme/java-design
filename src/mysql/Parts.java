package mysql;

public class Parts{
	private int number;
	private String type;
	private int total;
	private int allowance;
	private int sales;
	private int price;
	private String suppliers;
	private String others;
	static int max=1;

	//�����ǳ�ʼ�������ֶεĺ���
	public void setnumber() {
		this.number=max++;
	}
	
	public void settype(String type) { 
		this.type=type;
	}
	
	public void settotal(int total) {
		if(total>0)
			this.total=total;
		else{
			System.out.println("����С�ڻ��ߵ���0���������������ΪĬ��ֵ100\n");
			this.total=100;}
	}
	
	public void setallowance() {
		this.allowance=gettotal()-getsales();
	}
	
	public void setsales(int sales) {
		if(sales<0){
			System.out.println("����������ֵС��0�����ִ���������ΪĬ��ֵ0\n");
			this.sales=0;
		}
		else
			this.sales=sales;
	}
	
	public void setsales() {
		this.sales=0;
	}
	
	public void setprice(int price) {
		if(price>=0)
			this.price=price;
		else {
			System.out.println("�۸�С��0���������������ΪĬ��ֵ1 \n");
			this.price=1;}
			
	}
	
	public void setsupplier(String suppliers) {
		this.suppliers=suppliers;
	}
	
	public void setothers() {
		this.others=null;
	}
	
	public void setothers(String others) {
		this.others=others;
	}
	
	//�����Ǹ����ֶεĻ�ȡ����
	public int getnumber() {
		return number;
	}
	
	public String gettype() {
		return type;
	}
	
	public int gettotal() {
		return total;
	}
	
	public int getallowance() {
		return allowance;
	}
	
	public int getsales() {
		return sales;
	}
	
	public int getprice() {
		return price;
	}
	
	public String getsuppliers() {
		return suppliers;
	}
	
	public String getothers() {
		return others;
	}

	
	//Ĭ�Ϲ��캯���Լ��Զ����
	public Parts(){
		setnumber();
		settype("default");
		settotal(1);
		setsales(0);
		setallowance();
		setprice(1);
		setsupplier("default");
		setothers();
	}
	
	public Parts(String type,int total,int sales,int price,String supplier){
		setnumber();
		settype(type);
		settotal(total);
		setsales(sales);
		setallowance();
		setprice(price);
		setsupplier(supplier);
		setothers();
	}
}