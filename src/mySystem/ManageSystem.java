package mySystem;

import java.io.*;
import java.util.Scanner;


//管理系统
public class ManageSystem extends Borrow{
	protected Member member_list[];
	
	protected int member_amount = 0;
	
	protected int max_capacity = 1000;
		
	protected Book book_list[];
	
	protected DVD DVD_list[];
	
	protected Borrow borrow_list[];
	

	protected int item_amount = 0;
	
	protected int book_number = 0;
	
	protected int DVD_number = 0;
	
	protected int borrow_number = 0;
	
	
	//打印所有书籍
	public void printallbook(){
		for(int j = 0;j<book_number;j++){
			System.out.println("(图书)编号:"+book_list[j].item_serial+",名称:"+book_list[j].item_name+",作者:"+book_list[j].author+",ISBN:"+book_list[j].ISBN+",数量:"+book_list[j].item_amount);
		}
	}
	//打印所有dvd
	public void printalldvd(){
		for(int j = 0;j<DVD_number;j++){
			System.out.println("(DVD)编号:"+DVD_list[j].item_serial+",名称:"+DVD_list[j].item_name+",ISRC:"+DVD_list[j].ISRC+",数量:"+DVD_list[j].item_amount);
		}
	}
	//添加书籍元素
	public void addnewbook(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入书籍编号:");
    	String serial = input.next();
    	System.out.print("请输入书籍名称:");
    	String name = input.next();
    	System.out.print("请输入作者:");
    	String author = input.next();
    	System.out.print("请输入ISBN号:(格式 7-15-4456-48):");
    	String ISBN = input.next();
    	System.out.print("请输入这个商品的数量:");
    	int num = input.nextInt();
    	book_list[book_number] = new Book();
    	book_list[book_number].item_serial = serial;
    	book_list[book_number].item_name = name;
    	book_list[book_number].item_amount = num;
    	book_list[book_number].author = author;
    	book_list[book_number].ISBN = ISBN;
    	book_number+=1;
    	item_amount+=1;
	}
	//添加dvd
	public void addnewdvd(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入DVD编号:");
    	String serial = input.next();
    	System.out.print("请输入DVD名称:");
    	String name = input.next();
    	System.out.print("请输入ISRC号:(格式 7-15-4456-48):");
    	String ISRC = input.next();
    	System.out.print("请输入这个商品的数量:");
    	int num = input.nextInt();
    	DVD_list[DVD_number] = new DVD();
    	DVD_list[DVD_number].item_serial = serial;
    	DVD_list[DVD_number].item_name = name;
    	DVD_list[DVD_number].ISRC = ISRC;
    	DVD_list[DVD_number].item_amount = num;
    	DVD_number+=1;
    	item_amount+=1;
	}
	
	

	//1.主界面
	public void menu(){
		System.out.println("-------------------------------------------");
		System.out.println("\t\t1.新增会员");
		System.out.println("\t\t2.新增商品");
		System.out.println("\t\t3.借书或DVD");
		System.out.println("\t\t4.还书或DVD");
		System.out.println("\t\t5.显示所有会员信息 ");
		System.out.println("\t\t6.显示所有商品信息 ");
		System.out.println("\t\t7.显示所有借阅信息");
		System.out.println("\t\t8.退出程序");
		System.out.println("-------------------------------------------");
		
		Scanner input = new Scanner(System.in);
		int operation = input.nextInt();
		
		
		switch(operation)
		{
		case 1:this.add_member();
		break;
		case 2:this.add_item();
		break;
		case 3:this.borrow_item();
		break;
		case 4:this.return_book();
		break;
		case 5:this.visit_member_list();
		break;
		case 6:this.visit_goods_list();
		break;
		case 7:this.visit_borrow_list();
		break;
		case 8:this.exit();
		break;
		}
	}
	
	//2.新增会员
	public void add_member(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入添加的会员编号:");
		String serial = input.next();
		System.out.print("请输入添加的会员姓名:");
		String name = input.next();
		System.out.print("请输入添加的会员手机号:");
		String phone_number = input.next();
		
		//----------------------------------------
 	    member_list[member_amount] = new Member();
 	    member_list[member_amount].member_serial_number = serial;
 	    member_list[member_amount].member_name = name;
 	    member_list[member_amount].member_phone_number = phone_number;
 	    member_amount += 1;

	    System.out.println("会员信息添加成功。。。");
	    System.out.println("-------------------------------------------");
	    System.out.println("\t\t1.继续添加会员");
	    System.out.println("\t\t2.返回上一级");
	    System.out.println("-------------------------------------------");
	    int operation = input.nextInt();
	    if(operation == 1){
	    	//继续添加
	    	this.add_member();
	    }else{
	    	//返回上一级
	    	this.visit_member_list();
	    }

			
     	    
		    

	}
	
	
	//3.新增商品
	public void add_item(){

		Scanner input = new Scanner(System.in);
		System.out.print("请输入需要新增的商品类型(----1。图书----2.DVD----):");
	    int operation = input.nextInt();
	    if(operation == 1){
	    	this.addnewbook();
	    }else{
	    	this.addnewdvd();
	    }
 	    
	    System.out.println("商品信息添加成功。。。");
	    System.out.println("-------------------------------------------");
	    System.out.println("\t\t1.继续添加商品");
	    System.out.println("\t\t2.查看所有商品");
	    System.out.println("\t\t3.返回主页面");
	    System.out.println("-------------------------------------------");
	    int operation1 = input.nextInt();
	    switch(operation1)
	    {
	    case 1:this.add_item();
	    break;
	    case 2:this.visit_goods_list();
	    break;
	    case 3:this.menu();
	    }   

	}

	
	//4.借书或DVD
	public void borrow_item(){
		//对会员姓名进行验证
		System.out.print("请输入你的会员名:");
		Scanner input = new Scanner(System.in);
		String unchecked_name = input.next();
		for(int j = 0;j<member_amount;j++){
			if(member_list[j].member_name.equals(unchecked_name)){
				System.out.println("会员身份验证通过...");
				break;
			}
			if(j==member_amount-1){
				System.out.println("未找到该会员信息，返回主页面。。。");
				this.menu();
			}
		}
		System.out.print("请输入要借阅的书籍或者DVD的名称:");
		String unchecked_item = input.next();
		int j;
		int k;
		for(j = 0;j<book_number && !book_list[j].item_name.equals(unchecked_item);j++){
			if(j==book_number-1){
				for(k = 0;k<DVD_number&& !DVD_list[k].item_name.equals(unchecked_item);k++){
					if(k==DVD_number-1){
						System.out.println("未找到匹配商品，返回主菜单");
						this.menu();
					}
				}
				//说明是DVD
				System.out.println("商品匹配成功，当前剩余数量:"+DVD_list[k].item_amount);
				
				if(DVD_list[k].item_amount>0){
					System.out.print("请输入当前日期(XXXX年XX月XX日):");
					String date = input.next();
					DVD_list[k].item_amount-=1;
					borrow_list[borrow_number] = new Borrow();
					borrow_list[borrow_number].member_name = unchecked_name;
					borrow_list[borrow_number].item_name = unchecked_item;
					borrow_list[borrow_number].time_of_borrowed = date;
					borrow_number++;
					System.out.println("数量充足，借阅成功，返回主菜单。。。");
					this.menu();
				}else{
					System.out.println("数量不足，无法借阅，返回主菜单。。。");
					this.menu();
				}
			}
		}
		//说明是book
		System.out.println("商品已找到，剩余数量是:"+book_list[j].item_amount);
		
		if(book_list[j].item_amount>0){
			System.out.print("请输入当前日期(XXXX年XX月XX日):");
			String date = input.next();
			book_list[j].item_amount-=1;
			borrow_list[borrow_number] = new Borrow();
			borrow_list[borrow_number].member_name = unchecked_name;
			borrow_list[borrow_number].item_name = unchecked_item;
			borrow_list[borrow_number].time_of_borrowed = date;
			borrow_number++;
			System.out.println("数量充足，借阅成功，返回主菜单。。。");
			this.menu();
		}else{
			System.out.println("数量不足，无法借阅，返回主菜单。。。");
			this.menu();
		}
		
		
		
		
		
		

		
	}
	
	
	//5.还书或DVD
	public void return_book(){
		System.out.println("请输入您的姓名和借阅商品名称，用@隔开:");
		Scanner input = new Scanner(System.in);
		String str = input.next();
		if(!str.contains("@")){
			System.out.println("没有检测到@，返回主菜单");
			this.menu();
		}
		
		String[] return_item = str.split("@");
		for(int j = 0;j<borrow_number;j++){
			if(borrow_list[j].member_name.equals(return_item[0])){
				if(borrow_list[j].item_name.equals(return_item[1])){
					
					for(int i = 0;i<book_number;i++){
						if(book_list[i].item_name.equals(return_item[1])){
							book_list[i].item_amount+=1;
						}
						
					}
					for(int i=0;i<DVD_number;i++){
						if(DVD_list[i].item_name.equals(return_item[1])){
							DVD_list[i].item_amount+=1;
						}
					}
					for(int k = j;k<borrow_number;k++){
						borrow_list[k] = borrow_list[k+1];
					}
					borrow_number-=1;
					System.out.println("匹配成功，商品已归还,返回主菜单");
					this.menu();

				}
			}
		}
		System.out.println("会员姓名或商品名输入有误，返回主菜单");
		this.menu();
	}
	
	//6.显示所有会员信息
	public void visit_member_list(){ 
		
		
		for(int j = 0;j<member_amount;j++){
			System.out.println((j+1)+",会员编号:"+member_list[j].member_serial_number+",会员姓名:"+member_list[j].member_name+",会员电话:"+member_list[j].member_phone_number);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("会员信息打印完毕!当前共有"+(member_amount)+"个会员");
    	System.out.println("1.修改会员信息");
    	System.out.println("2.查询会员信息");
    	System.out.println("3.新增会员信息");
    	System.out.println("4.删除会员信息");
    	System.out.println("5.返回主页面");
    	int operation = input.nextInt();
	    switch(operation)
	    {
	    case 1:this.modify_memberinfo();
	    
	    case 2:this.search_member();
	    
	    case 3:this.add_member();
	    
	    case 4:this.delete_member();
	    
	    case 5:this.menu();
	    }
		
	}
	
	
	//7.显示所有商品信息
	public void visit_goods_list(){
		this.printallbook();
		this.printalldvd();
		System.out.println("商品信息打印完毕!当前共有"+(item_amount)+"种商品");
	    System.out.println("1.新增商品信息");
	    System.out.println("2.修改商品信息");
	    System.out.println("3.返回上一级");
	    Scanner input = new Scanner(System.in);
	    int operation = input.nextInt();
	    switch(operation)
	    {
	    case 1:this.add_item();
	    break;
	    case 2:this.modify_item();
	    break;
	    case 3:this.menu();
	    }
		    
		
	}
	
	
	//8.显示所有借阅信息
	public void visit_borrow_list(){
		if(borrow_number == 0){
			System.out.println("暂无借阅信息，返回主页面...");
			this.menu();
		}
		for(int j = 0;j<borrow_number;j++){
			System.out.println((j+1)+"."+"借阅会员姓名:"+borrow_list[j].member_name+"，借阅商品名称:"+borrow_list[j].item_name+"，借阅日期为:"+borrow_list[j].time_of_borrowed);
			//借阅日期至今的天数，get当前日期，求差
		}
		System.out.println("借阅信息打印完毕，返回主页面...");
		this.menu();
	}
	
	//9.修改商品信息
	public void modify_item(){
		System.out.println("请输入需要查找的商品类型(书籍 或 DVD)和商品名称，用'#'隔开");
		Scanner input = new Scanner(System.in);
		String[] oldStr = input.next().split("#");
		if(oldStr[0].equals("书籍")){
			for(int j = 0;j < book_number;j++){
				if(book_list[j].item_name.equals(oldStr[1])){
					System.out.println("商品已匹配成功，请输入修改后的商品信息(书籍序号，书籍名称，作者，ISBN号，数量，用@隔开)");
					String replaceStr = input.next();
					String[] newStr = replaceStr.split("@");
					book_list[j].item_serial = newStr[0];
					book_list[j].item_name = newStr[1];
					book_list[j].author = newStr[2];
					book_list[j].ISBN = newStr[3];
					book_list[j].item_amount = Integer.parseInt(newStr[4]);
					System.out.println("修改成功...");
					System.out.println("---------");
					System.out.println("1.再次修改");
					System.out.println("2.返回上一级");
					System.out.println("3.返回主页面");
					int operation = input.nextInt();
				    
				    switch(operation)
				    {
				    	case 1: this.modify_item();
				    	
				    	case 2: this.search_member();
				    	
				    	case 3: this.menu();
				    }   
				}
			}
			System.out.println("未找到此书籍，返回上一级");
			this.visit_goods_list();
		}else if(oldStr[0].equals("DVD")){
			for(int j = 0;j<DVD_number;j++){
				if(DVD_list[j].item_name.equals(oldStr[1])){
					System.out.println("商品已匹配成功，请输入修改后的商品信息(DVD序号，DVD名称，ISRC号，数量，用@隔开)");
					String replaceStr = input.next();
					String[] newStr = replaceStr.split("@");
					DVD_list[j].item_serial = newStr[0];
					DVD_list[j].item_name = newStr[1];
					DVD_list[j].ISRC = newStr[2];
					DVD_list[j].item_amount = Integer.parseInt(newStr[3]);
					System.out.println("修改成功...");
					System.out.println("---------");
					System.out.println("1.再次修改");
					System.out.println("2.返回上一级");
					System.out.println("3.返回主页面");
					int operation = input.nextInt();
				    
				    switch(operation)
				    {
				    	case 1: this.modify_item();
				    	
				    	case 2: this.visit_goods_list();
				    	
				    	case 3: this.menu();
				    }   
				}
			}
			System.out.println("未找到此书籍，返回上一级");
			this.visit_goods_list();
		}else{
			System.out.println("输入信息有误，返回上一级");
			this.visit_goods_list();
		}
	}
	
	//10.修改会员信息
	public void modify_memberinfo(){
		System.out.println("请输入需要修改的会员信息(会员编号，姓名，手机号其中之一即可):");
		Scanner input = new Scanner(System.in);
		String oldStr = input.next();
		int j;
		for(j = 0;j<member_amount;j++){
			if(member_list[j].member_serial_number.equals(oldStr)||member_list[j].member_name.equals(oldStr)||member_list[j].member_phone_number.equals(oldStr)){
				System.out.println("您要修改的会员信息为，"+"会员编号:"+member_list[j].member_serial_number+"，会员姓名:"+member_list[j].member_name+"，会员手机号为:"+member_list[j].member_phone_number);
				System.out.println("请输入修改后的会员信息(会员编号，姓名，手机号 用@隔开):");
				String replaceStr = input.next();
				//判断输入合法性
				if(!replaceStr.contains("@")){
					System.out.println("输入有误，请重新查询...");
					this.modify_memberinfo();
				}
				String[] newStr = replaceStr.split("@");
				
				//修改借阅记录中该会员的信息
				for(int i = 0;i<borrow_number;i++){
					if(borrow_list[i].member_name.equals(member_list[j].member_name)){
						borrow_list[i].member_name = newStr[1];
					}
				}
				member_list[j].member_serial_number = newStr[0];
				member_list[j].member_name = newStr[1];
				member_list[j].member_phone_number = newStr[2];
				
				System.out.println("修改成功...");
				System.out.println("---------");
				System.out.println("1.再次修改");
				System.out.println("2.查询会员信息");
				System.out.println("3.返回主页面");
				int operation = input.nextInt();
			    
			    switch(operation)
			    {
			    	case 1: this.modify_memberinfo();
			    	
			    	case 2: this.search_member();
			    	
			    	case 3: this.menu();
			    }   
			}
				
		}
		System.out.println("未找到您输入的会员相关信息");
		System.out.println("1.重新输入");
		System.out.println("2.返回主页面");
		int operation = input.nextInt();
		switch(operation)
		{
		case 1:this.modify_memberinfo();
		break;
		case 2:this.menu();
		}

	}
	
	
	//11.查询会员信息
	public void search_member(){
		System.out.println("请输入会员的某一项信息(会员编号，姓名，电话):");
		Scanner input = new Scanner(System.in);
		String keyword = input.next();
		
		int j;
		for(j = 0;j<member_amount;j++){
			if(member_list[j].member_serial_number.contains(keyword)){break;}
			if(member_list[j].member_name.contains(keyword)){break;}
			if(member_list[j].member_phone_number.contains(keyword)){break;}
		}
		System.out.println("查询结果：");
		System.out.println("会员编号:"+member_list[j].member_serial_number+"，会员姓名:"+member_list[j].member_name+"，会员电话:"+member_list[j].member_phone_number);
		System.out.println("----------------------------------");
		System.out.println("1.再次查询");
	    System.out.println("2.修改会员信息");
	    System.out.println("3.返回主页面");
	    int operation = input.nextInt();
	    
	    switch(operation)
	    {
	    	case 1: this.search_member();
	    	
	    	case 2: this.modify_memberinfo();
	    	
	    	case 3: this.menu();
	    }    	
		
	}
	
	//12.删除会员信息
	public void delete_member(){
		System.out.println("请输入需要删除的会员信息(会员编号，姓名，手机号其中之一即可):");
		Scanner input = new Scanner(System.in);
		String to_delete = input.next();
		System.out.println("您要删除的会员信息是:");
		int k;
		for(k = 0;k<member_amount;k++){
			if(member_list[k].member_name.contains(to_delete)){break;}
			if(member_list[k].member_serial_number.contains(to_delete)){break;}
			if(member_list[k].member_phone_number.contains(to_delete)){break;}
		}
		for(int i = 0;i<borrow_number;i++){
			if(borrow_list[i].member_name.equals(member_list[k].member_name)){
				System.out.println("当前会员有未归还的图书或DVD，请先归还再删除会员信息，返回上一级....");
				this.visit_member_list();
			}
		}

		System.out.println("会员编号:"+member_list[k].member_serial_number+"，会员姓名:"+member_list[k].member_name+"，会员电话:"+member_list[k].member_phone_number);
		System.out.println("请再次确认是否要删除:");
		System.out.println("1.我后悔了(退回到主页面)");
		System.out.println("2.是的，我确定删除");
		int delete = input.nextInt();
		
		if(delete == 2){
			for(;k<member_amount-1;k++){
				member_list[k]=member_list[k+1];
			}
			member_amount -= 1;
			if(k==member_amount-1){
				member_amount -= 1;
			}
			System.out.println("删除成功。。。");
			this.menu();
		}else{
			this.menu();
		}
		
		
		
		
	}
	
	
	
	//13.程序初始化
	public void init_system(){
		
		
		member_list = new Member[max_capacity];
		book_list = new Book[max_capacity];
		DVD_list = new DVD[max_capacity];
		borrow_list = new Borrow[max_capacity];
		
		
		
		
		//初始化会员数组
		
		
		
		try {
			File file = new File("member.txt");
		        //文件不存在时候，主动创建文件。
		    if(!file.exists()){
		        file.createNewFile();
		    }
		    FileReader fileReader = new FileReader("member.txt");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    FileWriter fw = new FileWriter(file,true); //新建会员信息用
		    
		    String str;
		    String[] memberinfo;
		    //会员信息数组 从序号0开始，三个位置存一个会员信息
		    int line_number = 1;
		    while((str = bufferedReader.readLine()) != null){
		    	
		    	//将text中的信息分割
		    	memberinfo = str.split("@");
		    	
		    	//分配内存空间 
		    	this.member_amount += 1;
		    	member_list[line_number-1] = new Member();
		    	member_list[line_number-1].member_serial_number = memberinfo[0];
		    	member_list[line_number-1].member_name = memberinfo[1];
		    	member_list[line_number-1].member_phone_number = memberinfo[2];
		    	
		    	line_number++;
		    }
		    
//		    fw.write("到此一游");
		    bufferedReader.close(); 
		    fw.close();
		    

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		//初始化商品数组
		
		
		
		
		try {
			File file = new File("product.txt");
		        //文件不存在时候，主动创建文件。
		    if(!file.exists()){
		        file.createNewFile();
		    }
		    FileReader fileReader = new FileReader(file);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    FileWriter fw = new FileWriter(file,true); //新建会员信息用
		    
		    String str;
		    String[] iteminfo;
		    //会员信息数组 从序号0开始，三个位置存一个会员信息
		    while((str = bufferedReader.readLine()) != null){
		    	
		    	//将text中的信息分割
		    	iteminfo = str.split("@");
		    	if(iteminfo[0].equals("图书")){
		    	
		    		this.item_amount += 1;
		    		book_list[book_number] = new Book();
		    		book_list[book_number].item_serial = iteminfo[1];
		    		book_list[book_number].item_name = iteminfo[2];
		    		book_list[book_number].author = iteminfo[3];
		    		book_list[book_number].ISBN = iteminfo[4];
		    		book_list[book_number].item_amount = Integer.parseInt(iteminfo[5]);

		    		book_number++;
		    	}else{
		    		
		    		this.item_amount += 1;
		    		DVD_list[DVD_number] = new DVD();
		    		DVD_list[DVD_number].item_serial = iteminfo[1];
		    		DVD_list[DVD_number].item_name = iteminfo[2];
		    		DVD_list[DVD_number].ISRC = iteminfo[3];
		    		DVD_list[DVD_number].item_amount = Integer.parseInt(iteminfo[4]);

		    		DVD_number++;
		    	}
		    }
//		    fw.write("到此一游");
		    fileReader.close();
		    bufferedReader.close(); 
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		//初始化借阅数组
		
		
		
		try {
			File file = new File("record.txt");
		        //文件不存在时候，主动创建文件。
		    if(!file.exists()){
		        file.createNewFile();
		    }
		    FileReader fileReader = new FileReader("record.txt");
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    FileWriter fw = new FileWriter(file,true); //新建会员信息用
		    
		    String str;
		    String[] borrowinfo;
		    //会员信息数组 从序号0开始，三个位置存一个会员信息
		    int line_number = 1;
		    while((str = bufferedReader.readLine()) != null){
		    	
		    	//将text中的信息分割
		    	borrowinfo = str.split("@");
		    	
		    	//分配内存空间 
		    	this.borrow_number += 1;
		    	borrow_list[line_number-1] = new Borrow();
		    	borrow_list[line_number-1].member_name = borrowinfo[0];
		    	borrow_list[line_number-1].item_name = borrowinfo[1];
		    	borrow_list[line_number-1].time_of_borrowed = borrowinfo[2];
		    	
		    	line_number++;
		    }
		    
//		    fw.write("到此一游");
		    bufferedReader.close(); 
		    fw.close();
		    

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\t\t管理系统初始化成功...");
	}
	
	
	//14.程序关闭前将数据输出
	public void exit(){
		
		//保存会员信息的更改
		
		try{ 
			File file = new File("member.txt");  
		    File file2 = new File("member2.txt");  
		    if(!file2.exists()){
		    	file2.createNewFile();
		    }
		     
		    PrintWriter writer = new PrintWriter(file2);   
		    String line;   
		    
		    for(int j = 0;j<member_amount;j++){
		    	writer.println(member_list[j].member_serial_number+"@"+member_list[j].member_name+"@"+member_list[j].member_phone_number);
		    	writer.flush();
		    }
		    writer.close();
		    

		    // 删除老文件   
		    file.delete();
		    file2.renameTo(file);  
		    
		  
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//保存商品信息的更改
		try{ 
			File file = new File("product.txt");  
		    File file2 = new File("product2.txt");  
		    if(!file2.exists()){
		    	file2.createNewFile();
		    }
		     
		    PrintWriter writer = new PrintWriter(file2);   
		    String line;   
		    
		    for(int j = 0;j<book_number;j++){
		    	writer.println("图书"+"@"+book_list[j].item_serial+"@"+book_list[j].item_name+"@"+book_list[j].author+"@"+book_list[j].ISBN+"@"+book_list[j].item_amount);
		    	writer.flush();
		    }
		    for(int j = 0;j<DVD_number;j++){
		    	writer.println("DVD"+"@"+DVD_list[j].item_serial+"@"+DVD_list[j].item_name+"@"+DVD_list[j].ISRC+"@"+DVD_list[j].item_amount);
		    	writer.flush();
		    }
		   
		    writer.close();

		    // 删除老文件   
		    file.delete();
		    file2.renameTo(file);  

		}catch(IOException e){
			e.printStackTrace();
		}
		//保存借阅信息
		try{ 
			File file = new File("record.txt");  
		    File file2 = new File("record1.txt");  
		    if(!file2.exists()){
		    	file2.createNewFile();
		    }
		     
		    PrintWriter writer = new PrintWriter(file2);   
		    String line;   
		    
		    
		    for(int j = 0;j<borrow_number;j++){
		    	writer.println(borrow_list[j].member_name+"@"+borrow_list[j].item_name+"@"+borrow_list[j].time_of_borrowed);
		    	writer.flush();
		    }
		   
		    writer.close();

		    // 删除老文件   
		    file.delete();
		    file2.renameTo(file);  
		    System.out.println("程序即将结束。。。");
		    System.exit(0);
		  
		}catch(IOException e){
			e.printStackTrace();
		}
			
	
	}
	

	
}


